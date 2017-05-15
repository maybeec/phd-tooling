/*
 * [The "BSD license"]
 *  Copyright (c) 2014 Terence Parr
 *  Copyright (c) 2014 Sam Harwell
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/**
 * A Java 8 grammar for ANTLR 4 derived from the Java Language Specification
 * chapter 19.
 *
 * NOTE: This grammar results in a generated parser that is much slower
 *       than the Java 7 grammar in the grammars-v4/java directory. This
 *     one is, however, extremely close to the spec.
 *
 * You can test with
 *
 *  $ antlr4 Java8.g4
 *  $ javac *.java
 *  $ grun Java8 compilationUnit *.java
 *
 * Or,
~/antlr/code/grammars-v4/java8 $ java Test .
/Users/parrt/antlr/code/grammars-v4/java8/./Java8BaseListener.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Lexer.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Listener.java
/Users/parrt/antlr/code/grammars-v4/java8/./Java8Parser.java
/Users/parrt/antlr/code/grammars-v4/java8/./Test.java
Total lexer+parser time 30844ms.
 */
grammar JavaTemplate;

/*
 * Productions from §3 (Lexical Structure)
 */

literal
  : (IntegerLiteral)
  | (FloatingPointLiteral)
  | (BooleanLiteral)
  | (CharacterLiteral)
  | (StringLiteral)
  | NullLiteral
  ;

/*
 * Productions from §4 (Types, Values, and Variables)
 */

type
  : primitiveType
  | referenceType
  ;

primitiveType
  : (annotation | fm_annotationStar)* (numericType | fm_numericType)
  | (annotation | fm_annotationStar)* BOOLEAN 
  ;
fm_primitiveType: FM_PLACEHOLDER | FM_IF (fm_primitiveType | primitiveType) (FM_ELSE_IF (fm_primitiveType | primitiveType))* FM_ELSE (fm_primitiveType | primitiveType) FM_IF_CLOSE;

numericType
  : integralType
  | floatingPointType
  ;
fm_numericType: FM_PLACEHOLDER | FM_IF (fm_numericType | numericType) (FM_ELSE_IF (fm_numericType | numericType))* FM_ELSE (fm_numericType | numericType) FM_IF_CLOSE;

integralType
  : BYTE 
  | SHORT 
  | INT 
  | LONG 
  | CHAR 
  ;

floatingPointType
  : FLOAT 
  | DOUBLE 
  ;

referenceType
  : classOrInterfaceType
  | typeVariable
  | arrayType
  ;
fm_referenceType: FM_PLACEHOLDER | FM_IF (fm_referenceType | referenceType) (FM_ELSE_IF (fm_referenceType | referenceType))* FM_ELSE (fm_referenceType | referenceType) FM_IF_CLOSE;

classOrInterfaceType
  : ( classType_lfno_classOrInterfaceType
    | interfaceType_lfno_classOrInterfaceType
    )
    ( classType_lf_classOrInterfaceType
    | interfaceType_lf_classOrInterfaceType
    )*
  ;
fm_classOrInterfaceType: FM_PLACEHOLDER | FM_IF (fm_classOrInterfaceType | classOrInterfaceType) (FM_ELSE_IF (fm_classOrInterfaceType | classOrInterfaceType))* FM_ELSE (fm_classOrInterfaceType | classOrInterfaceType) FM_IF_CLOSE;

classType
  : (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArguments | fm_typeArgumentsOpt)?
  | (classOrInterfaceType | fm_classOrInterfaceType) DOT  (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArguments | fm_typeArgumentsOpt)?
  ;
fm_classType: FM_PLACEHOLDER | FM_IF (fm_classType | classType) (FM_ELSE_IF (fm_classType | classType))* FM_ELSE (fm_classType | classType) FM_IF_CLOSE;

classType_lf_classOrInterfaceType
  : DOT  (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArguments | fm_typeArgumentsOpt)?
  ;

classType_lfno_classOrInterfaceType
  : (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArguments | fm_typeArgumentsOpt)?
  ;

interfaceType
  : classType
  ;
fm_interfaceType: FM_PLACEHOLDER | FM_IF (fm_interfaceType | interfaceType) (FM_ELSE_IF (fm_interfaceType | interfaceType))* FM_ELSE (fm_interfaceType | interfaceType) FM_IF_CLOSE;

interfaceType_lf_classOrInterfaceType
  : classType_lf_classOrInterfaceType
  ;

interfaceType_lfno_classOrInterfaceType
  : classType_lfno_classOrInterfaceType
  ;

typeVariable
  : (annotation | fm_annotationStar)* (Identifier | fm_Identifier)
  ;
fm_typeVariable: FM_PLACEHOLDER | FM_IF (fm_typeVariable | typeVariable) (FM_ELSE_IF (fm_typeVariable | typeVariable))* FM_ELSE (fm_typeVariable | typeVariable) FM_IF_CLOSE;

arrayType
  : (primitiveType | fm_primitiveType) (dims | fm_dims)
  | (classOrInterfaceType | fm_classOrInterfaceType) (dims | fm_dims)
  | (typeVariable | fm_typeVariable) (dims | fm_dims)
  ;
fm_arrayType: FM_PLACEHOLDER | FM_IF (fm_arrayType | arrayType) (FM_ELSE_IF (fm_arrayType | arrayType))* FM_ELSE (fm_arrayType | arrayType) FM_IF_CLOSE;

dims
  : (annotation | fm_annotationStar)* LBRACK  RBRACK  ((annotation | fm_annotationStar)* LBRACK  RBRACK )*
  ;
fm_dims: FM_PLACEHOLDER | FM_IF (fm_dims | dims) (FM_ELSE_IF (fm_dims | dims))* FM_ELSE (fm_dims | dims) FM_IF_CLOSE;
fm_dimsOpt: FM_PLACEHOLDER | FM_IF (fm_dimsOpt | dims) (FM_ELSE_IF (fm_dimsOpt | dims))* (FM_ELSE (fm_dimsOpt | dims))? FM_IF_CLOSE;

typeParameter
  : (typeParameterModifier | fm_typeParameterModifierStar)* (Identifier | fm_Identifier) (typeBound | fm_typeBoundOpt)?
  ;
fm_typeParameter: FM_PLACEHOLDER | FM_IF (fm_typeParameter | typeParameter) (FM_ELSE_IF (fm_typeParameter | typeParameter))* FM_ELSE (fm_typeParameter | typeParameter) FM_IF_CLOSE;

typeParameterModifier
  : annotation
  ;
fm_typeParameterModifierStar: FM_PLACEHOLDER | FM_IF (fm_typeParameterModifierStar | typeParameterModifier) (FM_ELSE_IF (fm_typeParameterModifierStar | typeParameterModifier))* (FM_ELSE (fm_typeParameterModifierStar | typeParameterModifier))? FM_IF_CLOSE | FM_LIST (fm_typeParameterModifierStar | typeParameterModifier) FM_LIST_CLOSE;

typeBound
  : EXTENDS  (typeVariable | fm_typeVariable)
  | EXTENDS  (classOrInterfaceType | fm_classOrInterfaceType) (additionalBound | fm_additionalBoundStar)*
  ;
fm_typeBoundOpt: FM_PLACEHOLDER | FM_IF (fm_typeBoundOpt | typeBound) (FM_ELSE_IF (fm_typeBoundOpt | typeBound))* (FM_ELSE (fm_typeBoundOpt | typeBound))? FM_IF_CLOSE;

additionalBound
  : BITAND  (interfaceType | fm_interfaceType)
  ;
fm_additionalBoundStar: FM_PLACEHOLDER | FM_IF (fm_additionalBoundStar | additionalBound) (FM_ELSE_IF (fm_additionalBoundStar | additionalBound))* (FM_ELSE (fm_additionalBoundStar | additionalBound))? FM_IF_CLOSE | FM_LIST (fm_additionalBoundStar | additionalBound) FM_LIST_CLOSE;

typeArguments
  : LT  (typeArgumentList | fm_typeArgumentList) GT 
  ;
fm_typeArgumentsOpt: FM_PLACEHOLDER | FM_IF (fm_typeArgumentsOpt | typeArguments) (FM_ELSE_IF (fm_typeArgumentsOpt | typeArguments))* (FM_ELSE (fm_typeArgumentsOpt | typeArguments))? FM_IF_CLOSE;

typeArgumentList
  : (typeArgument | fm_typeArgument) (COMMA  (typeArgument | fm_typeArgument))*
  ;
fm_typeArgumentList: FM_PLACEHOLDER | FM_IF (fm_typeArgumentList | typeArgumentList) (FM_ELSE_IF (fm_typeArgumentList | typeArgumentList))* FM_ELSE (fm_typeArgumentList | typeArgumentList) FM_IF_CLOSE;

typeArgument
  : referenceType
  | wildcard
  ;
fm_typeArgument: FM_PLACEHOLDER | FM_IF (fm_typeArgument | typeArgument) (FM_ELSE_IF (fm_typeArgument | typeArgument))* FM_ELSE (fm_typeArgument | typeArgument) FM_IF_CLOSE;

wildcard
  : (annotation | fm_annotationStar)* QUESTION  (wildcardBounds | fm_wildcardBoundsOpt)?
  ;

wildcardBounds
  : EXTENDS  (referenceType | fm_referenceType)
  | SUPER  (referenceType | fm_referenceType)
  ;
fm_wildcardBoundsOpt: FM_PLACEHOLDER | FM_IF (fm_wildcardBoundsOpt | wildcardBounds) (FM_ELSE_IF (fm_wildcardBoundsOpt | wildcardBounds))* (FM_ELSE (fm_wildcardBoundsOpt | wildcardBounds))? FM_IF_CLOSE;

/*
 * Productions from §6 (Names)
 */

packageName
  : Identifier
  | packageName DOT  (Identifier | fm_Identifier)
  | fm_packageName DOT ( Identifier | fm_Identifier ) 
  ;
fm_packageName: FM_PLACEHOLDER | FM_IF (fm_packageName | packageName) (FM_ELSE_IF (fm_packageName | packageName))* FM_ELSE (fm_packageName | packageName) FM_IF_CLOSE;

typeName
  : Identifier
  | (packageOrTypeName | fm_packageOrTypeName) DOT  (Identifier | fm_Identifier)
  ;
fm_typeName: FM_PLACEHOLDER | FM_IF (fm_typeName | typeName) (FM_ELSE_IF (fm_typeName | typeName))* FM_ELSE (fm_typeName | typeName) FM_IF_CLOSE;

packageOrTypeName
  : Identifier
  | packageOrTypeName DOT  (Identifier | fm_Identifier)
  | fm_packageOrTypeName DOT ( Identifier | fm_Identifier ) 
  ;
fm_packageOrTypeName: FM_PLACEHOLDER | FM_IF (fm_packageOrTypeName | packageOrTypeName) (FM_ELSE_IF (fm_packageOrTypeName | packageOrTypeName))* FM_ELSE (fm_packageOrTypeName | packageOrTypeName) FM_IF_CLOSE;

expressionName
  : Identifier
  | (ambiguousName | fm_ambiguousName) DOT  (Identifier | fm_Identifier)
  ;
fm_expressionName: FM_PLACEHOLDER | FM_IF (fm_expressionName | expressionName) (FM_ELSE_IF (fm_expressionName | expressionName))* FM_ELSE (fm_expressionName | expressionName) FM_IF_CLOSE;

methodName
  : Identifier
  ;
fm_methodName: FM_PLACEHOLDER | FM_IF (fm_methodName | methodName) (FM_ELSE_IF (fm_methodName | methodName))* FM_ELSE (fm_methodName | methodName) FM_IF_CLOSE;

ambiguousName
  : Identifier
  | ambiguousName DOT  (Identifier | fm_Identifier)
  | fm_ambiguousName DOT ( Identifier | fm_Identifier ) 
  ;
fm_ambiguousName: FM_PLACEHOLDER | FM_IF (fm_ambiguousName | ambiguousName) (FM_ELSE_IF (fm_ambiguousName | ambiguousName))* FM_ELSE (fm_ambiguousName | ambiguousName) FM_IF_CLOSE;

/*
 * Productions from §7 (Packages)
 */

compilationUnit
  : (packageDeclaration | fm_packageDeclarationOpt)? (importDeclaration | fm_importDeclarationStar)* (typeDeclaration | fm_typeDeclarationStar)* EOF
  ;

packageDeclaration
  : (packageModifier | fm_packageModifierStar)* PACKAGE  (Identifier | fm_Identifier) (DOT  (Identifier | fm_Identifier))* SEMI 
  ;
