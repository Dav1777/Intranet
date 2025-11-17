package com.saf.intranet.services;

import com.saf.intranet.dtos.FuncionarioRequestDTO;
import com.saf.intranet.dtos.InformativoRequestDTO;
import com.saf.intranet.models.Funcionario;
import com.saf.intranet.repositories.FuncionarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final ModelMapper modelMapper;
    private final PasswordEnconder passwordEnconder;

    public FuncionarioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos(){
        return funcionarioRepository.findAll();
    }

    public void deletar(Long id){
        funcionarioRepository.deleteById(id);
    }

    public Funcionario buscarPorId(Long id){
        var aux = funcionarioRepository.findById(id);
        if(aux.isEmpty()){
            throw new RuntimeException();
        }
        return aux.get();
    }

    public Funcionario salvar(FuncionarioRequestDTO dto){
        Funcionario novoFuncionario = modelMapper.map(dto, Funcionario.class);

        String senhaCriptografada = encryptor.encode(dto.getSenha());
        novoFuncionario.setSenha(senhaCriptografada);

        return funcionarioRepository.save(novoFuncionario);
    }
}
