package mapper;
import dto.TelefoneDTO;
import entities.Telefone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TelefoneMapper {

    TelefoneMapper INSTANCE = Mappers.getMapper(TelefoneMapper.class);

    Telefone toEntity(TelefoneDTO telefoneDTO);

    TelefoneDTO toDTO(Telefone telefone);
}