fm_packageDeclarationOpt: FM_PLACEHOLDER | FM_IF (fm_packageDeclarationOpt | packageDeclaration) (FM_ELSE_IF (fm_packageDeclarationOpt | packageDeclaration))* (FM_ELSE (fm_packageDeclarationOpt | packageDeclaration))? FM_IF_CLOSE;

packageModifier
  : annotation
  ;
fm_packageModifierStar: FM_PLACEHOLDER | FM_IF (fm_packageModifierStar | packageModifier) (FM_ELSE_IF (fm_packageModifierStar | packageModifier))* (FM_ELSE (fm_packageModifierStar | packageModifier))? FM_IF_CLOSE | FM_LIST (fm_packageModifierStar | packageModifier) FM_LIST_CLOSE;

importDeclaration
  : singleTypeImportDeclaration
  | typeImportOnDemandDeclaration
  | singleStaticImportDeclaration
  | staticImportOnDemandDeclaration
  ;
fm_importDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_importDeclarationStar | importDeclaration) (FM_ELSE_IF (fm_importDeclarationStar | importDeclaration))* (FM_ELSE (fm_importDeclarationStar | importDeclaration))? FM_IF_CLOSE | FM_LIST (fm_importDeclarationStar | importDeclaration) FM_LIST_CLOSE;

singleTypeImportDeclaration
  : IMPORT  (typeName | fm_typeName) SEMI 
  ;

typeImportOnDemandDeclaration
  : IMPORT  (packageOrTypeName | fm_packageOrTypeName) DOT  MUL  SEMI 
  ;

singleStaticImportDeclaration
  : IMPORT  STATIC  (typeName | fm_typeName) DOT  (Identifier | fm_Identifier) SEMI 
  ;

staticImportOnDemandDeclaration
  : IMPORT  STATIC  (typeName | fm_typeName) DOT  MUL  SEMI 
  ;

typeDeclaration
  : classDeclaration
  | interfaceDeclaration
  | SEMI 
  ;
fm_typeDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_typeDeclarationStar | typeDeclaration) (FM_ELSE_IF (fm_typeDeclarationStar | typeDeclaration))* (FM_ELSE (fm_typeDeclarationStar | typeDeclaration))? FM_IF_CLOSE | FM_LIST (fm_typeDeclarationStar | typeDeclaration) FM_LIST_CLOSE;

/*
 * Productions from §8 (Classes)
 */

classDeclaration
  : normalClassDeclaration
  | enumDeclaration
  ;

normalClassDeclaration
  : (classModifier | fm_classModifierStar)* CLASS  (Identifier | fm_Identifier) (typeParameters | fm_typeParametersOpt)? (superclass | fm_superclassOpt)? (superinterfaces | fm_superinterfacesOpt)? (classBody | fm_classBody)
  ;

classModifier
  : annotation
  | PUBLIC 
  | PROTECTED 
  | PRIVATE 
  | ABSTRACT 
  | STATIC 
  | FINAL 
  | STRICTFP 
  ;
fm_classModifierStar: FM_PLACEHOLDER | FM_IF (fm_classModifierStar | classModifier) (FM_ELSE_IF (fm_classModifierStar | classModifier))* (FM_ELSE (fm_classModifierStar | classModifier))? FM_IF_CLOSE | FM_LIST (fm_classModifierStar | classModifier) FM_LIST_CLOSE;

typeParameters
  : LT  (typeParameterList | fm_typeParameterList) GT 
  ;
fm_typeParameters: FM_PLACEHOLDER | FM_IF (fm_typeParameters | typeParameters) (FM_ELSE_IF (fm_typeParameters | typeParameters))* FM_ELSE (fm_typeParameters | typeParameters) FM_IF_CLOSE;
fm_typeParametersOpt: FM_PLACEHOLDER | FM_IF (fm_typeParametersOpt | typeParameters) (FM_ELSE_IF (fm_typeParametersOpt | typeParameters))* (FM_ELSE (fm_typeParametersOpt | typeParameters))? FM_IF_CLOSE;

typeParameterList
  : (typeParameter | fm_typeParameter) (COMMA  (typeParameter | fm_typeParameter))*
  ;
fm_typeParameterList: FM_PLACEHOLDER | FM_IF (fm_typeParameterList | typeParameterList) (FM_ELSE_IF (fm_typeParameterList | typeParameterList))* FM_ELSE (fm_typeParameterList | typeParameterList) FM_IF_CLOSE;

superclass
  : EXTENDS  (classType | fm_classType)
  ;
fm_superclassOpt: FM_PLACEHOLDER | FM_IF (fm_superclassOpt | superclass) (FM_ELSE_IF (fm_superclassOpt | superclass))* (FM_ELSE (fm_superclassOpt | superclass))? FM_IF_CLOSE;

superinterfaces
  : IMPLEMENTS  (interfaceTypeList | fm_interfaceTypeList)
  ;
fm_superinterfacesOpt: FM_PLACEHOLDER | FM_IF (fm_superinterfacesOpt | superinterfaces) (FM_ELSE_IF (fm_superinterfacesOpt | superinterfaces))* (FM_ELSE (fm_superinterfacesOpt | superinterfaces))? FM_IF_CLOSE;

interfaceTypeList
  : (interfaceType | fm_interfaceType) (COMMA  (interfaceType | fm_interfaceType))*
  ;
fm_interfaceTypeList: FM_PLACEHOLDER | FM_IF (fm_interfaceTypeList | interfaceTypeList) (FM_ELSE_IF (fm_interfaceTypeList | interfaceTypeList))* FM_ELSE (fm_interfaceTypeList | interfaceTypeList) FM_IF_CLOSE;

classBody
  : LBRACE  (classBodyDeclaration | fm_classBodyDeclarationStar)* RBRACE 
  ;
fm_classBody: FM_PLACEHOLDER | FM_IF (fm_classBody | classBody) (FM_ELSE_IF (fm_classBody | classBody))* FM_ELSE (fm_classBody | classBody) FM_IF_CLOSE;
fm_classBodyOpt: FM_PLACEHOLDER | FM_IF (fm_classBodyOpt | classBody) (FM_ELSE_IF (fm_classBodyOpt | classBody))* (FM_ELSE (fm_classBodyOpt | classBody))? FM_IF_CLOSE;

classBodyDeclaration
  : classMemberDeclaration
  | instanceInitializer
  | staticInitializer
  | constructorDeclaration
  ;
fm_classBodyDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_classBodyDeclarationStar | classBodyDeclaration) (FM_ELSE_IF (fm_classBodyDeclarationStar | classBodyDeclaration))* (FM_ELSE (fm_classBodyDeclarationStar | classBodyDeclaration))? FM_IF_CLOSE | FM_LIST (fm_classBodyDeclarationStar | classBodyDeclaration) FM_LIST_CLOSE;

classMemberDeclaration
  : fieldDeclaration
  | methodDeclaration
  | classDeclaration
  | interfaceDeclaration
  | SEMI 
  ;

fieldDeclaration
  : (fieldModifier | fm_fieldModifierStar)* (unannType | fm_unannType) (variableDeclaratorList | fm_variableDeclaratorList) SEMI 
  ;

fieldModifier
  : annotation
  | PUBLIC 
  | PROTECTED 
  | PRIVATE 
  | STATIC 
  | FINAL 
  | TRANSIENT 
  | VOLATILE 
  ;
fm_fieldModifierStar: FM_PLACEHOLDER | FM_IF (fm_fieldModifierStar | fieldModifier) (FM_ELSE_IF (fm_fieldModifierStar | fieldModifier))* (FM_ELSE (fm_fieldModifierStar | fieldModifier))? FM_IF_CLOSE | FM_LIST (fm_fieldModifierStar | fieldModifier) FM_LIST_CLOSE;

variableDeclaratorList
  : (variableDeclarator | fm_variableDeclarator) (COMMA  (variableDeclarator | fm_variableDeclarator))*
  ;
fm_variableDeclaratorList: FM_PLACEHOLDER | FM_IF (fm_variableDeclaratorList | variableDeclaratorList) (FM_ELSE_IF (fm_variableDeclaratorList | variableDeclaratorList))* FM_ELSE (fm_variableDeclaratorList | variableDeclaratorList) FM_IF_CLOSE;

variableDeclarator
  : (variableDeclaratorId | fm_variableDeclaratorId) (ASSIGN  (variableInitializer | fm_variableInitializer))?
  ;
fm_variableDeclarator: FM_PLACEHOLDER | FM_IF (fm_variableDeclarator | variableDeclarator) (FM_ELSE_IF (fm_variableDeclarator | variableDeclarator))* FM_ELSE (fm_variableDeclarator | variableDeclarator) FM_IF_CLOSE;

variableDeclaratorId
  : (Identifier | fm_Identifier) (dims | fm_dimsOpt)?
  ;
fm_variableDeclaratorId: FM_PLACEHOLDER | FM_IF (fm_variableDeclaratorId | variableDeclaratorId) (FM_ELSE_IF (fm_variableDeclaratorId | variableDeclaratorId))* FM_ELSE (fm_variableDeclaratorId | variableDeclaratorId) FM_IF_CLOSE;

variableInitializer
  : expression
  | arrayInitializer
  ;
fm_variableInitializer: FM_PLACEHOLDER | FM_IF (fm_variableInitializer | variableInitializer) (FM_ELSE_IF (fm_variableInitializer | variableInitializer))* FM_ELSE (fm_variableInitializer | variableInitializer) FM_IF_CLOSE;

unannType
  : unannPrimitiveType
  | unannReferenceType
  ;
fm_unannType: FM_PLACEHOLDER | FM_IF (fm_unannType | unannType) (FM_ELSE_IF (fm_unannType | unannType))* FM_ELSE (fm_unannType | unannType) FM_IF_CLOSE;

unannPrimitiveType
  : numericType
  | BOOLEAN 
  ;
fm_unannPrimitiveType: FM_PLACEHOLDER | FM_IF (fm_unannPrimitiveType | unannPrimitiveType) (FM_ELSE_IF (fm_unannPrimitiveType | unannPrimitiveType))* FM_ELSE (fm_unannPrimitiveType | unannPrimitiveType) FM_IF_CLOSE;

unannReferenceType
  : unannClassOrInterfaceType
  | unannTypeVariable
  | unannArrayType
  ;

unannClassOrInterfaceType
  : ( unannClassType_lfno_unannClassOrInterfaceType
    | unannInterfaceType_lfno_unannClassOrInterfaceType
    )
    ( unannClassType_lf_unannClassOrInterfaceType
    | unannInterfaceType_lf_unannClassOrInterfaceType
    )*
  ;
fm_unannClassOrInterfaceType: FM_PLACEHOLDER | FM_IF (fm_unannClassOrInterfaceType | unannClassOrInterfaceType) (FM_ELSE_IF (fm_unannClassOrInterfaceType | unannClassOrInterfaceType))* FM_ELSE (fm_unannClassOrInterfaceType | unannClassOrInterfaceType) FM_IF_CLOSE;

unannClassType
  : (Identifier | fm_Identifier) (typeArguments | fm_typeArgumentsOpt)?
  | (unannClassOrInterfaceType | fm_unannClassOrInterfaceType) DOT  (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArguments | fm_typeArgumentsOpt)?
  ;
fm_unannClassType: FM_PLACEHOLDER | FM_IF (fm_unannClassType | unannClassType) (FM_ELSE_IF (fm_unannClassType | unannClassType))* FM_ELSE (fm_unannClassType | unannClassType) FM_IF_CLOSE;

unannClassType_lf_unannClassOrInterfaceType
  : DOT  (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArguments | fm_typeArgumentsOpt)?
  ;

unannClassType_lfno_unannClassOrInterfaceType
  : (Identifier | fm_Identifier) (typeArguments | fm_typeArgumentsOpt)?
  ;

unannInterfaceType
  : unannClassType
  ;

unannInterfaceType_lf_unannClassOrInterfaceType
  : unannClassType_lf_unannClassOrInterfaceType
  ;

unannInterfaceType_lfno_unannClassOrInterfaceType
  : unannClassType_lfno_unannClassOrInterfaceType
  ;

unannTypeVariable
  : Identifier
  ;
fm_unannTypeVariable: FM_PLACEHOLDER | FM_IF (fm_unannTypeVariable | unannTypeVariable) (FM_ELSE_IF (fm_unannTypeVariable | unannTypeVariable))* FM_ELSE (fm_unannTypeVariable | unannTypeVariable) FM_IF_CLOSE;

