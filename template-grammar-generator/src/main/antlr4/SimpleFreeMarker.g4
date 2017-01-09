grammar SimpleFreeMarker;

PlaceHolder: '${' .*? '}';

if: '<#if' .*? '>' body ('<#elseif' .*? '>' body)* '</#if>';

ifElse: '<#if' .*? '>' body ('<#elseif' .*? '>' body )* '<#else>' body '</#if>';

loop: '<#list' .*? 'as' .*? '>' body '</#list>';