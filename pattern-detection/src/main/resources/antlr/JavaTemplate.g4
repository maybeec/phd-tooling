/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
 Copyright (c) 2017 Ivan Kochurkin
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/*parser */grammar JavaTemplate;

// options { tokenVocab=JavaLexer; }

compilationUnit
    : (fm_packageDeclarationOpt | packageDeclaration)? (fm_importDeclarationStar | importDeclaration)* (fm_typeDeclarationStar | typeDeclaration)* EOF
    ;

packageDeclaration
    : (fm_annotationStar | annotation)* PACKAGE (fm_qualifiedName | qualifiedName) SEMI 
    ;
fm_packageDeclarationOpt: FM_PLACEHOLDER | FM_IF (fm_packageDeclarationOpt | packageDeclaration)? (FM_ELSE_IF (fm_packageDeclarationOpt | packageDeclaration)?)* (FM_ELSE (fm_packageDeclarationOpt | packageDeclaration)?)? FM_IF_CLOSE;

importDeclaration
    : IMPORT STATIC? (fm_qualifiedName | qualifiedName) (DOT  MUL )? SEMI 
    ;
fm_importDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_importDeclarationStar | importDeclaration)* (FM_ELSE_IF (fm_importDeclarationStar | importDeclaration)*)* (FM_ELSE (fm_importDeclarationStar | importDeclaration)*)? FM_IF_CLOSE | FM_LIST (fm_importDeclarationStar | importDeclaration)* FM_LIST_CLOSE;

typeDeclaration
    : (fm_classOrInterfaceModifierStar | classOrInterfaceModifier)*
      (classDeclaration | enumDeclaration | interfaceDeclaration | annotationTypeDeclaration)
    | SEMI 
    ;
fm_typeDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_typeDeclarationStar | typeDeclaration)* (FM_ELSE_IF (fm_typeDeclarationStar | typeDeclaration)*)* (FM_ELSE (fm_typeDeclarationStar | typeDeclaration)*)? FM_IF_CLOSE | FM_LIST (fm_typeDeclarationStar | typeDeclaration)* FM_LIST_CLOSE;

modifier
    : classOrInterfaceModifier
    | NATIVE
    | SYNCHRONIZED
    | TRANSIENT
    | VOLATILE
    ;
fm_modifierStar: FM_PLACEHOLDER | FM_IF (fm_modifierStar | modifier)* (FM_ELSE_IF (fm_modifierStar | modifier)*)* (FM_ELSE (fm_modifierStar | modifier)*)? FM_IF_CLOSE | FM_LIST (fm_modifierStar | modifier)* FM_LIST_CLOSE;

classOrInterfaceModifier
    : annotation
    | PUBLIC
    | PROTECTED
    | PRIVATE
    | STATIC
    | ABSTRACT
    | FINAL    // FINAL for class only -- does not apply to interfaces
    | STRICTFP
    ;
fm_classOrInterfaceModifierStar: FM_PLACEHOLDER | FM_IF (fm_classOrInterfaceModifierStar | classOrInterfaceModifier)* (FM_ELSE_IF (fm_classOrInterfaceModifierStar | classOrInterfaceModifier)*)* (FM_ELSE (fm_classOrInterfaceModifierStar | classOrInterfaceModifier)*)? FM_IF_CLOSE | FM_LIST (fm_classOrInterfaceModifierStar | classOrInterfaceModifier)* FM_LIST_CLOSE;

variableModifier
    : FINAL
    | annotation
    ;
fm_variableModifierStar: FM_PLACEHOLDER | FM_IF (fm_variableModifierStar | variableModifier)* (FM_ELSE_IF (fm_variableModifierStar | variableModifier)*)* (FM_ELSE (fm_variableModifierStar | variableModifier)*)? FM_IF_CLOSE | FM_LIST (fm_variableModifierStar | variableModifier)* FM_LIST_CLOSE;

classDeclaration
    : CLASS (fm_IDENTIFIER | IDENTIFIER) (fm_typeParametersOpt | typeParameters)?
      (EXTENDS (fm_typeType | typeType))?
      (IMPLEMENTS (fm_typeList | typeList))?
      (fm_classBody | classBody)
    ;

typeParameters
    : LT  (fm_typeParameter | typeParameter) (COMMA  (fm_typeParameter | typeParameter))* GT 
    ;
fm_typeParameters: FM_PLACEHOLDER | FM_IF (fm_typeParameters | typeParameters) (FM_ELSE_IF (fm_typeParameters | typeParameters))* FM_ELSE (fm_typeParameters | typeParameters) FM_IF_CLOSE;
fm_typeParametersOpt: FM_PLACEHOLDER | FM_IF (fm_typeParametersOpt | typeParameters)? (FM_ELSE_IF (fm_typeParametersOpt | typeParameters)?)* (FM_ELSE (fm_typeParametersOpt | typeParameters)?)? FM_IF_CLOSE;

typeParameter
    : (fm_annotationStar | annotation)* IDENTIFIER (EXTENDS (fm_typeBound | typeBound))?
    ;
fm_typeParameter: FM_PLACEHOLDER | FM_IF (fm_typeParameter | typeParameter) (FM_ELSE_IF (fm_typeParameter | typeParameter))* FM_ELSE (fm_typeParameter | typeParameter) FM_IF_CLOSE;

typeBound
    : (fm_typeType | typeType) (BITAND  (fm_typeType | typeType))*
    ;
fm_typeBound: FM_PLACEHOLDER | FM_IF (fm_typeBound | typeBound) (FM_ELSE_IF (fm_typeBound | typeBound))* FM_ELSE (fm_typeBound | typeBound) FM_IF_CLOSE;

enumDeclaration
    : ENUM (fm_IDENTIFIER | IDENTIFIER) (IMPLEMENTS (fm_typeList | typeList))? LBRACE  (fm_enumConstantsOpt | enumConstants)? COMMA ? (fm_enumBodyDeclarationsOpt | enumBodyDeclarations)? RBRACE 
    ;

enumConstants
    : (fm_enumConstant | enumConstant) (COMMA  (fm_enumConstant | enumConstant))*
    ;
fm_enumConstantsOpt: FM_PLACEHOLDER | FM_IF (fm_enumConstantsOpt | enumConstants)? (FM_ELSE_IF (fm_enumConstantsOpt | enumConstants)?)* (FM_ELSE (fm_enumConstantsOpt | enumConstants)?)? FM_IF_CLOSE;

enumConstant
    : (fm_annotationStar | annotation)* IDENTIFIER (fm_argumentsOpt | arguments)? (fm_classBodyOpt | classBody)?
    ;
fm_enumConstant: FM_PLACEHOLDER | FM_IF (fm_enumConstant | enumConstant) (FM_ELSE_IF (fm_enumConstant | enumConstant))* FM_ELSE (fm_enumConstant | enumConstant) FM_IF_CLOSE;

enumBodyDeclarations
    : SEMI  (fm_classBodyDeclarationStar | classBodyDeclaration)*
    ;
fm_enumBodyDeclarationsOpt: FM_PLACEHOLDER | FM_IF (fm_enumBodyDeclarationsOpt | enumBodyDeclarations)? (FM_ELSE_IF (fm_enumBodyDeclarationsOpt | enumBodyDeclarations)?)* (FM_ELSE (fm_enumBodyDeclarationsOpt | enumBodyDeclarations)?)? FM_IF_CLOSE;

interfaceDeclaration
    : INTERFACE (fm_IDENTIFIER | IDENTIFIER) (fm_typeParametersOpt | typeParameters)? (EXTENDS (fm_typeList | typeList))? (fm_interfaceBody | interfaceBody)
    ;

