package mapper;

import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface NameMapper {
    @Select("select * from name")
    public List<Y> getId();
}
