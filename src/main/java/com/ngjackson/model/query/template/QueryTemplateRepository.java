
public class QueryTemplateRepository {
	public QueryTemplate getQueryTemplate(String templateName);
	public Collection<QueryTemplate> getAllQueryTemplates();
	public void createQueryTemplate(QueryTemplate template);
	public void deleteQueryTemplate(String templateName);
	public void updateQueryTemplate(QueryTemplate template);
}
