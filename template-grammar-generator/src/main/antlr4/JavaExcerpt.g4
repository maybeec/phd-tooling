grammar JavaExcerpt;

normalClassDeclarationOrPH: normalClassDeclaration | PLACEHOLDER;

normalClassDeclaration
  : fm_classModifierOrPH* fm_CLASSOrPH fm_IdentifierOrPH fm_classBodyOrPH EOF
  ;

fm_CLASSOrPH: CLASS | PLACEHOLDER;

fm_classBodyOrPH: classBody| PLACEHOLDER;
classBody: '{}';


fm_classModifierOrPH: classModifier| PLACEHOLDER;

fm_IdentifierOrPH: Identifier| PLACEHOLDER;

Identifier: 'TestClass';


classModifier
  : fm_PUBLICOrPH
  ;

// LEXER
PUBLIC : 'public';
fm_PUBLICOrPH: PUBLIC| PLACEHOLDER;

CLASS : 'class';

PLACEHOLDER: '${' .*? '}';