classBody
    : LBRACE  (fm_classBodyDeclarationStar | classBodyDeclaration)* RBRACE 
    ;
fm_classBody: FM_PLACEHOLDER | FM_IF (fm_classBody | classBody) (FM_ELSE_IF (fm_classBody | classBody))* FM_ELSE (fm_classBody | classBody) FM_IF_CLOSE;
fm_classBodyOpt: FM_PLACEHOLDER | FM_IF (fm_classBodyOpt | classBody)? (FM_ELSE_IF (fm_classBodyOpt | classBody)?)* (FM_ELSE (fm_classBodyOpt | classBody)?)? FM_IF_CLOSE;

interfaceBody
    : LBRACE  (fm_interfaceBodyDeclarationStar | interfaceBodyDeclaration)* RBRACE 
    ;
fm_interfaceBody: FM_PLACEHOLDER | FM_IF (fm_interfaceBody | interfaceBody) (FM_ELSE_IF (fm_interfaceBody | interfaceBody))* FM_ELSE (fm_interfaceBody | interfaceBody) FM_IF_CLOSE;

classBodyDeclaration
    : SEMI 
    | STATIC? block
    | (fm_modifierStar | modifier)* memberDeclaration
    ;
fm_classBodyDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_classBodyDeclarationStar | classBodyDeclaration)* (FM_ELSE_IF (fm_classBodyDeclarationStar | classBodyDeclaration)*)* (FM_ELSE (fm_classBodyDeclarationStar | classBodyDeclaration)*)? FM_IF_CLOSE | FM_LIST (fm_classBodyDeclarationStar | classBodyDeclaration)* FM_LIST_CLOSE;

memberDeclaration
    : methodDeclaration
    | genericMethodDeclaration
    | fieldDeclaration
    | constructorDeclaration
    | genericConstructorDeclaration
    | interfaceDeclaration
    | annotationTypeDeclaration
    | classDeclaration
    | enumDeclaration
    ;

/* We use rule this even for void methods which cannot have [] after parameters.
   This simplifies grammar and we can consider void to be a type, which
   renders the [] matching as a context-sensitive issue or a semantic check
   for invalid return type after parsing.
 */
methodDeclaration
    : (fm_typeTypeOrVoid | typeTypeOrVoid) (fm_IDENTIFIER | IDENTIFIER) (fm_formalParameters | formalParameters) (LBRACK  RBRACK )*
      (THROWS (fm_qualifiedNameList | qualifiedNameList))?
      (fm_methodBody | methodBody)
    ;
fm_methodDeclaration: FM_PLACEHOLDER | FM_IF (fm_methodDeclaration | methodDeclaration) (FM_ELSE_IF (fm_methodDeclaration | methodDeclaration))* FM_ELSE (fm_methodDeclaration | methodDeclaration) FM_IF_CLOSE;

methodBody
    : block
    | SEMI 
    ;
fm_methodBody: FM_PLACEHOLDER | FM_IF (fm_methodBody | methodBody) (FM_ELSE_IF (fm_methodBody | methodBody))* FM_ELSE (fm_methodBody | methodBody) FM_IF_CLOSE;

typeTypeOrVoid
    : typeType | VOID
    ;
fm_typeTypeOrVoid: FM_PLACEHOLDER | FM_IF (fm_typeTypeOrVoid | typeTypeOrVoid) (FM_ELSE_IF (fm_typeTypeOrVoid | typeTypeOrVoid))* FM_ELSE (fm_typeTypeOrVoid | typeTypeOrVoid) FM_IF_CLOSE;

genericMethodDeclaration
    : (fm_typeParameters | typeParameters) (fm_methodDeclaration | methodDeclaration)
    ;

genericConstructorDeclaration
    : (fm_typeParameters | typeParameters) (fm_constructorDeclaration | constructorDeclaration)
    ;

constructorDeclaration
    : (fm_IDENTIFIER | IDENTIFIER) (fm_formalParameters | formalParameters) (THROWS (fm_qualifiedNameList | qualifiedNameList))? (fm_block | block)
    ;
fm_constructorDeclaration: FM_PLACEHOLDER | FM_IF (fm_constructorDeclaration | constructorDeclaration) (FM_ELSE_IF (fm_constructorDeclaration | constructorDeclaration))* FM_ELSE (fm_constructorDeclaration | constructorDeclaration) FM_IF_CLOSE;

fieldDeclaration
    : (fm_typeType | typeType) (fm_variableDeclarators | variableDeclarators) SEMI 
    ;

interfaceBodyDeclaration
    : (fm_modifierStar | modifier)* interfaceMemberDeclaration
    | SEMI 
    ;
fm_interfaceBodyDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_interfaceBodyDeclarationStar | interfaceBodyDeclaration)* (FM_ELSE_IF (fm_interfaceBodyDeclarationStar | interfaceBodyDeclaration)*)* (FM_ELSE (fm_interfaceBodyDeclarationStar | interfaceBodyDeclaration)*)? FM_IF_CLOSE | FM_LIST (fm_interfaceBodyDeclarationStar | interfaceBodyDeclaration)* FM_LIST_CLOSE;

interfaceMemberDeclaration
    : constDeclaration
    | interfaceMethodDeclaration
    | genericInterfaceMethodDeclaration
    | interfaceDeclaration
    | annotationTypeDeclaration
    | classDeclaration
    | enumDeclaration
    ;

constDeclaration
    : (fm_typeType | typeType) (fm_constantDeclarator | constantDeclarator) (COMMA  (fm_constantDeclarator | constantDeclarator))* SEMI 
    ;

constantDeclarator
    : (fm_IDENTIFIER | IDENTIFIER) (LBRACK  RBRACK )* ASSIGN  (fm_variableInitializer | variableInitializer)
    ;
fm_constantDeclarator: FM_PLACEHOLDER | FM_IF (fm_constantDeclarator | constantDeclarator) (FM_ELSE_IF (fm_constantDeclarator | constantDeclarator))* FM_ELSE (fm_constantDeclarator | constantDeclarator) FM_IF_CLOSE;

// see matching of [] comment in methodDeclaratorRest
// methodBody from Java 8
interfaceMethodDeclaration
    : (fm_interfaceMethodModifierStar | interfaceMethodModifier)* (fm_typeTypeOrVoid | typeTypeOrVoid) (fm_IDENTIFIER | IDENTIFIER) (fm_formalParameters | formalParameters) (LBRACK  RBRACK )* (THROWS (fm_qualifiedNameList | qualifiedNameList))? (fm_methodBody | methodBody)
    ;
fm_interfaceMethodDeclaration: FM_PLACEHOLDER | FM_IF (fm_interfaceMethodDeclaration | interfaceMethodDeclaration) (FM_ELSE_IF (fm_interfaceMethodDeclaration | interfaceMethodDeclaration))* FM_ELSE (fm_interfaceMethodDeclaration | interfaceMethodDeclaration) FM_IF_CLOSE;

// Java8
interfaceMethodModifier
    : annotation
    | PUBLIC
    | ABSTRACT
    | DEFAULT
    | STATIC
    | STRICTFP
    ;
fm_interfaceMethodModifierStar: FM_PLACEHOLDER | FM_IF (fm_interfaceMethodModifierStar | interfaceMethodModifier)* (FM_ELSE_IF (fm_interfaceMethodModifierStar | interfaceMethodModifier)*)* (FM_ELSE (fm_interfaceMethodModifierStar | interfaceMethodModifier)*)? FM_IF_CLOSE | FM_LIST (fm_interfaceMethodModifierStar | interfaceMethodModifier)* FM_LIST_CLOSE;

