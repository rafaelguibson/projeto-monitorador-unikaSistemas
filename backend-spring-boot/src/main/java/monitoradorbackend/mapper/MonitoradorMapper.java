package mapper;
import dto.MonitoradorDTO;
import entities.Monitorador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MonitoradorMapper {

    MonitoradorMapper INSTANCE = Mappers.getMapper(MonitoradorMapper.class);

    @Mapping(target = "pessoaFisica", source = "pessoaFisicaDTO")
    @Mapping(target = "pessoaJuridica", source = "pessoaJuridicaDTO")
    @Mapping(target = "telefones", source = "telefoneDTOs")
    @Mapping(target = "enderecos", source = "enderecoDTOs")
    Monitorador toEntity(MonitoradorDTO monitoradorDTO);

    @Mapping(target = "pessoaFisicaDTO", source = "pessoaFisica")
    @Mapping(target = "pessoaJuridicaDTO", source = "pessoaJuridica")
    @Mapping(target = "telefoneDTOs", source = "telefones")
    @Mapping(target = "enderecoDTOs", source = "enderecos")
    MonitoradorDTO toDTO(Monitorador monitorador);
}
