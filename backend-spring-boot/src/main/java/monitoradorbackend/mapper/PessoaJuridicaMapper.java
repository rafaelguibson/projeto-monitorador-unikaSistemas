package mapper;
import dto.PessoaJuridicaDTO;
import entities.PessoaJuridica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaJuridicaMapper {

    PessoaJuridicaMapper INSTANCE = Mappers.getMapper(PessoaJuridicaMapper.class);

    PessoaJuridica toEntity(PessoaJuridicaDTO pessoaJuridicaDTO);

    PessoaJuridicaDTO toDTO(PessoaJuridica pessoaJuridica);
}