genericInterfaceMethodDeclaration
    : (fm_typeParameters | typeParameters) (fm_interfaceMethodDeclaration | interfaceMethodDeclaration)
    ;

variableDeclarators
    : (fm_variableDeclarator | variableDeclarator) (COMMA  (fm_variableDeclarator | variableDeclarator))*
    ;
fm_variableDeclarators: FM_PLACEHOLDER | FM_IF (fm_variableDeclarators | variableDeclarators) (FM_ELSE_IF (fm_variableDeclarators | variableDeclarators))* FM_ELSE (fm_variableDeclarators | variableDeclarators) FM_IF_CLOSE;

variableDeclarator
    : variableDeclaratorId (ASSIGN  (fm_variableInitializer | variableInitializer))?
    ;
fm_variableDeclarator: FM_PLACEHOLDER | FM_IF (fm_variableDeclarator | variableDeclarator) (FM_ELSE_IF (fm_variableDeclarator | variableDeclarator))* FM_ELSE (fm_variableDeclarator | variableDeclarator) FM_IF_CLOSE;

variableDeclaratorId
    : IDENTIFIER (LBRACK  RBRACK )*
    ;
fm_variableDeclaratorId: FM_PLACEHOLDER | FM_IF (fm_variableDeclaratorId | variableDeclaratorId) (FM_ELSE_IF (fm_variableDeclaratorId | variableDeclaratorId))* FM_ELSE (fm_variableDeclaratorId | variableDeclaratorId) FM_IF_CLOSE;

variableInitializer
    : arrayInitializer
    | expression
    ;
fm_variableInitializer: FM_PLACEHOLDER | FM_IF (fm_variableInitializer | variableInitializer) (FM_ELSE_IF (fm_variableInitializer | variableInitializer))* FM_ELSE (fm_variableInitializer | variableInitializer) FM_IF_CLOSE;

arrayInitializer
    : LBRACE  ((fm_variableInitializer | variableInitializer) (COMMA  (fm_variableInitializer | variableInitializer))* (COMMA )? )? RBRACE 
    ;
fm_arrayInitializer: FM_PLACEHOLDER | FM_IF (fm_arrayInitializer | arrayInitializer) (FM_ELSE_IF (fm_arrayInitializer | arrayInitializer))* FM_ELSE (fm_arrayInitializer | arrayInitializer) FM_IF_CLOSE;

classOrInterfaceType
    : IDENTIFIER (fm_typeArgumentsOpt | typeArguments)? (DOT  (fm_IDENTIFIER | IDENTIFIER) (fm_typeArgumentsOpt | typeArguments)?)*
    ;
fm_classOrInterfaceType: FM_PLACEHOLDER | FM_IF (fm_classOrInterfaceType | classOrInterfaceType) (FM_ELSE_IF (fm_classOrInterfaceType | classOrInterfaceType))* FM_ELSE (fm_classOrInterfaceType | classOrInterfaceType) FM_IF_CLOSE;

typeArgument
    : typeType
    | QUESTION  ((EXTENDS | SUPER) (fm_typeType | typeType))?
    ;
fm_typeArgument: FM_PLACEHOLDER | FM_IF (fm_typeArgument | typeArgument) (FM_ELSE_IF (fm_typeArgument | typeArgument))* FM_ELSE (fm_typeArgument | typeArgument) FM_IF_CLOSE;

qualifiedNameList
    : (fm_qualifiedName | qualifiedName) (COMMA  (fm_qualifiedName | qualifiedName))*
    ;
fm_qualifiedNameList: FM_PLACEHOLDER | FM_IF (fm_qualifiedNameList | qualifiedNameList) (FM_ELSE_IF (fm_qualifiedNameList | qualifiedNameList))* FM_ELSE (fm_qualifiedNameList | qualifiedNameList) FM_IF_CLOSE;

formalParameters
    : LPAREN  (fm_formalParameterListOpt | formalParameterList)? RPAREN 
    ;
fm_formalParameters: FM_PLACEHOLDER | FM_IF (fm_formalParameters | formalParameters) (FM_ELSE_IF (fm_formalParameters | formalParameters))* FM_ELSE (fm_formalParameters | formalParameters) FM_IF_CLOSE;

formalParameterList
    : formalParameter (COMMA  (fm_formalParameter | formalParameter))* (COMMA  (fm_lastFormalParameter | lastFormalParameter))?
    | lastFormalParameter
    ;
fm_formalParameterListOpt: FM_PLACEHOLDER | FM_IF (fm_formalParameterListOpt | formalParameterList)? (FM_ELSE_IF (fm_formalParameterListOpt | formalParameterList)?)* (FM_ELSE (fm_formalParameterListOpt | formalParameterList)?)? FM_IF_CLOSE;

formalParameter
    : (fm_variableModifierStar | variableModifier)* (fm_typeType | typeType) (fm_variableDeclaratorId | variableDeclaratorId)
    ;
fm_formalParameter: FM_PLACEHOLDER | FM_IF (fm_formalParameter | formalParameter) (FM_ELSE_IF (fm_formalParameter | formalParameter))* FM_ELSE (fm_formalParameter | formalParameter) FM_IF_CLOSE;

lastFormalParameter
    : (fm_variableModifierStar | variableModifier)* (fm_typeType | typeType) ELLIPSIS  (fm_variableDeclaratorId | variableDeclaratorId)
    ;
fm_lastFormalParameter: FM_PLACEHOLDER | FM_IF (fm_lastFormalParameter | lastFormalParameter) (FM_ELSE_IF (fm_lastFormalParameter | lastFormalParameter))* FM_ELSE (fm_lastFormalParameter | lastFormalParameter) FM_IF_CLOSE;

qualifiedName
    : IDENTIFIER 
    | fm_qualifiedName DOT ( fm_IDENTIFIER | IDENTIFIER ) 
  | qualifiedName DOT  (fm_IDENTIFIER | IDENTIFIER)
    ;
fm_qualifiedName: FM_PLACEHOLDER | FM_IF (fm_qualifiedName | qualifiedName) (FM_ELSE_IF (fm_qualifiedName | qualifiedName))* FM_ELSE (fm_qualifiedName | qualifiedName) FM_IF_CLOSE;

literal
    : integerLiteral
    | FLOAT_LITERAL
    | CHAR_LITERAL
    | STRING_LITERAL
    | BOOL_LITERAL
    | NULL_LITERAL
    ;

integerLiteral
    : DECIMAL_LITERAL
    | HEX_LITERAL
    | OCT_LITERAL
    | BINARY_LITERAL
    ;

// ANNOTATIONS

annotation
    : AT  (fm_qualifiedName | qualifiedName) (LPAREN  ( (fm_elementValuePairs | elementValuePairs) | (fm_elementValue | elementValue) )? RPAREN )?
    ;
fm_annotationStar: FM_PLACEHOLDER | FM_IF (fm_annotationStar | annotation)* (FM_ELSE_IF (fm_annotationStar | annotation)*)* (FM_ELSE (fm_annotationStar | annotation)*)? FM_IF_CLOSE | FM_LIST (fm_annotationStar | annotation)* FM_LIST_CLOSE;

elementValuePairs
    : (fm_elementValuePair | elementValuePair) (COMMA  (fm_elementValuePair | elementValuePair))*
    ;
fm_elementValuePairs: FM_PLACEHOLDER | FM_IF (fm_elementValuePairs | elementValuePairs) (FM_ELSE_IF (fm_elementValuePairs | elementValuePairs))* FM_ELSE (fm_elementValuePairs | elementValuePairs) FM_IF_CLOSE;

elementValuePair
    : (fm_IDENTIFIER | IDENTIFIER) ASSIGN  (fm_elementValue | elementValue)
    ;
