
@Controller
public class SqlReportController {

	@Autowired
	QueryTemplateRepository queryTemplateRepository;
	public ModelAndView executeQuery(@RequestParam Map<String, String> params, @RequestParam("templateName") String templateName) {
		ModelAndView mv = new ModelAndView("");
		List<Map<String, Object>> rows = queryService.executeQueryWithParams(templateName, params);
		// TODO: add rows to the model
		return mv;
	}
}