unannArrayType
  : (unannPrimitiveType | fm_unannPrimitiveType) (dims | fm_dims)
  | (unannClassOrInterfaceType | fm_unannClassOrInterfaceType) (dims | fm_dims)
  | (unannTypeVariable | fm_unannTypeVariable) (dims | fm_dims)
  ;

methodDeclaration
  : (methodModifier | fm_methodModifierStar)* (methodHeader | fm_methodHeader) (methodBody | fm_methodBody)
  ;

methodModifier
  : annotation
  | PUBLIC 
  | PROTECTED 
  | PRIVATE 
  | ABSTRACT 
  | STATIC 
  | FINAL 
  | SYNCHRONIZED 
  | NATIVE 
  | STRICTFP 
  ;
fm_methodModifierStar: FM_PLACEHOLDER | FM_IF (fm_methodModifierStar | methodModifier) (FM_ELSE_IF (fm_methodModifierStar | methodModifier))* (FM_ELSE (fm_methodModifierStar | methodModifier))? FM_IF_CLOSE | FM_LIST (fm_methodModifierStar | methodModifier) FM_LIST_CLOSE;

methodHeader
  : (result | fm_result) (methodDeclarator | fm_methodDeclarator) (throws_ | fm_throws_Opt)?
  | (typeParameters | fm_typeParameters) (annotation | fm_annotationStar)* (result | fm_result) (methodDeclarator | fm_methodDeclarator) (throws_ | fm_throws_Opt)?
  ;
fm_methodHeader: FM_PLACEHOLDER | FM_IF (fm_methodHeader | methodHeader) (FM_ELSE_IF (fm_methodHeader | methodHeader))* FM_ELSE (fm_methodHeader | methodHeader) FM_IF_CLOSE;

result
  : unannType
  | VOID 
  ;
fm_result: FM_PLACEHOLDER | FM_IF (fm_result | result) (FM_ELSE_IF (fm_result | result))* FM_ELSE (fm_result | result) FM_IF_CLOSE;

methodDeclarator
  : (Identifier | fm_Identifier) LPAREN  (formalParameterList | fm_formalParameterListOpt)? RPAREN  (dims | fm_dimsOpt)?
  ;
fm_methodDeclarator: FM_PLACEHOLDER | FM_IF (fm_methodDeclarator | methodDeclarator) (FM_ELSE_IF (fm_methodDeclarator | methodDeclarator))* FM_ELSE (fm_methodDeclarator | methodDeclarator) FM_IF_CLOSE;

formalParameterList
  : (formalParameters | fm_formalParameters) COMMA  (lastFormalParameter | fm_lastFormalParameter)
  | lastFormalParameter
  ;
fm_formalParameterListOpt: FM_PLACEHOLDER | FM_IF (fm_formalParameterListOpt | formalParameterList) (FM_ELSE_IF (fm_formalParameterListOpt | formalParameterList))* (FM_ELSE (fm_formalParameterListOpt | formalParameterList))? FM_IF_CLOSE;

formalParameters
  : (formalParameter | fm_formalParameter) (COMMA  (formalParameter | fm_formalParameter))*
  | (receiverParameter | fm_receiverParameter) (COMMA  (formalParameter | fm_formalParameter))*
  ;
fm_formalParameters: FM_PLACEHOLDER | FM_IF (fm_formalParameters | formalParameters) (FM_ELSE_IF (fm_formalParameters | formalParameters))* FM_ELSE (fm_formalParameters | formalParameters) FM_IF_CLOSE;

formalParameter
  : (variableModifier | fm_variableModifierStar)* (unannType | fm_unannType) (variableDeclaratorId | fm_variableDeclaratorId)
  ;
fm_formalParameter: FM_PLACEHOLDER | FM_IF (fm_formalParameter | formalParameter) (FM_ELSE_IF (fm_formalParameter | formalParameter))* FM_ELSE (fm_formalParameter | formalParameter) FM_IF_CLOSE;

variableModifier
  : annotation
  | FINAL 
  ;
fm_variableModifierStar: FM_PLACEHOLDER | FM_IF (fm_variableModifierStar | variableModifier) (FM_ELSE_IF (fm_variableModifierStar | variableModifier))* (FM_ELSE (fm_variableModifierStar | variableModifier))? FM_IF_CLOSE | FM_LIST (fm_variableModifierStar | variableModifier) FM_LIST_CLOSE;

lastFormalParameter
  : (variableModifier | fm_variableModifierStar)* (unannType | fm_unannType) (annotation | fm_annotationStar)* ELLIPSIS  (variableDeclaratorId | fm_variableDeclaratorId)
  | formalParameter
  ;
fm_lastFormalParameter: FM_PLACEHOLDER | FM_IF (fm_lastFormalParameter | lastFormalParameter) (FM_ELSE_IF (fm_lastFormalParameter | lastFormalParameter))* FM_ELSE (fm_lastFormalParameter | lastFormalParameter) FM_IF_CLOSE;

receiverParameter
  : (annotation | fm_annotationStar)* (unannType | fm_unannType) ((Identifier | fm_Identifier) DOT )? THIS 
  ;
fm_receiverParameter: FM_PLACEHOLDER | FM_IF (fm_receiverParameter | receiverParameter) (FM_ELSE_IF (fm_receiverParameter | receiverParameter))* FM_ELSE (fm_receiverParameter | receiverParameter) FM_IF_CLOSE;

throws_
  : THROWS  (exceptionTypeList | fm_exceptionTypeList)
  ;
fm_throws_Opt: FM_PLACEHOLDER | FM_IF (fm_throws_Opt | throws_) (FM_ELSE_IF (fm_throws_Opt | throws_))* (FM_ELSE (fm_throws_Opt | throws_))? FM_IF_CLOSE;

exceptionTypeList
  : (exceptionType | fm_exceptionType) (COMMA  (exceptionType | fm_exceptionType))*
  ;
fm_exceptionTypeList: FM_PLACEHOLDER | FM_IF (fm_exceptionTypeList | exceptionTypeList) (FM_ELSE_IF (fm_exceptionTypeList | exceptionTypeList))* FM_ELSE (fm_exceptionTypeList | exceptionTypeList) FM_IF_CLOSE;

exceptionType
  : classType
  | typeVariable
  ;
fm_exceptionType: FM_PLACEHOLDER | FM_IF (fm_exceptionType | exceptionType) (FM_ELSE_IF (fm_exceptionType | exceptionType))* FM_ELSE (fm_exceptionType | exceptionType) FM_IF_CLOSE;

methodBody
  : block
  | SEMI 
  ;
fm_methodBody: FM_PLACEHOLDER | FM_IF (fm_methodBody | methodBody) (FM_ELSE_IF (fm_methodBody | methodBody))* FM_ELSE (fm_methodBody | methodBody) FM_IF_CLOSE;

instanceInitializer
  : block
  ;

staticInitializer
  : STATIC  (block | fm_block)
  ;

constructorDeclaration
  : (constructorModifier | fm_constructorModifierStar)* (constructorDeclarator | fm_constructorDeclarator) (throws_ | fm_throws_Opt)? (constructorBody | fm_constructorBody)
  ;

constructorModifier
  : annotation
  | PUBLIC 
  | PROTECTED 
  | PRIVATE 
  ;
fm_constructorModifierStar: FM_PLACEHOLDER | FM_IF (fm_constructorModifierStar | constructorModifier) (FM_ELSE_IF (fm_constructorModifierStar | constructorModifier))* (FM_ELSE (fm_constructorModifierStar | constructorModifier))? FM_IF_CLOSE | FM_LIST (fm_constructorModifierStar | constructorModifier) FM_LIST_CLOSE;

constructorDeclarator
  : (typeParameters | fm_typeParametersOpt)? (simpleTypeName | fm_simpleTypeName) LPAREN  (formalParameterList | fm_formalParameterListOpt)? RPAREN 
  ;
fm_constructorDeclarator: FM_PLACEHOLDER | FM_IF (fm_constructorDeclarator | constructorDeclarator) (FM_ELSE_IF (fm_constructorDeclarator | constructorDeclarator))* FM_ELSE (fm_constructorDeclarator | constructorDeclarator) FM_IF_CLOSE;

simpleTypeName
  : Identifier
  ;
fm_simpleTypeName: FM_PLACEHOLDER | FM_IF (fm_simpleTypeName | simpleTypeName) (FM_ELSE_IF (fm_simpleTypeName | simpleTypeName))* FM_ELSE (fm_simpleTypeName | simpleTypeName) FM_IF_CLOSE;

constructorBody
  : LBRACE  (explicitConstructorInvocation | fm_explicitConstructorInvocationOpt)? (blockStatements | fm_blockStatementsOpt)? RBRACE 
  ;
fm_constructorBody: FM_PLACEHOLDER | FM_IF (fm_constructorBody | constructorBody) (FM_ELSE_IF (fm_constructorBody | constructorBody))* FM_ELSE (fm_constructorBody | constructorBody) FM_IF_CLOSE;

explicitConstructorInvocation
  : (typeArguments | fm_typeArgumentsOpt)? THIS  LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  SEMI 
  | (typeArguments | fm_typeArgumentsOpt)? SUPER  LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  SEMI 
  | (expressionName | fm_expressionName) DOT  (typeArguments | fm_typeArgumentsOpt)? SUPER  LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  SEMI 
  | (primary | fm_primary) DOT  (typeArguments | fm_typeArgumentsOpt)? SUPER  LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  SEMI 
  ;
fm_explicitConstructorInvocationOpt: FM_PLACEHOLDER | FM_IF (fm_explicitConstructorInvocationOpt | explicitConstructorInvocation) (FM_ELSE_IF (fm_explicitConstructorInvocationOpt | explicitConstructorInvocation))* (FM_ELSE (fm_explicitConstructorInvocationOpt | explicitConstructorInvocation))? FM_IF_CLOSE;

enumDeclaration
  : (classModifier | fm_classModifierStar)* ENUM  (Identifier | fm_Identifier) (superinterfaces | fm_superinterfacesOpt)? (enumBody | fm_enumBody)
  ;

enumBody
  : LBRACE  (enumConstantList | fm_enumConstantListOpt)? COMMA ? (enumBodyDeclarations | fm_enumBodyDeclarationsOpt)? RBRACE 
  ;
fm_enumBody: FM_PLACEHOLDER | FM_IF (fm_enumBody | enumBody) (FM_ELSE_IF (fm_enumBody | enumBody))* FM_ELSE (fm_enumBody | enumBody) FM_IF_CLOSE;

enumConstantList
  : (enumConstant | fm_enumConstant) (COMMA  (enumConstant | fm_enumConstant))*
  ;
fm_enumConstantListOpt: FM_PLACEHOLDER | FM_IF (fm_enumConstantListOpt | enumConstantList) (FM_ELSE_IF (fm_enumConstantListOpt | enumConstantList))* (FM_ELSE (fm_enumConstantListOpt | enumConstantList))? FM_IF_CLOSE;

enumConstant
  : (enumConstantModifier | fm_enumConstantModifierStar)* (Identifier | fm_Identifier) (LPAREN  (argumentList | fm_argumentListOpt)? RPAREN )? (classBody | fm_classBodyOpt)?
  ;
fm_enumConstant: FM_PLACEHOLDER | FM_IF (fm_enumConstant | enumConstant) (FM_ELSE_IF (fm_enumConstant | enumConstant))* FM_ELSE (fm_enumConstant | enumConstant) FM_IF_CLOSE;

enumConstantModifier
  : annotation
  ;
fm_enumConstantModifierStar: FM_PLACEHOLDER | FM_IF (fm_enumConstantModifierStar | enumConstantModifier) (FM_ELSE_IF (fm_enumConstantModifierStar | enumConstantModifier))* (FM_ELSE (fm_enumConstantModifierStar | enumConstantModifier))? FM_IF_CLOSE | FM_LIST (fm_enumConstantModifierStar | enumConstantModifier) FM_LIST_CLOSE;

enumBodyDeclarations
  : SEMI  (classBodyDeclaration | fm_classBodyDeclarationStar)*
  ;
fm_enumBodyDeclarationsOpt: FM_PLACEHOLDER | FM_IF (fm_enumBodyDeclarationsOpt | enumBodyDeclarations) (FM_ELSE_IF (fm_enumBodyDeclarationsOpt | enumBodyDeclarations))* (FM_ELSE (fm_enumBodyDeclarationsOpt | enumBodyDeclarations))? FM_IF_CLOSE;