fm_elementValuePair: FM_PLACEHOLDER | FM_IF (fm_elementValuePair | elementValuePair) (FM_ELSE_IF (fm_elementValuePair | elementValuePair))* FM_ELSE (fm_elementValuePair | elementValuePair) FM_IF_CLOSE;

elementValue
    : expression
    | annotation
    | elementValueArrayInitializer
    ;
fm_elementValue: FM_PLACEHOLDER | FM_IF (fm_elementValue | elementValue) (FM_ELSE_IF (fm_elementValue | elementValue))* FM_ELSE (fm_elementValue | elementValue) FM_IF_CLOSE;

elementValueArrayInitializer
    : LBRACE  ((fm_elementValue | elementValue) (COMMA  (fm_elementValue | elementValue))*)? (COMMA )? RBRACE 
    ;

annotationTypeDeclaration
    : AT  INTERFACE (fm_IDENTIFIER | IDENTIFIER) (fm_annotationTypeBody | annotationTypeBody)
    ;

annotationTypeBody
    : LBRACE  ((fm_annotationTypeElementDeclaration | annotationTypeElementDeclaration))* RBRACE 
    ;
fm_annotationTypeBody: FM_PLACEHOLDER | FM_IF (fm_annotationTypeBody | annotationTypeBody) (FM_ELSE_IF (fm_annotationTypeBody | annotationTypeBody))* FM_ELSE (fm_annotationTypeBody | annotationTypeBody) FM_IF_CLOSE;

annotationTypeElementDeclaration
    : (fm_modifierStar | modifier)* annotationTypeElementRest
    | SEMI  // this is not allowed by the grammar, but apparently allowed by the actual compiler
    ;
fm_annotationTypeElementDeclaration: FM_PLACEHOLDER | FM_IF (fm_annotationTypeElementDeclaration | annotationTypeElementDeclaration) (FM_ELSE_IF (fm_annotationTypeElementDeclaration | annotationTypeElementDeclaration))* FM_ELSE (fm_annotationTypeElementDeclaration | annotationTypeElementDeclaration) FM_IF_CLOSE;

annotationTypeElementRest
    : (fm_typeType | typeType) (fm_annotationMethodOrConstantRest | annotationMethodOrConstantRest) SEMI 
    | classDeclaration SEMI ?
    | interfaceDeclaration SEMI ?
    | enumDeclaration SEMI ?
    | annotationTypeDeclaration SEMI ?
    ;

annotationMethodOrConstantRest
    : annotationMethodRest
    | annotationConstantRest
    ;
fm_annotationMethodOrConstantRest: FM_PLACEHOLDER | FM_IF (fm_annotationMethodOrConstantRest | annotationMethodOrConstantRest) (FM_ELSE_IF (fm_annotationMethodOrConstantRest | annotationMethodOrConstantRest))* FM_ELSE (fm_annotationMethodOrConstantRest | annotationMethodOrConstantRest) FM_IF_CLOSE;

annotationMethodRest
    : (fm_IDENTIFIER | IDENTIFIER) LPAREN  RPAREN  (fm_defaultValueOpt | defaultValue)?
    ;

annotationConstantRest
    : variableDeclarators
    ;

defaultValue
    : DEFAULT (fm_elementValue | elementValue)
    ;
fm_defaultValueOpt: FM_PLACEHOLDER | FM_IF (fm_defaultValueOpt | defaultValue)? (FM_ELSE_IF (fm_defaultValueOpt | defaultValue)?)* (FM_ELSE (fm_defaultValueOpt | defaultValue)?)? FM_IF_CLOSE;

// STATEMENTS / BLOCKS

block
    : LBRACE  (fm_blockStatementStar | blockStatement)* RBRACE 
    ;
fm_block: FM_PLACEHOLDER | FM_IF (fm_block | block) (FM_ELSE_IF (fm_block | block))* FM_ELSE (fm_block | block) FM_IF_CLOSE;

blockStatement
    : (fm_localVariableDeclaration | localVariableDeclaration) SEMI 
    | statement
    | typeDeclaration
    ;
fm_blockStatementStar: FM_PLACEHOLDER | FM_IF (fm_blockStatementStar | blockStatement)* (FM_ELSE_IF (fm_blockStatementStar | blockStatement)*)* (FM_ELSE (fm_blockStatementStar | blockStatement)*)? FM_IF_CLOSE | FM_LIST (fm_blockStatementStar | blockStatement)* FM_LIST_CLOSE;
fm_blockStatementPlus: FM_PLACEHOLDER | (FM_IF (fm_blockStatementPlus | blockStatement)* (FM_ELSE_IF (fm_blockStatementPlus | blockStatement)*)* (FM_ELSE (fm_blockStatementPlus | blockStatement)*)? FM_IF_CLOSE | FM_LIST (fm_blockStatementPlus | blockStatement)* FM_LIST_CLOSE)* (FM_PLACEHOLDER | FM_IF (fm_blockStatementPlus | blockStatement)* (FM_ELSE_IF (fm_blockStatementPlus | blockStatement)*)* FM_ELSE (fm_blockStatementPlus | blockStatement)* FM_IF_CLOSE | FM_LIST (fm_blockStatementPlus | blockStatement)* FM_ELSE (fm_blockStatementPlus | blockStatement)* FM_LIST_CLOSE) (FM_IF (fm_blockStatementPlus | blockStatement)* (FM_ELSE_IF (fm_blockStatementPlus | blockStatement)*)* (FM_ELSE (fm_blockStatementPlus | blockStatement)*)? FM_IF_CLOSE | FM_LIST (fm_blockStatementPlus | blockStatement)* FM_LIST_CLOSE)*;

localVariableDeclaration
    : (fm_variableModifierStar | variableModifier)* (fm_typeType | typeType) (fm_variableDeclarators | variableDeclarators)
    ;
fm_localVariableDeclaration: FM_PLACEHOLDER | FM_IF (fm_localVariableDeclaration | localVariableDeclaration) (FM_ELSE_IF (fm_localVariableDeclaration | localVariableDeclaration))* FM_ELSE (fm_localVariableDeclaration | localVariableDeclaration) FM_IF_CLOSE;

statement
    : blockLabel=block
    | ASSERT (fm_expression | expression) (COLON  (fm_expression | expression))? SEMI 
    | IF (fm_parExpression | parExpression) (fm_statement | statement) (ELSE (fm_statement | statement))?
    | FOR LPAREN  (fm_forControl | forControl) RPAREN  (fm_statement | statement)
    | WHILE (fm_parExpression | parExpression) (fm_statement | statement)
    | DO (fm_statement | statement) WHILE (fm_parExpression | parExpression) SEMI 
    | TRY (fm_block | block) ((fm_catchClausePlus | catchClause)+ (fm_finallyBlockOpt | finallyBlock)? | (fm_finallyBlock | finallyBlock))
    | TRY (fm_resourceSpecification | resourceSpecification) (fm_block | block) (fm_catchClauseStar | catchClause)* (fm_finallyBlockOpt | finallyBlock)?
    | SWITCH (fm_parExpression | parExpression) LBRACE  (fm_switchBlockStatementGroupStar | switchBlockStatementGroup)* (fm_switchLabelStar | switchLabel)* RBRACE 
    | SYNCHRONIZED (fm_parExpression | parExpression) (fm_block | block)
    | RETURN (fm_expressionOpt | expression)? SEMI 
    | THROW (fm_expression | expression) SEMI 
    | BREAK (fm_IDENTIFIEROpt | IDENTIFIER)? SEMI 
    | CONTINUE (fm_IDENTIFIEROpt | IDENTIFIER)? SEMI 
    | SEMI
    | (fm_expression | expression) SEMI 
    | (fm_IDENTIFIER | IDENTIFIER) COLON  (fm_statement | statement)
    ;
