import a.c.b;

public class TestClass{

  private int i;

  <#if x == 1>
    private int i1; // = ${value};
  <#elseif x == 2>
    private int i2; // = ${class}.${"another" + method};
  <#else>
    private int ix;
  </#if>

  <#list fieldnames as fieldname>
    private int abc; // ${fieldname};
  </#list>

  public void lala() {
    // This${type} a;
  }
}