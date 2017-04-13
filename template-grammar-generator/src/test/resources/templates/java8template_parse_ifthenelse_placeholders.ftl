import a.c.b;

public class TestClass{

  private int i;

  <#if x == 1>
    private int = ${value};
  <#elseif x == 2>
    private int = ${class}.${"another" + method};
  <#else>
    ${acb}
  </#if>

  <#list fieldnames as fieldname>
    private int ${fieldname};
  </#list>

  public void lala() {
    // This${type} a;
  }
}