fm_statement: FM_PLACEHOLDER | FM_IF (fm_statement | statement) (FM_ELSE_IF (fm_statement | statement))* FM_ELSE (fm_statement | statement) FM_IF_CLOSE;

catchClause
    : CATCH LPAREN  (fm_variableModifierStar | variableModifier)* (fm_catchType | catchType) (fm_IDENTIFIER | IDENTIFIER) RPAREN  (fm_block | block)
    ;
fm_catchClauseStar: FM_PLACEHOLDER | FM_IF (fm_catchClauseStar | catchClause)* (FM_ELSE_IF (fm_catchClauseStar | catchClause)*)* (FM_ELSE (fm_catchClauseStar | catchClause)*)? FM_IF_CLOSE | FM_LIST (fm_catchClauseStar | catchClause)* FM_LIST_CLOSE;
fm_catchClausePlus: FM_PLACEHOLDER | (FM_IF (fm_catchClausePlus | catchClause)* (FM_ELSE_IF (fm_catchClausePlus | catchClause)*)* (FM_ELSE (fm_catchClausePlus | catchClause)*)? FM_IF_CLOSE | FM_LIST (fm_catchClausePlus | catchClause)* FM_LIST_CLOSE)* (FM_PLACEHOLDER | FM_IF (fm_catchClausePlus | catchClause)* (FM_ELSE_IF (fm_catchClausePlus | catchClause)*)* FM_ELSE (fm_catchClausePlus | catchClause)* FM_IF_CLOSE | FM_LIST (fm_catchClausePlus | catchClause)* FM_ELSE (fm_catchClausePlus | catchClause)* FM_LIST_CLOSE) (FM_IF (fm_catchClausePlus | catchClause)* (FM_ELSE_IF (fm_catchClausePlus | catchClause)*)* (FM_ELSE (fm_catchClausePlus | catchClause)*)? FM_IF_CLOSE | FM_LIST (fm_catchClausePlus | catchClause)* FM_LIST_CLOSE)*;

catchType
    : (fm_qualifiedName | qualifiedName) (BITOR  (fm_qualifiedName | qualifiedName))*
    ;
fm_catchType: FM_PLACEHOLDER | FM_IF (fm_catchType | catchType) (FM_ELSE_IF (fm_catchType | catchType))* FM_ELSE (fm_catchType | catchType) FM_IF_CLOSE;

finallyBlock
    : FINALLY (fm_block | block)
    ;
fm_finallyBlock: FM_PLACEHOLDER | FM_IF (fm_finallyBlock | finallyBlock) (FM_ELSE_IF (fm_finallyBlock | finallyBlock))* FM_ELSE (fm_finallyBlock | finallyBlock) FM_IF_CLOSE;
fm_finallyBlockOpt: FM_PLACEHOLDER | FM_IF (fm_finallyBlockOpt | finallyBlock)? (FM_ELSE_IF (fm_finallyBlockOpt | finallyBlock)?)* (FM_ELSE (fm_finallyBlockOpt | finallyBlock)?)? FM_IF_CLOSE;

resourceSpecification
    : LPAREN  (fm_resources | resources) SEMI ? RPAREN 
    ;
fm_resourceSpecification: FM_PLACEHOLDER | FM_IF (fm_resourceSpecification | resourceSpecification) (FM_ELSE_IF (fm_resourceSpecification | resourceSpecification))* FM_ELSE (fm_resourceSpecification | resourceSpecification) FM_IF_CLOSE;

resources
    : (fm_resource | resource) (SEMI  (fm_resource | resource))*
    ;
fm_resources: FM_PLACEHOLDER | FM_IF (fm_resources | resources) (FM_ELSE_IF (fm_resources | resources))* FM_ELSE (fm_resources | resources) FM_IF_CLOSE;

resource
    : (fm_variableModifierStar | variableModifier)* (fm_classOrInterfaceType | classOrInterfaceType) (fm_variableDeclaratorId | variableDeclaratorId) ASSIGN  (fm_expression | expression)
    ;
fm_resource: FM_PLACEHOLDER | FM_IF (fm_resource | resource) (FM_ELSE_IF (fm_resource | resource))* FM_ELSE (fm_resource | resource) FM_IF_CLOSE;

/** Matches cases then statements, both of which are mandatory.
 *  To handle empty cases at the end, we add switchLabel* to statement.
 */
switchBlockStatementGroup
    : (fm_switchLabelPlus | switchLabel)+ (fm_blockStatementPlus | blockStatement)+
    ;
fm_switchBlockStatementGroupStar: FM_PLACEHOLDER | FM_IF (fm_switchBlockStatementGroupStar | switchBlockStatementGroup)* (FM_ELSE_IF (fm_switchBlockStatementGroupStar | switchBlockStatementGroup)*)* (FM_ELSE (fm_switchBlockStatementGroupStar | switchBlockStatementGroup)*)? FM_IF_CLOSE | FM_LIST (fm_switchBlockStatementGroupStar | switchBlockStatementGroup)* FM_LIST_CLOSE;

switchLabel
    : CASE ((fm_expression | expression) | (fm_IDENTIFIER | IDENTIFIER)) COLON 
    | DEFAULT COLON 
    ;
fm_switchLabelStar: FM_PLACEHOLDER | FM_IF (fm_switchLabelStar | switchLabel)* (FM_ELSE_IF (fm_switchLabelStar | switchLabel)*)* (FM_ELSE (fm_switchLabelStar | switchLabel)*)? FM_IF_CLOSE | FM_LIST (fm_switchLabelStar | switchLabel)* FM_LIST_CLOSE;
fm_switchLabelPlus: FM_PLACEHOLDER | (FM_IF (fm_switchLabelPlus | switchLabel)* (FM_ELSE_IF (fm_switchLabelPlus | switchLabel)*)* (FM_ELSE (fm_switchLabelPlus | switchLabel)*)? FM_IF_CLOSE | FM_LIST (fm_switchLabelPlus | switchLabel)* FM_LIST_CLOSE)* (FM_PLACEHOLDER | FM_IF (fm_switchLabelPlus | switchLabel)* (FM_ELSE_IF (fm_switchLabelPlus | switchLabel)*)* FM_ELSE (fm_switchLabelPlus | switchLabel)* FM_IF_CLOSE | FM_LIST (fm_switchLabelPlus | switchLabel)* FM_ELSE (fm_switchLabelPlus | switchLabel)* FM_LIST_CLOSE) (FM_IF (fm_switchLabelPlus | switchLabel)* (FM_ELSE_IF (fm_switchLabelPlus | switchLabel)*)* (FM_ELSE (fm_switchLabelPlus | switchLabel)*)? FM_IF_CLOSE | FM_LIST (fm_switchLabelPlus | switchLabel)* FM_LIST_CLOSE)*;

forControl
    : enhancedForControl
    | (fm_forInitOpt | forInit)? SEMI  (fm_expressionOpt | expression)? SEMI  (fm_expressionListOpt | expressionList)?
    ;
fm_forControl: FM_PLACEHOLDER | FM_IF (fm_forControl | forControl) (FM_ELSE_IF (fm_forControl | forControl))* FM_ELSE (fm_forControl | forControl) FM_IF_CLOSE;

forInit
    : localVariableDeclaration
    | expressionList
    ;
fm_forInitOpt: FM_PLACEHOLDER | FM_IF (fm_forInitOpt | forInit)? (FM_ELSE_IF (fm_forInitOpt | forInit)?)* (FM_ELSE (fm_forInitOpt | forInit)?)? FM_IF_CLOSE;

