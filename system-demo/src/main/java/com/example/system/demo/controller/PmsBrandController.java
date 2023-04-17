package com.example.system.demo.controller;

import com.example.system.common.api.CommonPage;
import com.example.system.common.api.CommonResult;
import com.example.system.mbg.model.PmsBrand;
import com.example.system.demo.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 品牌管理Controller
 */
@Controller
@Api(tags = {"商品品牌管理"})
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

//    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList() {
        LOGGER.debug("获取所有品牌列表");
        return CommonResult.success(brandService.listAllBrand());
    }

//    @PreAuthorize("hasAuthority('pms:brand:create')")
    @ApiOperation("添加品牌")

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsBrand> createBrand(@RequestBody PmsBrand pmsBrand) {
        LOGGER.debug("添加品牌");
        CommonResult<PmsBrand> commonResult;
        int count = brandService.createBrand(pmsBrand);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return commonResult;
    }

//    @PreAuthorize("hasAuthority('pms:brand:update')")
    @ApiOperation("更新指定id品牌信息")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="id",value = "品牌id",dataTypeClass = Long.class)
    })
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PmsBrand> updateBrand(@RequestParam("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result) {
        LOGGER.debug("更新指定id品牌信息");
        CommonResult<PmsBrand> commonResult;
        int count = brandService.updateBrand(id, pmsBrandDto);
        if (count == 1) {
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}", pmsBrandDto);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}", pmsBrandDto);
        }
        return commonResult;
    }

//    @PreAuthorize("hasAuthority('pms:brand:delete')")
    @ApiOperation("删除指定id的品牌")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="id",value = "品牌id",dataTypeClass = Long.class)
    })
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<String> deleteBrand(@RequestParam(value="id") Long id) {
        LOGGER.debug("删除指定id的品牌");
        int count = brandService.deleteBrand(id);
        if (count == 1) {
            LOGGER.debug("deleteBrand success :id={}", id);
            return CommonResult.success("操作成功");
        } else {
            LOGGER.debug("deleteBrand failed :id={}", id);
            return CommonResult.failed("操作失败");
        }
    }

//    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("分页查询品牌列表")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="pageNum",value = "页",dataTypeClass = Integer.class),
            @ApiImplicitParam(name="pageSize",value = "一页显示数量",dataTypeClass = Integer.class)
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum",defaultValue = "0") Integer pageNum,
                                                        @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize) {
        LOGGER.debug("分页查询品牌列表");
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

//    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("获取指定id的品牌详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "id",value = "品牌id",dataTypeClass = Long.class)
    })
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@RequestParam(value="id") Long id) {
        LOGGER.debug("获取指定id的品牌详情");
        return CommonResult.success(brandService.getBrand(id));
    }
}