/*
 * Productions from §9 (Interfaces)
 */

interfaceDeclaration
  : normalInterfaceDeclaration
  | annotationTypeDeclaration
  ;

normalInterfaceDeclaration
  : (interfaceModifier | fm_interfaceModifierStar)* INTERFACE  (Identifier | fm_Identifier) (typeParameters | fm_typeParametersOpt)? (extendsInterfaces | fm_extendsInterfacesOpt)? (interfaceBody | fm_interfaceBody)
  ;

interfaceModifier
  : annotation
  | PUBLIC 
  | PROTECTED 
  | PRIVATE 
  | ABSTRACT 
  | STATIC 
  | STRICTFP 
  ;
fm_interfaceModifierStar: FM_PLACEHOLDER | FM_IF (fm_interfaceModifierStar | interfaceModifier) (FM_ELSE_IF (fm_interfaceModifierStar | interfaceModifier))* (FM_ELSE (fm_interfaceModifierStar | interfaceModifier))? FM_IF_CLOSE | FM_LIST (fm_interfaceModifierStar | interfaceModifier) FM_LIST_CLOSE;

extendsInterfaces
  : EXTENDS  (interfaceTypeList | fm_interfaceTypeList)
  ;
fm_extendsInterfacesOpt: FM_PLACEHOLDER | FM_IF (fm_extendsInterfacesOpt | extendsInterfaces) (FM_ELSE_IF (fm_extendsInterfacesOpt | extendsInterfaces))* (FM_ELSE (fm_extendsInterfacesOpt | extendsInterfaces))? FM_IF_CLOSE;

interfaceBody
  : LBRACE  (interfaceMemberDeclaration | fm_interfaceMemberDeclarationStar)* RBRACE 
  ;
fm_interfaceBody: FM_PLACEHOLDER | FM_IF (fm_interfaceBody | interfaceBody) (FM_ELSE_IF (fm_interfaceBody | interfaceBody))* FM_ELSE (fm_interfaceBody | interfaceBody) FM_IF_CLOSE;

interfaceMemberDeclaration
  : constantDeclaration
  | interfaceMethodDeclaration
  | classDeclaration
  | interfaceDeclaration
  | SEMI 
  ;
fm_interfaceMemberDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_interfaceMemberDeclarationStar | interfaceMemberDeclaration) (FM_ELSE_IF (fm_interfaceMemberDeclarationStar | interfaceMemberDeclaration))* (FM_ELSE (fm_interfaceMemberDeclarationStar | interfaceMemberDeclaration))? FM_IF_CLOSE | FM_LIST (fm_interfaceMemberDeclarationStar | interfaceMemberDeclaration) FM_LIST_CLOSE;

constantDeclaration
  : (constantModifier | fm_constantModifierStar)* (unannType | fm_unannType) (variableDeclaratorList | fm_variableDeclaratorList) SEMI 
  ;

constantModifier
  : annotation
  | PUBLIC 
  | STATIC 
  | FINAL 
  ;
fm_constantModifierStar: FM_PLACEHOLDER | FM_IF (fm_constantModifierStar | constantModifier) (FM_ELSE_IF (fm_constantModifierStar | constantModifier))* (FM_ELSE (fm_constantModifierStar | constantModifier))? FM_IF_CLOSE | FM_LIST (fm_constantModifierStar | constantModifier) FM_LIST_CLOSE;

interfaceMethodDeclaration
  : (interfaceMethodModifier | fm_interfaceMethodModifierStar)* (methodHeader | fm_methodHeader) (methodBody | fm_methodBody)
  ;

interfaceMethodModifier
  : annotation
  | PUBLIC 
  | ABSTRACT 
  | DEFAULT 
  | STATIC 
  | STRICTFP 
  ;
fm_interfaceMethodModifierStar: FM_PLACEHOLDER | FM_IF (fm_interfaceMethodModifierStar | interfaceMethodModifier) (FM_ELSE_IF (fm_interfaceMethodModifierStar | interfaceMethodModifier))* (FM_ELSE (fm_interfaceMethodModifierStar | interfaceMethodModifier))? FM_IF_CLOSE | FM_LIST (fm_interfaceMethodModifierStar | interfaceMethodModifier) FM_LIST_CLOSE;

annotationTypeDeclaration
  : (interfaceModifier | fm_interfaceModifierStar)* AT  INTERFACE  (Identifier | fm_Identifier) (annotationTypeBody | fm_annotationTypeBody)
  ;

annotationTypeBody
  : LBRACE  (annotationTypeMemberDeclaration | fm_annotationTypeMemberDeclarationStar)* RBRACE 
  ;
fm_annotationTypeBody: FM_PLACEHOLDER | FM_IF (fm_annotationTypeBody | annotationTypeBody) (FM_ELSE_IF (fm_annotationTypeBody | annotationTypeBody))* FM_ELSE (fm_annotationTypeBody | annotationTypeBody) FM_IF_CLOSE;

annotationTypeMemberDeclaration
  : annotationTypeElementDeclaration
  | constantDeclaration
  | classDeclaration
  | interfaceDeclaration
  | SEMI 
  ;
fm_annotationTypeMemberDeclarationStar: FM_PLACEHOLDER | FM_IF (fm_annotationTypeMemberDeclarationStar | annotationTypeMemberDeclaration) (FM_ELSE_IF (fm_annotationTypeMemberDeclarationStar | annotationTypeMemberDeclaration))* (FM_ELSE (fm_annotationTypeMemberDeclarationStar | annotationTypeMemberDeclaration))? FM_IF_CLOSE | FM_LIST (fm_annotationTypeMemberDeclarationStar | annotationTypeMemberDeclaration) FM_LIST_CLOSE;

annotationTypeElementDeclaration
  : (annotationTypeElementModifier | fm_annotationTypeElementModifierStar)* (unannType | fm_unannType) (Identifier | fm_Identifier) LPAREN  RPAREN  (dims | fm_dimsOpt)? (defaultValue | fm_defaultValueOpt)? SEMI 
  ;

annotationTypeElementModifier
  : annotation
  | PUBLIC 
  | ABSTRACT 
  ;
fm_annotationTypeElementModifierStar: FM_PLACEHOLDER | FM_IF (fm_annotationTypeElementModifierStar | annotationTypeElementModifier) (FM_ELSE_IF (fm_annotationTypeElementModifierStar | annotationTypeElementModifier))* (FM_ELSE (fm_annotationTypeElementModifierStar | annotationTypeElementModifier))? FM_IF_CLOSE | FM_LIST (fm_annotationTypeElementModifierStar | annotationTypeElementModifier) FM_LIST_CLOSE;

defaultValue
  : DEFAULT  (elementValue | fm_elementValue)
  ;
fm_defaultValueOpt: FM_PLACEHOLDER | FM_IF (fm_defaultValueOpt | defaultValue) (FM_ELSE_IF (fm_defaultValueOpt | defaultValue))* (FM_ELSE (fm_defaultValueOpt | defaultValue))? FM_IF_CLOSE;

annotation
  : normalAnnotation
  | markerAnnotation
  | singleElementAnnotation
  ;
fm_annotationStar: FM_PLACEHOLDER | FM_IF (fm_annotationStar | annotation) (FM_ELSE_IF (fm_annotationStar | annotation))* (FM_ELSE (fm_annotationStar | annotation))? FM_IF_CLOSE | FM_LIST (fm_annotationStar | annotation) FM_LIST_CLOSE;

normalAnnotation
  : AT  (typeName | fm_typeName) LPAREN  (elementValuePairList | fm_elementValuePairListOpt)? RPAREN 
  ;

elementValuePairList
  : (elementValuePair | fm_elementValuePair) (COMMA  (elementValuePair | fm_elementValuePair))*
  ;
fm_elementValuePairListOpt: FM_PLACEHOLDER | FM_IF (fm_elementValuePairListOpt | elementValuePairList) (FM_ELSE_IF (fm_elementValuePairListOpt | elementValuePairList))* (FM_ELSE (fm_elementValuePairListOpt | elementValuePairList))? FM_IF_CLOSE;

elementValuePair
  : (Identifier | fm_Identifier) ASSIGN  (elementValue | fm_elementValue)
  ;
fm_elementValuePair: FM_PLACEHOLDER | FM_IF (fm_elementValuePair | elementValuePair) (FM_ELSE_IF (fm_elementValuePair | elementValuePair))* FM_ELSE (fm_elementValuePair | elementValuePair) FM_IF_CLOSE;

elementValue
  : conditionalExpression
  | elementValueArrayInitializer
  | annotation
  ;
fm_elementValue: FM_PLACEHOLDER | FM_IF (fm_elementValue | elementValue) (FM_ELSE_IF (fm_elementValue | elementValue))* FM_ELSE (fm_elementValue | elementValue) FM_IF_CLOSE;

elementValueArrayInitializer
  : LBRACE  (elementValueList | fm_elementValueListOpt)? COMMA ? RBRACE 
  ;

elementValueList
  : (elementValue | fm_elementValue) (COMMA  (elementValue | fm_elementValue))*
  ;
fm_elementValueListOpt: FM_PLACEHOLDER | FM_IF (fm_elementValueListOpt | elementValueList) (FM_ELSE_IF (fm_elementValueListOpt | elementValueList))* (FM_ELSE (fm_elementValueListOpt | elementValueList))? FM_IF_CLOSE;

markerAnnotation
  : AT  (typeName | fm_typeName)
  ;

singleElementAnnotation
  : AT  (typeName | fm_typeName) LPAREN  (elementValue | fm_elementValue) RPAREN 
  ;

/*
 * Productions from §10 (Arrays)
 */

arrayInitializer
  : LBRACE  (variableInitializerList | fm_variableInitializerListOpt)? COMMA ? RBRACE 
  ;
fm_arrayInitializer: FM_PLACEHOLDER | FM_IF (fm_arrayInitializer | arrayInitializer) (FM_ELSE_IF (fm_arrayInitializer | arrayInitializer))* FM_ELSE (fm_arrayInitializer | arrayInitializer) FM_IF_CLOSE;

variableInitializerList
  : (variableInitializer | fm_variableInitializer) (COMMA  (variableInitializer | fm_variableInitializer))*
  ;
fm_variableInitializerListOpt: FM_PLACEHOLDER | FM_IF (fm_variableInitializerListOpt | variableInitializerList) (FM_ELSE_IF (fm_variableInitializerListOpt | variableInitializerList))* (FM_ELSE (fm_variableInitializerListOpt | variableInitializerList))? FM_IF_CLOSE;

/*
 * Productions from §14 (Blocks and Statements)
 */

block
  : LBRACE  (blockStatements | fm_blockStatementsOpt)? RBRACE 
  ;
fm_block: FM_PLACEHOLDER | FM_IF (fm_block | block) (FM_ELSE_IF (fm_block | block))* FM_ELSE (fm_block | block) FM_IF_CLOSE;

blockStatements
  : (blockStatement | fm_blockStatement) (blockStatement | fm_blockStatementStar)*
  ;
fm_blockStatements: FM_PLACEHOLDER | FM_IF (fm_blockStatements | blockStatements) (FM_ELSE_IF (fm_blockStatements | blockStatements))* FM_ELSE (fm_blockStatements | blockStatements) FM_IF_CLOSE;
fm_blockStatementsOpt: FM_PLACEHOLDER | FM_IF (fm_blockStatementsOpt | blockStatements) (FM_ELSE_IF (fm_blockStatementsOpt | blockStatements))* (FM_ELSE (fm_blockStatementsOpt | blockStatements))? FM_IF_CLOSE;

blockStatement
  : localVariableDeclarationStatement
  | classDeclaration
  | statement
  ;
fm_blockStatement: FM_PLACEHOLDER | FM_IF (fm_blockStatement | blockStatement) (FM_ELSE_IF (fm_blockStatement | blockStatement))* FM_ELSE (fm_blockStatement | blockStatement) FM_IF_CLOSE;
fm_blockStatementStar: FM_PLACEHOLDER | FM_IF (fm_blockStatementStar | blockStatement) (FM_ELSE_IF (fm_blockStatementStar | blockStatement))* (FM_ELSE (fm_blockStatementStar | blockStatement))? FM_IF_CLOSE | FM_LIST (fm_blockStatementStar | blockStatement) FM_LIST_CLOSE;

localVariableDeclarationStatement
  : (localVariableDeclaration | fm_localVariableDeclaration) SEMI 
  ;

localVariableDeclaration
  : (variableModifier | fm_variableModifierStar)* (unannType | fm_unannType) (variableDeclaratorList | fm_variableDeclaratorList)
  ;
