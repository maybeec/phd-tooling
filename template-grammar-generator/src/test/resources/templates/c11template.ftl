int number1=1;
int number2=${number};

<#list specifiers as spec>
  ${spec}
</#list> sum;

int main( v  oid )
{

  <#if x == 1>
    sum=number1;
  <#elseif x == 2>
    sum=number2;
  <#else>
    sum=number1+number2;
  </#if>

    return sum;
}