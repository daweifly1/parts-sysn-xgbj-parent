package cn.com.xgit.parts.rm.module.customer.service.impl;

import cn.com.xgit.parts.rm.common.util.BeanUtil;
import cn.com.xgit.parts.rm.exceptions.CommonPartsExceptions;
import cn.com.xgit.parts.rm.module.customer.entity.CompanyDealer;
import cn.com.xgit.parts.rm.module.customer.mapper.CompanyDealerMapper;
import cn.com.xgit.parts.rm.module.customer.service.CompanyDealerService;
import cn.com.xgit.parts.rm.module.customer.vo.CompanyDealerVO;
import cn.com.xgit.platform.common.base.mapper.SuperMapper;
import cn.com.xgit.platform.common.base.service.impl.SuperServiceImpl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CompanyDealer 后台接口实现类
 */
@Slf4j
@Service
@RefreshScope
public class CompanyDealerServiceImpl extends SuperServiceImpl<SuperMapper<CompanyDealer>, CompanyDealer> implements CompanyDealerService {

    @Autowired
    private CompanyDealerMapper companyDealerMapper;

    //同步时候是否需要容忍不校验一些数据库未加约束的字段;0严格校验，1仅仅原有不符合现在设计约束不校验
    @Value("${parts.linient:1}")
    private Integer sysnLinient;

    @Override
    public IPage<CompanyDealerVO> queryPage(IPage page, CompanyDealerVO companyDealerVO) {
        Page<CompanyDealerVO> r = null;
        Wrapper<CompanyDealer> q = new QueryWrapper<>(BeanUtil.do2bo(companyDealerVO, CompanyDealer.class));
        IPage<CompanyDealer> pr = companyDealerMapper.selectPage(page, q);
        r = BeanUtil.do2bo(pr, Page.class);
        if (null != r && !CollectionUtils.isEmpty(pr.getRecords())) {
            r.setRecords(BeanUtil.do2bo4List(pr.getRecords(), CompanyDealerVO.class));
        }
        return r;
    }

    //TODO transaction
    @Override
    public boolean saveByCompanyDealerVO(CompanyDealerVO vo) {
        if (null == vo || null == vo.getId()) {
            throw new CommonPartsExceptions("参数错误");
        }
        CompanyDealer ddo = BeanUtil.do2bo(vo, CompanyDealer.class);
        CompanyDealer model = super.getById(vo.getId());

        if (null == model) {
            return insertModel(ddo);
        } else {
            return updateModelByVO(ddo, model);
        }
    }

    private boolean updateModelByVO(CompanyDealer ddo, CompanyDealer model) {
        ddo.setOrgId(model.getOrgId());
        ddo.setCreateId(model.getCreateId());
        checkNameOrCodeValidate(ddo);
        return super.updateByVO(ddo);
    }

    private boolean insertModel(CompanyDealer ddo) {
        if (StringUtils.isBlank(ddo.getOrgId())) {
            throw new CommonPartsExceptions("组织id不存在");
        }
        checkNameOrCodeValidate(ddo);
        return super.save(ddo);
    }

    private void checkNameOrCodeValidate(CompanyDealer ddo) {
        if (1 == sysnLinient.intValue()) {
            return;
        }
        CompanyDealer header = new CompanyDealer();
        header.setOrgId(ddo.getOrgId());
        header.setCompanyName(ddo.getCompanyName());
        header.setIsDel(0);
        QueryWrapper queryWrapper = new QueryWrapper<>(header);
        if (null != ddo.getId()) {
            queryWrapper.notIn("ID", ddo.getId());
        }
        List<CompanyDealer> ll = super.list(queryWrapper);
        if (ll.size() > 0) {
            log.warn("相同主店下存在相同的用户名，{}", ddo);
            throw new CommonPartsExceptions("该组织下客户已经存在");
        }
        if (ddo.getDealerCode() != null) {
            CompanyDealer cc = new CompanyDealer();
            cc.setOrgId(ddo.getOrgId());
            cc.setDealerCode(ddo.getDealerCode());
            cc.setIsDel(0);
            QueryWrapper queryWrapper2 = new QueryWrapper<>(cc);
            if (null != ddo.getId()) {
                queryWrapper2.notIn("ID", ddo.getId());
            }
            List<CompanyDealer> ll2 = super.list(queryWrapper2);
            if (ll2.size() > 0) {
                log.warn("相同主店下存在相同的用户code，{}", ddo);
                throw new CommonPartsExceptions("该组织下客户CODE已经存在");
            }
        }
    }
}