fm_localVariableDeclaration: FM_PLACEHOLDER | FM_IF (fm_localVariableDeclaration | localVariableDeclaration) (FM_ELSE_IF (fm_localVariableDeclaration | localVariableDeclaration))* FM_ELSE (fm_localVariableDeclaration | localVariableDeclaration) FM_IF_CLOSE;

statement
  : statementWithoutTrailingSubstatement
  | labeledStatement
  | ifThenStatement
  | ifThenElseStatement
  | whileStatement
  | forStatement
  ;
fm_statement: FM_PLACEHOLDER | FM_IF (fm_statement | statement) (FM_ELSE_IF (fm_statement | statement))* FM_ELSE (fm_statement | statement) FM_IF_CLOSE;

statementNoShortIf
  : statementWithoutTrailingSubstatement
  | labeledStatementNoShortIf
  | ifThenElseStatementNoShortIf
  | whileStatementNoShortIf
  | forStatementNoShortIf
  ;
fm_statementNoShortIf: FM_PLACEHOLDER | FM_IF (fm_statementNoShortIf | statementNoShortIf) (FM_ELSE_IF (fm_statementNoShortIf | statementNoShortIf))* FM_ELSE (fm_statementNoShortIf | statementNoShortIf) FM_IF_CLOSE;

statementWithoutTrailingSubstatement
  : block
  | emptyStatement
  | expressionStatement
  | assertStatement
  | switchStatement
  | doStatement
  | breakStatement
  | continueStatement
  | returnStatement
  | synchronizedStatement
  | throwStatement
  | tryStatement
  ;

emptyStatement
  : SEMI 
  ;

labeledStatement
  : (Identifier | fm_Identifier) COLON  (statement | fm_statement)
  ;

labeledStatementNoShortIf
  : (Identifier | fm_Identifier) COLON  (statementNoShortIf | fm_statementNoShortIf)
  ;

expressionStatement
  : (statementExpression | fm_statementExpression) SEMI 
  ;

statementExpression
  : assignment
  | preIncrementExpression
  | preDecrementExpression
  | postIncrementExpression
  | postDecrementExpression
  | methodInvocation
  | classInstanceCreationExpression
  ;
fm_statementExpression: FM_PLACEHOLDER | FM_IF (fm_statementExpression | statementExpression) (FM_ELSE_IF (fm_statementExpression | statementExpression))* FM_ELSE (fm_statementExpression | statementExpression) FM_IF_CLOSE;

ifThenStatement
  : IF  LPAREN  (expression | fm_expression) RPAREN  (statement | fm_statement)
  ;

ifThenElseStatement
  : IF  LPAREN  (expression | fm_expression) RPAREN  (statementNoShortIf | fm_statementNoShortIf) ELSE  (statement | fm_statement)
  ;

ifThenElseStatementNoShortIf
  : IF  LPAREN  (expression | fm_expression) RPAREN  (statementNoShortIf | fm_statementNoShortIf) ELSE  (statementNoShortIf | fm_statementNoShortIf)
  ;

assertStatement
  : ASSERT  (expression | fm_expression) SEMI 
  | ASSERT  (expression | fm_expression) COLON  (expression | fm_expression) SEMI 
  ;

switchStatement
  : SWITCH  LPAREN  (expression | fm_expression) RPAREN  (switchBlock | fm_switchBlock)
  ;

switchBlock
  : LBRACE  (switchBlockStatementGroup | fm_switchBlockStatementGroupStar)* (switchLabel | fm_switchLabelStar)* RBRACE 
  ;
fm_switchBlock: FM_PLACEHOLDER | FM_IF (fm_switchBlock | switchBlock) (FM_ELSE_IF (fm_switchBlock | switchBlock))* FM_ELSE (fm_switchBlock | switchBlock) FM_IF_CLOSE;

switchBlockStatementGroup
  : (switchLabels | fm_switchLabels) (blockStatements | fm_blockStatements)
  ;
fm_switchBlockStatementGroupStar: FM_PLACEHOLDER | FM_IF (fm_switchBlockStatementGroupStar | switchBlockStatementGroup) (FM_ELSE_IF (fm_switchBlockStatementGroupStar | switchBlockStatementGroup))* (FM_ELSE (fm_switchBlockStatementGroupStar | switchBlockStatementGroup))? FM_IF_CLOSE | FM_LIST (fm_switchBlockStatementGroupStar | switchBlockStatementGroup) FM_LIST_CLOSE;

switchLabels
  : (switchLabel | fm_switchLabel) (switchLabel | fm_switchLabelStar)*
  ;
fm_switchLabels: FM_PLACEHOLDER | FM_IF (fm_switchLabels | switchLabels) (FM_ELSE_IF (fm_switchLabels | switchLabels))* FM_ELSE (fm_switchLabels | switchLabels) FM_IF_CLOSE;

switchLabel
  : CASE  (constantExpression | fm_constantExpression) COLON 
  | CASE  (enumConstantName | fm_enumConstantName) COLON 
  | DEFAULT  COLON 
  ;
fm_switchLabel: FM_PLACEHOLDER | FM_IF (fm_switchLabel | switchLabel) (FM_ELSE_IF (fm_switchLabel | switchLabel))* FM_ELSE (fm_switchLabel | switchLabel) FM_IF_CLOSE;
fm_switchLabelStar: FM_PLACEHOLDER | FM_IF (fm_switchLabelStar | switchLabel) (FM_ELSE_IF (fm_switchLabelStar | switchLabel))* (FM_ELSE (fm_switchLabelStar | switchLabel))? FM_IF_CLOSE | FM_LIST (fm_switchLabelStar | switchLabel) FM_LIST_CLOSE;

enumConstantName
  : Identifier
  ;
fm_enumConstantName: FM_PLACEHOLDER | FM_IF (fm_enumConstantName | enumConstantName) (FM_ELSE_IF (fm_enumConstantName | enumConstantName))* FM_ELSE (fm_enumConstantName | enumConstantName) FM_IF_CLOSE;

whileStatement
  : WHILE  LPAREN  (expression | fm_expression) RPAREN  (statement | fm_statement)
  ;

whileStatementNoShortIf
  : WHILE  LPAREN  (expression | fm_expression) RPAREN  (statementNoShortIf | fm_statementNoShortIf)
  ;

doStatement
  : DO  (statement | fm_statement) WHILE  LPAREN  (expression | fm_expression) RPAREN  SEMI 
  ;

forStatement
  : basicForStatement
  | enhancedForStatement
  ;

forStatementNoShortIf
  : basicForStatementNoShortIf
  | enhancedForStatementNoShortIf
  ;

basicForStatement
  : FOR  LPAREN  (forInit | fm_forInitOpt)? SEMI  (expression | fm_expressionOpt)? SEMI  (forUpdate | fm_forUpdateOpt)? RPAREN  (statement | fm_statement)
  ;

basicForStatementNoShortIf
  : FOR  LPAREN  (forInit | fm_forInitOpt)? SEMI  (expression | fm_expressionOpt)? SEMI  (forUpdate | fm_forUpdateOpt)? RPAREN  (statementNoShortIf | fm_statementNoShortIf)
  ;

forInit
  : statementExpressionList
  | localVariableDeclaration
  ;
fm_forInitOpt: FM_PLACEHOLDER | FM_IF (fm_forInitOpt | forInit) (FM_ELSE_IF (fm_forInitOpt | forInit))* (FM_ELSE (fm_forInitOpt | forInit))? FM_IF_CLOSE;

forUpdate
  : statementExpressionList
  ;
fm_forUpdateOpt: FM_PLACEHOLDER | FM_IF (fm_forUpdateOpt | forUpdate) (FM_ELSE_IF (fm_forUpdateOpt | forUpdate))* (FM_ELSE (fm_forUpdateOpt | forUpdate))? FM_IF_CLOSE;

statementExpressionList
  : (statementExpression | fm_statementExpression) (COMMA  (statementExpression | fm_statementExpression))*
  ;

enhancedForStatement
  : FOR  LPAREN  (variableModifier | fm_variableModifierStar)* (unannType | fm_unannType) (variableDeclaratorId | fm_variableDeclaratorId) COLON  (expression | fm_expression) RPAREN  (statement | fm_statement)
  ;

enhancedForStatementNoShortIf
  : FOR  LPAREN  (variableModifier | fm_variableModifierStar)* (unannType | fm_unannType) (variableDeclaratorId | fm_variableDeclaratorId) COLON  (expression | fm_expression) RPAREN  (statementNoShortIf | fm_statementNoShortIf)
  ;

breakStatement
  : BREAK  (Identifier | fm_IdentifierOpt)? SEMI 
  ;

continueStatement
  : CONTINUE  (Identifier | fm_IdentifierOpt)? SEMI 
  ;

returnStatement
  : RETURN  (expression | fm_expressionOpt)? SEMI 
  ;

throwStatement
  : THROW  (expression | fm_expression) SEMI 
  ;

synchronizedStatement
  : SYNCHRONIZED  LPAREN  (expression | fm_expression) RPAREN  (block | fm_block)
  ;

tryStatement
  : TRY  (block | fm_block) (catches | fm_catches)
  | TRY  (block | fm_block) (catches | fm_catchesOpt)? (finally_ | fm_finally_)
  | tryWithResourcesStatement
  ;

catches
  : (catchClause | fm_catchClause) (catchClause | fm_catchClauseStar)*
  ;
fm_catches: FM_PLACEHOLDER | FM_IF (fm_catches | catches) (FM_ELSE_IF (fm_catches | catches))* FM_ELSE (fm_catches | catches) FM_IF_CLOSE;
fm_catchesOpt: FM_PLACEHOLDER | FM_IF (fm_catchesOpt | catches) (FM_ELSE_IF (fm_catchesOpt | catches))* (FM_ELSE (fm_catchesOpt | catches))? FM_IF_CLOSE;

catchClause
  : CATCH  LPAREN  (catchFormalParameter | fm_catchFormalParameter) RPAREN  (block | fm_block)
  ;
fm_catchClause: FM_PLACEHOLDER | FM_IF (fm_catchClause | catchClause) (FM_ELSE_IF (fm_catchClause | catchClause))* FM_ELSE (fm_catchClause | catchClause) FM_IF_CLOSE;
fm_catchClauseStar: FM_PLACEHOLDER | FM_IF (fm_catchClauseStar | catchClause) (FM_ELSE_IF (fm_catchClauseStar | catchClause))* (FM_ELSE (fm_catchClauseStar | catchClause))? FM_IF_CLOSE | FM_LIST (fm_catchClauseStar | catchClause) FM_LIST_CLOSE;

catchFormalParameter
  : (variableModifier | fm_variableModifierStar)* (catchType | fm_catchType) (variableDeclaratorId | fm_variableDeclaratorId)
  ;
fm_catchFormalParameter: FM_PLACEHOLDER | FM_IF (fm_catchFormalParameter | catchFormalParameter) (FM_ELSE_IF (fm_catchFormalParameter | catchFormalParameter))* FM_ELSE (fm_catchFormalParameter | catchFormalParameter) FM_IF_CLOSE;

catchType
  : (unannClassType | fm_unannClassType) (BITOR  (classType | fm_classType))*
  ;
fm_catchType: FM_PLACEHOLDER | FM_IF (fm_catchType | catchType) (FM_ELSE_IF (fm_catchType | catchType))* FM_ELSE (fm_catchType | catchType) FM_IF_CLOSE;

finally_
  : FINALLY  (block | fm_block)
  ;
fm_finally_: FM_PLACEHOLDER | FM_IF (fm_finally_ | finally_) (FM_ELSE_IF (fm_finally_ | finally_))* FM_ELSE (fm_finally_ | finally_) FM_IF_CLOSE;
fm_finally_Opt: FM_PLACEHOLDER | FM_IF (fm_finally_Opt | finally_) (FM_ELSE_IF (fm_finally_Opt | finally_))* (FM_ELSE (fm_finally_Opt | finally_))? FM_IF_CLOSE;

tryWithResourcesStatement
  : TRY  (resourceSpecification | fm_resourceSpecification) (block | fm_block) (catches | fm_catchesOpt)? (finally_ | fm_finally_Opt)?
  ;

resourceSpecification
  : LPAREN  (resourceList | fm_resourceList) SEMI ? RPAREN 
  ;
fm_resourceSpecification: FM_PLACEHOLDER | FM_IF (fm_resourceSpecification | resourceSpecification) (FM_ELSE_IF (fm_resourceSpecification | resourceSpecification))* FM_ELSE (fm_resourceSpecification | resourceSpecification) FM_IF_CLOSE;