enhancedForControl
    : (fm_variableModifierStar | variableModifier)* (fm_typeType | typeType) (fm_variableDeclaratorId | variableDeclaratorId) COLON  (fm_expression | expression)
    ;

// EXPRESSIONS

parExpression
    : LPAREN  (fm_expression | expression) RPAREN 
    ;
fm_parExpression: FM_PLACEHOLDER | FM_IF (fm_parExpression | parExpression) (FM_ELSE_IF (fm_parExpression | parExpression))* FM_ELSE (fm_parExpression | parExpression) FM_IF_CLOSE;

expressionList
    : (fm_expression | expression) (COMMA  (fm_expression | expression))*
    ;
fm_expressionListOpt: FM_PLACEHOLDER | FM_IF (fm_expressionListOpt | expressionList)? (FM_ELSE_IF (fm_expressionListOpt | expressionList)?)* (FM_ELSE (fm_expressionListOpt | expressionList)?)? FM_IF_CLOSE;

expression
    : primary
    | fm_expression bop = DOT ( ( fm_IDENTIFIER | IDENTIFIER ) | THIS | NEW ( fm_nonWildcardTypeArgumentsOpt | nonWildcardTypeArguments ) ? ( fm_innerCreator | innerCreator ) | SUPER ( fm_superSuffix | superSuffix ) | ( fm_explicitGenericInvocation | explicitGenericInvocation ) ) 
  | expression bop=DOT 
      ((fm_IDENTIFIER | IDENTIFIER)
      | THIS
      | NEW (fm_nonWildcardTypeArgumentsOpt | nonWildcardTypeArguments)? (fm_innerCreator | innerCreator)
      | SUPER (fm_superSuffix | superSuffix)
      | (fm_explicitGenericInvocation | explicitGenericInvocation)
      )
    | fm_expression LBRACK ( fm_expression | expression ) RBRACK 
  | expression LBRACK  (fm_expression | expression) RBRACK 
    | fm_expression LPAREN ( fm_expressionListOpt | expressionList ) ? RPAREN 
  | expression LPAREN  (fm_expressionListOpt | expressionList)? RPAREN 
    | NEW (fm_creator | creator)
    | LPAREN  (fm_typeType | typeType) RPAREN  (fm_expression | expression)
    | fm_expression postfix = ( INC | DEC ) 
  | expression postfix=(INC  | DEC )
    | prefix=(ADD |SUB |INC |DEC ) (fm_expression | expression)
    | prefix=(TILDE |BANG ) (fm_expression | expression)
    | fm_expression bop = ( MUL | DIV | MOD ) ( fm_expression | expression ) 
  | expression bop=(MUL |DIV |MOD ) (fm_expression | expression)
    | fm_expression bop = ( ADD | SUB ) ( fm_expression | expression ) 
  | expression bop=(ADD |SUB ) (fm_expression | expression)
    | fm_expression ( LT LT | GT GT GT | GT GT ) ( fm_expression | expression ) 
  | expression (LT  LT  | GT  GT  GT  | GT  GT ) (fm_expression | expression)
    | fm_expression bop = ( LE | GE | GT | LT ) ( fm_expression | expression ) 
  | expression bop=(LE  | GE  | GT  | LT ) (fm_expression | expression)
    | fm_expression bop = INSTANCEOF ( fm_typeType | typeType ) 
  | expression bop=INSTANCEOF (fm_typeType | typeType)
    | fm_expression bop = ( EQUAL | NOTEQUAL ) ( fm_expression | expression ) 
  | expression bop=(EQUAL  | NOTEQUAL ) (fm_expression | expression)
    | fm_expression bop = BITAND ( fm_expression | expression ) 
  | expression bop=BITAND  (fm_expression | expression)
    | fm_expression bop = CARET ( fm_expression | expression ) 
  | expression bop=CARET  (fm_expression | expression)
    | fm_expression bop = BITOR ( fm_expression | expression ) 
  | expression bop=BITOR  (fm_expression | expression)
    | fm_expression bop = AND ( fm_expression | expression ) 
  | expression bop=AND  (fm_expression | expression)
    | fm_expression bop = OR ( fm_expression | expression ) 
  | expression bop=OR  (fm_expression | expression)
    | fm_expression bop = QUESTION ( fm_expression | expression ) COLON ( fm_expression | expression ) 
  | expression bop=QUESTION  (fm_expression | expression) COLON  (fm_expression | expression)
    | < assoc = right > fm_expression bop = ( ASSIGN | ADD_ASSIGN | SUB_ASSIGN | MUL_ASSIGN | DIV_ASSIGN | AND_ASSIGN | OR_ASSIGN | XOR_ASSIGN | RSHIFT_ASSIGN | URSHIFT_ASSIGN | LSHIFT_ASSIGN | MOD_ASSIGN ) ( fm_expression | expression ) 
  | <assoc=right> expression
      bop=(ASSIGN  | ADD_ASSIGN  | SUB_ASSIGN  | MUL_ASSIGN  | DIV_ASSIGN  | AND_ASSIGN  | OR_ASSIGN  | XOR_ASSIGN  | RSHIFT_ASSIGN  | URSHIFT_ASSIGN  | LSHIFT_ASSIGN  | MOD_ASSIGN )
      (fm_expression | expression)
    | lambdaExpression // Java8
    ;
fm_expression: FM_PLACEHOLDER | FM_IF (fm_expression | expression) (FM_ELSE_IF (fm_expression | expression))* FM_ELSE (fm_expression | expression) FM_IF_CLOSE;
fm_expressionOpt: FM_PLACEHOLDER | FM_IF (fm_expressionOpt | expression)? (FM_ELSE_IF (fm_expressionOpt | expression)?)* (FM_ELSE (fm_expressionOpt | expression)?)? FM_IF_CLOSE;

// Java8
lambdaExpression
    : (fm_lambdaParameters | lambdaParameters) ARROW  (fm_lambdaBody | lambdaBody)
    ;

// Java8
lambdaParameters
    : IDENTIFIER
    | LPAREN  (fm_formalParameterListOpt | formalParameterList)? RPAREN 
    | LPAREN  (fm_IDENTIFIER | IDENTIFIER) (COMMA  (fm_IDENTIFIER | IDENTIFIER))* RPAREN 
    ;
fm_lambdaParameters: FM_PLACEHOLDER | FM_IF (fm_lambdaParameters | lambdaParameters) (FM_ELSE_IF (fm_lambdaParameters | lambdaParameters))* FM_ELSE (fm_lambdaParameters | lambdaParameters) FM_IF_CLOSE;

// Java8
lambdaBody
    : expression
    | block
    ;
fm_lambdaBody: FM_PLACEHOLDER | FM_IF (fm_lambdaBody | lambdaBody) (FM_ELSE_IF (fm_lambdaBody | lambdaBody))* FM_ELSE (fm_lambdaBody | lambdaBody) FM_IF_CLOSE;

primary
    : LPAREN  (fm_expression | expression) RPAREN 
    | THIS
    | SUPER
    | literal
    | IDENTIFIER
    | (fm_typeTypeOrVoid | typeTypeOrVoid) DOT  CLASS
    | (fm_nonWildcardTypeArguments | nonWildcardTypeArguments) ((fm_explicitGenericInvocationSuffix | explicitGenericInvocationSuffix) | THIS (fm_arguments | arguments))
    | methodReference // Java 8
    ;

