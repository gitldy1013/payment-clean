package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.cmcc.paymentclean.exception.bizException.BizException;

/**
* <p>
* ${table.comment!} 服务实现类
* </p>
*
* @author ${author}
* @since ${date}
*/
@Slf4j
@Service
<#if kotlin>
    open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

    }
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    @Override
    public Page<${entity}> list${entity}sByPage(int page, int pageSize, String factor) {
        log.info("正在执行分页查询${entity?uncap_first}: page = {} pageSize = {} factor = {}",page,pageSize,factor);
        QueryWrapper<${entity}> queryWrapper =  new QueryWrapper<${entity}>().like("", factor);
        //TODO 这里需要自定义用于匹配的字段,并把wrapper传入下面的page方法
        Page<${entity}> result = super.page(new Page<${entity}>(page, pageSize),queryWrapper);
        result.setTotal(result.getRecords().size());
        log.info("分页查询${entity?uncap_first}完毕: 结果数 = {} ",result.getRecords().size());
        return result;
    }

}
</#if>