resourceList
  : (resource | fm_resource) (SEMI  (resource | fm_resource))*
  ;
fm_resourceList: FM_PLACEHOLDER | FM_IF (fm_resourceList | resourceList) (FM_ELSE_IF (fm_resourceList | resourceList))* FM_ELSE (fm_resourceList | resourceList) FM_IF_CLOSE;

resource
  : (variableModifier | fm_variableModifierStar)* (unannType | fm_unannType) (variableDeclaratorId | fm_variableDeclaratorId) ASSIGN  (expression | fm_expression)
  ;
fm_resource: FM_PLACEHOLDER | FM_IF (fm_resource | resource) (FM_ELSE_IF (fm_resource | resource))* FM_ELSE (fm_resource | resource) FM_IF_CLOSE;

/*
 * Productions from §15 (Expressions)
 */

primary
  : ( primaryNoNewArray_lfno_primary
    | arrayCreationExpression
    )
    ( primaryNoNewArray_lf_primary
    )*
  ;
fm_primary: FM_PLACEHOLDER | FM_IF (fm_primary | primary) (FM_ELSE_IF (fm_primary | primary))* FM_ELSE (fm_primary | primary) FM_IF_CLOSE;

primaryNoNewArray
  : literal
  | (typeName | fm_typeName) (LBRACK  RBRACK )* DOT  CLASS 
  | VOID  DOT  CLASS 
  | THIS 
  | (typeName | fm_typeName) DOT  THIS 
  | LPAREN  (expression | fm_expression) RPAREN 
  | classInstanceCreationExpression
  | fieldAccess
  | arrayAccess
  | methodInvocation
  | methodReference
  ;

primaryNoNewArray_lf_arrayAccess
  :
  ;
fm_primaryNoNewArray_lf_arrayAccess: FM_PLACEHOLDER | FM_IF (fm_primaryNoNewArray_lf_arrayAccess | primaryNoNewArray_lf_arrayAccess) (FM_ELSE_IF (fm_primaryNoNewArray_lf_arrayAccess | primaryNoNewArray_lf_arrayAccess))* FM_ELSE (fm_primaryNoNewArray_lf_arrayAccess | primaryNoNewArray_lf_arrayAccess) FM_IF_CLOSE;

primaryNoNewArray_lfno_arrayAccess
  : literal
  | (typeName | fm_typeName) (LBRACK  RBRACK )* DOT  CLASS 
  | VOID  DOT  CLASS 
  | THIS 
  | (typeName | fm_typeName) DOT  THIS 
  | LPAREN  (expression | fm_expression) RPAREN 
  | classInstanceCreationExpression
  | fieldAccess
  | methodInvocation
  | methodReference
  ;
fm_primaryNoNewArray_lfno_arrayAccess: FM_PLACEHOLDER | FM_IF (fm_primaryNoNewArray_lfno_arrayAccess | primaryNoNewArray_lfno_arrayAccess) (FM_ELSE_IF (fm_primaryNoNewArray_lfno_arrayAccess | primaryNoNewArray_lfno_arrayAccess))* FM_ELSE (fm_primaryNoNewArray_lfno_arrayAccess | primaryNoNewArray_lfno_arrayAccess) FM_IF_CLOSE;

primaryNoNewArray_lf_primary
  : classInstanceCreationExpression_lf_primary
  | fieldAccess_lf_primary
  | arrayAccess_lf_primary
  | methodInvocation_lf_primary
  | methodReference_lf_primary
  ;

primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary
  :
  ;
fm_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary: FM_PLACEHOLDER | FM_IF (fm_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary | primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary) (FM_ELSE_IF (fm_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary | primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary))* FM_ELSE (fm_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary | primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary) FM_IF_CLOSE;

primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary
  : classInstanceCreationExpression_lf_primary
  | fieldAccess_lf_primary
  | methodInvocation_lf_primary
  | methodReference_lf_primary
  ;
fm_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary: FM_PLACEHOLDER | FM_IF (fm_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary | primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary) (FM_ELSE_IF (fm_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary | primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary))* FM_ELSE (fm_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary | primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary) FM_IF_CLOSE;

primaryNoNewArray_lfno_primary
  : literal
  | (typeName | fm_typeName) (LBRACK  RBRACK )* DOT  CLASS 
  | (unannPrimitiveType | fm_unannPrimitiveType) (LBRACK  RBRACK )* DOT  CLASS 
  | VOID  DOT  CLASS 
  | THIS 
  | (typeName | fm_typeName) DOT  THIS 
  | LPAREN  (expression | fm_expression) RPAREN 
  | classInstanceCreationExpression_lfno_primary
  | fieldAccess_lfno_primary
  | arrayAccess_lfno_primary
  | methodInvocation_lfno_primary
  | methodReference_lfno_primary
  ;

primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary
  :
  ;
fm_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary: FM_PLACEHOLDER | FM_IF (fm_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary | primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary) (FM_ELSE_IF (fm_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary | primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary))* FM_ELSE (fm_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary | primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary) FM_IF_CLOSE;

primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary
  : literal
  | (typeName | fm_typeName) (LBRACK  RBRACK )* DOT  CLASS 
  | (unannPrimitiveType | fm_unannPrimitiveType) (LBRACK  RBRACK )* DOT  CLASS 
  | VOID  DOT  CLASS 
  | THIS 
  | (typeName | fm_typeName) DOT  THIS 
  | LPAREN  (expression | fm_expression) RPAREN 
  | classInstanceCreationExpression_lfno_primary
  | fieldAccess_lfno_primary
  | methodInvocation_lfno_primary
  | methodReference_lfno_primary
  ;
fm_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary: FM_PLACEHOLDER | FM_IF (fm_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary | primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary) (FM_ELSE_IF (fm_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary | primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary))* FM_ELSE (fm_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary | primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary) FM_IF_CLOSE;

