grammar SimpleFreeMarker;

if: IF body (ELSE_IF body)* (ELSE body)? IF_CLOSE;

ifElse: IF body (ELSE_IF body)* ELSE body IF_CLOSE;

loop: LIST body LIST_CLOSE;


PLACEHOLDER: '${' ~'}'+? '}';
IF: '<#if' ~'>'+? '>';
IF_CLOSE: '</#if>';
ELSE_IF: '<#elseif' ~'>'+? '>';
ELSE: '<#else>';
LIST: '<#list' .+? 'as' ~'>'+? '>';
LIST_CLOSE: '</#list>';