methodReference
    : ((fm_qualifiedName | qualifiedName) | (fm_typeType | typeType) | ((fm_qualifiedName | qualifiedName) DOT )? SUPER ) COLONCOLON  (fm_typeArgumentsOpt | typeArguments)? (fm_IDENTIFIER | IDENTIFIER)
    | (fm_classType | classType) COLONCOLON  (fm_typeArgumentsOpt | typeArguments)? NEW
    | (fm_typeType | typeType) COLONCOLON  NEW
    ;

classType
    : ((fm_classOrInterfaceType | classOrInterfaceType) DOT )? (fm_annotationStar | annotation)* IDENTIFIER (fm_typeArgumentsOpt | typeArguments)?
    ;
fm_classType: FM_PLACEHOLDER | FM_IF (fm_classType | classType) (FM_ELSE_IF (fm_classType | classType))* FM_ELSE (fm_classType | classType) FM_IF_CLOSE;

creator
    : (fm_nonWildcardTypeArguments | nonWildcardTypeArguments) (fm_createdName | createdName) (fm_classCreatorRest | classCreatorRest)
    | (fm_createdName | createdName) ((fm_arrayCreatorRest | arrayCreatorRest) | (fm_classCreatorRest | classCreatorRest))
    ;
fm_creator: FM_PLACEHOLDER | FM_IF (fm_creator | creator) (FM_ELSE_IF (fm_creator | creator))* FM_ELSE (fm_creator | creator) FM_IF_CLOSE;

createdName
    : IDENTIFIER (fm_typeArgumentsOrDiamondOpt | typeArgumentsOrDiamond)? (DOT  (fm_IDENTIFIER | IDENTIFIER) (fm_typeArgumentsOrDiamondOpt | typeArgumentsOrDiamond)?)*
    | primitiveType
    ;
fm_createdName: FM_PLACEHOLDER | FM_IF (fm_createdName | createdName) (FM_ELSE_IF (fm_createdName | createdName))* FM_ELSE (fm_createdName | createdName) FM_IF_CLOSE;

innerCreator
    : (fm_IDENTIFIER | IDENTIFIER) (fm_nonWildcardTypeArgumentsOrDiamondOpt | nonWildcardTypeArgumentsOrDiamond)? (fm_classCreatorRest | classCreatorRest)
    ;
fm_innerCreator: FM_PLACEHOLDER | FM_IF (fm_innerCreator | innerCreator) (FM_ELSE_IF (fm_innerCreator | innerCreator))* FM_ELSE (fm_innerCreator | innerCreator) FM_IF_CLOSE;

arrayCreatorRest
    : LBRACK  (RBRACK  (LBRACK  RBRACK )* (fm_arrayInitializer | arrayInitializer) | (fm_expression | expression) RBRACK  (LBRACK  (fm_expression | expression) RBRACK )* (LBRACK  RBRACK )*)
    ;
fm_arrayCreatorRest: FM_PLACEHOLDER | FM_IF (fm_arrayCreatorRest | arrayCreatorRest) (FM_ELSE_IF (fm_arrayCreatorRest | arrayCreatorRest))* FM_ELSE (fm_arrayCreatorRest | arrayCreatorRest) FM_IF_CLOSE;

classCreatorRest
    : arguments (fm_classBodyOpt | classBody)?
    ;
fm_classCreatorRest: FM_PLACEHOLDER | FM_IF (fm_classCreatorRest | classCreatorRest) (FM_ELSE_IF (fm_classCreatorRest | classCreatorRest))* FM_ELSE (fm_classCreatorRest | classCreatorRest) FM_IF_CLOSE;

explicitGenericInvocation
    : (fm_nonWildcardTypeArguments | nonWildcardTypeArguments) (fm_explicitGenericInvocationSuffix | explicitGenericInvocationSuffix)
    ;
fm_explicitGenericInvocation: FM_PLACEHOLDER | FM_IF (fm_explicitGenericInvocation | explicitGenericInvocation) (FM_ELSE_IF (fm_explicitGenericInvocation | explicitGenericInvocation))* FM_ELSE (fm_explicitGenericInvocation | explicitGenericInvocation) FM_IF_CLOSE;

typeArgumentsOrDiamond
    : LT  GT 
    | typeArguments
    ;
fm_typeArgumentsOrDiamondOpt: FM_PLACEHOLDER | FM_IF (fm_typeArgumentsOrDiamondOpt | typeArgumentsOrDiamond)? (FM_ELSE_IF (fm_typeArgumentsOrDiamondOpt | typeArgumentsOrDiamond)?)* (FM_ELSE (fm_typeArgumentsOrDiamondOpt | typeArgumentsOrDiamond)?)? FM_IF_CLOSE;

nonWildcardTypeArgumentsOrDiamond
    : LT  GT 
    | nonWildcardTypeArguments
    ;
fm_nonWildcardTypeArgumentsOrDiamondOpt: FM_PLACEHOLDER | FM_IF (fm_nonWildcardTypeArgumentsOrDiamondOpt | nonWildcardTypeArgumentsOrDiamond)? (FM_ELSE_IF (fm_nonWildcardTypeArgumentsOrDiamondOpt | nonWildcardTypeArgumentsOrDiamond)?)* (FM_ELSE (fm_nonWildcardTypeArgumentsOrDiamondOpt | nonWildcardTypeArgumentsOrDiamond)?)? FM_IF_CLOSE;

nonWildcardTypeArguments
    : LT  (fm_typeList | typeList) GT 
    ;
fm_nonWildcardTypeArguments: FM_PLACEHOLDER | FM_IF (fm_nonWildcardTypeArguments | nonWildcardTypeArguments) (FM_ELSE_IF (fm_nonWildcardTypeArguments | nonWildcardTypeArguments))* FM_ELSE (fm_nonWildcardTypeArguments | nonWildcardTypeArguments) FM_IF_CLOSE;
fm_nonWildcardTypeArgumentsOpt: FM_PLACEHOLDER | FM_IF (fm_nonWildcardTypeArgumentsOpt | nonWildcardTypeArguments)? (FM_ELSE_IF (fm_nonWildcardTypeArgumentsOpt | nonWildcardTypeArguments)?)* (FM_ELSE (fm_nonWildcardTypeArgumentsOpt | nonWildcardTypeArguments)?)? FM_IF_CLOSE;

typeList
    : typeType
    | fm_typeList COMMA ( fm_typeType | typeType ) 
  | typeList COMMA  (fm_typeType | typeType)
    ;
fm_typeList: FM_PLACEHOLDER | FM_IF (fm_typeList | typeList) (FM_ELSE_IF (fm_typeList | typeList))* FM_ELSE (fm_typeList | typeList) FM_IF_CLOSE;

typeType
    : (classOrInterfaceType | primitiveType) (LBRACK  RBRACK )*
    ;
fm_typeType: FM_PLACEHOLDER | FM_IF (fm_typeType | typeType) (FM_ELSE_IF (fm_typeType | typeType))* FM_ELSE (fm_typeType | typeType) FM_IF_CLOSE;

primitiveType
    : BOOLEAN
    | CHAR
    | BYTE
    | SHORT
    | INT
    | LONG
    | FLOAT
    | DOUBLE
    ;

typeArguments
    : LT  (fm_typeArgument | typeArgument) (COMMA  (fm_typeArgument | typeArgument))* GT 
    ;
fm_typeArgumentsOpt: FM_PLACEHOLDER | FM_IF (fm_typeArgumentsOpt | typeArguments)? (FM_ELSE_IF (fm_typeArgumentsOpt | typeArguments)?)* (FM_ELSE (fm_typeArgumentsOpt | typeArguments)?)? FM_IF_CLOSE;

superSuffix
    : arguments
    | DOT  (fm_IDENTIFIER | IDENTIFIER) (fm_argumentsOpt | arguments)?
    ;
