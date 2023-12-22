package mapper;
import dto.PessoaFisicaDTO;
import entities.PessoaFisica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PessoaFisicaMapper {

    PessoaFisicaMapper INSTANCE = Mappers.getMapper(PessoaFisicaMapper.class);

    PessoaFisica toEntity(PessoaFisicaDTO pessoaFisicaDTO);

    PessoaFisicaDTO toDTO(PessoaFisica pessoaFisica);
}