classInstanceCreationExpression
  : NEW  (typeArguments | fm_typeArgumentsOpt)? (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (DOT  (annotation | fm_annotationStar)* (Identifier | fm_Identifier))* (typeArgumentsOrDiamond | fm_typeArgumentsOrDiamondOpt)? LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  (classBody | fm_classBodyOpt)?
  | (expressionName | fm_expressionName) DOT  NEW  (typeArguments | fm_typeArgumentsOpt)? (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArgumentsOrDiamond | fm_typeArgumentsOrDiamondOpt)? LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  (classBody | fm_classBodyOpt)?
  | (primary | fm_primary) DOT  NEW  (typeArguments | fm_typeArgumentsOpt)? (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArgumentsOrDiamond | fm_typeArgumentsOrDiamondOpt)? LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  (classBody | fm_classBodyOpt)?
  ;

classInstanceCreationExpression_lf_primary
  : DOT  NEW  (typeArguments | fm_typeArgumentsOpt)? (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArgumentsOrDiamond | fm_typeArgumentsOrDiamondOpt)? LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  (classBody | fm_classBodyOpt)?
  ;

classInstanceCreationExpression_lfno_primary
  : NEW  (typeArguments | fm_typeArgumentsOpt)? (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (DOT  (annotation | fm_annotationStar)* (Identifier | fm_Identifier))* (typeArgumentsOrDiamond | fm_typeArgumentsOrDiamondOpt)? LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  (classBody | fm_classBodyOpt)?
  | (expressionName | fm_expressionName) DOT  NEW  (typeArguments | fm_typeArgumentsOpt)? (annotation | fm_annotationStar)* (Identifier | fm_Identifier) (typeArgumentsOrDiamond | fm_typeArgumentsOrDiamondOpt)? LPAREN  (argumentList | fm_argumentListOpt)? RPAREN  (classBody | fm_classBodyOpt)?
  ;

typeArgumentsOrDiamond
  : typeArguments
  | LT  GT 
  ;
fm_typeArgumentsOrDiamondOpt: FM_PLACEHOLDER | FM_IF (fm_typeArgumentsOrDiamondOpt | typeArgumentsOrDiamond) (FM_ELSE_IF (fm_typeArgumentsOrDiamondOpt | typeArgumentsOrDiamond))* (FM_ELSE (fm_typeArgumentsOrDiamondOpt | typeArgumentsOrDiamond))? FM_IF_CLOSE;

fieldAccess
  : (primary | fm_primary) DOT  (Identifier | fm_Identifier)
  | SUPER  DOT  (Identifier | fm_Identifier)
  | (typeName | fm_typeName) DOT  SUPER  DOT  (Identifier | fm_Identifier)
  ;

fieldAccess_lf_primary
  : DOT  (Identifier | fm_Identifier)
  ;

fieldAccess_lfno_primary
  : SUPER  DOT  (Identifier | fm_Identifier)
  | (typeName | fm_typeName) DOT  SUPER  DOT  (Identifier | fm_Identifier)
  ;

arrayAccess
  : ( (expressionName | fm_expressionName) LBRACK  (expression | fm_expression) RBRACK 
    | (primaryNoNewArray_lfno_arrayAccess | fm_primaryNoNewArray_lfno_arrayAccess) LBRACK  (expression | fm_expression) RBRACK 
    )
    ( (primaryNoNewArray_lf_arrayAccess | fm_primaryNoNewArray_lf_arrayAccess) LBRACK  (expression | fm_expression) RBRACK 
    )*
  ;

arrayAccess_lf_primary
  : ( (primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary | fm_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary) LBRACK  (expression | fm_expression) RBRACK 
    )
    ( (primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary | fm_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary) LBRACK  (expression | fm_expression) RBRACK 
    )*
  ;

arrayAccess_lfno_primary
  : ( (expressionName | fm_expressionName) LBRACK  (expression | fm_expression) RBRACK 
    | (primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary | fm_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary) LBRACK  (expression | fm_expression) RBRACK 
    )
    ( (primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary | fm_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary) LBRACK  (expression | fm_expression) RBRACK 
    )*
  ;

methodInvocation
  : (methodName | fm_methodName) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | (typeName | fm_typeName) DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | (expressionName | fm_expressionName) DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | (primary | fm_primary) DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | SUPER  DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | (typeName | fm_typeName) DOT  SUPER  DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  ;

methodInvocation_lf_primary
  : DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  ;

methodInvocation_lfno_primary
  : (methodName | fm_methodName) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | (typeName | fm_typeName) DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | (expressionName | fm_expressionName) DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | SUPER  DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  | (typeName | fm_typeName) DOT  SUPER  DOT  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier) LPAREN  (argumentList | fm_argumentListOpt)? RPAREN 
  ;

argumentList
  : (expression | fm_expression) (COMMA  (expression | fm_expression))*
  ;
fm_argumentListOpt: FM_PLACEHOLDER | FM_IF (fm_argumentListOpt | argumentList) (FM_ELSE_IF (fm_argumentListOpt | argumentList))* (FM_ELSE (fm_argumentListOpt | argumentList))? FM_IF_CLOSE;

methodReference
  : (expressionName | fm_expressionName) COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | (referenceType | fm_referenceType) COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | (primary | fm_primary) COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | SUPER  COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | (typeName | fm_typeName) DOT  SUPER  COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | (classType | fm_classType) COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? NEW 
  | (arrayType | fm_arrayType) COLONCOLON  NEW 
  ;

methodReference_lf_primary
  : COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  ;

methodReference_lfno_primary
  : (expressionName | fm_expressionName) COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | (referenceType | fm_referenceType) COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | SUPER  COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | (typeName | fm_typeName) DOT  SUPER  COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? (Identifier | fm_Identifier)
  | (classType | fm_classType) COLONCOLON  (typeArguments | fm_typeArgumentsOpt)? NEW 
  | (arrayType | fm_arrayType) COLONCOLON  NEW 
  ;

arrayCreationExpression
  : NEW  (primitiveType | fm_primitiveType) (dimExprs | fm_dimExprs) (dims | fm_dimsOpt)?
  | NEW  (classOrInterfaceType | fm_classOrInterfaceType) (dimExprs | fm_dimExprs) (dims | fm_dimsOpt)?
  | NEW  (primitiveType | fm_primitiveType) (dims | fm_dims) (arrayInitializer | fm_arrayInitializer)
  | NEW  (classOrInterfaceType | fm_classOrInterfaceType) (dims | fm_dims) (arrayInitializer | fm_arrayInitializer)
  ;

dimExprs
  : (dimExpr | fm_dimExpr) (dimExpr | fm_dimExprStar)*
  ;
fm_dimExprs: FM_PLACEHOLDER | FM_IF (fm_dimExprs | dimExprs) (FM_ELSE_IF (fm_dimExprs | dimExprs))* FM_ELSE (fm_dimExprs | dimExprs) FM_IF_CLOSE;

dimExpr
  : (annotation | fm_annotationStar)* LBRACK  (expression | fm_expression) RBRACK 
  ;
fm_dimExpr: FM_PLACEHOLDER | FM_IF (fm_dimExpr | dimExpr) (FM_ELSE_IF (fm_dimExpr | dimExpr))* FM_ELSE (fm_dimExpr | dimExpr) FM_IF_CLOSE;
fm_dimExprStar: FM_PLACEHOLDER | FM_IF (fm_dimExprStar | dimExpr) (FM_ELSE_IF (fm_dimExprStar | dimExpr))* (FM_ELSE (fm_dimExprStar | dimExpr))? FM_IF_CLOSE | FM_LIST (fm_dimExprStar | dimExpr) FM_LIST_CLOSE;

constantExpression
  : expression
  ;
fm_constantExpression: FM_PLACEHOLDER | FM_IF (fm_constantExpression | constantExpression) (FM_ELSE_IF (fm_constantExpression | constantExpression))* FM_ELSE (fm_constantExpression | constantExpression) FM_IF_CLOSE;

expression
  : lambdaExpression
  | assignmentExpression
  ;
fm_expression: FM_PLACEHOLDER | FM_IF (fm_expression | expression) (FM_ELSE_IF (fm_expression | expression))* FM_ELSE (fm_expression | expression) FM_IF_CLOSE;
fm_expressionOpt: FM_PLACEHOLDER | FM_IF (fm_expressionOpt | expression) (FM_ELSE_IF (fm_expressionOpt | expression))* (FM_ELSE (fm_expressionOpt | expression))? FM_IF_CLOSE;

lambdaExpression
  : (lambdaParameters | fm_lambdaParameters) ARROW  (lambdaBody | fm_lambdaBody)
  ;
fm_lambdaExpression: FM_PLACEHOLDER | FM_IF (fm_lambdaExpression | lambdaExpression) (FM_ELSE_IF (fm_lambdaExpression | lambdaExpression))* FM_ELSE (fm_lambdaExpression | lambdaExpression) FM_IF_CLOSE;

lambdaParameters
  : Identifier
  | LPAREN  (formalParameterList | fm_formalParameterListOpt)? RPAREN 
  | LPAREN  (inferredFormalParameterList | fm_inferredFormalParameterList) RPAREN 
  ;
fm_lambdaParameters: FM_PLACEHOLDER | FM_IF (fm_lambdaParameters | lambdaParameters) (FM_ELSE_IF (fm_lambdaParameters | lambdaParameters))* FM_ELSE (fm_lambdaParameters | lambdaParameters) FM_IF_CLOSE;

inferredFormalParameterList
  : (Identifier | fm_Identifier) (COMMA  (Identifier | fm_Identifier))*
  ;
fm_inferredFormalParameterList: FM_PLACEHOLDER | FM_IF (fm_inferredFormalParameterList | inferredFormalParameterList) (FM_ELSE_IF (fm_inferredFormalParameterList | inferredFormalParameterList))* FM_ELSE (fm_inferredFormalParameterList | inferredFormalParameterList) FM_IF_CLOSE;

lambdaBody
  : expression
  | block
  ;
fm_lambdaBody: FM_PLACEHOLDER | FM_IF (fm_lambdaBody | lambdaBody) (FM_ELSE_IF (fm_lambdaBody | lambdaBody))* FM_ELSE (fm_lambdaBody | lambdaBody) FM_IF_CLOSE;

assignmentExpression
  : conditionalExpression
  | assignment
  ;

assignment
  : (leftHandSide | fm_leftHandSide) (assignmentOperator | fm_assignmentOperator) (expression | fm_expression)
  ;

leftHandSide
  : expressionName
  | fieldAccess
  | arrayAccess
  ;
fm_leftHandSide: FM_PLACEHOLDER | FM_IF (fm_leftHandSide | leftHandSide) (FM_ELSE_IF (fm_leftHandSide | leftHandSide))* FM_ELSE (fm_leftHandSide | leftHandSide) FM_IF_CLOSE;

assignmentOperator
  : ASSIGN 
  | MUL_ASSIGN 
  | DIV_ASSIGN 
  | MOD_ASSIGN 
  | ADD_ASSIGN 
  | SUB_ASSIGN 
  | LSHIFT_ASSIGN 
  | RSHIFT_ASSIGN 
  | URSHIFT_ASSIGN 
  | AND_ASSIGN 
  | XOR_ASSIGN 
  | OR_ASSIGN 
  ;
fm_assignmentOperator: FM_PLACEHOLDER | FM_IF (fm_assignmentOperator | assignmentOperator) (FM_ELSE_IF (fm_assignmentOperator | assignmentOperator))* FM_ELSE (fm_assignmentOperator | assignmentOperator) FM_IF_CLOSE;

conditionalExpression
  : conditionalOrExpression
  | (conditionalOrExpression | fm_conditionalOrExpression) QUESTION  (expression | fm_expression) COLON  conditionalExpression
  | ( conditionalOrExpression | fm_conditionalOrExpression ) QUESTION ( expression | fm_expression ) COLON fm_conditionalExpression 
  ;
fm_conditionalExpression: FM_PLACEHOLDER | FM_IF (fm_conditionalExpression | conditionalExpression) (FM_ELSE_IF (fm_conditionalExpression | conditionalExpression))* FM_ELSE (fm_conditionalExpression | conditionalExpression) FM_IF_CLOSE;

conditionalOrExpression
  : conditionalAndExpression
  | conditionalOrExpression OR  (conditionalAndExpression | fm_conditionalAndExpression)
  | fm_conditionalOrExpression OR ( conditionalAndExpression | fm_conditionalAndExpression ) 
  ;
fm_conditionalOrExpression: FM_PLACEHOLDER | FM_IF (fm_conditionalOrExpression | conditionalOrExpression) (FM_ELSE_IF (fm_conditionalOrExpression | conditionalOrExpression))* FM_ELSE (fm_conditionalOrExpression | conditionalOrExpression) FM_IF_CLOSE;

conditionalAndExpression
  : inclusiveOrExpression
  | conditionalAndExpression AND  (inclusiveOrExpression | fm_inclusiveOrExpression)
  | fm_conditionalAndExpression AND ( inclusiveOrExpression | fm_inclusiveOrExpression ) 
  ;
fm_conditionalAndExpression: FM_PLACEHOLDER | FM_IF (fm_conditionalAndExpression | conditionalAndExpression) (FM_ELSE_IF (fm_conditionalAndExpression | conditionalAndExpression))* FM_ELSE (fm_conditionalAndExpression | conditionalAndExpression) FM_IF_CLOSE;

inclusiveOrExpression
  : exclusiveOrExpression
  | inclusiveOrExpression BITOR  (exclusiveOrExpression | fm_exclusiveOrExpression)
  | fm_inclusiveOrExpression BITOR ( exclusiveOrExpression | fm_exclusiveOrExpression ) 
  ;
fm_inclusiveOrExpression: FM_PLACEHOLDER | FM_IF (fm_inclusiveOrExpression | inclusiveOrExpression) (FM_ELSE_IF (fm_inclusiveOrExpression | inclusiveOrExpression))* FM_ELSE (fm_inclusiveOrExpression | inclusiveOrExpression) FM_IF_CLOSE;

exclusiveOrExpression
  : andExpression
  | exclusiveOrExpression CARET  (andExpression | fm_andExpression)
  | fm_exclusiveOrExpression CARET ( andExpression | fm_andExpression ) 
  ;
fm_exclusiveOrExpression: FM_PLACEHOLDER | FM_IF (fm_exclusiveOrExpression | exclusiveOrExpression) (FM_ELSE_IF (fm_exclusiveOrExpression | exclusiveOrExpression))* FM_ELSE (fm_exclusiveOrExpression | exclusiveOrExpression) FM_IF_CLOSE;

andExpression
  : equalityExpression
  | andExpression BITAND  (equalityExpression | fm_equalityExpression)
  | fm_andExpression BITAND ( equalityExpression | fm_equalityExpression ) 
  ;
fm_andExpression: FM_PLACEHOLDER | FM_IF (fm_andExpression | andExpression) (FM_ELSE_IF (fm_andExpression | andExpression))* FM_ELSE (fm_andExpression | andExpression) FM_IF_CLOSE;

equalityExpression
  : relationalExpression
  | equalityExpression EQUAL  (relationalExpression | fm_relationalExpression)
  | fm_equalityExpression EQUAL ( relationalExpression | fm_relationalExpression ) 
  | equalityExpression NOTEQUAL  (relationalExpression | fm_relationalExpression)
  | fm_equalityExpression NOTEQUAL ( relationalExpression | fm_relationalExpression ) 
  ;
fm_equalityExpression: FM_PLACEHOLDER | FM_IF (fm_equalityExpression | equalityExpression) (FM_ELSE_IF (fm_equalityExpression | equalityExpression))* FM_ELSE (fm_equalityExpression | equalityExpression) FM_IF_CLOSE;

relationalExpression
  : shiftExpression
  | relationalExpression LT  (shiftExpression | fm_shiftExpression)
  | fm_relationalExpression LT ( shiftExpression | fm_shiftExpression ) 
  | relationalExpression GT  (shiftExpression | fm_shiftExpression)
  | fm_relationalExpression GT ( shiftExpression | fm_shiftExpression ) 
  | relationalExpression LE  (shiftExpression | fm_shiftExpression)
  | fm_relationalExpression LE ( shiftExpression | fm_shiftExpression ) 
  | relationalExpression GE  (shiftExpression | fm_shiftExpression)
  | fm_relationalExpression GE ( shiftExpression | fm_shiftExpression ) 
  | relationalExpression INSTANCEOF  (referenceType | fm_referenceType)
  | fm_relationalExpression INSTANCEOF ( referenceType | fm_referenceType ) 
  ;
fm_relationalExpression: FM_PLACEHOLDER | FM_IF (fm_relationalExpression | relationalExpression) (FM_ELSE_IF (fm_relationalExpression | relationalExpression))* FM_ELSE (fm_relationalExpression | relationalExpression) FM_IF_CLOSE;

shiftExpression
  : additiveExpression
  | shiftExpression LT  LT  (additiveExpression | fm_additiveExpression)
  | fm_shiftExpression LT LT ( additiveExpression | fm_additiveExpression ) 
  | shiftExpression GT  GT  (additiveExpression | fm_additiveExpression)
  | fm_shiftExpression GT GT ( additiveExpression | fm_additiveExpression ) 
  | shiftExpression GT  GT  GT  (additiveExpression | fm_additiveExpression)
  | fm_shiftExpression GT GT GT ( additiveExpression | fm_additiveExpression ) 
  ;
fm_shiftExpression: FM_PLACEHOLDER | FM_IF (fm_shiftExpression | shiftExpression) (FM_ELSE_IF (fm_shiftExpression | shiftExpression))* FM_ELSE (fm_shiftExpression | shiftExpression) FM_IF_CLOSE;

additiveExpression
  : multiplicativeExpression
  | additiveExpression ADD  (multiplicativeExpression | fm_multiplicativeExpression)
  | fm_additiveExpression ADD ( multiplicativeExpression | fm_multiplicativeExpression ) 
  | additiveExpression SUB  (multiplicativeExpression | fm_multiplicativeExpression)
  | fm_additiveExpression SUB ( multiplicativeExpression | fm_multiplicativeExpression ) 
  ;
fm_additiveExpression: FM_PLACEHOLDER | FM_IF (fm_additiveExpression | additiveExpression) (FM_ELSE_IF (fm_additiveExpression | additiveExpression))* FM_ELSE (fm_additiveExpression | additiveExpression) FM_IF_CLOSE;

multiplicativeExpression
  : unaryExpression
  | multiplicativeExpression MUL  (unaryExpression | fm_unaryExpression)
  | fm_multiplicativeExpression MUL ( unaryExpression | fm_unaryExpression ) 
  | multiplicativeExpression DIV  (unaryExpression | fm_unaryExpression)
  | fm_multiplicativeExpression DIV ( unaryExpression | fm_unaryExpression ) 
  | multiplicativeExpression MOD  (unaryExpression | fm_unaryExpression)
  | fm_multiplicativeExpression MOD ( unaryExpression | fm_unaryExpression ) 
  ;
fm_multiplicativeExpression: FM_PLACEHOLDER | FM_IF (fm_multiplicativeExpression | multiplicativeExpression) (FM_ELSE_IF (fm_multiplicativeExpression | multiplicativeExpression))* FM_ELSE (fm_multiplicativeExpression | multiplicativeExpression) FM_IF_CLOSE;

unaryExpression
  : preIncrementExpression
  | preDecrementExpression
  | ADD  unaryExpression
  | ADD fm_unaryExpression 
  | SUB  unaryExpression
  | SUB fm_unaryExpression 
  | unaryExpressionNotPlusMinus
  ;
fm_unaryExpression: FM_PLACEHOLDER | FM_IF (fm_unaryExpression | unaryExpression) (FM_ELSE_IF (fm_unaryExpression | unaryExpression))* FM_ELSE (fm_unaryExpression | unaryExpression) FM_IF_CLOSE;

preIncrementExpression
  : INC  (unaryExpression | fm_unaryExpression)
  ;

preDecrementExpression
  : DEC  (unaryExpression | fm_unaryExpression)
  ;

unaryExpressionNotPlusMinus
  : postfixExpression
  | TILDE  (unaryExpression | fm_unaryExpression)
  | BANG  (unaryExpression | fm_unaryExpression)
  | castExpression
  ;
fm_unaryExpressionNotPlusMinus: FM_PLACEHOLDER | FM_IF (fm_unaryExpressionNotPlusMinus | unaryExpressionNotPlusMinus) (FM_ELSE_IF (fm_unaryExpressionNotPlusMinus | unaryExpressionNotPlusMinus))* FM_ELSE (fm_unaryExpressionNotPlusMinus | unaryExpressionNotPlusMinus) FM_IF_CLOSE;

postfixExpression
  : ( primary
    | expressionName
    )
    ( postIncrementExpression_lf_postfixExpression
    | postDecrementExpression_lf_postfixExpression
    )*
  ;
fm_postfixExpression: FM_PLACEHOLDER | FM_IF (fm_postfixExpression | postfixExpression) (FM_ELSE_IF (fm_postfixExpression | postfixExpression))* FM_ELSE (fm_postfixExpression | postfixExpression) FM_IF_CLOSE;

postIncrementExpression
  : (postfixExpression | fm_postfixExpression) INC 
  ;

postIncrementExpression_lf_postfixExpression
  : INC 
  ;

postDecrementExpression
  : (postfixExpression | fm_postfixExpression) DEC 
  ;

postDecrementExpression_lf_postfixExpression
  : DEC 
  ;

castExpression
  : LPAREN  (primitiveType | fm_primitiveType) RPAREN  (unaryExpression | fm_unaryExpression)
  | LPAREN  (referenceType | fm_referenceType) (additionalBound | fm_additionalBoundStar)* RPAREN  (unaryExpressionNotPlusMinus | fm_unaryExpressionNotPlusMinus)
  | LPAREN  (referenceType | fm_referenceType) (additionalBound | fm_additionalBoundStar)* RPAREN  (lambdaExpression | fm_lambdaExpression)
  ;

// LEXER

// §3.9 Keywords

ABSTRACT : 'abstract';
ASSERT : 'assert';
BOOLEAN : 'boolean';
BREAK : 'break';
BYTE : 'byte';
CASE : 'case';
CATCH : 'catch';
CHAR : 'char';
CLASS : 'class';
CONST : 'const';
CONTINUE : 'continue';
DEFAULT : 'default';
DO : 'do';
DOUBLE : 'double';
ELSE : 'else';
ENUM : 'enum';
EXTENDS : 'extends';
FINAL : 'final';
FINALLY : 'finally';
FLOAT : 'float';
FOR : 'for';
IF : 'if';
GOTO : 'goto';
IMPLEMENTS : 'implements';
IMPORT : 'import';
INSTANCEOF : 'instanceof';
INT : 'int';
INTERFACE : 'interface';
LONG : 'long';
NATIVE : 'native';
NEW : 'new';
PACKAGE : 'package';
PRIVATE : 'private';
PROTECTED : 'protected';
PUBLIC : 'public';
RETURN : 'return';
SHORT : 'short';
STATIC : 'static';
STRICTFP : 'strictfp';
SUPER : 'super';
SWITCH : 'switch';
SYNCHRONIZED : 'synchronized';
THIS : 'this';
THROW : 'throw';
THROWS : 'throws';
TRANSIENT : 'transient';
TRY : 'try';
VOID : 'void';
VOLATILE : 'volatile';
WHILE : 'while';

// §3.10.1 Integer Literals

IntegerLiteral
  : DecimalIntegerLiteral
  | HexIntegerLiteral
  | OctalIntegerLiteral
  | BinaryIntegerLiteral
  ;

fragment
DecimalIntegerLiteral
  : DecimalNumeral IntegerTypeSuffix?
  ;

fragment
HexIntegerLiteral
  : HexNumeral IntegerTypeSuffix?
  ;

fragment
OctalIntegerLiteral
  : OctalNumeral IntegerTypeSuffix?
  ;

fragment
BinaryIntegerLiteral
  : BinaryNumeral IntegerTypeSuffix?
  ;

fragment
IntegerTypeSuffix
  : [lL]
  ;

fragment
DecimalNumeral
  : '0'
  | NonZeroDigit (Digits? | Underscores Digits)
  ;

fragment
Digits
  : Digit (DigitsAndUnderscores? Digit)?
  ;

fragment
Digit
  : '0'
  | NonZeroDigit
  ;

fragment
NonZeroDigit
  : [1-9]
  ;

fragment
DigitsAndUnderscores
  : DigitOrUnderscore+
  ;

fragment
DigitOrUnderscore
  : Digit
  | '_'
  ;

fragment
Underscores
  : '_'+
  ;

fragment
HexNumeral
  : '0' [xX] HexDigits
  ;

fragment
HexDigits
  : HexDigit (HexDigitsAndUnderscores? HexDigit)?
  ;

fragment
HexDigit
  : [0-9a-fA-F]
  ;

fragment
HexDigitsAndUnderscores
  : HexDigitOrUnderscore+
  ;

fragment
HexDigitOrUnderscore
  : HexDigit
  | '_'
  ;

fragment
OctalNumeral
  : '0' Underscores? OctalDigits
  ;

fragment
OctalDigits
  : OctalDigit (OctalDigitsAndUnderscores? OctalDigit)?
  ;

fragment
OctalDigit
  : [0-7]
  ;

fragment
OctalDigitsAndUnderscores
  : OctalDigitOrUnderscore+
  ;

fragment
OctalDigitOrUnderscore
  : OctalDigit
  | '_'
  ;

fragment
BinaryNumeral
  : '0' [bB] BinaryDigits
  ;

fragment
BinaryDigits
  : BinaryDigit (BinaryDigitsAndUnderscores? BinaryDigit)?
  ;

fragment
BinaryDigit
  : [01]
  ;

fragment
BinaryDigitsAndUnderscores
  : BinaryDigitOrUnderscore+
  ;

fragment
BinaryDigitOrUnderscore
  : BinaryDigit
  | '_'
  ;

// §3.10.2 Floating-Point Literals

FloatingPointLiteral
  : DecimalFloatingPointLiteral
  | HexadecimalFloatingPointLiteral
  ;

fragment
DecimalFloatingPointLiteral
  : Digits '.' Digits? ExponentPart? FloatTypeSuffix?
  | '.' Digits ExponentPart? FloatTypeSuffix?
  | Digits ExponentPart FloatTypeSuffix?
  | Digits FloatTypeSuffix
  ;

fragment
ExponentPart
  : ExponentIndicator SignedInteger
  ;

fragment
ExponentIndicator
  : [eE]
  ;

fragment
SignedInteger
  : Sign? Digits
  ;

fragment
Sign
  : [+-]
  ;

fragment
FloatTypeSuffix
  : [fFdD]
  ;

fragment
HexadecimalFloatingPointLiteral
  : HexSignificand BinaryExponent FloatTypeSuffix?
  ;

fragment
HexSignificand
  : HexNumeral '.'?
  | '0' [xX] HexDigits? '.' HexDigits
  ;

fragment
BinaryExponent
  : BinaryExponentIndicator SignedInteger
  ;

fragment
BinaryExponentIndicator
  : [pP]
  ;

// §3.10.3 Boolean Literals

BooleanLiteral
  : 'true'
  | 'false'
  ;

// §3.10.4 Character Literals

CharacterLiteral
  : '\'' SingleCharacter '\''
  | '\'' EscapeSequence '\''
  ;

fragment
SingleCharacter
  : ~['\\]
  ;

// §3.10.5 String Literals

StringLiteral
  : '"' StringCharacters? '"'
  ;

fragment
StringCharacters
  : StringCharacter+
  ;

fragment
StringCharacter
  : ~["\\]
  | EscapeSequence
  ;

// §3.10.6 Escape Sequences for Character and String Literals

fragment
EscapeSequence
  : '\\' [btnfr"'\\]
  | OctalEscape
    |   UnicodeEscape // This is not in the spec but prevents having to preprocess the input
  ;

fragment
OctalEscape
  : '\\' OctalDigit
  | '\\' OctalDigit OctalDigit
  | '\\' ZeroToThree OctalDigit OctalDigit
  ;

fragment
ZeroToThree
  : [0-3]
  ;

// This is not in the spec but prevents having to preprocess the input
fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

// §3.10.7 The Null Literal

NullLiteral
  : 'null'
  ;

// §3.11 Separators

LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
LBRACK : '[';
RBRACK : ']';
SEMI : ';';
COMMA : ',';
DOT : '.';

// §3.12 Operators

ASSIGN : '=';
GT : '>';
LT : '<';
BANG : '!';
TILDE : '~';
QUESTION : '?';
COLON : ':';
EQUAL : '==';
LE : '<=';
GE : '>=';
NOTEQUAL : '!=';
AND : '&&';
OR : '||';
INC : '++';
DEC : '--';
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
BITAND : '&';
BITOR : '|';
CARET : '^';
MOD : '%';
ARROW : '->';
COLONCOLON : '::';

ADD_ASSIGN : '+=';
SUB_ASSIGN : '-=';
MUL_ASSIGN : '*=';
DIV_ASSIGN : '/=';
AND_ASSIGN : '&=';
OR_ASSIGN : '|=';
XOR_ASSIGN : '^=';
MOD_ASSIGN : '%=';
LSHIFT_ASSIGN : '<<=';
RSHIFT_ASSIGN : '>>=';
URSHIFT_ASSIGN : '>>>=';

// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
  : JavaLetter JavaLetterOrDigit*
  ;
fm_Identifier: FM_PLACEHOLDER | FM_IF (fm_Identifier | Identifier) (FM_ELSE_IF (fm_Identifier | Identifier))* FM_ELSE (fm_Identifier | Identifier) FM_IF_CLOSE;
fm_IdentifierOpt: FM_PLACEHOLDER | FM_IF (fm_IdentifierOpt | Identifier) (FM_ELSE_IF (fm_IdentifierOpt | Identifier))* (FM_ELSE (fm_IdentifierOpt | Identifier))? FM_IF_CLOSE;

fragment
JavaLetter
  : [a-zA-Z$_] // these are the "java letters" below 0xFF
  | // covers all characters above 0xFF which are not a surrogate
    ~[\u0000-\u00FF\uD800-\uDBFF]
    {Character.isJavaIdentifierStart(_input.LA(-1))}?
  | // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    [\uD800-\uDBFF] [\uDC00-\uDFFF]
    {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
  ;

fragment
JavaLetterOrDigit
  : [a-zA-Z0-9$_] // these are the "java letters or digits" below 0xFF
  | // covers all characters above 0xFF which are not a surrogate
    ~[\u0000-\u00FF\uD800-\uDBFF]
    {Character.isJavaIdentifierPart(_input.LA(-1))}?
  | // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    [\uD800-\uDBFF] [\uDC00-\uDFFF]
    {Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
  ;

//
// Additional symbols not defined in the lexical specification
//

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;

FM_PLACEHOLDER: '${' ~'}'+? '}';
FM_IF: '<#if' ~'>'+? '>';
FM_IF_CLOSE: '</#if>';
FM_ELSE_IF: '<#elseif' ~'>'+? '>';
FM_ELSE: '<#else>';
FM_LIST: '<#list' .+? 'as' ~'>'+? '>';
FM_LIST_CLOSE: '</#list>';