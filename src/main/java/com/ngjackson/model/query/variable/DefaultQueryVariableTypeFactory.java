
public class DefaultQueryVariableTypeFactory implements QueryVariableTypeFactory {
	public static final String DATE_TYPE_NAME = "Date";
	public static final String INTEGER_TYPE_NAME = "Integer";
	public static final String DECIMAL_TYPE_NAME = "Decimal";
	public static final String STRING_TYPE_NAME = "String";
	public QueryVariableType createQueryVariableType(String typeName) {
		if (typeName.equalsIgnoreCase(DATE_TYPE_NAME)) {
			return new QueryVariableDate();
		}
		else if (typeName.equalsIgnoreCase(INTEGER_TYPE_NAME)) {
			return new QueryVariableInteger();
		}
		else if (typeName.equalsIgnoreCase(DECIMAL_TYPE_NAME)) {
			return new QueryVariableDecimal();
		}
		else if (typeName.equalsIgnoreCase(STRING_TYPE_NAME)) {
			return new QueryVariableString();
		} else {
			throw new IllegalArgumentException("");
		}

	}
}
