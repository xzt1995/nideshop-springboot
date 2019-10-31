package com.newland.nideshopserver.controller.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newland.nideshopserver.mapper.GoodsMapper;
import com.newland.nideshopserver.model.NideshopBrand;
import com.newland.nideshopserver.model.NideshopCategory;
import com.newland.nideshopserver.model.NideshopComment;
import com.newland.nideshopserver.model.NideshopGoods;
import com.newland.nideshopserver.model.NideshopGoodsGallery;
import com.newland.nideshopserver.model.NideshopGoodsIssue;
import com.newland.nideshopserver.model.NideshopProduct;
import com.newland.nideshopserver.model.NideshopSearchHistory;
import com.newland.nideshopserver.model.dto.Attribute;
import com.newland.nideshopserver.model.dto.Comment;
import com.newland.nideshopserver.model.dto.Result;
import com.newland.nideshopserver.model.dto.Specification;
import com.newland.nideshopserver.service.BrandService;
import com.newland.nideshopserver.service.CategoryService;
import com.newland.nideshopserver.service.CollectService;
import com.newland.nideshopserver.service.CommentService;
import com.newland.nideshopserver.service.FootprintService;
import com.newland.nideshopserver.service.GoodsAttributeService;
import com.newland.nideshopserver.service.GoodsGalleryService;
import com.newland.nideshopserver.service.GoodsIssueService;
import com.newland.nideshopserver.service.GoodsService;
import com.newland.nideshopserver.service.SearchHistoryService;
import com.newland.nideshopserver.service.UserService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

/**
 * @author xzt @CREATE2019-10-11 12:36
 * @param <E>
 */
@RestController
public class GoodsController<E> {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SearchHistoryService searchHistoryService;

	@Autowired
	private GoodsGalleryService goodsGalleryService;

	@Autowired
	private GoodsAttributeService goodsAttributeService;

	@Autowired
	private GoodsIssueService goodsIssueService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	@Autowired
	private CollectService collectService;

	@Autowired
	private FootprintService footprintService;

	/**
	 * 首页搜索框显示的宝贝总数
	 * 
	 * @return
	 */
	@RequestMapping("/goods/count")
	public Result count() {
		Result result = new Result();
		HashMap<String, Object> map = new HashMap<>();
		int goodsCount = goodsService.goodsCount();
		map.put("goodsCount", goodsCount);
		result.setData(map);
		return result;
	}

	@RequestMapping("/goods/category")

	public Result category(Integer id) {
		NideshopCategory current = categoryService.getById(id);
		NideshopCategory parent = categoryService.getById(current.getParentId());
		List<NideshopCategory> brother = categoryService.selectByParentId(current.getParentId());
		HashMap<String, Object> map = new HashMap<>();
		map.put("currentCategory", current);
		map.put("parentCategory", parent);
		map.put("brotherCategory", brother);
		Result result = new Result();
		result.setData(map);
		return result;

	}

	@RequestMapping("/goods/list")
	public Result list(HttpSession session, Integer categoryId, Integer brandId, String keywords, Integer isNew,
			Integer isHot, Integer page, Integer size, String sort, String order) {
		Example e = new Example(NideshopGoods.class);
		Criteria criteria = e.selectProperties("categoryId").createCriteria();
		if (isNew != null) {
			criteria.andEqualTo("isNew", isNew);
		}
		if (isHot != null) {
			criteria.andEqualTo("isHot", isHot);
		}
		if (keywords != null) {
			criteria.andLike("name", "%" + keywords + "%");

			// 添加到搜索历史
			Object id = session.getAttribute("userId");
			NideshopSearchHistory history = new NideshopSearchHistory();
			if (id != null) {
				history.setUserId(id.toString());
			}
			history.setKeyword(keywords);
			history.setAddTime((int) (new Date().getTime() / 1000));
			searchHistoryService.add(history);
		}

		if (brandId != null) {
			criteria.andEqualTo("brandId", brandId);
		}

		// 查找所属二级分类的id
		@SuppressWarnings("unchecked")
		List<NideshopGoods> goodsList = goodsService.queryByExample(e);
		int listSize = goodsList.size();
		if (listSize > 10000) {
			listSize = 10000;
		}
		ArrayList<Integer> categoryIds = new ArrayList<>();
		for (int i = 0; i < listSize; i++) {
			categoryIds.add(goodsList.get(i).getCategoryId());
		}
		List<NideshopCategory> filterCategory = new ArrayList<>();

		NideshopCategory superParent = new NideshopCategory();
		superParent.setName("全部");
		superParent.setId(0);
		superParent.setChecked(false);
		filterCategory.add(0, superParent);

		if (categoryIds != null && categoryIds.size() > 0) {
			// 查找二级分类的parent_id
			List<Integer> parentIds = categoryService.getParentIdsBycategoryIds(categoryIds);
			List<NideshopCategory> parentCategory = categoryService.selectByIdList(parentIds);
			filterCategory.addAll(parentCategory);
		}

		// 排序
		e.selectProperties("id", "name", "listPicUrl", "retailPrice");
		if ("price".equals(sort)) {
			// 按价格
			e.setOrderByClause("retailPrice " + order);
		} else {
			// 按商品添加时间
			e.setOrderByClause("id desc");
		}

		// 加入分类条件
		if (categoryId != null && categoryId > 0) {

			List<Integer> categoryids = categoryService.selectSubCatetoryIds(categoryId);
			categoryids.add(categoryId);
			criteria.andIn("categoryId", categoryids);

		}

		// 查询商品
		PageInfo<NideshopGoods> pageInfo = PageHelper.startPage(page, size)
				.doSelectPageInfo(() -> goodsService.queryByExample(e));

		Result result = new Result();
		HashMap<String, Object> map = new HashMap<>();
		map.put("filterCategory", filterCategory);
		map.put("goodsList", pageInfo.getList());
		map.put("count", pageInfo.getTotal());
		map.put("currentPage", page);
		map.put("totalPage", pageInfo.getPageNum());
		map.put("pageSize", pageInfo.getSize());
		result.setData(map);
		return result;
	}

