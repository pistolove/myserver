package myserver.api.modules;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.lib.mysql.FacadeMySqlDao;
import com.lib.server.CacheTemplate;
import com.lib.server.RmiClient;
import com.lib.transport.BaseTpDao;
import com.lib.transport.FacadeTpDao;
import com.lib.transport.HttpClientTemplate;

@Component
public class BaseService {

	@Resource
	protected FacadeService facadeService;

	@Resource
	protected BaseTpDao baseTpDao;

	@Resource
	protected FacadeTpDao facadeTpDao;

	@Resource
	protected FacadeMySqlDao facadeMySqlDao;
	
	@Resource
	protected HttpClientTemplate httpClientTemplate;

	protected RmiClient rmiClient = RmiClient.getRmiClient();

	@Resource
	protected CacheTemplate cacheTemplate;

	public FacadeService getFacadeService() {
		return facadeService;
	}

	public void setFacadeService(FacadeService facadeService) {
		this.facadeService = facadeService;
	}

	public BaseTpDao getBaseTpDao() {
		return baseTpDao;
	}

	public void setBaseTpDao(BaseTpDao baseTpDao) {
		this.baseTpDao = baseTpDao;
	}

	public FacadeTpDao getFacadeTpDao() {
		return facadeTpDao;
	}

	public void setFacadeTpDao(FacadeTpDao facadeTpDao) {
		this.facadeTpDao = facadeTpDao;
	}

	public HttpClientTemplate getHttpClientTemplate() {
		return httpClientTemplate;
	}

	public void setHttpClientTemplate(HttpClientTemplate httpClientTemplate) {
		this.httpClientTemplate = httpClientTemplate;
	}

	public CacheTemplate getCacheTemplate() {
		return cacheTemplate;
	}

	public void setCacheTemplate(CacheTemplate cacheTemplate) {
		this.cacheTemplate = cacheTemplate;
	}

	public RmiClient getRmiClient() {
		return rmiClient;
	}

	public void setRmiClient(RmiClient rmiClient) {
		this.rmiClient = rmiClient;
	}

	public FacadeMySqlDao getfacadeMySqlDao() {
		return facadeMySqlDao;
	}

	public void setfacadeMySqlDao(FacadeMySqlDao mySqlDao) {
		this.facadeMySqlDao = mySqlDao;
	}

	
}