fm_superSuffix: FM_PLACEHOLDER | FM_IF (fm_superSuffix | superSuffix) (FM_ELSE_IF (fm_superSuffix | superSuffix))* FM_ELSE (fm_superSuffix | superSuffix) FM_IF_CLOSE;

explicitGenericInvocationSuffix
    : SUPER (fm_superSuffix | superSuffix)
    | (fm_IDENTIFIER | IDENTIFIER) (fm_arguments | arguments)
    ;
fm_explicitGenericInvocationSuffix: FM_PLACEHOLDER | FM_IF (fm_explicitGenericInvocationSuffix | explicitGenericInvocationSuffix) (FM_ELSE_IF (fm_explicitGenericInvocationSuffix | explicitGenericInvocationSuffix))* FM_ELSE (fm_explicitGenericInvocationSuffix | explicitGenericInvocationSuffix) FM_IF_CLOSE;

arguments
    : LPAREN  (fm_expressionListOpt | expressionList)? RPAREN 
    ;
fm_arguments: FM_PLACEHOLDER | FM_IF (fm_arguments | arguments) (FM_ELSE_IF (fm_arguments | arguments))* FM_ELSE (fm_arguments | arguments) FM_IF_CLOSE;
fm_argumentsOpt: FM_PLACEHOLDER | FM_IF (fm_argumentsOpt | arguments)? (FM_ELSE_IF (fm_argumentsOpt | arguments)?)* (FM_ELSE (fm_argumentsOpt | arguments)?)? FM_IF_CLOSE;
    

// Keywords

ABSTRACT:           'abstract';
ASSERT:             'assert';
BOOLEAN:            'boolean';
BREAK:              'break';
BYTE:               'byte';
CASE:               'case';
CATCH:              'catch';
CHAR:               'char';
CLASS:              'class';
CONST:              'const';
CONTINUE:           'continue';
DEFAULT:            'default';
DO:                 'do';
DOUBLE:             'double';
ELSE:               'else';
ENUM:               'enum';
EXTENDS:            'extends';
FINAL:              'final';
FINALLY:            'finally';
FLOAT:              'float';
FOR:                'for';
IF:                 'if';
GOTO:               'goto';
IMPLEMENTS:         'implements';
IMPORT:             'import';
INSTANCEOF:         'instanceof';
INT:                'int';
INTERFACE:          'interface';
LONG:               'long';
NATIVE:             'native';
NEW:                'new';
PACKAGE:            'package';
PRIVATE:            'private';
PROTECTED:          'protected';
PUBLIC:             'public';
RETURN:             'return';
SHORT:              'short';
STATIC:             'static';
STRICTFP:           'strictfp';
SUPER:              'super';
SWITCH:             'switch';
SYNCHRONIZED:       'synchronized';
THIS:               'this';
THROW:              'throw';
THROWS:             'throws';
TRANSIENT:          'transient';
TRY:                'try';
VOID:               'void';
VOLATILE:           'volatile';
WHILE:              'while';

// Literals

DECIMAL_LITERAL:    ('0' | [1-9] (Digits? | '_'+ Digits)) [lL]?;
HEX_LITERAL:        '0' [xX] [0-9a-fA-F] ([0-9a-fA-F_]* [0-9a-fA-F])? [lL]?;
OCT_LITERAL:        '0' '_'* [0-7] ([0-7_]* [0-7])? [lL]?;
BINARY_LITERAL:     '0' [bB] [01] ([01_]* [01])? [lL]?;
                    
FLOAT_LITERAL:      (Digits '.' Digits? | '.' Digits) ExponentPart? [fFdD]?
             |       Digits (ExponentPart [fFdD]? | [fFdD])
             ;

HEX_FLOAT_LITERAL:  '0' [xX] (HexDigits '.'? | HexDigits? '.' HexDigits) [pP] [+-]? Digits [fFdD]?;

BOOL_LITERAL:       'true' | 'false';

CHAR_LITERAL:       '\'' (~['\\] | EscapeSequence) '\'';

STRING_LITERAL:     '"' (~["\\] | EscapeSequence)* '"';

NULL_LITERAL:       'null';

// Separators

LPAREN:             '(';
RPAREN:             ')';
LBRACE:             '{';
RBRACE:             '}';
LBRACK:             '[';
RBRACK:             ']';
SEMI:               ';';
COMMA:              ',';
DOT:                '.';

// Operators

ASSIGN:             '=';
GT:                 '>';
LT:                 '<';
BANG:               '!';
TILDE:              '~';
QUESTION:           '?';
COLON:              ':';
EQUAL:              '==';
LE:                 '<=';
GE:                 '>=';
NOTEQUAL:           '!=';
AND:                '&&';
OR:                 '||';
INC:                '++';
DEC:                '--';
ADD:                '+';
SUB:                '-';
MUL:                '*';
DIV:                '/';
BITAND:             '&';
BITOR:              '|';
CARET:              '^';
MOD:                '%';

ADD_ASSIGN:         '+=';
SUB_ASSIGN:         '-=';
MUL_ASSIGN:         '*=';
DIV_ASSIGN:         '/=';
AND_ASSIGN:         '&=';
OR_ASSIGN:          '|=';
XOR_ASSIGN:         '^=';
MOD_ASSIGN:         '%=';
LSHIFT_ASSIGN:      '<<=';
RSHIFT_ASSIGN:      '>>=';
URSHIFT_ASSIGN:     '>>>=';

// Java 8 tokens

ARROW:              '->';
COLONCOLON:         '::';

// Additional symbols not defined in the lexical specification

AT:                 '@';
ELLIPSIS:           '...';

// Whitespace and comments

WS:                 [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

// Identifiers

IDENTIFIER:         JavaLetter JavaLetterOrDigit*;
fm_IDENTIFIER: FM_PLACEHOLDER | FM_IF (fm_IDENTIFIER | IDENTIFIER) (FM_ELSE_IF (fm_IDENTIFIER | IDENTIFIER))* FM_ELSE (fm_IDENTIFIER | IDENTIFIER) FM_IF_CLOSE;
fm_IDENTIFIEROpt: FM_PLACEHOLDER | FM_IF (fm_IDENTIFIEROpt | IDENTIFIER)? (FM_ELSE_IF (fm_IDENTIFIEROpt | IDENTIFIER)?)* (FM_ELSE (fm_IDENTIFIEROpt | IDENTIFIER)?)? FM_IF_CLOSE;

// Fragments rules

fragment
ExponentPart
    : [eE] [+-]? Digits
    ;

// Escape Sequences for Character and String Literals

fragment
EscapeSequence
    : '\\' [btnfr"'\\]
    | OctalEscape
    | UnicodeEscape
    ;

fragment
OctalEscape: '\\' ([0-3]? [0-7])? [0-7];

fragment
UnicodeEscape
    : '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
HexDigits
    : HexDigit ((HexDigit | '_') * HexDigit)?
    ;

fragment
HexDigit
    : [0-9a-fA-F]
    ;

fragment
Digits
    : [0-9] ([0-9_]* [0-9])?
    ;

fragment
JavaLetter
    : [a-zA-Z$_] // these are the "java letters" below 0x7F
    | // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
    | // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
    ;

fragment
JavaLetterOrDigit
    : [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
    | // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
    | // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
    ;

FM_PLACEHOLDER: '${' ~'}'+? '}';
FM_IF: '<#if' ~'>'+? '>';
FM_IF_CLOSE: '</#if>';
FM_ELSE_IF: '<#elseif' ~'>'+? '>';
FM_ELSE: '<#else>';
FM_LIST: '<#list' .+? 'as' ~'>'+? '>';
FM_LIST_CLOSE: '</#list>';