package model.mappers;

import model.dto.PostDashboardDto;
import model.business.Dashboard;
import model.dto.PutDashboardDto;
import org.modelmapper.ModelMapper;

public class DashboardMapper {
    static ModelMapper mapper = new ModelMapper();
    static {
        mapper.typeMap(Dashboard.class, PostDashboardDto.class);
        mapper.typeMap(Dashboard.class, PutDashboardDto.class);
    }
    public static <T> T map(Dashboard dashboard, Class<T> clazz){
        return mapper.map(dashboard, clazz);
    }
}
