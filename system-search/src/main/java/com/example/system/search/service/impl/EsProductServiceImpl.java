package com.example.system.search.service.impl;

import com.example.system.search.dao.EsProductDao;
import com.example.system.search.document.EsProduct;
import com.example.system.search.repository.EsProductRepository;
import com.example.system.search.service.EsProductService;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 商品搜索管理Service实现类
 */
@Service
public class EsProductServiceImpl implements EsProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsProductServiceImpl.class);
    @Autowired
    private EsProductDao productDao;
    @Autowired
    private EsProductRepository productRepository;

    //操作DLS语句
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 导入数据
     * @return
     */
    @Override
    public int importAll() {
        //拿出在数据库中的数据集
        List<EsProduct> esProductList = productDao.getAllEsProductList(null);
        //把数据库数据保存到es
        Iterable<EsProduct> esProductIterable = productRepository.saveAll(esProductList);
        esProductIterable.spliterator().estimateSize();
        Iterator<EsProduct> iterator = esProductIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public EsProduct create(Long id) {
        EsProduct result = null;
        List<EsProduct> esProductList = productDao.getAllEsProductList(id);
        if (esProductList.size() > 0) {
            EsProduct esProduct = esProductList.get(0);
            result = productRepository.save(esProduct);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsProduct> esProductList = new ArrayList<>();
            for (Long id : ids) {
                EsProduct esProduct = new EsProduct();
                esProduct.setId(id);
                esProductList.add(esProduct);
            }
            productRepository.deleteAll(esProductList);
        }
    }

    @Override
    public Page<EsProduct> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return productRepository.findByNameOrSubTitleOrKeywords(keyword, keyword, keyword, pageable);
    }

    @Override
    public Page<EsProduct> noteSearch(String name, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
//        SearchRequest request = new SearchRequest("pms");
//        MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(matchAllQueryBuilder);
//        sourceBuilder.timeout(new TimeValue(20, TimeUnit.SECONDS));
//        sourceBuilder.from(0);  //查询结果从第几条数据开始返回
//        sourceBuilder.size(5);//一次返回几条数据
//        request.source(sourceBuilder);
//        SearchResponse response = null;
//        try {
//            response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for (SearchHit fields : response.getHits().getHits()) {
//            System.out.println(fields.getSourceAsString());
//        }
        return productRepository.findByBrandName(name,pageable);
    }

}
