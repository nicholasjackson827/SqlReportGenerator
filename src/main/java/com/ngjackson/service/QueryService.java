

@Service
public class QueryService {
	@Autowired
	QueryTemplateRepository queryTemplateRepository;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List<Map<String, Object>> executeQueryWithParams(String queryTemplateName, Map<String, String> params) {
		QueryTemplate queryTemplate = queryTemplateRepository.getQueryTemplate(queryTemplateName);
		Query query = queryTemplate.createQuery(params);
		return query.executeQuery(namedParameterJdbcTemplate);
	}
}