	@RequestMapping("goods/detail")
	public Result detail(HttpSession session, Integer id) {
		NideshopGoods info = goodsService.selectById(id);

		List<NideshopGoodsGallery> gallery = goodsGalleryService.selectByGoodsId(id, 0, 4);

		List<Attribute> attribute = goodsAttributeService.getAttributes(id);

		List<NideshopGoodsIssue> issue = goodsIssueService.selectAll();

		NideshopBrand brand = brandService.getById(info.getBrandId());

		int commentCount = commentService.allCount(0, id);

		NideshopComment hotComment = commentService.getHotCommentByGoodsId(0, id);

		Comment commentInfo = commentService.getCommentInfo(hotComment);
		HashMap<String, Object> comment = new HashMap<>();
		comment.put("count", commentCount);
		comment.put("data", commentInfo);

		Integer userId = (Integer) session.getAttribute("userId");
		

		int userHasCollect = collectService.isUserHasCollect(userId, 0, id);

		footprintService.addFootprint(userId, id);

		List<Specification> specificationList = goodsService.getSpecificationList(id);

		List<NideshopProduct> productList = goodsService.getProductList(id);
		Result result = new Result();
		HashMap<String, Object> data = new HashMap<>();
		data.put("info", info);
		data.put("gallery", gallery);
		data.put("attribute", attribute);
		data.put("userHasCollect", userHasCollect);
		data.put("issue", issue);
		data.put("comment", comment);
		data.put("brand", brand);
		data.put("specificationList", specificationList);
		data.put("productList", productList);
		result.setData(data);
		return result;
	}

	@RequestMapping("goods/related")
	public Result related(Integer id) {

		List<NideshopGoods> relatedGoods = goodsService.relatedGoods(id);
		HashMap<String, Object> map = new HashMap<>();
		map.put("goodsList", relatedGoods);
		Result result = new Result();
		result.setData(map);
		return result;
	}

	@RequestMapping("goods/hot")
	public Result hot() {

		HashMap<String, Object> data = new HashMap<>();
		HashMap<String, Object> bannerInfo = new HashMap<>();
		bannerInfo.put("url", "");
		bannerInfo.put("name", "大家都在买的严选好物");
		bannerInfo.put("img_url", "http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");
		data.put("bannerInfo", bannerInfo);
		Result result = new Result();
		return result;
	}

	@RequestMapping("goods/new")
	public Result newGoods() {
		HashMap<String, Object> data = new HashMap<>();
		HashMap<String, Object> bannerInfo = new HashMap<>();
		bannerInfo.put("url", "");
		bannerInfo.put("name", "坚持初心，为你寻觅世间好物");
		bannerInfo.put("img_url", "http://yanxuan.nosdn.127.net/8976116db321744084774643a933c5ce.png");
		data.put("bannerInfo", bannerInfo);
		Result result = new Result();
		return result;
	}

	@RequestMapping("goods/filter")
	public Result filter(Integer categoryId, String keyword, Integer isNew, Integer isHot) {
		Example example = new Example(NideshopGoods.class);
		Criteria criteria = example.createCriteria();

		if (categoryId != null) {
			List<Integer> ids = categoryService.getChildCategoryId(categoryId);
			criteria.andIn("categoryId", ids);
		}

		if (isNew != null) {
			criteria.andEqualTo("isNew", isNew);
		}
		if (isHot != null) {
			criteria.andEqualTo("isHot", isHot);
		}
		if (keyword != null) {
			criteria.andLike("name", "%" + keyword + "%");
		}
		List<NideshopCategory> filterCategory = new ArrayList<>();

		NideshopCategory superParent = new NideshopCategory();
		superParent.setName("全部");
		superParent.setId(0);
		filterCategory.add(0, superParent);

		example.selectProperties("categoryId");
		@SuppressWarnings("unchecked")
		List<Integer> categoryIds = goodsService.queryByExample(example);
		if (categoryIds != null && categoryIds.size() > 0) {
			List<Integer> parentIds = categoryService.getParentIdsBycategoryIds(categoryIds);
			List<NideshopCategory> parentCategory = categoryService.selectByIdList(parentIds);
			if(parentCategory!=null&&parentCategory.size()>0) {
				filterCategory.addAll(parentCategory);
			}
		}

		Result result = new Result();
		result.setData(filterCategory);
		return result;
	}

	@RequestMapping("goods/sku")
	public Result sku(Integer id) {
		List<Specification> specificationList = goodsService.getSpecificationList(id);
		List<NideshopProduct> productList = goodsService.getProductList(id);
		HashMap<String, Object> data = new HashMap<>();
		data.put("specificationList", specificationList);
		data.put("productList", productList);
		
		Result result = new Result();
		return result;
	}
	
	@RequestMapping("goods/index")
	public Result index() {
		List<NideshopGoods> goodsList=goodsService.selectAll();
		Result result = new Result();
		result.setData(goodsList);
		return result;
	}
	
}
