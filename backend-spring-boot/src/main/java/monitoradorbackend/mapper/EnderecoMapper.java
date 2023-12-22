package mapper;
import dto.EnderecoDTO;
import entities.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnderecoMapper {

    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    Endereco toEntity(EnderecoDTO enderecoDTO);

    EnderecoDTO toDTO(Endereco endereco);
}
