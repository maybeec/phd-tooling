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
grammar Java8Template;

/*
 * Productions from §3 (Lexical Structure)
 */

literal
  : ((fm_IntegerLiteralPlaceHolder | IntegerLiteral) | fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne)
  | ((fm_FloatingPointLiteralPlaceHolder | FloatingPointLiteral) | fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne)
  | ((fm_BooleanLiteralPlaceHolder | BooleanLiteral) | fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne)
  | ((fm_CharacterLiteralPlaceHolder | CharacterLiteral) | fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne)
  | ((fm_StringLiteralPlaceHolder | StringLiteral) | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne)
  | ((fm_NullLiteralPlaceHolder | NullLiteral) | fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne)
  ;

/*
 * Productions from §4 (Types, Values, and Variables)
 */

type
  : ((primitiveType) | fm_LParenprimitiveTypeRParenOne)
  | ((referenceType) | fm_LParenreferenceTypeRParenOne)
  ;

primitiveType
  : ((annotation) | fm_LParenannotationRParenStar)* ((numericType) | fm_LParennumericTypeRParenOne)
  | ((annotation) | fm_LParenannotationRParenStar)* ((fm_BOOLEANPlaceHolder | BOOLEAN ) | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne)
  ;

numericType
  : ((integralType) | fm_LParenintegralTypeRParenOne)
  | ((floatingPointType) | fm_LParenfloatingPointTypeRParenOne)
  ;

integralType
  : ((fm_BYTEPlaceHolder | BYTE ) | fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne)
  | ((fm_SHORTPlaceHolder | SHORT ) | fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne)
  | ((fm_INTPlaceHolder | INT ) | fm_LParenfm_INTPlaceHolderOrINTRParenOne)
  | ((fm_LONGPlaceHolder | LONG ) | fm_LParenfm_LONGPlaceHolderOrLONGRParenOne)
  | ((fm_CHARPlaceHolder | CHAR ) | fm_LParenfm_CHARPlaceHolderOrCHARRParenOne)
  ;

floatingPointType
  : ((fm_FLOATPlaceHolder | FLOAT ) | fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne)
  | ((fm_DOUBLEPlaceHolder | DOUBLE ) | fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne)
  ;

referenceType
  : ((classOrInterfaceType) | fm_LParenclassOrInterfaceTypeRParenOne)
  | ((typeVariable) | fm_LParentypeVariableRParenOne)
  | ((arrayType) | fm_LParenarrayTypeRParenOne)
  ;

classOrInterfaceType
  : (( ((classType_lfno_classOrInterfaceType) | fm_LParenclassType_lfno_classOrInterfaceTypeRParenOne)
    | ((interfaceType_lfno_classOrInterfaceType) | fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne)
    ) | fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne)
    (( ((classType_lf_classOrInterfaceType) | fm_LParenclassType_lf_classOrInterfaceTypeRParenOne)
    | ((interfaceType_lf_classOrInterfaceType) | fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne)
    ) | fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar)*
  ;

classType
  : ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)?
  | ((classOrInterfaceType) | fm_LParenclassOrInterfaceTypeRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)?
  ;

classType_lf_classOrInterfaceType
  : ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)?
  ;

classType_lfno_classOrInterfaceType
  : ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)?
  ;

interfaceType
  : ((classType) | fm_LParenclassTypeRParenOne)
  ;

interfaceType_lf_classOrInterfaceType
  : ((classType_lf_classOrInterfaceType) | fm_LParenclassType_lf_classOrInterfaceTypeRParenOne)
  ;

interfaceType_lfno_classOrInterfaceType
  : ((classType_lfno_classOrInterfaceType) | fm_LParenclassType_lfno_classOrInterfaceTypeRParenOne)
  ;

typeVariable
  : ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

arrayType
  : ((primitiveType) | fm_LParenprimitiveTypeRParenOne) ((dims) | fm_LParendimsRParenOne)
  | ((classOrInterfaceType) | fm_LParenclassOrInterfaceTypeRParenOne) ((dims) | fm_LParendimsRParenOne)
  | ((typeVariable) | fm_LParentypeVariableRParenOne) ((dims) | fm_LParendimsRParenOne)
  ;

dims
  : ((annotation) | fm_LParenannotationRParenStar)* ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne) ((((annotation) | fm_LParenannotationRParenStar)* ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)*
  ;

typeParameter
  : ((typeParameterModifier) | fm_LParentypeParameterModifierRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeBound) | fm_LParentypeBoundRParenQuestion)?
  ;

typeParameterModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  ;

typeBound
  : ((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ((typeVariable) | fm_LParentypeVariableRParenOne)
  | ((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ((classOrInterfaceType) | fm_LParenclassOrInterfaceTypeRParenOne) ((additionalBound) | fm_LParenadditionalBoundRParenStar)*
  ;

additionalBound
  : ((fm_BITANDPlaceHolder | BITAND ) | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne) ((interfaceType) | fm_LPareninterfaceTypeRParenOne)
  ;

typeArguments
  : ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((typeArgumentList) | fm_LParentypeArgumentListRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)
  ;

typeArgumentList
  : ((typeArgument) | fm_LParentypeArgumentRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((typeArgument) | fm_LParentypeArgumentRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar)*
  ;

typeArgument
  : ((referenceType) | fm_LParenreferenceTypeRParenOne)
  | ((wildcard) | fm_LParenwildcardRParenOne)
  ;

wildcard
  : ((annotation) | fm_LParenannotationRParenStar)* ((fm_QUESTIONPlaceHolder | QUESTION ) | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne) ((wildcardBounds) | fm_LParenwildcardBoundsRParenQuestion)?
  ;

wildcardBounds
  : ((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ((referenceType) | fm_LParenreferenceTypeRParenOne)
  | ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((referenceType) | fm_LParenreferenceTypeRParenOne)
  ;

/*
 * Productions from §6 (Names)
 */

packageName
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | packageName ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

typeName
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((packageOrTypeName) | fm_LParenpackageOrTypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

packageOrTypeName
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | packageOrTypeName ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

expressionName
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((ambiguousName) | fm_LParenambiguousNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

methodName
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

ambiguousName
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ambiguousName ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

/*
 * Productions from §7 (Packages)
 */

compilationUnit
  : ((packageDeclaration) | fm_LParenpackageDeclarationRParenQuestion)? ((importDeclaration) | fm_LParenimportDeclarationRParenStar)* ((typeDeclaration) | fm_LParentypeDeclarationRParenStar)* EOF
  ;

packageDeclaration
  : ((packageModifier) | fm_LParenpackageModifierRParenStar)* ((fm_PACKAGEPlaceHolder | PACKAGE ) | fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)) | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar)* ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

packageModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  ;

importDeclaration
  : ((singleTypeImportDeclaration) | fm_LParensingleTypeImportDeclarationRParenOne)
  | ((typeImportOnDemandDeclaration) | fm_LParentypeImportOnDemandDeclarationRParenOne)
  | ((singleStaticImportDeclaration) | fm_LParensingleStaticImportDeclarationRParenOne)
  | ((staticImportOnDemandDeclaration) | fm_LParenstaticImportOnDemandDeclarationRParenOne)
  ;

singleTypeImportDeclaration
  : ((fm_IMPORTPlaceHolder | IMPORT ) | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

typeImportOnDemandDeclaration
  : ((fm_IMPORTPlaceHolder | IMPORT ) | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne) ((packageOrTypeName) | fm_LParenpackageOrTypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_MULPlaceHolder | MUL ) | fm_LParenfm_MULPlaceHolderOrMULRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

singleStaticImportDeclaration
  : ((fm_IMPORTPlaceHolder | IMPORT ) | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne) ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

staticImportOnDemandDeclaration
  : ((fm_IMPORTPlaceHolder | IMPORT ) | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne) ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_MULPlaceHolder | MUL ) | fm_LParenfm_MULPlaceHolderOrMULRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

typeDeclaration
  : ((classDeclaration) | fm_LParenclassDeclarationRParenOne)
  | ((interfaceDeclaration) | fm_LPareninterfaceDeclarationRParenOne)
  | ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

/*
 * Productions from §8 (Classes)
 */

classDeclaration
  : ((normalClassDeclaration) | fm_LParennormalClassDeclarationRParenOne)
  | ((enumDeclaration) | fm_LParenenumDeclarationRParenOne)
  ;

normalClassDeclaration
  : ((classModifier) | fm_LParenclassModifierRParenStar)* ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeParameters) | fm_LParentypeParametersRParenQuestion)? ((superclass) | fm_LParensuperclassRParenQuestion)? ((superinterfaces) | fm_LParensuperinterfacesRParenQuestion)? ((classBody) | fm_LParenclassBodyRParenOne)
  ;

classModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)
  | ((fm_PROTECTEDPlaceHolder | PROTECTED ) | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne)
  | ((fm_PRIVATEPlaceHolder | PRIVATE ) | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne)
  | ((fm_ABSTRACTPlaceHolder | ABSTRACT ) | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne)
  | ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)
  | ((fm_FINALPlaceHolder | FINAL ) | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)
  | ((fm_STRICTFPPlaceHolder | STRICTFP ) | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne)
  ;

typeParameters
  : ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((typeParameterList) | fm_LParentypeParameterListRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)
  ;

typeParameterList
  : ((typeParameter) | fm_LParentypeParameterRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((typeParameter) | fm_LParentypeParameterRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar)*
  ;

superclass
  : ((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ((classType) | fm_LParenclassTypeRParenOne)
  ;

superinterfaces
  : ((fm_IMPLEMENTSPlaceHolder | IMPLEMENTS ) | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne) ((interfaceTypeList) | fm_LPareninterfaceTypeListRParenOne)
  ;

interfaceTypeList
  : ((interfaceType) | fm_LPareninterfaceTypeRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((interfaceType) | fm_LPareninterfaceTypeRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar)*
  ;

classBody
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((classBodyDeclaration) | fm_LParenclassBodyDeclarationRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

classBodyDeclaration
  : ((classMemberDeclaration) | fm_LParenclassMemberDeclarationRParenOne)
  | ((instanceInitializer) | fm_LPareninstanceInitializerRParenOne)
  | ((staticInitializer) | fm_LParenstaticInitializerRParenOne)
  | ((constructorDeclaration) | fm_LParenconstructorDeclarationRParenOne)
  ;

classMemberDeclaration
  : ((fieldDeclaration) | fm_LParenfieldDeclarationRParenOne)
  | ((methodDeclaration) | fm_LParenmethodDeclarationRParenOne)
  | ((classDeclaration) | fm_LParenclassDeclarationRParenOne)
  | ((interfaceDeclaration) | fm_LPareninterfaceDeclarationRParenOne)
  | ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

fieldDeclaration
  : ((fieldModifier) | fm_LParenfieldModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((variableDeclaratorList) | fm_LParenvariableDeclaratorListRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

fieldModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)
  | ((fm_PROTECTEDPlaceHolder | PROTECTED ) | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne)
  | ((fm_PRIVATEPlaceHolder | PRIVATE ) | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne)
  | ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)
  | ((fm_FINALPlaceHolder | FINAL ) | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)
  | ((fm_TRANSIENTPlaceHolder | TRANSIENT ) | fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne)
  | ((fm_VOLATILEPlaceHolder | VOLATILE ) | fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne)
  ;

variableDeclaratorList
  : ((variableDeclarator) | fm_LParenvariableDeclaratorRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((variableDeclarator) | fm_LParenvariableDeclaratorRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar)*
  ;

variableDeclarator
  : ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne) ((((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) ((variableInitializer) | fm_LParenvariableInitializerRParenOne)) | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion)?
  ;

variableDeclaratorId
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((dims) | fm_LParendimsRParenQuestion)?
  ;

variableInitializer
  : ((expression) | fm_LParenexpressionRParenOne)
  | ((arrayInitializer) | fm_LParenarrayInitializerRParenOne)
  ;

unannType
  : ((unannPrimitiveType) | fm_LParenunannPrimitiveTypeRParenOne)
  | ((unannReferenceType) | fm_LParenunannReferenceTypeRParenOne)
  ;

unannPrimitiveType
  : ((numericType) | fm_LParennumericTypeRParenOne)
  | ((fm_BOOLEANPlaceHolder | BOOLEAN ) | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne)
  ;

unannReferenceType
  : ((unannClassOrInterfaceType) | fm_LParenunannClassOrInterfaceTypeRParenOne)
  | ((unannTypeVariable) | fm_LParenunannTypeVariableRParenOne)
  | ((unannArrayType) | fm_LParenunannArrayTypeRParenOne)
  ;

unannClassOrInterfaceType
  : (( ((unannClassType_lfno_unannClassOrInterfaceType) | fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne)
    | ((unannInterfaceType_lfno_unannClassOrInterfaceType) | fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne)
    ) | fm_newRulexXXx0)
    (( ((unannClassType_lf_unannClassOrInterfaceType) | fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne)
    | ((unannInterfaceType_lf_unannClassOrInterfaceType) | fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne)
    ) | fm_newRulexXXx1)*
  ;

unannClassType
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)?
  | ((unannClassOrInterfaceType) | fm_LParenunannClassOrInterfaceTypeRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)?
  ;

unannClassType_lf_unannClassOrInterfaceType
  : ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)?
  ;

unannClassType_lfno_unannClassOrInterfaceType
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)?
  ;

unannInterfaceType
  : ((unannClassType) | fm_LParenunannClassTypeRParenOne)
  ;

unannInterfaceType_lf_unannClassOrInterfaceType
  : ((unannClassType_lf_unannClassOrInterfaceType) | fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne)
  ;

unannInterfaceType_lfno_unannClassOrInterfaceType
  : ((unannClassType_lfno_unannClassOrInterfaceType) | fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne)
  ;

unannTypeVariable
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

unannArrayType
  : ((unannPrimitiveType) | fm_LParenunannPrimitiveTypeRParenOne) ((dims) | fm_LParendimsRParenOne)
  | ((unannClassOrInterfaceType) | fm_LParenunannClassOrInterfaceTypeRParenOne) ((dims) | fm_LParendimsRParenOne)
  | ((unannTypeVariable) | fm_LParenunannTypeVariableRParenOne) ((dims) | fm_LParendimsRParenOne)
  ;

methodDeclaration
  : ((methodModifier) | fm_LParenmethodModifierRParenStar)* ((methodHeader) | fm_LParenmethodHeaderRParenOne) ((methodBody) | fm_LParenmethodBodyRParenOne)
  ;

methodModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)
  | ((fm_PROTECTEDPlaceHolder | PROTECTED ) | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne)
  | ((fm_PRIVATEPlaceHolder | PRIVATE ) | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne)
  | ((fm_ABSTRACTPlaceHolder | ABSTRACT ) | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne)
  | ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)
  | ((fm_FINALPlaceHolder | FINAL ) | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)
  | ((fm_SYNCHRONIZEDPlaceHolder | SYNCHRONIZED ) | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne)
  | ((fm_NATIVEPlaceHolder | NATIVE ) | fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne)
  | ((fm_STRICTFPPlaceHolder | STRICTFP ) | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne)
  ;

methodHeader
  : ((result) | fm_LParenresultRParenOne) ((methodDeclarator) | fm_LParenmethodDeclaratorRParenOne) ((throws_) | fm_LParenthrows_RParenQuestion)?
  | ((typeParameters) | fm_LParentypeParametersRParenOne) ((annotation) | fm_LParenannotationRParenStar)* ((result) | fm_LParenresultRParenOne) ((methodDeclarator) | fm_LParenmethodDeclaratorRParenOne) ((throws_) | fm_LParenthrows_RParenQuestion)?
  ;

result
  : ((unannType) | fm_LParenunannTypeRParenOne)
  | ((fm_VOIDPlaceHolder | VOID ) | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne)
  ;

methodDeclarator
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((formalParameterList) | fm_LParenformalParameterListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((dims) | fm_LParendimsRParenQuestion)?
  ;

formalParameterList
  : ((formalParameters) | fm_LParenformalParametersRParenOne) ((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((lastFormalParameter) | fm_LParenlastFormalParameterRParenOne)
  | ((lastFormalParameter) | fm_LParenlastFormalParameterRParenOne)
  ;

formalParameters
  : ((formalParameter) | fm_LParenformalParameterRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((formalParameter) | fm_LParenformalParameterRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar)*
  | ((receiverParameter) | fm_LParenreceiverParameterRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((formalParameter) | fm_LParenformalParameterRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar)*
  ;

formalParameter
  : ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne)
  ;

variableModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_FINALPlaceHolder | FINAL ) | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)
  ;

lastFormalParameter
  : ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((annotation) | fm_LParenannotationRParenStar)* ((fm_ELLIPSISPlaceHolder | ELLIPSIS ) | fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne)
  | ((formalParameter) | fm_LParenformalParameterRParenOne)
  ;

receiverParameter
  : ((annotation) | fm_LParenannotationRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne)) | fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion)? ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  ;

throws_
  : ((fm_THROWSPlaceHolder | THROWS ) | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne) ((exceptionTypeList) | fm_LParenexceptionTypeListRParenOne)
  ;

exceptionTypeList
  : ((exceptionType) | fm_LParenexceptionTypeRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((exceptionType) | fm_LParenexceptionTypeRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar)*
  ;

exceptionType
  : ((classType) | fm_LParenclassTypeRParenOne)
  | ((typeVariable) | fm_LParentypeVariableRParenOne)
  ;

methodBody
  : ((block) | fm_LParenblockRParenOne)
  | ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

instanceInitializer
  : ((block) | fm_LParenblockRParenOne)
  ;

staticInitializer
  : ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne) ((block) | fm_LParenblockRParenOne)
  ;

constructorDeclaration
  : ((constructorModifier) | fm_LParenconstructorModifierRParenStar)* ((constructorDeclarator) | fm_LParenconstructorDeclaratorRParenOne) ((throws_) | fm_LParenthrows_RParenQuestion)? ((constructorBody) | fm_LParenconstructorBodyRParenOne)
  ;

constructorModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)
  | ((fm_PROTECTEDPlaceHolder | PROTECTED ) | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne)
  | ((fm_PRIVATEPlaceHolder | PRIVATE ) | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne)
  ;

constructorDeclarator
  : ((typeParameters) | fm_LParentypeParametersRParenQuestion)? ((simpleTypeName) | fm_LParensimpleTypeNameRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((formalParameterList) | fm_LParenformalParameterListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  ;

simpleTypeName
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

constructorBody
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((explicitConstructorInvocation) | fm_LParenexplicitConstructorInvocationRParenQuestion)? ((blockStatements) | fm_LParenblockStatementsRParenQuestion)? ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

explicitConstructorInvocation
  : ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  | ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  | ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  | ((primary) | fm_LParenprimaryRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

enumDeclaration
  : ((classModifier) | fm_LParenclassModifierRParenStar)* ((fm_ENUMPlaceHolder | ENUM ) | fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((superinterfaces) | fm_LParensuperinterfacesRParenQuestion)? ((enumBody) | fm_LParenenumBodyRParenOne)
  ;

enumBody
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((enumConstantList) | fm_LParenenumConstantListRParenQuestion)? ((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion)? ((enumBodyDeclarations) | fm_LParenenumBodyDeclarationsRParenQuestion)? ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

enumConstantList
  : ((enumConstant) | fm_LParenenumConstantRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((enumConstant) | fm_LParenenumConstantRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar)*
  ;

enumConstant
  : ((enumConstantModifier) | fm_LParenenumConstantModifierRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)) | fm_newRulexXXx2)? ((classBody) | fm_LParenclassBodyRParenQuestion)?
  ;

enumConstantModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  ;

enumBodyDeclarations
  : ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((classBodyDeclaration) | fm_LParenclassBodyDeclarationRParenStar)*
  ;

/*
 * Productions from §9 (Interfaces)
 */

interfaceDeclaration
  : ((normalInterfaceDeclaration) | fm_LParennormalInterfaceDeclarationRParenOne)
  | ((annotationTypeDeclaration) | fm_LParenannotationTypeDeclarationRParenOne)
  ;

normalInterfaceDeclaration
  : ((interfaceModifier) | fm_LPareninterfaceModifierRParenStar)* ((fm_INTERFACEPlaceHolder | INTERFACE ) | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeParameters) | fm_LParentypeParametersRParenQuestion)? ((extendsInterfaces) | fm_LParenextendsInterfacesRParenQuestion)? ((interfaceBody) | fm_LPareninterfaceBodyRParenOne)
  ;

interfaceModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)
  | ((fm_PROTECTEDPlaceHolder | PROTECTED ) | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne)
  | ((fm_PRIVATEPlaceHolder | PRIVATE ) | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne)
  | ((fm_ABSTRACTPlaceHolder | ABSTRACT ) | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne)
  | ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)
  | ((fm_STRICTFPPlaceHolder | STRICTFP ) | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne)
  ;

extendsInterfaces
  : ((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ((interfaceTypeList) | fm_LPareninterfaceTypeListRParenOne)
  ;

interfaceBody
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((interfaceMemberDeclaration) | fm_LPareninterfaceMemberDeclarationRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

interfaceMemberDeclaration
  : ((constantDeclaration) | fm_LParenconstantDeclarationRParenOne)
  | ((interfaceMethodDeclaration) | fm_LPareninterfaceMethodDeclarationRParenOne)
  | ((classDeclaration) | fm_LParenclassDeclarationRParenOne)
  | ((interfaceDeclaration) | fm_LPareninterfaceDeclarationRParenOne)
  | ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

constantDeclaration
  : ((constantModifier) | fm_LParenconstantModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((variableDeclaratorList) | fm_LParenvariableDeclaratorListRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

constantModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)
  | ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)
  | ((fm_FINALPlaceHolder | FINAL ) | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)
  ;

interfaceMethodDeclaration
  : ((interfaceMethodModifier) | fm_LPareninterfaceMethodModifierRParenStar)* ((methodHeader) | fm_LParenmethodHeaderRParenOne) ((methodBody) | fm_LParenmethodBodyRParenOne)
  ;

interfaceMethodModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)
  | ((fm_ABSTRACTPlaceHolder | ABSTRACT ) | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne)
  | ((fm_DEFAULTPlaceHolder | DEFAULT ) | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne)
  | ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)
  | ((fm_STRICTFPPlaceHolder | STRICTFP ) | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne)
  ;

annotationTypeDeclaration
  : ((interfaceModifier) | fm_LPareninterfaceModifierRParenStar)* ((fm_ATPlaceHolder | AT ) | fm_LParenfm_ATPlaceHolderOrATRParenOne) ((fm_INTERFACEPlaceHolder | INTERFACE ) | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((annotationTypeBody) | fm_LParenannotationTypeBodyRParenOne)
  ;

annotationTypeBody
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((annotationTypeMemberDeclaration) | fm_LParenannotationTypeMemberDeclarationRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

annotationTypeMemberDeclaration
  : ((annotationTypeElementDeclaration) | fm_LParenannotationTypeElementDeclarationRParenOne)
  | ((constantDeclaration) | fm_LParenconstantDeclarationRParenOne)
  | ((classDeclaration) | fm_LParenclassDeclarationRParenOne)
  | ((interfaceDeclaration) | fm_LPareninterfaceDeclarationRParenOne)
  | ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

annotationTypeElementDeclaration
  : ((annotationTypeElementModifier) | fm_LParenannotationTypeElementModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((dims) | fm_LParendimsRParenQuestion)? ((defaultValue) | fm_LParendefaultValueRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

annotationTypeElementModifier
  : ((annotation) | fm_LParenannotationRParenOne)
  | ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)
  | ((fm_ABSTRACTPlaceHolder | ABSTRACT ) | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne)
  ;

defaultValue
  : ((fm_DEFAULTPlaceHolder | DEFAULT ) | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne) ((elementValue) | fm_LParenelementValueRParenOne)
  ;

annotation
  : ((normalAnnotation) | fm_LParennormalAnnotationRParenOne)
  | ((markerAnnotation) | fm_LParenmarkerAnnotationRParenOne)
  | ((singleElementAnnotation) | fm_LParensingleElementAnnotationRParenOne)
  ;

normalAnnotation
  : ((fm_ATPlaceHolder | AT ) | fm_LParenfm_ATPlaceHolderOrATRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((elementValuePairList) | fm_LParenelementValuePairListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  ;

elementValuePairList
  : ((elementValuePair) | fm_LParenelementValuePairRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((elementValuePair) | fm_LParenelementValuePairRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar)*
  ;

elementValuePair
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) ((elementValue) | fm_LParenelementValueRParenOne)
  ;

elementValue
  : ((conditionalExpression) | fm_LParenconditionalExpressionRParenOne)
  | ((elementValueArrayInitializer) | fm_LParenelementValueArrayInitializerRParenOne)
  | ((annotation) | fm_LParenannotationRParenOne)
  ;

elementValueArrayInitializer
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((elementValueList) | fm_LParenelementValueListRParenQuestion)? ((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion)? ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

elementValueList
  : ((elementValue) | fm_LParenelementValueRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((elementValue) | fm_LParenelementValueRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar)*
  ;

markerAnnotation
  : ((fm_ATPlaceHolder | AT ) | fm_LParenfm_ATPlaceHolderOrATRParenOne) ((typeName) | fm_LParentypeNameRParenOne)
  ;

singleElementAnnotation
  : ((fm_ATPlaceHolder | AT ) | fm_LParenfm_ATPlaceHolderOrATRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((elementValue) | fm_LParenelementValueRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  ;

/*
 * Productions from §10 (Arrays)
 */

arrayInitializer
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((variableInitializerList) | fm_LParenvariableInitializerListRParenQuestion)? ((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion)? ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

variableInitializerList
  : ((variableInitializer) | fm_LParenvariableInitializerRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((variableInitializer) | fm_LParenvariableInitializerRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar)*
  ;

/*
 * Productions from §14 (Blocks and Statements)
 */

block
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((blockStatements) | fm_LParenblockStatementsRParenQuestion)? ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

blockStatements
  : ((blockStatement) | fm_LParenblockStatementRParenOne) ((blockStatement) | fm_LParenblockStatementRParenStar)*
  ;

blockStatement
  : ((localVariableDeclarationStatement) | fm_LParenlocalVariableDeclarationStatementRParenOne)
  | ((classDeclaration) | fm_LParenclassDeclarationRParenOne)
  | ((statement) | fm_LParenstatementRParenOne)
  ;

localVariableDeclarationStatement
  : ((localVariableDeclaration) | fm_LParenlocalVariableDeclarationRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

localVariableDeclaration
  : ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((variableDeclaratorList) | fm_LParenvariableDeclaratorListRParenOne)
  ;

statement
  : ((statementWithoutTrailingSubstatement) | fm_LParenstatementWithoutTrailingSubstatementRParenOne)
  | ((labeledStatement) | fm_LParenlabeledStatementRParenOne)
  | ((ifThenStatement) | fm_LParenifThenStatementRParenOne)
  | ((ifThenElseStatement) | fm_LParenifThenElseStatementRParenOne)
  | ((whileStatement) | fm_LParenwhileStatementRParenOne)
  | ((forStatement) | fm_LParenforStatementRParenOne)
  ;

statementNoShortIf
  : ((statementWithoutTrailingSubstatement) | fm_LParenstatementWithoutTrailingSubstatementRParenOne)
  | ((labeledStatementNoShortIf) | fm_LParenlabeledStatementNoShortIfRParenOne)
  | ((ifThenElseStatementNoShortIf) | fm_LParenifThenElseStatementNoShortIfRParenOne)
  | ((whileStatementNoShortIf) | fm_LParenwhileStatementNoShortIfRParenOne)
  | ((forStatementNoShortIf) | fm_LParenforStatementNoShortIfRParenOne)
  ;

statementWithoutTrailingSubstatement
  : ((block) | fm_LParenblockRParenOne)
  | ((emptyStatement) | fm_LParenemptyStatementRParenOne)
  | ((expressionStatement) | fm_LParenexpressionStatementRParenOne)
  | ((assertStatement) | fm_LParenassertStatementRParenOne)
  | ((switchStatement) | fm_LParenswitchStatementRParenOne)
  | ((doStatement) | fm_LParendoStatementRParenOne)
  | ((breakStatement) | fm_LParenbreakStatementRParenOne)
  | ((continueStatement) | fm_LParencontinueStatementRParenOne)
  | ((returnStatement) | fm_LParenreturnStatementRParenOne)
  | ((synchronizedStatement) | fm_LParensynchronizedStatementRParenOne)
  | ((throwStatement) | fm_LParenthrowStatementRParenOne)
  | ((tryStatement) | fm_LParentryStatementRParenOne)
  ;

emptyStatement
  : ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

labeledStatement
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) ((statement) | fm_LParenstatementRParenOne)
  ;

labeledStatementNoShortIf
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) ((statementNoShortIf) | fm_LParenstatementNoShortIfRParenOne)
  ;

expressionStatement
  : ((statementExpression) | fm_LParenstatementExpressionRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

statementExpression
  : ((assignment) | fm_LParenassignmentRParenOne)
  | ((preIncrementExpression) | fm_LParenpreIncrementExpressionRParenOne)
  | ((preDecrementExpression) | fm_LParenpreDecrementExpressionRParenOne)
  | ((postIncrementExpression) | fm_LParenpostIncrementExpressionRParenOne)
  | ((postDecrementExpression) | fm_LParenpostDecrementExpressionRParenOne)
  | ((methodInvocation) | fm_LParenmethodInvocationRParenOne)
  | ((classInstanceCreationExpression) | fm_LParenclassInstanceCreationExpressionRParenOne)
  ;

ifThenStatement
  : ((fm_IFPlaceHolder | IF ) | fm_LParenfm_IFPlaceHolderOrIFRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statement) | fm_LParenstatementRParenOne)
  ;

ifThenElseStatement
  : ((fm_IFPlaceHolder | IF ) | fm_LParenfm_IFPlaceHolderOrIFRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statementNoShortIf) | fm_LParenstatementNoShortIfRParenOne) ((fm_ELSEPlaceHolder | ELSE ) | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne) ((statement) | fm_LParenstatementRParenOne)
  ;

ifThenElseStatementNoShortIf
  : ((fm_IFPlaceHolder | IF ) | fm_LParenfm_IFPlaceHolderOrIFRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statementNoShortIf) | fm_LParenstatementNoShortIfRParenOne) ((fm_ELSEPlaceHolder | ELSE ) | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne) ((statementNoShortIf) | fm_LParenstatementNoShortIfRParenOne)
  ;

assertStatement
  : ((fm_ASSERTPlaceHolder | ASSERT ) | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  | ((fm_ASSERTPlaceHolder | ASSERT ) | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

switchStatement
  : ((fm_SWITCHPlaceHolder | SWITCH ) | fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((switchBlock) | fm_LParenswitchBlockRParenOne)
  ;

switchBlock
  : ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((switchBlockStatementGroup) | fm_LParenswitchBlockStatementGroupRParenStar)* ((switchLabel) | fm_LParenswitchLabelRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
  ;

switchBlockStatementGroup
  : ((switchLabels) | fm_LParenswitchLabelsRParenOne) ((blockStatements) | fm_LParenblockStatementsRParenOne)
  ;

switchLabels
  : ((switchLabel) | fm_LParenswitchLabelRParenOne) ((switchLabel) | fm_LParenswitchLabelRParenStar)*
  ;

switchLabel
  : ((fm_CASEPlaceHolder | CASE ) | fm_LParenfm_CASEPlaceHolderOrCASERParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne)
  | ((fm_CASEPlaceHolder | CASE ) | fm_LParenfm_CASEPlaceHolderOrCASERParenOne) ((enumConstantName) | fm_LParenenumConstantNameRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne)
  | ((fm_DEFAULTPlaceHolder | DEFAULT ) | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne)
  ;

enumConstantName
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

whileStatement
  : ((fm_WHILEPlaceHolder | WHILE ) | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statement) | fm_LParenstatementRParenOne)
  ;

whileStatementNoShortIf
  : ((fm_WHILEPlaceHolder | WHILE ) | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statementNoShortIf) | fm_LParenstatementNoShortIfRParenOne)
  ;

doStatement
  : ((fm_DOPlaceHolder | DO ) | fm_LParenfm_DOPlaceHolderOrDORParenOne) ((statement) | fm_LParenstatementRParenOne) ((fm_WHILEPlaceHolder | WHILE ) | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

forStatement
  : ((basicForStatement) | fm_LParenbasicForStatementRParenOne)
  | ((enhancedForStatement) | fm_LParenenhancedForStatementRParenOne)
  ;

forStatementNoShortIf
  : ((basicForStatementNoShortIf) | fm_LParenbasicForStatementNoShortIfRParenOne)
  | ((enhancedForStatementNoShortIf) | fm_LParenenhancedForStatementNoShortIfRParenOne)
  ;

basicForStatement
  : ((fm_FORPlaceHolder | FOR ) | fm_LParenfm_FORPlaceHolderOrFORRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((forInit) | fm_LParenforInitRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((forUpdate) | fm_LParenforUpdateRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statement) | fm_LParenstatementRParenOne)
  ;

basicForStatementNoShortIf
  : ((fm_FORPlaceHolder | FOR ) | fm_LParenfm_FORPlaceHolderOrFORRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((forInit) | fm_LParenforInitRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((forUpdate) | fm_LParenforUpdateRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statementNoShortIf) | fm_LParenstatementNoShortIfRParenOne)
  ;

forInit
  : ((statementExpressionList) | fm_LParenstatementExpressionListRParenOne)
  | ((localVariableDeclaration) | fm_LParenlocalVariableDeclarationRParenOne)
  ;

forUpdate
  : ((statementExpressionList) | fm_LParenstatementExpressionListRParenOne)
  ;

statementExpressionList
  : ((statementExpression) | fm_LParenstatementExpressionRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((statementExpression) | fm_LParenstatementExpressionRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar)*
  ;

enhancedForStatement
  : ((fm_FORPlaceHolder | FOR ) | fm_LParenfm_FORPlaceHolderOrFORRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statement) | fm_LParenstatementRParenOne)
  ;

enhancedForStatementNoShortIf
  : ((fm_FORPlaceHolder | FOR ) | fm_LParenfm_FORPlaceHolderOrFORRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((statementNoShortIf) | fm_LParenstatementNoShortIfRParenOne)
  ;

breakStatement
  : ((fm_BREAKPlaceHolder | BREAK ) | fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

continueStatement
  : ((fm_CONTINUEPlaceHolder | CONTINUE ) | fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

returnStatement
  : ((fm_RETURNPlaceHolder | RETURN ) | fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

throwStatement
  : ((fm_THROWPlaceHolder | THROW ) | fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
  ;

synchronizedStatement
  : ((fm_SYNCHRONIZEDPlaceHolder | SYNCHRONIZED ) | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((block) | fm_LParenblockRParenOne)
  ;

tryStatement
  : ((fm_TRYPlaceHolder | TRY ) | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne) ((block) | fm_LParenblockRParenOne) ((catches) | fm_LParencatchesRParenOne)
  | ((fm_TRYPlaceHolder | TRY ) | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne) ((block) | fm_LParenblockRParenOne) ((catches) | fm_LParencatchesRParenQuestion)? ((finally_) | fm_LParenfinally_RParenOne)
  | ((tryWithResourcesStatement) | fm_LParentryWithResourcesStatementRParenOne)
  ;

catches
  : ((catchClause) | fm_LParencatchClauseRParenOne) ((catchClause) | fm_LParencatchClauseRParenStar)*
  ;

catchClause
  : ((fm_CATCHPlaceHolder | CATCH ) | fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((catchFormalParameter) | fm_LParencatchFormalParameterRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((block) | fm_LParenblockRParenOne)
  ;

catchFormalParameter
  : ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((catchType) | fm_LParencatchTypeRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne)
  ;

catchType
  : ((unannClassType) | fm_LParenunannClassTypeRParenOne) ((((fm_BITORPlaceHolder | BITOR ) | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne) ((classType) | fm_LParenclassTypeRParenOne)) | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar)*
  ;

finally_
  : ((fm_FINALLYPlaceHolder | FINALLY ) | fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne) ((block) | fm_LParenblockRParenOne)
  ;

tryWithResourcesStatement
  : ((fm_TRYPlaceHolder | TRY ) | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne) ((resourceSpecification) | fm_LParenresourceSpecificationRParenOne) ((block) | fm_LParenblockRParenOne) ((catches) | fm_LParencatchesRParenQuestion)? ((finally_) | fm_LParenfinally_RParenQuestion)?
  ;

resourceSpecification
  : ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((resourceList) | fm_LParenresourceListRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  ;

resourceList
  : ((resource) | fm_LParenresourceRParenOne) ((((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((resource) | fm_LParenresourceRParenOne)) | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar)*
  ;

resource
  : ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((unannType) | fm_LParenunannTypeRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne) ((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) ((expression) | fm_LParenexpressionRParenOne)
  ;

/*
 * Productions from §15 (Expressions)
 */

primary
  : (( ((primaryNoNewArray_lfno_primary) | fm_LParenprimaryNoNewArray_lfno_primaryRParenOne)
    | ((arrayCreationExpression) | fm_LParenarrayCreationExpressionRParenOne)
    ) | fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne)
    (( ((primaryNoNewArray_lf_primary) | fm_LParenprimaryNoNewArray_lf_primaryRParenOne)
    ) | fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar)*
  ;

primaryNoNewArray
  : ((literal) | fm_LParenliteralRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((fm_VOIDPlaceHolder | VOID ) | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  | ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((classInstanceCreationExpression) | fm_LParenclassInstanceCreationExpressionRParenOne)
  | ((fieldAccess) | fm_LParenfieldAccessRParenOne)
  | ((arrayAccess) | fm_LParenarrayAccessRParenOne)
  | ((methodInvocation) | fm_LParenmethodInvocationRParenOne)
  | ((methodReference) | fm_LParenmethodReferenceRParenOne)
  ;

primaryNoNewArray_lf_arrayAccess
  :
  ;

primaryNoNewArray_lfno_arrayAccess
  : ((literal) | fm_LParenliteralRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((fm_VOIDPlaceHolder | VOID ) | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  | ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((classInstanceCreationExpression) | fm_LParenclassInstanceCreationExpressionRParenOne)
  | ((fieldAccess) | fm_LParenfieldAccessRParenOne)
  | ((methodInvocation) | fm_LParenmethodInvocationRParenOne)
  | ((methodReference) | fm_LParenmethodReferenceRParenOne)
  ;

primaryNoNewArray_lf_primary
  : ((classInstanceCreationExpression_lf_primary) | fm_LParenclassInstanceCreationExpression_lf_primaryRParenOne)
  | ((fieldAccess_lf_primary) | fm_LParenfieldAccess_lf_primaryRParenOne)
  | ((arrayAccess_lf_primary) | fm_LParenarrayAccess_lf_primaryRParenOne)
  | ((methodInvocation_lf_primary) | fm_LParenmethodInvocation_lf_primaryRParenOne)
  | ((methodReference_lf_primary) | fm_LParenmethodReference_lf_primaryRParenOne)
  ;

primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary
  :
  ;

primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary
  : ((classInstanceCreationExpression_lf_primary) | fm_LParenclassInstanceCreationExpression_lf_primaryRParenOne)
  | ((fieldAccess_lf_primary) | fm_LParenfieldAccess_lf_primaryRParenOne)
  | ((methodInvocation_lf_primary) | fm_LParenmethodInvocation_lf_primaryRParenOne)
  | ((methodReference_lf_primary) | fm_LParenmethodReference_lf_primaryRParenOne)
  ;

primaryNoNewArray_lfno_primary
  : ((literal) | fm_LParenliteralRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((unannPrimitiveType) | fm_LParenunannPrimitiveTypeRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((fm_VOIDPlaceHolder | VOID ) | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  | ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((classInstanceCreationExpression_lfno_primary) | fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne)
  | ((fieldAccess_lfno_primary) | fm_LParenfieldAccess_lfno_primaryRParenOne)
  | ((arrayAccess_lfno_primary) | fm_LParenarrayAccess_lfno_primaryRParenOne)
  | ((methodInvocation_lfno_primary) | fm_LParenmethodInvocation_lfno_primaryRParenOne)
  | ((methodReference_lfno_primary) | fm_LParenmethodReference_lfno_primaryRParenOne)
  ;

primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary
  :
  ;

primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary
  : ((literal) | fm_LParenliteralRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((unannPrimitiveType) | fm_LParenunannPrimitiveTypeRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((fm_VOIDPlaceHolder | VOID ) | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
  | ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
  | ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((classInstanceCreationExpression_lfno_primary) | fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne)
  | ((fieldAccess_lfno_primary) | fm_LParenfieldAccess_lfno_primaryRParenOne)
  | ((methodInvocation_lfno_primary) | fm_LParenmethodInvocation_lfno_primaryRParenOne)
  | ((methodReference_lfno_primary) | fm_LParenmethodReference_lfno_primaryRParenOne)
  ;

classInstanceCreationExpression
  : ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)) | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar)* ((typeArgumentsOrDiamond) | fm_LParentypeArgumentsOrDiamondRParenQuestion)? ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((classBody) | fm_LParenclassBodyRParenQuestion)?
  | ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArgumentsOrDiamond) | fm_LParentypeArgumentsOrDiamondRParenQuestion)? ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((classBody) | fm_LParenclassBodyRParenQuestion)?
  | ((primary) | fm_LParenprimaryRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArgumentsOrDiamond) | fm_LParentypeArgumentsOrDiamondRParenQuestion)? ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((classBody) | fm_LParenclassBodyRParenQuestion)?
  ;

classInstanceCreationExpression_lf_primary
  : ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArgumentsOrDiamond) | fm_LParentypeArgumentsOrDiamondRParenQuestion)? ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((classBody) | fm_LParenclassBodyRParenQuestion)?
  ;

classInstanceCreationExpression_lfno_primary
  : ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)) | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar)* ((typeArgumentsOrDiamond) | fm_LParentypeArgumentsOrDiamondRParenQuestion)? ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((classBody) | fm_LParenclassBodyRParenQuestion)?
  | ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArgumentsOrDiamond) | fm_LParentypeArgumentsOrDiamondRParenQuestion)? ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((classBody) | fm_LParenclassBodyRParenQuestion)?
  ;

typeArgumentsOrDiamond
  : ((typeArguments) | fm_LParentypeArgumentsRParenOne)
  | ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)
  ;

fieldAccess
  : ((primary) | fm_LParenprimaryRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

fieldAccess_lf_primary
  : ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

fieldAccess_lfno_primary
  : ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

arrayAccess
  : (( ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    | ((primaryNoNewArray_lfno_arrayAccess) | fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne) ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    ) | fm_newRulexXXx3)
    (( ((primaryNoNewArray_lf_arrayAccess) | fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne) ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    ) | fm_newRulexXXx4)*
  ;

arrayAccess_lf_primary
  : (( ((primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary) | fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne) ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    ) | fm_newRulexXXx5)
    (( ((primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary) | fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne) ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    ) | fm_newRulexXXx6)*
  ;

arrayAccess_lfno_primary
  : (( ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    | ((primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary) | fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne) ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    ) | fm_newRulexXXx7)
    (( ((primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary) | fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne) ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    ) | fm_newRulexXXx8)*
  ;

methodInvocation
  : ((methodName) | fm_LParenmethodNameRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((primary) | fm_LParenprimaryRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  ;

methodInvocation_lf_primary
  : ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  ;

methodInvocation_lfno_primary
  : ((methodName) | fm_LParenmethodNameRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((argumentList) | fm_LParenargumentListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  ;

argumentList
  : ((expression) | fm_LParenexpressionRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((expression) | fm_LParenexpressionRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar)*
  ;

methodReference
  : ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((referenceType) | fm_LParenreferenceTypeRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((primary) | fm_LParenprimaryRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((classType) | fm_LParenclassTypeRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne)
  | ((arrayType) | fm_LParenarrayTypeRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne)
  ;

methodReference_lf_primary
  : ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  ;

methodReference_lfno_primary
  : ((expressionName) | fm_LParenexpressionNameRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((referenceType) | fm_LParenreferenceTypeRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((typeName) | fm_LParentypeNameRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((classType) | fm_LParenclassTypeRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne)
  | ((arrayType) | fm_LParenarrayTypeRParenOne) ((fm_COLONCOLONPlaceHolder | COLONCOLON ) | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne)
  ;

arrayCreationExpression
  : ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((primitiveType) | fm_LParenprimitiveTypeRParenOne) ((dimExprs) | fm_LParendimExprsRParenOne) ((dims) | fm_LParendimsRParenQuestion)?
  | ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((classOrInterfaceType) | fm_LParenclassOrInterfaceTypeRParenOne) ((dimExprs) | fm_LParendimExprsRParenOne) ((dims) | fm_LParendimsRParenQuestion)?
  | ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((primitiveType) | fm_LParenprimitiveTypeRParenOne) ((dims) | fm_LParendimsRParenOne) ((arrayInitializer) | fm_LParenarrayInitializerRParenOne)
  | ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((classOrInterfaceType) | fm_LParenclassOrInterfaceTypeRParenOne) ((dims) | fm_LParendimsRParenOne) ((arrayInitializer) | fm_LParenarrayInitializerRParenOne)
  ;

dimExprs
  : ((dimExpr) | fm_LParendimExprRParenOne) ((dimExpr) | fm_LParendimExprRParenStar)*
  ;

dimExpr
  : ((annotation) | fm_LParenannotationRParenStar)* ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
  ;

constantExpression
  : ((expression) | fm_LParenexpressionRParenOne)
  ;

expression
  : ((lambdaExpression) | fm_LParenlambdaExpressionRParenOne)
  | ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne)
  ;

lambdaExpression
  : ((lambdaParameters) | fm_LParenlambdaParametersRParenOne) ((fm_ARROWPlaceHolder | ARROW ) | fm_LParenfm_ARROWPlaceHolderOrARROWRParenOne) ((lambdaBody) | fm_LParenlambdaBodyRParenOne)
  ;

lambdaParameters
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
  | ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((formalParameterList) | fm_LParenformalParameterListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  | ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((inferredFormalParameterList) | fm_LPareninferredFormalParameterListRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
  ;

inferredFormalParameterList
  : ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar)*
  ;

lambdaBody
  : ((expression) | fm_LParenexpressionRParenOne)
  | ((block) | fm_LParenblockRParenOne)
  ;

assignmentExpression
  : ((conditionalExpression) | fm_LParenconditionalExpressionRParenOne)
  | ((assignment) | fm_LParenassignmentRParenOne)
  ;

assignment
  : ((leftHandSide) | fm_LParenleftHandSideRParenOne) ((assignmentOperator) | fm_LParenassignmentOperatorRParenOne) ((expression) | fm_LParenexpressionRParenOne)
  ;

leftHandSide
  : ((expressionName) | fm_LParenexpressionNameRParenOne)
  | ((fieldAccess) | fm_LParenfieldAccessRParenOne)
  | ((arrayAccess) | fm_LParenarrayAccessRParenOne)
  ;

assignmentOperator
  : ((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne)
  | ((fm_MUL_ASSIGNPlaceHolder | MUL_ASSIGN ) | fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne)
  | ((fm_DIV_ASSIGNPlaceHolder | DIV_ASSIGN ) | fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne)
  | ((fm_MOD_ASSIGNPlaceHolder | MOD_ASSIGN ) | fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne)
  | ((fm_ADD_ASSIGNPlaceHolder | ADD_ASSIGN ) | fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne)
  | ((fm_SUB_ASSIGNPlaceHolder | SUB_ASSIGN ) | fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne)
  | ((fm_LSHIFT_ASSIGNPlaceHolder | LSHIFT_ASSIGN ) | fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne)
  | ((fm_RSHIFT_ASSIGNPlaceHolder | RSHIFT_ASSIGN ) | fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne)
  | ((fm_URSHIFT_ASSIGNPlaceHolder | URSHIFT_ASSIGN ) | fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne)
  | ((fm_AND_ASSIGNPlaceHolder | AND_ASSIGN ) | fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne)
  | ((fm_XOR_ASSIGNPlaceHolder | XOR_ASSIGN ) | fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne)
  | ((fm_OR_ASSIGNPlaceHolder | OR_ASSIGN ) | fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne)
  ;

conditionalExpression
  : ((conditionalOrExpression) | fm_LParenconditionalOrExpressionRParenOne)
  | ((conditionalOrExpression) | fm_LParenconditionalOrExpressionRParenOne) ((fm_QUESTIONPlaceHolder | QUESTION ) | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) conditionalExpression
  ;

conditionalOrExpression
  : ((conditionalAndExpression) | fm_LParenconditionalAndExpressionRParenOne)
  | conditionalOrExpression ((fm_ORPlaceHolder | OR ) | fm_LParenfm_ORPlaceHolderOrORRParenOne) ((conditionalAndExpression) | fm_LParenconditionalAndExpressionRParenOne)
  ;

conditionalAndExpression
  : ((inclusiveOrExpression) | fm_LPareninclusiveOrExpressionRParenOne)
  | conditionalAndExpression ((fm_ANDPlaceHolder | AND ) | fm_LParenfm_ANDPlaceHolderOrANDRParenOne) ((inclusiveOrExpression) | fm_LPareninclusiveOrExpressionRParenOne)
  ;

inclusiveOrExpression
  : ((exclusiveOrExpression) | fm_LParenexclusiveOrExpressionRParenOne)
  | inclusiveOrExpression ((fm_BITORPlaceHolder | BITOR ) | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne) ((exclusiveOrExpression) | fm_LParenexclusiveOrExpressionRParenOne)
  ;

exclusiveOrExpression
  : ((andExpression) | fm_LParenandExpressionRParenOne)
  | exclusiveOrExpression ((fm_CARETPlaceHolder | CARET ) | fm_LParenfm_CARETPlaceHolderOrCARETRParenOne) ((andExpression) | fm_LParenandExpressionRParenOne)
  ;

andExpression
  : ((equalityExpression) | fm_LParenequalityExpressionRParenOne)
  | andExpression ((fm_BITANDPlaceHolder | BITAND ) | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne) ((equalityExpression) | fm_LParenequalityExpressionRParenOne)
  ;

equalityExpression
  : ((relationalExpression) | fm_LParenrelationalExpressionRParenOne)
  | equalityExpression ((fm_EQUALPlaceHolder | EQUAL ) | fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne) ((relationalExpression) | fm_LParenrelationalExpressionRParenOne)
  | equalityExpression ((fm_NOTEQUALPlaceHolder | NOTEQUAL ) | fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne) ((relationalExpression) | fm_LParenrelationalExpressionRParenOne)
  ;

relationalExpression
  : ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
  | relationalExpression ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
  | relationalExpression ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
  | relationalExpression ((fm_LEPlaceHolder | LE ) | fm_LParenfm_LEPlaceHolderOrLERParenOne) ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
  | relationalExpression ((fm_GEPlaceHolder | GE ) | fm_LParenfm_GEPlaceHolderOrGERParenOne) ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
  | relationalExpression ((fm_INSTANCEOFPlaceHolder | INSTANCEOF ) | fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne) ((referenceType) | fm_LParenreferenceTypeRParenOne)
  ;

shiftExpression
  : ((additiveExpression) | fm_LParenadditiveExpressionRParenOne)
  | shiftExpression ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((additiveExpression) | fm_LParenadditiveExpressionRParenOne)
  | shiftExpression ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((additiveExpression) | fm_LParenadditiveExpressionRParenOne)
  | shiftExpression ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((additiveExpression) | fm_LParenadditiveExpressionRParenOne)
  ;

additiveExpression
  : ((multiplicativeExpression) | fm_LParenmultiplicativeExpressionRParenOne)
  | additiveExpression ((fm_ADDPlaceHolder | ADD ) | fm_LParenfm_ADDPlaceHolderOrADDRParenOne) ((multiplicativeExpression) | fm_LParenmultiplicativeExpressionRParenOne)
  | additiveExpression ((fm_SUBPlaceHolder | SUB ) | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne) ((multiplicativeExpression) | fm_LParenmultiplicativeExpressionRParenOne)
  ;

multiplicativeExpression
  : ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  | multiplicativeExpression ((fm_MULPlaceHolder | MUL ) | fm_LParenfm_MULPlaceHolderOrMULRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  | multiplicativeExpression ((fm_DIVPlaceHolder | DIV ) | fm_LParenfm_DIVPlaceHolderOrDIVRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  | multiplicativeExpression ((fm_MODPlaceHolder | MOD ) | fm_LParenfm_MODPlaceHolderOrMODRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  ;

unaryExpression
  : ((preIncrementExpression) | fm_LParenpreIncrementExpressionRParenOne)
  | ((preDecrementExpression) | fm_LParenpreDecrementExpressionRParenOne)
  | ((fm_ADDPlaceHolder | ADD ) | fm_LParenfm_ADDPlaceHolderOrADDRParenOne) unaryExpression
  | ((fm_SUBPlaceHolder | SUB ) | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne) unaryExpression
  | ((unaryExpressionNotPlusMinus) | fm_LParenunaryExpressionNotPlusMinusRParenOne)
  ;

preIncrementExpression
  : ((fm_INCPlaceHolder | INC ) | fm_LParenfm_INCPlaceHolderOrINCRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  ;

preDecrementExpression
  : ((fm_DECPlaceHolder | DEC ) | fm_LParenfm_DECPlaceHolderOrDECRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  ;

unaryExpressionNotPlusMinus
  : ((postfixExpression) | fm_LParenpostfixExpressionRParenOne)
  | ((fm_TILDEPlaceHolder | TILDE ) | fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  | ((fm_BANGPlaceHolder | BANG ) | fm_LParenfm_BANGPlaceHolderOrBANGRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  | ((castExpression) | fm_LParencastExpressionRParenOne)
  ;

postfixExpression
  : (( ((primary) | fm_LParenprimaryRParenOne)
    | ((expressionName) | fm_LParenexpressionNameRParenOne)
    ) | fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne)
    (( ((postIncrementExpression_lf_postfixExpression) | fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne)
    | ((postDecrementExpression_lf_postfixExpression) | fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne)
    ) | fm_newRulexXXx9)*
  ;

postIncrementExpression
  : ((postfixExpression) | fm_LParenpostfixExpressionRParenOne) ((fm_INCPlaceHolder | INC ) | fm_LParenfm_INCPlaceHolderOrINCRParenOne)
  ;

postIncrementExpression_lf_postfixExpression
  : ((fm_INCPlaceHolder | INC ) | fm_LParenfm_INCPlaceHolderOrINCRParenOne)
  ;

postDecrementExpression
  : ((postfixExpression) | fm_LParenpostfixExpressionRParenOne) ((fm_DECPlaceHolder | DEC ) | fm_LParenfm_DECPlaceHolderOrDECRParenOne)
  ;

postDecrementExpression_lf_postfixExpression
  : ((fm_DECPlaceHolder | DEC ) | fm_LParenfm_DECPlaceHolderOrDECRParenOne)
  ;

castExpression
  : ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((primitiveType) | fm_LParenprimitiveTypeRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
  | ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((referenceType) | fm_LParenreferenceTypeRParenOne) ((additionalBound) | fm_LParenadditionalBoundRParenStar)* ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((unaryExpressionNotPlusMinus) | fm_LParenunaryExpressionNotPlusMinusRParenOne)
  | ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((referenceType) | fm_LParenreferenceTypeRParenOne) ((additionalBound) | fm_LParenadditionalBoundRParenStar)* ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((lambdaExpression) | fm_LParenlambdaExpressionRParenOne)
  ;

// LEXER

// §3.9 Keywords

ABSTRACT : 'abstract';
fm_ABSTRACTPlaceHolder: FM_PlaceHolder; //language extension
ASSERT : 'assert';
fm_ASSERTPlaceHolder: FM_PlaceHolder; //language extension
BOOLEAN : 'boolean';
fm_BOOLEANPlaceHolder: FM_PlaceHolder; //language extension
BREAK : 'break';
fm_BREAKPlaceHolder: FM_PlaceHolder; //language extension
BYTE : 'byte';
fm_BYTEPlaceHolder: FM_PlaceHolder; //language extension
CASE : 'case';
fm_CASEPlaceHolder: FM_PlaceHolder; //language extension
CATCH : 'catch';
fm_CATCHPlaceHolder: FM_PlaceHolder; //language extension
CHAR : 'char';
fm_CHARPlaceHolder: FM_PlaceHolder; //language extension
CLASS : 'class';
fm_CLASSPlaceHolder: FM_PlaceHolder; //language extension
CONST : 'const';
fm_CONSTPlaceHolder: FM_PlaceHolder; //language extension
CONTINUE : 'continue';
fm_CONTINUEPlaceHolder: FM_PlaceHolder; //language extension
DEFAULT : 'default';
fm_DEFAULTPlaceHolder: FM_PlaceHolder; //language extension
DO : 'do';
fm_DOPlaceHolder: FM_PlaceHolder; //language extension
DOUBLE : 'double';
fm_DOUBLEPlaceHolder: FM_PlaceHolder; //language extension
ELSE : 'else';
fm_ELSEPlaceHolder: FM_PlaceHolder; //language extension
ENUM : 'enum';
fm_ENUMPlaceHolder: FM_PlaceHolder; //language extension
EXTENDS : 'extends';
fm_EXTENDSPlaceHolder: FM_PlaceHolder; //language extension
FINAL : 'final';
fm_FINALPlaceHolder: FM_PlaceHolder; //language extension
FINALLY : 'finally';
fm_FINALLYPlaceHolder: FM_PlaceHolder; //language extension
FLOAT : 'float';
fm_FLOATPlaceHolder: FM_PlaceHolder; //language extension
FOR : 'for';
fm_FORPlaceHolder: FM_PlaceHolder; //language extension
IF : 'if';
fm_IFPlaceHolder: FM_PlaceHolder; //language extension
GOTO : 'goto';
fm_GOTOPlaceHolder: FM_PlaceHolder; //language extension
IMPLEMENTS : 'implements';
fm_IMPLEMENTSPlaceHolder: FM_PlaceHolder; //language extension
IMPORT : 'import';
fm_IMPORTPlaceHolder: FM_PlaceHolder; //language extension
INSTANCEOF : 'instanceof';
fm_INSTANCEOFPlaceHolder: FM_PlaceHolder; //language extension
INT : 'int';
fm_INTPlaceHolder: FM_PlaceHolder; //language extension
INTERFACE : 'interface';
fm_INTERFACEPlaceHolder: FM_PlaceHolder; //language extension
LONG : 'long';
fm_LONGPlaceHolder: FM_PlaceHolder; //language extension
NATIVE : 'native';
fm_NATIVEPlaceHolder: FM_PlaceHolder; //language extension
NEW : 'new';
fm_NEWPlaceHolder: FM_PlaceHolder; //language extension
PACKAGE : 'package';
fm_PACKAGEPlaceHolder: FM_PlaceHolder; //language extension
PRIVATE : 'private';
fm_PRIVATEPlaceHolder: FM_PlaceHolder; //language extension
PROTECTED : 'protected';
fm_PROTECTEDPlaceHolder: FM_PlaceHolder; //language extension
PUBLIC : 'public';
fm_PUBLICPlaceHolder: FM_PlaceHolder; //language extension
RETURN : 'return';
fm_RETURNPlaceHolder: FM_PlaceHolder; //language extension
SHORT : 'short';
fm_SHORTPlaceHolder: FM_PlaceHolder; //language extension
STATIC : 'static';
fm_STATICPlaceHolder: FM_PlaceHolder; //language extension
STRICTFP : 'strictfp';
fm_STRICTFPPlaceHolder: FM_PlaceHolder; //language extension
SUPER : 'super';
fm_SUPERPlaceHolder: FM_PlaceHolder; //language extension
SWITCH : 'switch';
fm_SWITCHPlaceHolder: FM_PlaceHolder; //language extension
SYNCHRONIZED : 'synchronized';
fm_SYNCHRONIZEDPlaceHolder: FM_PlaceHolder; //language extension
THIS : 'this';
fm_THISPlaceHolder: FM_PlaceHolder; //language extension
THROW : 'throw';
fm_THROWPlaceHolder: FM_PlaceHolder; //language extension
THROWS : 'throws';
fm_THROWSPlaceHolder: FM_PlaceHolder; //language extension
TRANSIENT : 'transient';
fm_TRANSIENTPlaceHolder: FM_PlaceHolder; //language extension
TRY : 'try';
fm_TRYPlaceHolder: FM_PlaceHolder; //language extension
VOID : 'void';
fm_VOIDPlaceHolder: FM_PlaceHolder; //language extension
VOLATILE : 'volatile';
fm_VOLATILEPlaceHolder: FM_PlaceHolder; //language extension
WHILE : 'while';
fm_WHILEPlaceHolder: FM_PlaceHolder; //language extension

// §3.10.1 Integer Literals

IntegerLiteral
  : DecimalIntegerLiteral
  | HexIntegerLiteral
  | OctalIntegerLiteral
  | BinaryIntegerLiteral
  ;
fm_IntegerLiteralPlaceHolder: FM_PlaceHolder; //language extension

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
fm_FloatingPointLiteralPlaceHolder: FM_PlaceHolder; //language extension

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
fm_BooleanLiteralPlaceHolder: FM_PlaceHolder; //language extension

// §3.10.4 Character Literals

CharacterLiteral
  : '\'' SingleCharacter '\''
  | '\'' EscapeSequence '\''
  ;
fm_CharacterLiteralPlaceHolder: FM_PlaceHolder; //language extension

fragment
SingleCharacter
  : ~['\\]
  ;

// §3.10.5 String Literals

StringLiteral
  : '"' StringCharacters? '"'
  ;
fm_StringLiteralPlaceHolder: FM_PlaceHolder; //language extension

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
fm_NullLiteralPlaceHolder: FM_PlaceHolder; //language extension

// §3.11 Separators

LPAREN : '(';
fm_LPARENPlaceHolder: FM_PlaceHolder; //language extension
RPAREN : ')';
fm_RPARENPlaceHolder: FM_PlaceHolder; //language extension
LBRACE : '{';
fm_LBRACEPlaceHolder: FM_PlaceHolder; //language extension
RBRACE : '}';
fm_RBRACEPlaceHolder: FM_PlaceHolder; //language extension
LBRACK : '[';
fm_LBRACKPlaceHolder: FM_PlaceHolder; //language extension
RBRACK : ']';
fm_RBRACKPlaceHolder: FM_PlaceHolder; //language extension
SEMI : ';';
fm_SEMIPlaceHolder: FM_PlaceHolder; //language extension
COMMA : ',';
fm_COMMAPlaceHolder: FM_PlaceHolder; //language extension
DOT : '.';
fm_DOTPlaceHolder: FM_PlaceHolder; //language extension

// §3.12 Operators

ASSIGN : '=';
fm_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
GT : '>';
fm_GTPlaceHolder: FM_PlaceHolder; //language extension
LT : '<';
fm_LTPlaceHolder: FM_PlaceHolder; //language extension
BANG : '!';
fm_BANGPlaceHolder: FM_PlaceHolder; //language extension
TILDE : '~';
fm_TILDEPlaceHolder: FM_PlaceHolder; //language extension
QUESTION : '?';
fm_QUESTIONPlaceHolder: FM_PlaceHolder; //language extension
COLON : ':';
fm_COLONPlaceHolder: FM_PlaceHolder; //language extension
EQUAL : '==';
fm_EQUALPlaceHolder: FM_PlaceHolder; //language extension
LE : '<=';
fm_LEPlaceHolder: FM_PlaceHolder; //language extension
GE : '>=';
fm_GEPlaceHolder: FM_PlaceHolder; //language extension
NOTEQUAL : '!=';
fm_NOTEQUALPlaceHolder: FM_PlaceHolder; //language extension
AND : '&&';
fm_ANDPlaceHolder: FM_PlaceHolder; //language extension
OR : '||';
fm_ORPlaceHolder: FM_PlaceHolder; //language extension
INC : '++';
fm_INCPlaceHolder: FM_PlaceHolder; //language extension
DEC : '--';
fm_DECPlaceHolder: FM_PlaceHolder; //language extension
ADD : '+';
fm_ADDPlaceHolder: FM_PlaceHolder; //language extension
SUB : '-';
fm_SUBPlaceHolder: FM_PlaceHolder; //language extension
MUL : '*';
fm_MULPlaceHolder: FM_PlaceHolder; //language extension
DIV : '/';
fm_DIVPlaceHolder: FM_PlaceHolder; //language extension
BITAND : '&';
fm_BITANDPlaceHolder: FM_PlaceHolder; //language extension
BITOR : '|';
fm_BITORPlaceHolder: FM_PlaceHolder; //language extension
CARET : '^';
fm_CARETPlaceHolder: FM_PlaceHolder; //language extension
MOD : '%';
fm_MODPlaceHolder: FM_PlaceHolder; //language extension
ARROW : '->';
fm_ARROWPlaceHolder: FM_PlaceHolder; //language extension
COLONCOLON : '::';
fm_COLONCOLONPlaceHolder: FM_PlaceHolder; //language extension

ADD_ASSIGN : '+=';
fm_ADD_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
SUB_ASSIGN : '-=';
fm_SUB_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
MUL_ASSIGN : '*=';
fm_MUL_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
DIV_ASSIGN : '/=';
fm_DIV_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
AND_ASSIGN : '&=';
fm_AND_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
OR_ASSIGN : '|=';
fm_OR_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
XOR_ASSIGN : '^=';
fm_XOR_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
MOD_ASSIGN : '%=';
fm_MOD_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
LSHIFT_ASSIGN : '<<=';
fm_LSHIFT_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
RSHIFT_ASSIGN : '>>=';
fm_RSHIFT_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
URSHIFT_ASSIGN : '>>>=';
fm_URSHIFT_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension

// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
  : JavaLetter JavaLetterOrDigit*
  ;
fm_IdentifierPlaceHolder: FM_PlaceHolder; //language extension

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
fm_ATPlaceHolder: FM_PlaceHolder; //language extension
ELLIPSIS : '...';
fm_ELLIPSISPlaceHolder: FM_PlaceHolder; //language extension

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;
fm_WSPlaceHolder: FM_PlaceHolder; //language extension

COMMENT
    :   '/*' .*? '*/' -> skip
    ;
fm_COMMENTPlaceHolder: FM_PlaceHolder; //language extension

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;
fm_LINE_COMMENTPlaceHolder: FM_PlaceHolder; //language extension

FM_PlaceHolder: '${' .*? '}';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*) '</#list>';
fm_LParendimExprRParenStar: '<#if' .*? '>' (( dimExpr      ) * | fm_LParendimExprRParenStar*) ('<#elseif' .*? '>' (( dimExpr      ) * | fm_LParendimExprRParenStar*))* '</#if>' | '<#if' .*? '>' (( dimExpr      ) * | fm_LParendimExprRParenStar*) ('<#elseif' .*? '>' (( dimExpr      ) * | fm_LParendimExprRParenStar*) )* '<#else>' (( dimExpr      ) * | fm_LParendimExprRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( dimExpr      ) * | fm_LParendimExprRParenStar*) '</#list>';
fm_LParenannotationTypeElementModifierRParenStar: '<#if' .*? '>' (( annotationTypeElementModifier      ) * | fm_LParenannotationTypeElementModifierRParenStar*) ('<#elseif' .*? '>' (( annotationTypeElementModifier      ) * | fm_LParenannotationTypeElementModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( annotationTypeElementModifier      ) * | fm_LParenannotationTypeElementModifierRParenStar*) ('<#elseif' .*? '>' (( annotationTypeElementModifier      ) * | fm_LParenannotationTypeElementModifierRParenStar*) )* '<#else>' (( annotationTypeElementModifier      ) * | fm_LParenannotationTypeElementModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( annotationTypeElementModifier      ) * | fm_LParenannotationTypeElementModifierRParenStar*) '</#list>';
fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar: '<#if' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( annotation      )  *     ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( annotation      )  *     ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( annotation      )  *     ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( annotation      )  *     ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) )* '<#else>' (( ( fm_DOTPlaceHolder     | DOT      )    ( annotation      )  *     ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( annotation      )  *     ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) '</#list>';
fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar: '<#if' .*? '>' (( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*) )* '<#else>' (( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*) '</#list>';
fm_LParenswitchBlockStatementGroupRParenStar: '<#if' .*? '>' (( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*) ('<#elseif' .*? '>' (( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*))* '</#if>' | '<#if' .*? '>' (( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*) ('<#elseif' .*? '>' (( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*) )* '<#else>' (( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*) '</#list>';
fm_LParentypeParameterModifierRParenStar: '<#if' .*? '>' (( typeParameterModifier      ) * | fm_LParentypeParameterModifierRParenStar*) ('<#elseif' .*? '>' (( typeParameterModifier      ) * | fm_LParentypeParameterModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( typeParameterModifier      ) * | fm_LParentypeParameterModifierRParenStar*) ('<#elseif' .*? '>' (( typeParameterModifier      ) * | fm_LParentypeParameterModifierRParenStar*) )* '<#else>' (( typeParameterModifier      ) * | fm_LParentypeParameterModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( typeParameterModifier      ) * | fm_LParentypeParameterModifierRParenStar*) '</#list>';
fm_LParencatchClauseRParenStar: '<#if' .*? '>' (( catchClause      ) * | fm_LParencatchClauseRParenStar*) ('<#elseif' .*? '>' (( catchClause      ) * | fm_LParencatchClauseRParenStar*))* '</#if>' | '<#if' .*? '>' (( catchClause      ) * | fm_LParencatchClauseRParenStar*) ('<#elseif' .*? '>' (( catchClause      ) * | fm_LParencatchClauseRParenStar*) )* '<#else>' (( catchClause      ) * | fm_LParencatchClauseRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( catchClause      ) * | fm_LParencatchClauseRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*) '</#list>';
fm_LParenenumConstantModifierRParenStar: '<#if' .*? '>' (( enumConstantModifier      ) * | fm_LParenenumConstantModifierRParenStar*) ('<#elseif' .*? '>' (( enumConstantModifier      ) * | fm_LParenenumConstantModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( enumConstantModifier      ) * | fm_LParenenumConstantModifierRParenStar*) ('<#elseif' .*? '>' (( enumConstantModifier      ) * | fm_LParenenumConstantModifierRParenStar*) )* '<#else>' (( enumConstantModifier      ) * | fm_LParenenumConstantModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( enumConstantModifier      ) * | fm_LParenenumConstantModifierRParenStar*) '</#list>';
fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar: '<#if' .*? '>' (( ( annotation      )  *     ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) ('<#elseif' .*? '>' (( ( annotation      )  *     ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( annotation      )  *     ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) ('<#elseif' .*? '>' (( ( annotation      )  *     ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) )* '<#else>' (( ( annotation      )  *     ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( annotation      )  *     ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( statementExpression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( statementExpression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( statementExpression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( statementExpression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( statementExpression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( statementExpression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar*) '</#list>';
fm_LParenimportDeclarationRParenStar: '<#if' .*? '>' (( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*) ('<#elseif' .*? '>' (( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*))* '</#if>' | '<#if' .*? '>' (( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*) ('<#elseif' .*? '>' (( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*) )* '<#else>' (( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*) '</#list>';
fm_LParentypeDeclarationRParenStar: '<#if' .*? '>' (( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*) ('<#elseif' .*? '>' (( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*))* '</#if>' | '<#if' .*? '>' (( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*) ('<#elseif' .*? '>' (( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*) )* '<#else>' (( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*) '</#list>';
fm_LParenclassBodyDeclarationRParenStar: '<#if' .*? '>' (( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*) ('<#elseif' .*? '>' (( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*))* '</#if>' | '<#if' .*? '>' (( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*) ('<#elseif' .*? '>' (( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*) )* '<#else>' (( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*) '</#list>';
fm_LParenmethodModifierRParenStar: '<#if' .*? '>' (( methodModifier      ) * | fm_LParenmethodModifierRParenStar*) ('<#elseif' .*? '>' (( methodModifier      ) * | fm_LParenmethodModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( methodModifier      ) * | fm_LParenmethodModifierRParenStar*) ('<#elseif' .*? '>' (( methodModifier      ) * | fm_LParenmethodModifierRParenStar*) )* '<#else>' (( methodModifier      ) * | fm_LParenmethodModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( methodModifier      ) * | fm_LParenmethodModifierRParenStar*) '</#list>';
fm_LParenadditionalBoundRParenStar: '<#if' .*? '>' (( additionalBound      ) * | fm_LParenadditionalBoundRParenStar*) ('<#elseif' .*? '>' (( additionalBound      ) * | fm_LParenadditionalBoundRParenStar*))* '</#if>' | '<#if' .*? '>' (( additionalBound      ) * | fm_LParenadditionalBoundRParenStar*) ('<#elseif' .*? '>' (( additionalBound      ) * | fm_LParenadditionalBoundRParenStar*) )* '<#else>' (( additionalBound      ) * | fm_LParenadditionalBoundRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( additionalBound      ) * | fm_LParenadditionalBoundRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*) '</#list>';
fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar: '<#if' .*? '>' (( ( classType_lf_classOrInterfaceType      )     | ( interfaceType_lf_classOrInterfaceType      )      ) * | fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar*) ('<#elseif' .*? '>' (( ( classType_lf_classOrInterfaceType      )     | ( interfaceType_lf_classOrInterfaceType      )      ) * | fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( classType_lf_classOrInterfaceType      )     | ( interfaceType_lf_classOrInterfaceType      )      ) * | fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar*) ('<#elseif' .*? '>' (( ( classType_lf_classOrInterfaceType      )     | ( interfaceType_lf_classOrInterfaceType      )      ) * | fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar*) )* '<#else>' (( ( classType_lf_classOrInterfaceType      )     | ( interfaceType_lf_classOrInterfaceType      )      ) * | fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( classType_lf_classOrInterfaceType      )     | ( interfaceType_lf_classOrInterfaceType      )      ) * | fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar*) '</#list>';
fm_newRulexXXx9: '<#if' .*? '>' (( ( postIncrementExpression_lf_postfixExpression      )     | ( postDecrementExpression_lf_postfixExpression      )      ) * | fm_newRulexXXx9*) ('<#elseif' .*? '>' (( ( postIncrementExpression_lf_postfixExpression      )     | ( postDecrementExpression_lf_postfixExpression      )      ) * | fm_newRulexXXx9*))* '</#if>' | '<#if' .*? '>' (( ( postIncrementExpression_lf_postfixExpression      )     | ( postDecrementExpression_lf_postfixExpression      )      ) * | fm_newRulexXXx9*) ('<#elseif' .*? '>' (( ( postIncrementExpression_lf_postfixExpression      )     | ( postDecrementExpression_lf_postfixExpression      )      ) * | fm_newRulexXXx9*) )* '<#else>' (( ( postIncrementExpression_lf_postfixExpression      )     | ( postDecrementExpression_lf_postfixExpression      )      ) * | fm_newRulexXXx9*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( postIncrementExpression_lf_postfixExpression      )     | ( postDecrementExpression_lf_postfixExpression      )      ) * | fm_newRulexXXx9*) '</#list>';
fm_LParenannotationTypeMemberDeclarationRParenStar: '<#if' .*? '>' (( annotationTypeMemberDeclaration      ) * | fm_LParenannotationTypeMemberDeclarationRParenStar*) ('<#elseif' .*? '>' (( annotationTypeMemberDeclaration      ) * | fm_LParenannotationTypeMemberDeclarationRParenStar*))* '</#if>' | '<#if' .*? '>' (( annotationTypeMemberDeclaration      ) * | fm_LParenannotationTypeMemberDeclarationRParenStar*) ('<#elseif' .*? '>' (( annotationTypeMemberDeclaration      ) * | fm_LParenannotationTypeMemberDeclarationRParenStar*) )* '<#else>' (( annotationTypeMemberDeclaration      ) * | fm_LParenannotationTypeMemberDeclarationRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( annotationTypeMemberDeclaration      ) * | fm_LParenannotationTypeMemberDeclarationRParenStar*) '</#list>';
fm_LParenfieldModifierRParenStar: '<#if' .*? '>' (( fieldModifier      ) * | fm_LParenfieldModifierRParenStar*) ('<#elseif' .*? '>' (( fieldModifier      ) * | fm_LParenfieldModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( fieldModifier      ) * | fm_LParenfieldModifierRParenStar*) ('<#elseif' .*? '>' (( fieldModifier      ) * | fm_LParenfieldModifierRParenStar*) )* '<#else>' (( fieldModifier      ) * | fm_LParenfieldModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( fieldModifier      ) * | fm_LParenfieldModifierRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( interfaceType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( interfaceType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( interfaceType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( interfaceType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( interfaceType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( interfaceType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar*) '</#list>';
fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar: '<#if' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) )* '<#else>' (( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*) '</#list>';
fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar: '<#if' .*? '>' (( ( primaryNoNewArray_lf_primary      )      ) * | fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar*) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lf_primary      )      ) * | fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( primaryNoNewArray_lf_primary      )      ) * | fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar*) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lf_primary      )      ) * | fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar*) )* '<#else>' (( ( primaryNoNewArray_lf_primary      )      ) * | fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( primaryNoNewArray_lf_primary      )      ) * | fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar*) '</#list>';
fm_LParenconstantModifierRParenStar: '<#if' .*? '>' (( constantModifier      ) * | fm_LParenconstantModifierRParenStar*) ('<#elseif' .*? '>' (( constantModifier      ) * | fm_LParenconstantModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( constantModifier      ) * | fm_LParenconstantModifierRParenStar*) ('<#elseif' .*? '>' (( constantModifier      ) * | fm_LParenconstantModifierRParenStar*) )* '<#else>' (( constantModifier      ) * | fm_LParenconstantModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( constantModifier      ) * | fm_LParenconstantModifierRParenStar*) '</#list>';
fm_newRulexXXx1: '<#if' .*? '>' (( ( unannClassType_lf_unannClassOrInterfaceType      )     | ( unannInterfaceType_lf_unannClassOrInterfaceType      )      ) * | fm_newRulexXXx1*) ('<#elseif' .*? '>' (( ( unannClassType_lf_unannClassOrInterfaceType      )     | ( unannInterfaceType_lf_unannClassOrInterfaceType      )      ) * | fm_newRulexXXx1*))* '</#if>' | '<#if' .*? '>' (( ( unannClassType_lf_unannClassOrInterfaceType      )     | ( unannInterfaceType_lf_unannClassOrInterfaceType      )      ) * | fm_newRulexXXx1*) ('<#elseif' .*? '>' (( ( unannClassType_lf_unannClassOrInterfaceType      )     | ( unannInterfaceType_lf_unannClassOrInterfaceType      )      ) * | fm_newRulexXXx1*) )* '<#else>' (( ( unannClassType_lf_unannClassOrInterfaceType      )     | ( unannInterfaceType_lf_unannClassOrInterfaceType      )      ) * | fm_newRulexXXx1*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( unannClassType_lf_unannClassOrInterfaceType      )     | ( unannInterfaceType_lf_unannClassOrInterfaceType      )      ) * | fm_newRulexXXx1*) '</#list>';
fm_newRulexXXx8: '<#if' .*? '>' (( ( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx8*) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx8*))* '</#if>' | '<#if' .*? '>' (( ( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx8*) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx8*) )* '<#else>' (( ( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx8*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx8*) '</#list>';
fm_LParenpackageModifierRParenStar: '<#if' .*? '>' (( packageModifier      ) * | fm_LParenpackageModifierRParenStar*) ('<#elseif' .*? '>' (( packageModifier      ) * | fm_LParenpackageModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( packageModifier      ) * | fm_LParenpackageModifierRParenStar*) ('<#elseif' .*? '>' (( packageModifier      ) * | fm_LParenpackageModifierRParenStar*) )* '<#else>' (( packageModifier      ) * | fm_LParenpackageModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( packageModifier      ) * | fm_LParenpackageModifierRParenStar*) '</#list>';
fm_LPareninterfaceMethodModifierRParenStar: '<#if' .*? '>' (( interfaceMethodModifier      ) * | fm_LPareninterfaceMethodModifierRParenStar*) ('<#elseif' .*? '>' (( interfaceMethodModifier      ) * | fm_LPareninterfaceMethodModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( interfaceMethodModifier      ) * | fm_LPareninterfaceMethodModifierRParenStar*) ('<#elseif' .*? '>' (( interfaceMethodModifier      ) * | fm_LPareninterfaceMethodModifierRParenStar*) )* '<#else>' (( interfaceMethodModifier      ) * | fm_LPareninterfaceMethodModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( interfaceMethodModifier      ) * | fm_LPareninterfaceMethodModifierRParenStar*) '</#list>';
fm_LParenvariableModifierRParenStar: '<#if' .*? '>' (( variableModifier      ) * | fm_LParenvariableModifierRParenStar*) ('<#elseif' .*? '>' (( variableModifier      ) * | fm_LParenvariableModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( variableModifier      ) * | fm_LParenvariableModifierRParenStar*) ('<#elseif' .*? '>' (( variableModifier      ) * | fm_LParenvariableModifierRParenStar*) )* '<#else>' (( variableModifier      ) * | fm_LParenvariableModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( variableModifier      ) * | fm_LParenvariableModifierRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*) '</#list>';
fm_LPareninterfaceModifierRParenStar: '<#if' .*? '>' (( interfaceModifier      ) * | fm_LPareninterfaceModifierRParenStar*) ('<#elseif' .*? '>' (( interfaceModifier      ) * | fm_LPareninterfaceModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( interfaceModifier      ) * | fm_LPareninterfaceModifierRParenStar*) ('<#elseif' .*? '>' (( interfaceModifier      ) * | fm_LPareninterfaceModifierRParenStar*) )* '<#else>' (( interfaceModifier      ) * | fm_LPareninterfaceModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( interfaceModifier      ) * | fm_LPareninterfaceModifierRParenStar*) '</#list>';
fm_newRulexXXx4: '<#if' .*? '>' (( ( primaryNoNewArray_lf_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx4*) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lf_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx4*))* '</#if>' | '<#if' .*? '>' (( ( primaryNoNewArray_lf_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx4*) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lf_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx4*) )* '<#else>' (( ( primaryNoNewArray_lf_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx4*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( primaryNoNewArray_lf_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx4*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( exceptionType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( exceptionType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( exceptionType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( exceptionType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( exceptionType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( exceptionType      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*) '</#list>';
fm_newRulexXXx6: '<#if' .*? '>' (( ( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx6*) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx6*))* '</#if>' | '<#if' .*? '>' (( ( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx6*) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx6*) )* '<#else>' (( ( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx6*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_newRulexXXx6*) '</#list>';
fm_LParenclassModifierRParenStar: '<#if' .*? '>' (( classModifier      ) * | fm_LParenclassModifierRParenStar*) ('<#elseif' .*? '>' (( classModifier      ) * | fm_LParenclassModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( classModifier      ) * | fm_LParenclassModifierRParenStar*) ('<#elseif' .*? '>' (( classModifier      ) * | fm_LParenclassModifierRParenStar*) )* '<#else>' (( classModifier      ) * | fm_LParenclassModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( classModifier      ) * | fm_LParenclassModifierRParenStar*) '</#list>';
fm_LParenconstructorModifierRParenStar: '<#if' .*? '>' (( constructorModifier      ) * | fm_LParenconstructorModifierRParenStar*) ('<#elseif' .*? '>' (( constructorModifier      ) * | fm_LParenconstructorModifierRParenStar*))* '</#if>' | '<#if' .*? '>' (( constructorModifier      ) * | fm_LParenconstructorModifierRParenStar*) ('<#elseif' .*? '>' (( constructorModifier      ) * | fm_LParenconstructorModifierRParenStar*) )* '<#else>' (( constructorModifier      ) * | fm_LParenconstructorModifierRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( constructorModifier      ) * | fm_LParenconstructorModifierRParenStar*) '</#list>';
fm_LParenswitchLabelRParenStar: '<#if' .*? '>' (( switchLabel      ) * | fm_LParenswitchLabelRParenStar*) ('<#elseif' .*? '>' (( switchLabel      ) * | fm_LParenswitchLabelRParenStar*))* '</#if>' | '<#if' .*? '>' (( switchLabel      ) * | fm_LParenswitchLabelRParenStar*) ('<#elseif' .*? '>' (( switchLabel      ) * | fm_LParenswitchLabelRParenStar*) )* '<#else>' (( switchLabel      ) * | fm_LParenswitchLabelRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( switchLabel      ) * | fm_LParenswitchLabelRParenStar*) '</#list>';
fm_LPareninterfaceMemberDeclarationRParenStar: '<#if' .*? '>' (( interfaceMemberDeclaration      ) * | fm_LPareninterfaceMemberDeclarationRParenStar*) ('<#elseif' .*? '>' (( interfaceMemberDeclaration      ) * | fm_LPareninterfaceMemberDeclarationRParenStar*))* '</#if>' | '<#if' .*? '>' (( interfaceMemberDeclaration      ) * | fm_LPareninterfaceMemberDeclarationRParenStar*) ('<#elseif' .*? '>' (( interfaceMemberDeclaration      ) * | fm_LPareninterfaceMemberDeclarationRParenStar*) )* '<#else>' (( interfaceMemberDeclaration      ) * | fm_LPareninterfaceMemberDeclarationRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( interfaceMemberDeclaration      ) * | fm_LPareninterfaceMemberDeclarationRParenStar*) '</#list>';
fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar: '<#if' .*? '>' (( ( fm_BITORPlaceHolder     | BITOR      )    ( classType      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_BITORPlaceHolder     | BITOR      )    ( classType      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_BITORPlaceHolder     | BITOR      )    ( classType      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_BITORPlaceHolder     | BITOR      )    ( classType      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar*) )* '<#else>' (( ( fm_BITORPlaceHolder     | BITOR      )    ( classType      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_BITORPlaceHolder     | BITOR      )    ( classType      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar*) '</#list>';
fm_LParenblockStatementRParenStar: '<#if' .*? '>' (( blockStatement      ) * | fm_LParenblockStatementRParenStar*) ('<#elseif' .*? '>' (( blockStatement      ) * | fm_LParenblockStatementRParenStar*))* '</#if>' | '<#if' .*? '>' (( blockStatement      ) * | fm_LParenblockStatementRParenStar*) ('<#elseif' .*? '>' (( blockStatement      ) * | fm_LParenblockStatementRParenStar*) )* '<#else>' (( blockStatement      ) * | fm_LParenblockStatementRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( blockStatement      ) * | fm_LParenblockStatementRParenStar*) '</#list>';
fm_LParenannotationRParenStar: '<#if' .*? '>' (( annotation      ) * | fm_LParenannotationRParenStar*) ('<#elseif' .*? '>' (( annotation      ) * | fm_LParenannotationRParenStar*))* '</#if>' | '<#if' .*? '>' (( annotation      ) * | fm_LParenannotationRParenStar*) ('<#elseif' .*? '>' (( annotation      ) * | fm_LParenannotationRParenStar*) )* '<#else>' (( annotation      ) * | fm_LParenannotationRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( annotation      ) * | fm_LParenannotationRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*) '</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar: '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*) )* '<#else>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*) '</#list>';
fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar: '<#if' .*? '>' (( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*))* '</#if>' | '<#if' .*? '>' (( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) ('<#elseif' .*? '>' (( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) )* '<#else>' (( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) '</#if>' | '<#list' .*? 'as' .*? '>' (( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*) '</#list>';
fm_LParentypeBoundRParenQuestion: '<#if' .*? '>' (( typeBound      ) ? | fm_LParentypeBoundRParenQuestion?) ('<#elseif' .*? '>' (( typeBound      ) ? | fm_LParentypeBoundRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( typeBound      ) ? | fm_LParentypeBoundRParenQuestion?) ('<#elseif' .*? '>' (( typeBound      ) ? | fm_LParentypeBoundRParenQuestion?) )* '<#else>' (( typeBound      ) ? | fm_LParentypeBoundRParenQuestion?) '</#if>';
fm_LParencatchesRParenQuestion: '<#if' .*? '>' (( catches      ) ? | fm_LParencatchesRParenQuestion?) ('<#elseif' .*? '>' (( catches      ) ? | fm_LParencatchesRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( catches      ) ? | fm_LParencatchesRParenQuestion?) ('<#elseif' .*? '>' (( catches      ) ? | fm_LParencatchesRParenQuestion?) )* '<#else>' (( catches      ) ? | fm_LParencatchesRParenQuestion?) '</#if>';
fm_LParenexpressionRParenQuestion: '<#if' .*? '>' (( expression      ) ? | fm_LParenexpressionRParenQuestion?) ('<#elseif' .*? '>' (( expression      ) ? | fm_LParenexpressionRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( expression      ) ? | fm_LParenexpressionRParenQuestion?) ('<#elseif' .*? '>' (( expression      ) ? | fm_LParenexpressionRParenQuestion?) )* '<#else>' (( expression      ) ? | fm_LParenexpressionRParenQuestion?) '</#if>';
fm_LParensuperinterfacesRParenQuestion: '<#if' .*? '>' (( superinterfaces      ) ? | fm_LParensuperinterfacesRParenQuestion?) ('<#elseif' .*? '>' (( superinterfaces      ) ? | fm_LParensuperinterfacesRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( superinterfaces      ) ? | fm_LParensuperinterfacesRParenQuestion?) ('<#elseif' .*? '>' (( superinterfaces      ) ? | fm_LParensuperinterfacesRParenQuestion?) )* '<#else>' (( superinterfaces      ) ? | fm_LParensuperinterfacesRParenQuestion?) '</#if>';
fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion: '<#if' .*? '>' (( ( fm_ASSIGNPlaceHolder     | ASSIGN      )    ( variableInitializer      )      ) ? | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion?) ('<#elseif' .*? '>' (( ( fm_ASSIGNPlaceHolder     | ASSIGN      )    ( variableInitializer      )      ) ? | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( ( fm_ASSIGNPlaceHolder     | ASSIGN      )    ( variableInitializer      )      ) ? | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion?) ('<#elseif' .*? '>' (( ( fm_ASSIGNPlaceHolder     | ASSIGN      )    ( variableInitializer      )      ) ? | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion?) )* '<#else>' (( ( fm_ASSIGNPlaceHolder     | ASSIGN      )    ( variableInitializer      )      ) ? | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion?) '</#if>';
fm_LParenelementValuePairListRParenQuestion: '<#if' .*? '>' (( elementValuePairList      ) ? | fm_LParenelementValuePairListRParenQuestion?) ('<#elseif' .*? '>' (( elementValuePairList      ) ? | fm_LParenelementValuePairListRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( elementValuePairList      ) ? | fm_LParenelementValuePairListRParenQuestion?) ('<#elseif' .*? '>' (( elementValuePairList      ) ? | fm_LParenelementValuePairListRParenQuestion?) )* '<#else>' (( elementValuePairList      ) ? | fm_LParenelementValuePairListRParenQuestion?) '</#if>';
fm_LParenexplicitConstructorInvocationRParenQuestion: '<#if' .*? '>' (( explicitConstructorInvocation      ) ? | fm_LParenexplicitConstructorInvocationRParenQuestion?) ('<#elseif' .*? '>' (( explicitConstructorInvocation      ) ? | fm_LParenexplicitConstructorInvocationRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( explicitConstructorInvocation      ) ? | fm_LParenexplicitConstructorInvocationRParenQuestion?) ('<#elseif' .*? '>' (( explicitConstructorInvocation      ) ? | fm_LParenexplicitConstructorInvocationRParenQuestion?) )* '<#else>' (( explicitConstructorInvocation      ) ? | fm_LParenexplicitConstructorInvocationRParenQuestion?) '</#if>';
fm_LParenforUpdateRParenQuestion: '<#if' .*? '>' (( forUpdate      ) ? | fm_LParenforUpdateRParenQuestion?) ('<#elseif' .*? '>' (( forUpdate      ) ? | fm_LParenforUpdateRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( forUpdate      ) ? | fm_LParenforUpdateRParenQuestion?) ('<#elseif' .*? '>' (( forUpdate      ) ? | fm_LParenforUpdateRParenQuestion?) )* '<#else>' (( forUpdate      ) ? | fm_LParenforUpdateRParenQuestion?) '</#if>';
fm_LParenfinally_RParenQuestion: '<#if' .*? '>' (( finally_      ) ? | fm_LParenfinally_RParenQuestion?) ('<#elseif' .*? '>' (( finally_      ) ? | fm_LParenfinally_RParenQuestion?))* '</#if>' | '<#if' .*? '>' (( finally_      ) ? | fm_LParenfinally_RParenQuestion?) ('<#elseif' .*? '>' (( finally_      ) ? | fm_LParenfinally_RParenQuestion?) )* '<#else>' (( finally_      ) ? | fm_LParenfinally_RParenQuestion?) '</#if>';
fm_LParentypeArgumentsOrDiamondRParenQuestion: '<#if' .*? '>' (( typeArgumentsOrDiamond      ) ? | fm_LParentypeArgumentsOrDiamondRParenQuestion?) ('<#elseif' .*? '>' (( typeArgumentsOrDiamond      ) ? | fm_LParentypeArgumentsOrDiamondRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( typeArgumentsOrDiamond      ) ? | fm_LParentypeArgumentsOrDiamondRParenQuestion?) ('<#elseif' .*? '>' (( typeArgumentsOrDiamond      ) ? | fm_LParentypeArgumentsOrDiamondRParenQuestion?) )* '<#else>' (( typeArgumentsOrDiamond      ) ? | fm_LParentypeArgumentsOrDiamondRParenQuestion?) '</#if>';
fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion: '<#if' .*? '>' (( fm_COMMAPlaceHolder     | COMMA      ) ? | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion?) ('<#elseif' .*? '>' (( fm_COMMAPlaceHolder     | COMMA      ) ? | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion?))* '</#if>' | '<#if' .*? '>' (( fm_COMMAPlaceHolder     | COMMA      ) ? | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion?) ('<#elseif' .*? '>' (( fm_COMMAPlaceHolder     | COMMA      ) ? | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion?) )* '<#else>' (( fm_COMMAPlaceHolder     | COMMA      ) ? | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion?) '</#if>';
fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion: '<#if' .*? '>' (( ( fm_IdentifierPlaceHolder     | Identifier      )    ( fm_DOTPlaceHolder     | DOT      )      ) ? | fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion?) ('<#elseif' .*? '>' (( ( fm_IdentifierPlaceHolder     | Identifier      )    ( fm_DOTPlaceHolder     | DOT      )      ) ? | fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( ( fm_IdentifierPlaceHolder     | Identifier      )    ( fm_DOTPlaceHolder     | DOT      )      ) ? | fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion?) ('<#elseif' .*? '>' (( ( fm_IdentifierPlaceHolder     | Identifier      )    ( fm_DOTPlaceHolder     | DOT      )      ) ? | fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion?) )* '<#else>' (( ( fm_IdentifierPlaceHolder     | Identifier      )    ( fm_DOTPlaceHolder     | DOT      )      ) ? | fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion?) '</#if>';
fm_LParendimsRParenQuestion: '<#if' .*? '>' (( dims      ) ? | fm_LParendimsRParenQuestion?) ('<#elseif' .*? '>' (( dims      ) ? | fm_LParendimsRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( dims      ) ? | fm_LParendimsRParenQuestion?) ('<#elseif' .*? '>' (( dims      ) ? | fm_LParendimsRParenQuestion?) )* '<#else>' (( dims      ) ? | fm_LParendimsRParenQuestion?) '</#if>';
fm_LParensuperclassRParenQuestion: '<#if' .*? '>' (( superclass      ) ? | fm_LParensuperclassRParenQuestion?) ('<#elseif' .*? '>' (( superclass      ) ? | fm_LParensuperclassRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( superclass      ) ? | fm_LParensuperclassRParenQuestion?) ('<#elseif' .*? '>' (( superclass      ) ? | fm_LParensuperclassRParenQuestion?) )* '<#else>' (( superclass      ) ? | fm_LParensuperclassRParenQuestion?) '</#if>';
fm_LParenvariableInitializerListRParenQuestion: '<#if' .*? '>' (( variableInitializerList      ) ? | fm_LParenvariableInitializerListRParenQuestion?) ('<#elseif' .*? '>' (( variableInitializerList      ) ? | fm_LParenvariableInitializerListRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( variableInitializerList      ) ? | fm_LParenvariableInitializerListRParenQuestion?) ('<#elseif' .*? '>' (( variableInitializerList      ) ? | fm_LParenvariableInitializerListRParenQuestion?) )* '<#else>' (( variableInitializerList      ) ? | fm_LParenvariableInitializerListRParenQuestion?) '</#if>';
fm_LParenpackageDeclarationRParenQuestion: '<#if' .*? '>' (( packageDeclaration      ) ? | fm_LParenpackageDeclarationRParenQuestion?) ('<#elseif' .*? '>' (( packageDeclaration      ) ? | fm_LParenpackageDeclarationRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( packageDeclaration      ) ? | fm_LParenpackageDeclarationRParenQuestion?) ('<#elseif' .*? '>' (( packageDeclaration      ) ? | fm_LParenpackageDeclarationRParenQuestion?) )* '<#else>' (( packageDeclaration      ) ? | fm_LParenpackageDeclarationRParenQuestion?) '</#if>';
fm_LParenthrows_RParenQuestion: '<#if' .*? '>' (( throws_      ) ? | fm_LParenthrows_RParenQuestion?) ('<#elseif' .*? '>' (( throws_      ) ? | fm_LParenthrows_RParenQuestion?))* '</#if>' | '<#if' .*? '>' (( throws_      ) ? | fm_LParenthrows_RParenQuestion?) ('<#elseif' .*? '>' (( throws_      ) ? | fm_LParenthrows_RParenQuestion?) )* '<#else>' (( throws_      ) ? | fm_LParenthrows_RParenQuestion?) '</#if>';
fm_LParenwildcardBoundsRParenQuestion: '<#if' .*? '>' (( wildcardBounds      ) ? | fm_LParenwildcardBoundsRParenQuestion?) ('<#elseif' .*? '>' (( wildcardBounds      ) ? | fm_LParenwildcardBoundsRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( wildcardBounds      ) ? | fm_LParenwildcardBoundsRParenQuestion?) ('<#elseif' .*? '>' (( wildcardBounds      ) ? | fm_LParenwildcardBoundsRParenQuestion?) )* '<#else>' (( wildcardBounds      ) ? | fm_LParenwildcardBoundsRParenQuestion?) '</#if>';
fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion: '<#if' .*? '>' (( fm_SEMIPlaceHolder     | SEMI      ) ? | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion?) ('<#elseif' .*? '>' (( fm_SEMIPlaceHolder     | SEMI      ) ? | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( fm_SEMIPlaceHolder     | SEMI      ) ? | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion?) ('<#elseif' .*? '>' (( fm_SEMIPlaceHolder     | SEMI      ) ? | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion?) )* '<#else>' (( fm_SEMIPlaceHolder     | SEMI      ) ? | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion?) '</#if>';
fm_newRulexXXx2: '<#if' .*? '>' (( ( fm_LPARENPlaceHolder     | LPAREN      )    ( argumentList      )  ?     ( fm_RPARENPlaceHolder     | RPAREN      )      ) ? | fm_newRulexXXx2?) ('<#elseif' .*? '>' (( ( fm_LPARENPlaceHolder     | LPAREN      )    ( argumentList      )  ?     ( fm_RPARENPlaceHolder     | RPAREN      )      ) ? | fm_newRulexXXx2?))* '</#if>' | '<#if' .*? '>' (( ( fm_LPARENPlaceHolder     | LPAREN      )    ( argumentList      )  ?     ( fm_RPARENPlaceHolder     | RPAREN      )      ) ? | fm_newRulexXXx2?) ('<#elseif' .*? '>' (( ( fm_LPARENPlaceHolder     | LPAREN      )    ( argumentList      )  ?     ( fm_RPARENPlaceHolder     | RPAREN      )      ) ? | fm_newRulexXXx2?) )* '<#else>' (( ( fm_LPARENPlaceHolder     | LPAREN      )    ( argumentList      )  ?     ( fm_RPARENPlaceHolder     | RPAREN      )      ) ? | fm_newRulexXXx2?) '</#if>';
fm_LParenenumConstantListRParenQuestion: '<#if' .*? '>' (( enumConstantList      ) ? | fm_LParenenumConstantListRParenQuestion?) ('<#elseif' .*? '>' (( enumConstantList      ) ? | fm_LParenenumConstantListRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( enumConstantList      ) ? | fm_LParenenumConstantListRParenQuestion?) ('<#elseif' .*? '>' (( enumConstantList      ) ? | fm_LParenenumConstantListRParenQuestion?) )* '<#else>' (( enumConstantList      ) ? | fm_LParenenumConstantListRParenQuestion?) '</#if>';
fm_LParentypeParametersRParenQuestion: '<#if' .*? '>' (( typeParameters      ) ? | fm_LParentypeParametersRParenQuestion?) ('<#elseif' .*? '>' (( typeParameters      ) ? | fm_LParentypeParametersRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( typeParameters      ) ? | fm_LParentypeParametersRParenQuestion?) ('<#elseif' .*? '>' (( typeParameters      ) ? | fm_LParentypeParametersRParenQuestion?) )* '<#else>' (( typeParameters      ) ? | fm_LParentypeParametersRParenQuestion?) '</#if>';
fm_LParendefaultValueRParenQuestion: '<#if' .*? '>' (( defaultValue      ) ? | fm_LParendefaultValueRParenQuestion?) ('<#elseif' .*? '>' (( defaultValue      ) ? | fm_LParendefaultValueRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( defaultValue      ) ? | fm_LParendefaultValueRParenQuestion?) ('<#elseif' .*? '>' (( defaultValue      ) ? | fm_LParendefaultValueRParenQuestion?) )* '<#else>' (( defaultValue      ) ? | fm_LParendefaultValueRParenQuestion?) '</#if>';
fm_LParenenumBodyDeclarationsRParenQuestion: '<#if' .*? '>' (( enumBodyDeclarations      ) ? | fm_LParenenumBodyDeclarationsRParenQuestion?) ('<#elseif' .*? '>' (( enumBodyDeclarations      ) ? | fm_LParenenumBodyDeclarationsRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( enumBodyDeclarations      ) ? | fm_LParenenumBodyDeclarationsRParenQuestion?) ('<#elseif' .*? '>' (( enumBodyDeclarations      ) ? | fm_LParenenumBodyDeclarationsRParenQuestion?) )* '<#else>' (( enumBodyDeclarations      ) ? | fm_LParenenumBodyDeclarationsRParenQuestion?) '</#if>';
fm_LParenclassBodyRParenQuestion: '<#if' .*? '>' (( classBody      ) ? | fm_LParenclassBodyRParenQuestion?) ('<#elseif' .*? '>' (( classBody      ) ? | fm_LParenclassBodyRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( classBody      ) ? | fm_LParenclassBodyRParenQuestion?) ('<#elseif' .*? '>' (( classBody      ) ? | fm_LParenclassBodyRParenQuestion?) )* '<#else>' (( classBody      ) ? | fm_LParenclassBodyRParenQuestion?) '</#if>';
fm_LParenextendsInterfacesRParenQuestion: '<#if' .*? '>' (( extendsInterfaces      ) ? | fm_LParenextendsInterfacesRParenQuestion?) ('<#elseif' .*? '>' (( extendsInterfaces      ) ? | fm_LParenextendsInterfacesRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( extendsInterfaces      ) ? | fm_LParenextendsInterfacesRParenQuestion?) ('<#elseif' .*? '>' (( extendsInterfaces      ) ? | fm_LParenextendsInterfacesRParenQuestion?) )* '<#else>' (( extendsInterfaces      ) ? | fm_LParenextendsInterfacesRParenQuestion?) '</#if>';
fm_LParenblockStatementsRParenQuestion: '<#if' .*? '>' (( blockStatements      ) ? | fm_LParenblockStatementsRParenQuestion?) ('<#elseif' .*? '>' (( blockStatements      ) ? | fm_LParenblockStatementsRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( blockStatements      ) ? | fm_LParenblockStatementsRParenQuestion?) ('<#elseif' .*? '>' (( blockStatements      ) ? | fm_LParenblockStatementsRParenQuestion?) )* '<#else>' (( blockStatements      ) ? | fm_LParenblockStatementsRParenQuestion?) '</#if>';
fm_LParenelementValueListRParenQuestion: '<#if' .*? '>' (( elementValueList      ) ? | fm_LParenelementValueListRParenQuestion?) ('<#elseif' .*? '>' (( elementValueList      ) ? | fm_LParenelementValueListRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( elementValueList      ) ? | fm_LParenelementValueListRParenQuestion?) ('<#elseif' .*? '>' (( elementValueList      ) ? | fm_LParenelementValueListRParenQuestion?) )* '<#else>' (( elementValueList      ) ? | fm_LParenelementValueListRParenQuestion?) '</#if>';
fm_LParenargumentListRParenQuestion: '<#if' .*? '>' (( argumentList      ) ? | fm_LParenargumentListRParenQuestion?) ('<#elseif' .*? '>' (( argumentList      ) ? | fm_LParenargumentListRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( argumentList      ) ? | fm_LParenargumentListRParenQuestion?) ('<#elseif' .*? '>' (( argumentList      ) ? | fm_LParenargumentListRParenQuestion?) )* '<#else>' (( argumentList      ) ? | fm_LParenargumentListRParenQuestion?) '</#if>';
fm_LParentypeArgumentsRParenQuestion: '<#if' .*? '>' (( typeArguments      ) ? | fm_LParentypeArgumentsRParenQuestion?) ('<#elseif' .*? '>' (( typeArguments      ) ? | fm_LParentypeArgumentsRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( typeArguments      ) ? | fm_LParentypeArgumentsRParenQuestion?) ('<#elseif' .*? '>' (( typeArguments      ) ? | fm_LParentypeArgumentsRParenQuestion?) )* '<#else>' (( typeArguments      ) ? | fm_LParentypeArgumentsRParenQuestion?) '</#if>';
fm_LParenforInitRParenQuestion: '<#if' .*? '>' (( forInit      ) ? | fm_LParenforInitRParenQuestion?) ('<#elseif' .*? '>' (( forInit      ) ? | fm_LParenforInitRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( forInit      ) ? | fm_LParenforInitRParenQuestion?) ('<#elseif' .*? '>' (( forInit      ) ? | fm_LParenforInitRParenQuestion?) )* '<#else>' (( forInit      ) ? | fm_LParenforInitRParenQuestion?) '</#if>';
fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion: '<#if' .*? '>' (( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?) ('<#elseif' .*? '>' (( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?) ('<#elseif' .*? '>' (( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?) )* '<#else>' (( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?) '</#if>';
fm_LParenformalParameterListRParenQuestion: '<#if' .*? '>' (( formalParameterList      ) ? | fm_LParenformalParameterListRParenQuestion?) ('<#elseif' .*? '>' (( formalParameterList      ) ? | fm_LParenformalParameterListRParenQuestion?))* '</#if>' | '<#if' .*? '>' (( formalParameterList      ) ? | fm_LParenformalParameterListRParenQuestion?) ('<#elseif' .*? '>' (( formalParameterList      ) ? | fm_LParenformalParameterListRParenQuestion?) )* '<#else>' (( formalParameterList      ) ? | fm_LParenformalParameterListRParenQuestion?) '</#if>';
fm_LParenfm_LEPlaceHolderOrLERParenOne: '<#if' .*? '>' (( fm_LEPlaceHolder     | LE      )  | fm_LParenfm_LEPlaceHolderOrLERParenOne) ('<#elseif' .*? '>' (( fm_LEPlaceHolder     | LE      )  | fm_LParenfm_LEPlaceHolderOrLERParenOne) )* '<#else>' (( fm_LEPlaceHolder     | LE      )  | fm_LParenfm_LEPlaceHolderOrLERParenOne) '</#if>';
fm_LParenambiguousNameRParenOne: '<#if' .*? '>' (( ambiguousName      )  | fm_LParenambiguousNameRParenOne) ('<#elseif' .*? '>' (( ambiguousName      )  | fm_LParenambiguousNameRParenOne) )* '<#else>' (( ambiguousName      )  | fm_LParenambiguousNameRParenOne) '</#if>';
fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne: '<#if' .*? '>' (( fm_WHILEPlaceHolder     | WHILE      )  | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne) ('<#elseif' .*? '>' (( fm_WHILEPlaceHolder     | WHILE      )  | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne) )* '<#else>' (( fm_WHILEPlaceHolder     | WHILE      )  | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne) '</#if>';
fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne: '<#if' .*? '>' (( fm_VOIDPlaceHolder     | VOID      )  | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne) ('<#elseif' .*? '>' (( fm_VOIDPlaceHolder     | VOID      )  | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne) )* '<#else>' (( fm_VOIDPlaceHolder     | VOID      )  | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne) '</#if>';
fm_LParenfm_CHARPlaceHolderOrCHARRParenOne: '<#if' .*? '>' (( fm_CHARPlaceHolder     | CHAR      )  | fm_LParenfm_CHARPlaceHolderOrCHARRParenOne) ('<#elseif' .*? '>' (( fm_CHARPlaceHolder     | CHAR      )  | fm_LParenfm_CHARPlaceHolderOrCHARRParenOne) )* '<#else>' (( fm_CHARPlaceHolder     | CHAR      )  | fm_LParenfm_CHARPlaceHolderOrCHARRParenOne) '</#if>';
fm_LParenfm_IFPlaceHolderOrIFRParenOne: '<#if' .*? '>' (( fm_IFPlaceHolder     | IF      )  | fm_LParenfm_IFPlaceHolderOrIFRParenOne) ('<#elseif' .*? '>' (( fm_IFPlaceHolder     | IF      )  | fm_LParenfm_IFPlaceHolderOrIFRParenOne) )* '<#else>' (( fm_IFPlaceHolder     | IF      )  | fm_LParenfm_IFPlaceHolderOrIFRParenOne) '</#if>';
fm_LParenconstructorDeclaratorRParenOne: '<#if' .*? '>' (( constructorDeclarator      )  | fm_LParenconstructorDeclaratorRParenOne) ('<#elseif' .*? '>' (( constructorDeclarator      )  | fm_LParenconstructorDeclaratorRParenOne) )* '<#else>' (( constructorDeclarator      )  | fm_LParenconstructorDeclaratorRParenOne) '</#if>';
fm_LParenreferenceTypeRParenOne: '<#if' .*? '>' (( referenceType      )  | fm_LParenreferenceTypeRParenOne) ('<#elseif' .*? '>' (( referenceType      )  | fm_LParenreferenceTypeRParenOne) )* '<#else>' (( referenceType      )  | fm_LParenreferenceTypeRParenOne) '</#if>';
fm_newRulexXXx3: '<#if' .*? '>' (( ( expressionName      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )     | ( primaryNoNewArray_lfno_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx3) ('<#elseif' .*? '>' (( ( expressionName      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )     | ( primaryNoNewArray_lfno_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx3) )* '<#else>' (( ( expressionName      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )     | ( primaryNoNewArray_lfno_arrayAccess      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx3) '</#if>';
fm_LParenannotationTypeBodyRParenOne: '<#if' .*? '>' (( annotationTypeBody      )  | fm_LParenannotationTypeBodyRParenOne) ('<#elseif' .*? '>' (( annotationTypeBody      )  | fm_LParenannotationTypeBodyRParenOne) )* '<#else>' (( annotationTypeBody      )  | fm_LParenannotationTypeBodyRParenOne) '</#if>';
fm_LParenwhileStatementNoShortIfRParenOne: '<#if' .*? '>' (( whileStatementNoShortIf      )  | fm_LParenwhileStatementNoShortIfRParenOne) ('<#elseif' .*? '>' (( whileStatementNoShortIf      )  | fm_LParenwhileStatementNoShortIfRParenOne) )* '<#else>' (( whileStatementNoShortIf      )  | fm_LParenwhileStatementNoShortIfRParenOne) '</#if>';
fm_LParenfm_TRYPlaceHolderOrTRYRParenOne: '<#if' .*? '>' (( fm_TRYPlaceHolder     | TRY      )  | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne) ('<#elseif' .*? '>' (( fm_TRYPlaceHolder     | TRY      )  | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne) )* '<#else>' (( fm_TRYPlaceHolder     | TRY      )  | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne) '</#if>';
fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne: '<#if' .*? '>' (( unannClassType_lfno_unannClassOrInterfaceType      )  | fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( unannClassType_lfno_unannClassOrInterfaceType      )  | fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne) )* '<#else>' (( unannClassType_lfno_unannClassOrInterfaceType      )  | fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne) '</#if>';
fm_LParenstatementNoShortIfRParenOne: '<#if' .*? '>' (( statementNoShortIf      )  | fm_LParenstatementNoShortIfRParenOne) ('<#elseif' .*? '>' (( statementNoShortIf      )  | fm_LParenstatementNoShortIfRParenOne) )* '<#else>' (( statementNoShortIf      )  | fm_LParenstatementNoShortIfRParenOne) '</#if>';
fm_LParenfm_FINALPlaceHolderOrFINALRParenOne: '<#if' .*? '>' (( fm_FINALPlaceHolder     | FINAL      )  | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne) ('<#elseif' .*? '>' (( fm_FINALPlaceHolder     | FINAL      )  | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne) )* '<#else>' (( fm_FINALPlaceHolder     | FINAL      )  | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne) '</#if>';
fm_LParenarrayAccess_lfno_primaryRParenOne: '<#if' .*? '>' (( arrayAccess_lfno_primary      )  | fm_LParenarrayAccess_lfno_primaryRParenOne) ('<#elseif' .*? '>' (( arrayAccess_lfno_primary      )  | fm_LParenarrayAccess_lfno_primaryRParenOne) )* '<#else>' (( arrayAccess_lfno_primary      )  | fm_LParenarrayAccess_lfno_primaryRParenOne) '</#if>';
fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne: '<#if' .*? '>' (( fm_QUESTIONPlaceHolder     | QUESTION      )  | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne) ('<#elseif' .*? '>' (( fm_QUESTIONPlaceHolder     | QUESTION      )  | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne) )* '<#else>' (( fm_QUESTIONPlaceHolder     | QUESTION      )  | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne) '</#if>';
fm_LParenfm_SUBPlaceHolderOrSUBRParenOne: '<#if' .*? '>' (( fm_SUBPlaceHolder     | SUB      )  | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne) ('<#elseif' .*? '>' (( fm_SUBPlaceHolder     | SUB      )  | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne) )* '<#else>' (( fm_SUBPlaceHolder     | SUB      )  | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne) '</#if>';
fm_LParenprimaryRParenOne: '<#if' .*? '>' (( primary      )  | fm_LParenprimaryRParenOne) ('<#elseif' .*? '>' (( primary      )  | fm_LParenprimaryRParenOne) )* '<#else>' (( primary      )  | fm_LParenprimaryRParenOne) '</#if>';
fm_LParenclassOrInterfaceTypeRParenOne: '<#if' .*? '>' (( classOrInterfaceType      )  | fm_LParenclassOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( classOrInterfaceType      )  | fm_LParenclassOrInterfaceTypeRParenOne) )* '<#else>' (( classOrInterfaceType      )  | fm_LParenclassOrInterfaceTypeRParenOne) '</#if>';
fm_LParenfieldAccess_lfno_primaryRParenOne: '<#if' .*? '>' (( fieldAccess_lfno_primary      )  | fm_LParenfieldAccess_lfno_primaryRParenOne) ('<#elseif' .*? '>' (( fieldAccess_lfno_primary      )  | fm_LParenfieldAccess_lfno_primaryRParenOne) )* '<#else>' (( fieldAccess_lfno_primary      )  | fm_LParenfieldAccess_lfno_primaryRParenOne) '</#if>';
fm_LParentypeParameterListRParenOne: '<#if' .*? '>' (( typeParameterList      )  | fm_LParentypeParameterListRParenOne) ('<#elseif' .*? '>' (( typeParameterList      )  | fm_LParentypeParameterListRParenOne) )* '<#else>' (( typeParameterList      )  | fm_LParentypeParameterListRParenOne) '</#if>';
fm_LParentypeImportOnDemandDeclarationRParenOne: '<#if' .*? '>' (( typeImportOnDemandDeclaration      )  | fm_LParentypeImportOnDemandDeclarationRParenOne) ('<#elseif' .*? '>' (( typeImportOnDemandDeclaration      )  | fm_LParentypeImportOnDemandDeclarationRParenOne) )* '<#else>' (( typeImportOnDemandDeclaration      )  | fm_LParentypeImportOnDemandDeclarationRParenOne) '</#if>';
fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne: '<#if' .*? '>' (( fm_TRANSIENTPlaceHolder     | TRANSIENT      )  | fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne) ('<#elseif' .*? '>' (( fm_TRANSIENTPlaceHolder     | TRANSIENT      )  | fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne) )* '<#else>' (( fm_TRANSIENTPlaceHolder     | TRANSIENT      )  | fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne) '</#if>';
fm_LParenstatementRParenOne: '<#if' .*? '>' (( statement      )  | fm_LParenstatementRParenOne) ('<#elseif' .*? '>' (( statement      )  | fm_LParenstatementRParenOne) )* '<#else>' (( statement      )  | fm_LParenstatementRParenOne) '</#if>';
fm_newRulexXXx5: '<#if' .*? '>' (( ( primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx5) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx5) )* '<#else>' (( ( primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx5) '</#if>';
fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne: '<#if' .*? '>' (( fm_EQUALPlaceHolder     | EQUAL      )  | fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne) ('<#elseif' .*? '>' (( fm_EQUALPlaceHolder     | EQUAL      )  | fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne) )* '<#else>' (( fm_EQUALPlaceHolder     | EQUAL      )  | fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne) '</#if>';
fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne: '<#if' .*? '>' (( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )  | fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )  | fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne) )* '<#else>' (( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )  | fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne) '</#if>';
fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne: '<#if' .*? '>' (( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )  | fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )  | fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne) )* '<#else>' (( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )  | fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne) '</#if>';
fm_LParenenumDeclarationRParenOne: '<#if' .*? '>' (( enumDeclaration      )  | fm_LParenenumDeclarationRParenOne) ('<#elseif' .*? '>' (( enumDeclaration      )  | fm_LParenenumDeclarationRParenOne) )* '<#else>' (( enumDeclaration      )  | fm_LParenenumDeclarationRParenOne) '</#if>';
fm_LParenexclusiveOrExpressionRParenOne: '<#if' .*? '>' (( exclusiveOrExpression      )  | fm_LParenexclusiveOrExpressionRParenOne) ('<#elseif' .*? '>' (( exclusiveOrExpression      )  | fm_LParenexclusiveOrExpressionRParenOne) )* '<#else>' (( exclusiveOrExpression      )  | fm_LParenexclusiveOrExpressionRParenOne) '</#if>';
fm_LParenresourceSpecificationRParenOne: '<#if' .*? '>' (( resourceSpecification      )  | fm_LParenresourceSpecificationRParenOne) ('<#elseif' .*? '>' (( resourceSpecification      )  | fm_LParenresourceSpecificationRParenOne) )* '<#else>' (( resourceSpecification      )  | fm_LParenresourceSpecificationRParenOne) '</#if>';
fm_LParentypeArgumentsRParenOne: '<#if' .*? '>' (( typeArguments      )  | fm_LParentypeArgumentsRParenOne) ('<#elseif' .*? '>' (( typeArguments      )  | fm_LParentypeArgumentsRParenOne) )* '<#else>' (( typeArguments      )  | fm_LParentypeArgumentsRParenOne) '</#if>';
fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne: '<#if' .*? '>' (( fm_RPARENPlaceHolder     | RPAREN      )  | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ('<#elseif' .*? '>' (( fm_RPARENPlaceHolder     | RPAREN      )  | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) )* '<#else>' (( fm_RPARENPlaceHolder     | RPAREN      )  | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) '</#if>';
fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne: '<#if' .*? '>' (( fm_ABSTRACTPlaceHolder     | ABSTRACT      )  | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne) ('<#elseif' .*? '>' (( fm_ABSTRACTPlaceHolder     | ABSTRACT      )  | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne) )* '<#else>' (( fm_ABSTRACTPlaceHolder     | ABSTRACT      )  | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne) '</#if>';
fm_LParenprimaryNoNewArray_lfno_primaryRParenOne: '<#if' .*? '>' (( primaryNoNewArray_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primaryRParenOne) ('<#elseif' .*? '>' (( primaryNoNewArray_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primaryRParenOne) )* '<#else>' (( primaryNoNewArray_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primaryRParenOne) '</#if>';
fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne: '<#if' .*? '>' (( fm_ASSIGNPlaceHolder     | ASSIGN      )  | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_ASSIGNPlaceHolder     | ASSIGN      )  | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) )* '<#else>' (( fm_ASSIGNPlaceHolder     | ASSIGN      )  | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) '</#if>';
fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne: '<#if' .*? '>' (( fm_CLASSPlaceHolder     | CLASS      )  | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne) ('<#elseif' .*? '>' (( fm_CLASSPlaceHolder     | CLASS      )  | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne) )* '<#else>' (( fm_CLASSPlaceHolder     | CLASS      )  | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne) '</#if>';
fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne: '<#if' .*? '>' (( ( primary      )     | ( expressionName      )      )  | fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne) ('<#elseif' .*? '>' (( ( primary      )     | ( expressionName      )      )  | fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne) )* '<#else>' (( ( primary      )     | ( expressionName      )      )  | fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne) '</#if>';
fm_LParenfm_CASEPlaceHolderOrCASERParenOne: '<#if' .*? '>' (( fm_CASEPlaceHolder     | CASE      )  | fm_LParenfm_CASEPlaceHolderOrCASERParenOne) ('<#elseif' .*? '>' (( fm_CASEPlaceHolder     | CASE      )  | fm_LParenfm_CASEPlaceHolderOrCASERParenOne) )* '<#else>' (( fm_CASEPlaceHolder     | CASE      )  | fm_LParenfm_CASEPlaceHolderOrCASERParenOne) '</#if>';
fm_LParencontinueStatementRParenOne: '<#if' .*? '>' (( continueStatement      )  | fm_LParencontinueStatementRParenOne) ('<#elseif' .*? '>' (( continueStatement      )  | fm_LParencontinueStatementRParenOne) )* '<#else>' (( continueStatement      )  | fm_LParencontinueStatementRParenOne) '</#if>';
fm_LParenunannClassOrInterfaceTypeRParenOne: '<#if' .*? '>' (( unannClassOrInterfaceType      )  | fm_LParenunannClassOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( unannClassOrInterfaceType      )  | fm_LParenunannClassOrInterfaceTypeRParenOne) )* '<#else>' (( unannClassOrInterfaceType      )  | fm_LParenunannClassOrInterfaceTypeRParenOne) '</#if>';
fm_LParenfinally_RParenOne: '<#if' .*? '>' (( finally_      )  | fm_LParenfinally_RParenOne) ('<#elseif' .*? '>' (( finally_      )  | fm_LParenfinally_RParenOne) )* '<#else>' (( finally_      )  | fm_LParenfinally_RParenOne) '</#if>';
fm_LParenpostfixExpressionRParenOne: '<#if' .*? '>' (( postfixExpression      )  | fm_LParenpostfixExpressionRParenOne) ('<#elseif' .*? '>' (( postfixExpression      )  | fm_LParenpostfixExpressionRParenOne) )* '<#else>' (( postfixExpression      )  | fm_LParenpostfixExpressionRParenOne) '</#if>';
fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne: '<#if' .*? '>' (( classInstanceCreationExpression_lfno_primary      )  | fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne) ('<#elseif' .*? '>' (( classInstanceCreationExpression_lfno_primary      )  | fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne) )* '<#else>' (( classInstanceCreationExpression_lfno_primary      )  | fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne) '</#if>';
fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne: '<#if' .*? '>' (( unannClassType_lf_unannClassOrInterfaceType      )  | fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( unannClassType_lf_unannClassOrInterfaceType      )  | fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne) )* '<#else>' (( unannClassType_lf_unannClassOrInterfaceType      )  | fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne) '</#if>';
fm_LParenfm_BITORPlaceHolderOrBITORRParenOne: '<#if' .*? '>' (( fm_BITORPlaceHolder     | BITOR      )  | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne) ('<#elseif' .*? '>' (( fm_BITORPlaceHolder     | BITOR      )  | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne) )* '<#else>' (( fm_BITORPlaceHolder     | BITOR      )  | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne) '</#if>';
fm_LParencatchTypeRParenOne: '<#if' .*? '>' (( catchType      )  | fm_LParencatchTypeRParenOne) ('<#elseif' .*? '>' (( catchType      )  | fm_LParencatchTypeRParenOne) )* '<#else>' (( catchType      )  | fm_LParencatchTypeRParenOne) '</#if>';
fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne: '<#if' .*? '>' (( fm_CATCHPlaceHolder     | CATCH      )  | fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne) ('<#elseif' .*? '>' (( fm_CATCHPlaceHolder     | CATCH      )  | fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne) )* '<#else>' (( fm_CATCHPlaceHolder     | CATCH      )  | fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne) '</#if>';
fm_LParenunannPrimitiveTypeRParenOne: '<#if' .*? '>' (( unannPrimitiveType      )  | fm_LParenunannPrimitiveTypeRParenOne) ('<#elseif' .*? '>' (( unannPrimitiveType      )  | fm_LParenunannPrimitiveTypeRParenOne) )* '<#else>' (( unannPrimitiveType      )  | fm_LParenunannPrimitiveTypeRParenOne) '</#if>';
fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne: '<#if' .*? '>' (( fm_PACKAGEPlaceHolder     | PACKAGE      )  | fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne) ('<#elseif' .*? '>' (( fm_PACKAGEPlaceHolder     | PACKAGE      )  | fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne) )* '<#else>' (( fm_PACKAGEPlaceHolder     | PACKAGE      )  | fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne) '</#if>';
fm_LParensingleStaticImportDeclarationRParenOne: '<#if' .*? '>' (( singleStaticImportDeclaration      )  | fm_LParensingleStaticImportDeclarationRParenOne) ('<#elseif' .*? '>' (( singleStaticImportDeclaration      )  | fm_LParensingleStaticImportDeclarationRParenOne) )* '<#else>' (( singleStaticImportDeclaration      )  | fm_LParensingleStaticImportDeclarationRParenOne) '</#if>';
fm_LParenfm_LTPlaceHolderOrLTRParenOne: '<#if' .*? '>' (( fm_LTPlaceHolder     | LT      )  | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ('<#elseif' .*? '>' (( fm_LTPlaceHolder     | LT      )  | fm_LParenfm_LTPlaceHolderOrLTRParenOne) )* '<#else>' (( fm_LTPlaceHolder     | LT      )  | fm_LParenfm_LTPlaceHolderOrLTRParenOne) '</#if>';
fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne: '<#if' .*? '>' (( fm_DOUBLEPlaceHolder     | DOUBLE      )  | fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne) ('<#elseif' .*? '>' (( fm_DOUBLEPlaceHolder     | DOUBLE      )  | fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne) )* '<#else>' (( fm_DOUBLEPlaceHolder     | DOUBLE      )  | fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne) '</#if>';
fm_LParenlocalVariableDeclarationStatementRParenOne: '<#if' .*? '>' (( localVariableDeclarationStatement      )  | fm_LParenlocalVariableDeclarationStatementRParenOne) ('<#elseif' .*? '>' (( localVariableDeclarationStatement      )  | fm_LParenlocalVariableDeclarationStatementRParenOne) )* '<#else>' (( localVariableDeclarationStatement      )  | fm_LParenlocalVariableDeclarationStatementRParenOne) '</#if>';
fm_LPareninterfaceBodyRParenOne: '<#if' .*? '>' (( interfaceBody      )  | fm_LPareninterfaceBodyRParenOne) ('<#elseif' .*? '>' (( interfaceBody      )  | fm_LPareninterfaceBodyRParenOne) )* '<#else>' (( interfaceBody      )  | fm_LPareninterfaceBodyRParenOne) '</#if>';
fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne: '<#if' .*? '>' (( unannInterfaceType_lf_unannClassOrInterfaceType      )  | fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( unannInterfaceType_lf_unannClassOrInterfaceType      )  | fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne) )* '<#else>' (( unannInterfaceType_lf_unannClassOrInterfaceType      )  | fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne) '</#if>';
fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne: '<#if' .*? '>' (( fm_PRIVATEPlaceHolder     | PRIVATE      )  | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne) ('<#elseif' .*? '>' (( fm_PRIVATEPlaceHolder     | PRIVATE      )  | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne) )* '<#else>' (( fm_PRIVATEPlaceHolder     | PRIVATE      )  | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne) '</#if>';
fm_LParenifThenStatementRParenOne: '<#if' .*? '>' (( ifThenStatement      )  | fm_LParenifThenStatementRParenOne) ('<#elseif' .*? '>' (( ifThenStatement      )  | fm_LParenifThenStatementRParenOne) )* '<#else>' (( ifThenStatement      )  | fm_LParenifThenStatementRParenOne) '</#if>';
fm_LParenconditionalAndExpressionRParenOne: '<#if' .*? '>' (( conditionalAndExpression      )  | fm_LParenconditionalAndExpressionRParenOne) ('<#elseif' .*? '>' (( conditionalAndExpression      )  | fm_LParenconditionalAndExpressionRParenOne) )* '<#else>' (( conditionalAndExpression      )  | fm_LParenconditionalAndExpressionRParenOne) '</#if>';
fm_LParensingleElementAnnotationRParenOne: '<#if' .*? '>' (( singleElementAnnotation      )  | fm_LParensingleElementAnnotationRParenOne) ('<#elseif' .*? '>' (( singleElementAnnotation      )  | fm_LParensingleElementAnnotationRParenOne) )* '<#else>' (( singleElementAnnotation      )  | fm_LParensingleElementAnnotationRParenOne) '</#if>';
fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne: '<#if' .*? '>' (( fm_DEFAULTPlaceHolder     | DEFAULT      )  | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne) ('<#elseif' .*? '>' (( fm_DEFAULTPlaceHolder     | DEFAULT      )  | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne) )* '<#else>' (( fm_DEFAULTPlaceHolder     | DEFAULT      )  | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne) '</#if>';
fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne: '<#if' .*? '>' (( fm_SEMIPlaceHolder     | SEMI      )  | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ('<#elseif' .*? '>' (( fm_SEMIPlaceHolder     | SEMI      )  | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) )* '<#else>' (( fm_SEMIPlaceHolder     | SEMI      )  | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) '</#if>';
fm_LParenstatementExpressionRParenOne: '<#if' .*? '>' (( statementExpression      )  | fm_LParenstatementExpressionRParenOne) ('<#elseif' .*? '>' (( statementExpression      )  | fm_LParenstatementExpressionRParenOne) )* '<#else>' (( statementExpression      )  | fm_LParenstatementExpressionRParenOne) '</#if>';
fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne: '<#if' .*? '>' (( postIncrementExpression_lf_postfixExpression      )  | fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne) ('<#elseif' .*? '>' (( postIncrementExpression_lf_postfixExpression      )  | fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne) )* '<#else>' (( postIncrementExpression_lf_postfixExpression      )  | fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne) '</#if>';
fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne: '<#if' .*? '>' (( ( classType_lfno_classOrInterfaceType      )     | ( interfaceType_lfno_classOrInterfaceType      )      )  | fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne) ('<#elseif' .*? '>' (( ( classType_lfno_classOrInterfaceType      )     | ( interfaceType_lfno_classOrInterfaceType      )      )  | fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne) )* '<#else>' (( ( classType_lfno_classOrInterfaceType      )     | ( interfaceType_lfno_classOrInterfaceType      )      )  | fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne) '</#if>';
fm_LParenformalParameterRParenOne: '<#if' .*? '>' (( formalParameter      )  | fm_LParenformalParameterRParenOne) ('<#elseif' .*? '>' (( formalParameter      )  | fm_LParenformalParameterRParenOne) )* '<#else>' (( formalParameter      )  | fm_LParenformalParameterRParenOne) '</#if>';
fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne: '<#if' .*? '>' (( fm_LPARENPlaceHolder     | LPAREN      )  | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ('<#elseif' .*? '>' (( fm_LPARENPlaceHolder     | LPAREN      )  | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) )* '<#else>' (( fm_LPARENPlaceHolder     | LPAREN      )  | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) '</#if>';
fm_LParenmethodBodyRParenOne: '<#if' .*? '>' (( methodBody      )  | fm_LParenmethodBodyRParenOne) ('<#elseif' .*? '>' (( methodBody      )  | fm_LParenmethodBodyRParenOne) )* '<#else>' (( methodBody      )  | fm_LParenmethodBodyRParenOne) '</#if>';
fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne: '<#if' .*? '>' (( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne) ('<#elseif' .*? '>' (( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne) )* '<#else>' (( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne) '</#if>';
fm_LParenifThenElseStatementNoShortIfRParenOne: '<#if' .*? '>' (( ifThenElseStatementNoShortIf      )  | fm_LParenifThenElseStatementNoShortIfRParenOne) ('<#elseif' .*? '>' (( ifThenElseStatementNoShortIf      )  | fm_LParenifThenElseStatementNoShortIfRParenOne) )* '<#else>' (( ifThenElseStatementNoShortIf      )  | fm_LParenifThenElseStatementNoShortIfRParenOne) '</#if>';
fm_LParenmarkerAnnotationRParenOne: '<#if' .*? '>' (( markerAnnotation      )  | fm_LParenmarkerAnnotationRParenOne) ('<#elseif' .*? '>' (( markerAnnotation      )  | fm_LParenmarkerAnnotationRParenOne) )* '<#else>' (( markerAnnotation      )  | fm_LParenmarkerAnnotationRParenOne) '</#if>';
fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne: '<#if' .*? '>' (( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )  | fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )  | fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne) )* '<#else>' (( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )  | fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne) '</#if>';
fm_LParenfm_ANDPlaceHolderOrANDRParenOne: '<#if' .*? '>' (( fm_ANDPlaceHolder     | AND      )  | fm_LParenfm_ANDPlaceHolderOrANDRParenOne) ('<#elseif' .*? '>' (( fm_ANDPlaceHolder     | AND      )  | fm_LParenfm_ANDPlaceHolderOrANDRParenOne) )* '<#else>' (( fm_ANDPlaceHolder     | AND      )  | fm_LParenfm_ANDPlaceHolderOrANDRParenOne) '</#if>';
fm_LPareninclusiveOrExpressionRParenOne: '<#if' .*? '>' (( inclusiveOrExpression      )  | fm_LPareninclusiveOrExpressionRParenOne) ('<#elseif' .*? '>' (( inclusiveOrExpression      )  | fm_LPareninclusiveOrExpressionRParenOne) )* '<#else>' (( inclusiveOrExpression      )  | fm_LPareninclusiveOrExpressionRParenOne) '</#if>';
fm_LParenconstructorDeclarationRParenOne: '<#if' .*? '>' (( constructorDeclaration      )  | fm_LParenconstructorDeclarationRParenOne) ('<#elseif' .*? '>' (( constructorDeclaration      )  | fm_LParenconstructorDeclarationRParenOne) )* '<#else>' (( constructorDeclaration      )  | fm_LParenconstructorDeclarationRParenOne) '</#if>';
fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne: '<#if' .*? '>' (( fm_LBRACEPlaceHolder     | LBRACE      )  | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ('<#elseif' .*? '>' (( fm_LBRACEPlaceHolder     | LBRACE      )  | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) )* '<#else>' (( fm_LBRACEPlaceHolder     | LBRACE      )  | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) '</#if>';
fm_LParenreturnStatementRParenOne: '<#if' .*? '>' (( returnStatement      )  | fm_LParenreturnStatementRParenOne) ('<#elseif' .*? '>' (( returnStatement      )  | fm_LParenreturnStatementRParenOne) )* '<#else>' (( returnStatement      )  | fm_LParenreturnStatementRParenOne) '</#if>';
fm_LParenfm_GTPlaceHolderOrGTRParenOne: '<#if' .*? '>' (( fm_GTPlaceHolder     | GT      )  | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ('<#elseif' .*? '>' (( fm_GTPlaceHolder     | GT      )  | fm_LParenfm_GTPlaceHolderOrGTRParenOne) )* '<#else>' (( fm_GTPlaceHolder     | GT      )  | fm_LParenfm_GTPlaceHolderOrGTRParenOne) '</#if>';
fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne: '<#if' .*? '>' (( primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne) ('<#elseif' .*? '>' (( primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne) )* '<#else>' (( primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne) '</#if>';
fm_LParenarrayAccess_lf_primaryRParenOne: '<#if' .*? '>' (( arrayAccess_lf_primary      )  | fm_LParenarrayAccess_lf_primaryRParenOne) ('<#elseif' .*? '>' (( arrayAccess_lf_primary      )  | fm_LParenarrayAccess_lf_primaryRParenOne) )* '<#else>' (( arrayAccess_lf_primary      )  | fm_LParenarrayAccess_lf_primaryRParenOne) '</#if>';
fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne: '<#if' .*? '>' (( interfaceType_lf_classOrInterfaceType      )  | fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( interfaceType_lf_classOrInterfaceType      )  | fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne) )* '<#else>' (( interfaceType_lf_classOrInterfaceType      )  | fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne) '</#if>';
fm_LParenfm_LONGPlaceHolderOrLONGRParenOne: '<#if' .*? '>' (( fm_LONGPlaceHolder     | LONG      )  | fm_LParenfm_LONGPlaceHolderOrLONGRParenOne) ('<#elseif' .*? '>' (( fm_LONGPlaceHolder     | LONG      )  | fm_LParenfm_LONGPlaceHolderOrLONGRParenOne) )* '<#else>' (( fm_LONGPlaceHolder     | LONG      )  | fm_LParenfm_LONGPlaceHolderOrLONGRParenOne) '</#if>';
fm_LParenexpressionRParenOne: '<#if' .*? '>' (( expression      )  | fm_LParenexpressionRParenOne) ('<#elseif' .*? '>' (( expression      )  | fm_LParenexpressionRParenOne) )* '<#else>' (( expression      )  | fm_LParenexpressionRParenOne) '</#if>';
fm_LParenconstantExpressionRParenOne: '<#if' .*? '>' (( constantExpression      )  | fm_LParenconstantExpressionRParenOne) ('<#elseif' .*? '>' (( constantExpression      )  | fm_LParenconstantExpressionRParenOne) )* '<#else>' (( constantExpression      )  | fm_LParenconstantExpressionRParenOne) '</#if>';
fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne: '<#if' .*? '>' (( fm_IMPORTPlaceHolder     | IMPORT      )  | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne) ('<#elseif' .*? '>' (( fm_IMPORTPlaceHolder     | IMPORT      )  | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne) )* '<#else>' (( fm_IMPORTPlaceHolder     | IMPORT      )  | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne) '</#if>';
fm_LParenarrayAccessRParenOne: '<#if' .*? '>' (( arrayAccess      )  | fm_LParenarrayAccessRParenOne) ('<#elseif' .*? '>' (( arrayAccess      )  | fm_LParenarrayAccessRParenOne) )* '<#else>' (( arrayAccess      )  | fm_LParenarrayAccessRParenOne) '</#if>';
fm_LParentypeArgumentRParenOne: '<#if' .*? '>' (( typeArgument      )  | fm_LParentypeArgumentRParenOne) ('<#elseif' .*? '>' (( typeArgument      )  | fm_LParentypeArgumentRParenOne) )* '<#else>' (( typeArgument      )  | fm_LParentypeArgumentRParenOne) '</#if>';
fm_LParenfm_ARROWPlaceHolderOrARROWRParenOne: '<#if' .*? '>' (( fm_ARROWPlaceHolder     | ARROW      )  | fm_LParenfm_ARROWPlaceHolderOrARROWRParenOne) ('<#elseif' .*? '>' (( fm_ARROWPlaceHolder     | ARROW      )  | fm_LParenfm_ARROWPlaceHolderOrARROWRParenOne) )* '<#else>' (( fm_ARROWPlaceHolder     | ARROW      )  | fm_LParenfm_ARROWPlaceHolderOrARROWRParenOne) '</#if>';
fm_LParenpreDecrementExpressionRParenOne: '<#if' .*? '>' (( preDecrementExpression      )  | fm_LParenpreDecrementExpressionRParenOne) ('<#elseif' .*? '>' (( preDecrementExpression      )  | fm_LParenpreDecrementExpressionRParenOne) )* '<#else>' (( preDecrementExpression      )  | fm_LParenpreDecrementExpressionRParenOne) '</#if>';
fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne: '<#if' .*? '>' (( fm_ELLIPSISPlaceHolder     | ELLIPSIS      )  | fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne) ('<#elseif' .*? '>' (( fm_ELLIPSISPlaceHolder     | ELLIPSIS      )  | fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne) )* '<#else>' (( fm_ELLIPSISPlaceHolder     | ELLIPSIS      )  | fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne) '</#if>';
fm_LParenswitchLabelsRParenOne: '<#if' .*? '>' (( switchLabels      )  | fm_LParenswitchLabelsRParenOne) ('<#elseif' .*? '>' (( switchLabels      )  | fm_LParenswitchLabelsRParenOne) )* '<#else>' (( switchLabels      )  | fm_LParenswitchLabelsRParenOne) '</#if>';
fm_LParenarrayInitializerRParenOne: '<#if' .*? '>' (( arrayInitializer      )  | fm_LParenarrayInitializerRParenOne) ('<#elseif' .*? '>' (( arrayInitializer      )  | fm_LParenarrayInitializerRParenOne) )* '<#else>' (( arrayInitializer      )  | fm_LParenarrayInitializerRParenOne) '</#if>';
fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne: '<#if' .*? '>' (( fm_RBRACKPlaceHolder     | RBRACK      )  | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne) ('<#elseif' .*? '>' (( fm_RBRACKPlaceHolder     | RBRACK      )  | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne) )* '<#else>' (( fm_RBRACKPlaceHolder     | RBRACK      )  | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne) '</#if>';
fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne: '<#if' .*? '>' (( fm_BITANDPlaceHolder     | BITAND      )  | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne) ('<#elseif' .*? '>' (( fm_BITANDPlaceHolder     | BITAND      )  | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne) )* '<#else>' (( fm_BITANDPlaceHolder     | BITAND      )  | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne) '</#if>';
fm_LParennormalInterfaceDeclarationRParenOne: '<#if' .*? '>' (( normalInterfaceDeclaration      )  | fm_LParennormalInterfaceDeclarationRParenOne) ('<#elseif' .*? '>' (( normalInterfaceDeclaration      )  | fm_LParennormalInterfaceDeclarationRParenOne) )* '<#else>' (( normalInterfaceDeclaration      )  | fm_LParennormalInterfaceDeclarationRParenOne) '</#if>';
fm_LParenmethodDeclaratorRParenOne: '<#if' .*? '>' (( methodDeclarator      )  | fm_LParenmethodDeclaratorRParenOne) ('<#elseif' .*? '>' (( methodDeclarator      )  | fm_LParenmethodDeclaratorRParenOne) )* '<#else>' (( methodDeclarator      )  | fm_LParenmethodDeclaratorRParenOne) '</#if>';
fm_LParentypeParameterRParenOne: '<#if' .*? '>' (( typeParameter      )  | fm_LParentypeParameterRParenOne) ('<#elseif' .*? '>' (( typeParameter      )  | fm_LParentypeParameterRParenOne) )* '<#else>' (( typeParameter      )  | fm_LParentypeParameterRParenOne) '</#if>';
fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne: '<#if' .*? '>' (( fm_FloatingPointLiteralPlaceHolder     | FloatingPointLiteral      )  | fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne) ('<#elseif' .*? '>' (( fm_FloatingPointLiteralPlaceHolder     | FloatingPointLiteral      )  | fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne) )* '<#else>' (( fm_FloatingPointLiteralPlaceHolder     | FloatingPointLiteral      )  | fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne) '</#if>';
fm_LParennormalAnnotationRParenOne: '<#if' .*? '>' (( normalAnnotation      )  | fm_LParennormalAnnotationRParenOne) ('<#elseif' .*? '>' (( normalAnnotation      )  | fm_LParennormalAnnotationRParenOne) )* '<#else>' (( normalAnnotation      )  | fm_LParennormalAnnotationRParenOne) '</#if>';
fm_LParentypeVariableRParenOne: '<#if' .*? '>' (( typeVariable      )  | fm_LParentypeVariableRParenOne) ('<#elseif' .*? '>' (( typeVariable      )  | fm_LParentypeVariableRParenOne) )* '<#else>' (( typeVariable      )  | fm_LParentypeVariableRParenOne) '</#if>';
fm_LParenmethodReferenceRParenOne: '<#if' .*? '>' (( methodReference      )  | fm_LParenmethodReferenceRParenOne) ('<#elseif' .*? '>' (( methodReference      )  | fm_LParenmethodReferenceRParenOne) )* '<#else>' (( methodReference      )  | fm_LParenmethodReferenceRParenOne) '</#if>';
fm_LParenmethodHeaderRParenOne: '<#if' .*? '>' (( methodHeader      )  | fm_LParenmethodHeaderRParenOne) ('<#elseif' .*? '>' (( methodHeader      )  | fm_LParenmethodHeaderRParenOne) )* '<#else>' (( methodHeader      )  | fm_LParenmethodHeaderRParenOne) '</#if>';
fm_LParenliteralRParenOne: '<#if' .*? '>' (( literal      )  | fm_LParenliteralRParenOne) ('<#elseif' .*? '>' (( literal      )  | fm_LParenliteralRParenOne) )* '<#else>' (( literal      )  | fm_LParenliteralRParenOne) '</#if>';
fm_LParencatchClauseRParenOne: '<#if' .*? '>' (( catchClause      )  | fm_LParencatchClauseRParenOne) ('<#elseif' .*? '>' (( catchClause      )  | fm_LParencatchClauseRParenOne) )* '<#else>' (( catchClause      )  | fm_LParencatchClauseRParenOne) '</#if>';
fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne: '<#if' .*? '>' (( unannInterfaceType_lfno_unannClassOrInterfaceType      )  | fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( unannInterfaceType_lfno_unannClassOrInterfaceType      )  | fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne) )* '<#else>' (( unannInterfaceType_lfno_unannClassOrInterfaceType      )  | fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne) '</#if>';
fm_LParenclassTypeRParenOne: '<#if' .*? '>' (( classType      )  | fm_LParenclassTypeRParenOne) ('<#elseif' .*? '>' (( classType      )  | fm_LParenclassTypeRParenOne) )* '<#else>' (( classType      )  | fm_LParenclassTypeRParenOne) '</#if>';
fm_LParenclassInstanceCreationExpressionRParenOne: '<#if' .*? '>' (( classInstanceCreationExpression      )  | fm_LParenclassInstanceCreationExpressionRParenOne) ('<#elseif' .*? '>' (( classInstanceCreationExpression      )  | fm_LParenclassInstanceCreationExpressionRParenOne) )* '<#else>' (( classInstanceCreationExpression      )  | fm_LParenclassInstanceCreationExpressionRParenOne) '</#if>';
fm_LParenfm_THISPlaceHolderOrTHISRParenOne: '<#if' .*? '>' (( fm_THISPlaceHolder     | THIS      )  | fm_LParenfm_THISPlaceHolderOrTHISRParenOne) ('<#elseif' .*? '>' (( fm_THISPlaceHolder     | THIS      )  | fm_LParenfm_THISPlaceHolderOrTHISRParenOne) )* '<#else>' (( fm_THISPlaceHolder     | THIS      )  | fm_LParenfm_THISPlaceHolderOrTHISRParenOne) '</#if>';
fm_LParenunannTypeVariableRParenOne: '<#if' .*? '>' (( unannTypeVariable      )  | fm_LParenunannTypeVariableRParenOne) ('<#elseif' .*? '>' (( unannTypeVariable      )  | fm_LParenunannTypeVariableRParenOne) )* '<#else>' (( unannTypeVariable      )  | fm_LParenunannTypeVariableRParenOne) '</#if>';
fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne: '<#if' .*? '>' (( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )  | fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )  | fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne) )* '<#else>' (( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )  | fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne) '</#if>';
fm_LParenunannArrayTypeRParenOne: '<#if' .*? '>' (( unannArrayType      )  | fm_LParenunannArrayTypeRParenOne) ('<#elseif' .*? '>' (( unannArrayType      )  | fm_LParenunannArrayTypeRParenOne) )* '<#else>' (( unannArrayType      )  | fm_LParenunannArrayTypeRParenOne) '</#if>';
fm_LParendimExprsRParenOne: '<#if' .*? '>' (( dimExprs      )  | fm_LParendimExprsRParenOne) ('<#elseif' .*? '>' (( dimExprs      )  | fm_LParendimExprsRParenOne) )* '<#else>' (( dimExprs      )  | fm_LParendimExprsRParenOne) '</#if>';
fm_LParenintegralTypeRParenOne: '<#if' .*? '>' (( integralType      )  | fm_LParenintegralTypeRParenOne) ('<#elseif' .*? '>' (( integralType      )  | fm_LParenintegralTypeRParenOne) )* '<#else>' (( integralType      )  | fm_LParenintegralTypeRParenOne) '</#if>';
fm_LParenclassBodyRParenOne: '<#if' .*? '>' (( classBody      )  | fm_LParenclassBodyRParenOne) ('<#elseif' .*? '>' (( classBody      )  | fm_LParenclassBodyRParenOne) )* '<#else>' (( classBody      )  | fm_LParenclassBodyRParenOne) '</#if>';
fm_LParenassignmentExpressionRParenOne: '<#if' .*? '>' (( assignmentExpression      )  | fm_LParenassignmentExpressionRParenOne) ('<#elseif' .*? '>' (( assignmentExpression      )  | fm_LParenassignmentExpressionRParenOne) )* '<#else>' (( assignmentExpression      )  | fm_LParenassignmentExpressionRParenOne) '</#if>';
fm_LParenvariableDeclaratorIdRParenOne: '<#if' .*? '>' (( variableDeclaratorId      )  | fm_LParenvariableDeclaratorIdRParenOne) ('<#elseif' .*? '>' (( variableDeclaratorId      )  | fm_LParenvariableDeclaratorIdRParenOne) )* '<#else>' (( variableDeclaratorId      )  | fm_LParenvariableDeclaratorIdRParenOne) '</#if>';
fm_LParenblockStatementsRParenOne: '<#if' .*? '>' (( blockStatements      )  | fm_LParenblockStatementsRParenOne) ('<#elseif' .*? '>' (( blockStatements      )  | fm_LParenblockStatementsRParenOne) )* '<#else>' (( blockStatements      )  | fm_LParenblockStatementsRParenOne) '</#if>';
fm_LParenenumConstantNameRParenOne: '<#if' .*? '>' (( enumConstantName      )  | fm_LParenenumConstantNameRParenOne) ('<#elseif' .*? '>' (( enumConstantName      )  | fm_LParenenumConstantNameRParenOne) )* '<#else>' (( enumConstantName      )  | fm_LParenenumConstantNameRParenOne) '</#if>';
fm_LParenifThenElseStatementRParenOne: '<#if' .*? '>' (( ifThenElseStatement      )  | fm_LParenifThenElseStatementRParenOne) ('<#elseif' .*? '>' (( ifThenElseStatement      )  | fm_LParenifThenElseStatementRParenOne) )* '<#else>' (( ifThenElseStatement      )  | fm_LParenifThenElseStatementRParenOne) '</#if>';
fm_LParenstaticImportOnDemandDeclarationRParenOne: '<#if' .*? '>' (( staticImportOnDemandDeclaration      )  | fm_LParenstaticImportOnDemandDeclarationRParenOne) ('<#elseif' .*? '>' (( staticImportOnDemandDeclaration      )  | fm_LParenstaticImportOnDemandDeclarationRParenOne) )* '<#else>' (( staticImportOnDemandDeclaration      )  | fm_LParenstaticImportOnDemandDeclarationRParenOne) '</#if>';
fm_LParenfm_MULPlaceHolderOrMULRParenOne: '<#if' .*? '>' (( fm_MULPlaceHolder     | MUL      )  | fm_LParenfm_MULPlaceHolderOrMULRParenOne) ('<#elseif' .*? '>' (( fm_MULPlaceHolder     | MUL      )  | fm_LParenfm_MULPlaceHolderOrMULRParenOne) )* '<#else>' (( fm_MULPlaceHolder     | MUL      )  | fm_LParenfm_MULPlaceHolderOrMULRParenOne) '</#if>';
fm_LParenlambdaParametersRParenOne: '<#if' .*? '>' (( lambdaParameters      )  | fm_LParenlambdaParametersRParenOne) ('<#elseif' .*? '>' (( lambdaParameters      )  | fm_LParenlambdaParametersRParenOne) )* '<#else>' (( lambdaParameters      )  | fm_LParenlambdaParametersRParenOne) '</#if>';
fm_LParenpostIncrementExpressionRParenOne: '<#if' .*? '>' (( postIncrementExpression      )  | fm_LParenpostIncrementExpressionRParenOne) ('<#elseif' .*? '>' (( postIncrementExpression      )  | fm_LParenpostIncrementExpressionRParenOne) )* '<#else>' (( postIncrementExpression      )  | fm_LParenpostIncrementExpressionRParenOne) '</#if>';
fm_LParenenumConstantRParenOne: '<#if' .*? '>' (( enumConstant      )  | fm_LParenenumConstantRParenOne) ('<#elseif' .*? '>' (( enumConstant      )  | fm_LParenenumConstantRParenOne) )* '<#else>' (( enumConstant      )  | fm_LParenenumConstantRParenOne) '</#if>';
fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne: '<#if' .*? '>' (( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )  | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne) ('<#elseif' .*? '>' (( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )  | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne) )* '<#else>' (( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )  | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne) '</#if>';
fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne: '<#if' .*? '>' (( fm_INSTANCEOFPlaceHolder     | INSTANCEOF      )  | fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne) ('<#elseif' .*? '>' (( fm_INSTANCEOFPlaceHolder     | INSTANCEOF      )  | fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne) )* '<#else>' (( fm_INSTANCEOFPlaceHolder     | INSTANCEOF      )  | fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne) '</#if>';
fm_LParenfm_ORPlaceHolderOrORRParenOne: '<#if' .*? '>' (( fm_ORPlaceHolder     | OR      )  | fm_LParenfm_ORPlaceHolderOrORRParenOne) ('<#elseif' .*? '>' (( fm_ORPlaceHolder     | OR      )  | fm_LParenfm_ORPlaceHolderOrORRParenOne) )* '<#else>' (( fm_ORPlaceHolder     | OR      )  | fm_LParenfm_ORPlaceHolderOrORRParenOne) '</#if>';
fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne: '<#if' .*? '>' (( fm_ENUMPlaceHolder     | ENUM      )  | fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne) ('<#elseif' .*? '>' (( fm_ENUMPlaceHolder     | ENUM      )  | fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne) )* '<#else>' (( fm_ENUMPlaceHolder     | ENUM      )  | fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne) '</#if>';
fm_LParenfm_DECPlaceHolderOrDECRParenOne: '<#if' .*? '>' (( fm_DECPlaceHolder     | DEC      )  | fm_LParenfm_DECPlaceHolderOrDECRParenOne) ('<#elseif' .*? '>' (( fm_DECPlaceHolder     | DEC      )  | fm_LParenfm_DECPlaceHolderOrDECRParenOne) )* '<#else>' (( fm_DECPlaceHolder     | DEC      )  | fm_LParenfm_DECPlaceHolderOrDECRParenOne) '</#if>';
fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne: '<#if' .*? '>' (( fm_COLONCOLONPlaceHolder     | COLONCOLON      )  | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) ('<#elseif' .*? '>' (( fm_COLONCOLONPlaceHolder     | COLONCOLON      )  | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) )* '<#else>' (( fm_COLONCOLONPlaceHolder     | COLONCOLON      )  | fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne) '</#if>';
fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne: '<#if' .*? '>' (( primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne) ('<#elseif' .*? '>' (( primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne) )* '<#else>' (( primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne) '</#if>';
fm_LParenunaryExpressionRParenOne: '<#if' .*? '>' (( unaryExpression      )  | fm_LParenunaryExpressionRParenOne) ('<#elseif' .*? '>' (( unaryExpression      )  | fm_LParenunaryExpressionRParenOne) )* '<#else>' (( unaryExpression      )  | fm_LParenunaryExpressionRParenOne) '</#if>';
fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne: '<#if' .*? '>' (( fm_VOLATILEPlaceHolder     | VOLATILE      )  | fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne) ('<#elseif' .*? '>' (( fm_VOLATILEPlaceHolder     | VOLATILE      )  | fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne) )* '<#else>' (( fm_VOLATILEPlaceHolder     | VOLATILE      )  | fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne) '</#if>';
fm_LParenmethodDeclarationRParenOne: '<#if' .*? '>' (( methodDeclaration      )  | fm_LParenmethodDeclarationRParenOne) ('<#elseif' .*? '>' (( methodDeclaration      )  | fm_LParenmethodDeclarationRParenOne) )* '<#else>' (( methodDeclaration      )  | fm_LParenmethodDeclarationRParenOne) '</#if>';
fm_LParenrelationalExpressionRParenOne: '<#if' .*? '>' (( relationalExpression      )  | fm_LParenrelationalExpressionRParenOne) ('<#elseif' .*? '>' (( relationalExpression      )  | fm_LParenrelationalExpressionRParenOne) )* '<#else>' (( relationalExpression      )  | fm_LParenrelationalExpressionRParenOne) '</#if>';
fm_LParenvariableDeclaratorListRParenOne: '<#if' .*? '>' (( variableDeclaratorList      )  | fm_LParenvariableDeclaratorListRParenOne) ('<#elseif' .*? '>' (( variableDeclaratorList      )  | fm_LParenvariableDeclaratorListRParenOne) )* '<#else>' (( variableDeclaratorList      )  | fm_LParenvariableDeclaratorListRParenOne) '</#if>';
fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne: '<#if' .*? '>' (( fm_STATICPlaceHolder     | STATIC      )  | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne) ('<#elseif' .*? '>' (( fm_STATICPlaceHolder     | STATIC      )  | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne) )* '<#else>' (( fm_STATICPlaceHolder     | STATIC      )  | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne) '</#if>';
fm_LPareninterfaceTypeListRParenOne: '<#if' .*? '>' (( interfaceTypeList      )  | fm_LPareninterfaceTypeListRParenOne) ('<#elseif' .*? '>' (( interfaceTypeList      )  | fm_LPareninterfaceTypeListRParenOne) )* '<#else>' (( interfaceTypeList      )  | fm_LPareninterfaceTypeListRParenOne) '</#if>';
fm_LParenemptyStatementRParenOne: '<#if' .*? '>' (( emptyStatement      )  | fm_LParenemptyStatementRParenOne) ('<#elseif' .*? '>' (( emptyStatement      )  | fm_LParenemptyStatementRParenOne) )* '<#else>' (( emptyStatement      )  | fm_LParenemptyStatementRParenOne) '</#if>';
fm_LParenfm_ELSEPlaceHolderOrELSERParenOne: '<#if' .*? '>' (( fm_ELSEPlaceHolder     | ELSE      )  | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne) ('<#elseif' .*? '>' (( fm_ELSEPlaceHolder     | ELSE      )  | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne) )* '<#else>' (( fm_ELSEPlaceHolder     | ELSE      )  | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne) '</#if>';
fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne: '<#if' .*? '>' (( fm_THROWSPlaceHolder     | THROWS      )  | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne) ('<#elseif' .*? '>' (( fm_THROWSPlaceHolder     | THROWS      )  | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne) )* '<#else>' (( fm_THROWSPlaceHolder     | THROWS      )  | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne) '</#if>';
fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne: '<#if' .*? '>' (( fm_SUPERPlaceHolder     | SUPER      )  | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ('<#elseif' .*? '>' (( fm_SUPERPlaceHolder     | SUPER      )  | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) )* '<#else>' (( fm_SUPERPlaceHolder     | SUPER      )  | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) '</#if>';
fm_LParenmethodReference_lfno_primaryRParenOne: '<#if' .*? '>' (( methodReference_lfno_primary      )  | fm_LParenmethodReference_lfno_primaryRParenOne) ('<#elseif' .*? '>' (( methodReference_lfno_primary      )  | fm_LParenmethodReference_lfno_primaryRParenOne) )* '<#else>' (( methodReference_lfno_primary      )  | fm_LParenmethodReference_lfno_primaryRParenOne) '</#if>';
fm_LParenfm_FORPlaceHolderOrFORRParenOne: '<#if' .*? '>' (( fm_FORPlaceHolder     | FOR      )  | fm_LParenfm_FORPlaceHolderOrFORRParenOne) ('<#elseif' .*? '>' (( fm_FORPlaceHolder     | FOR      )  | fm_LParenfm_FORPlaceHolderOrFORRParenOne) )* '<#else>' (( fm_FORPlaceHolder     | FOR      )  | fm_LParenfm_FORPlaceHolderOrFORRParenOne) '</#if>';
fm_LParensingleTypeImportDeclarationRParenOne: '<#if' .*? '>' (( singleTypeImportDeclaration      )  | fm_LParensingleTypeImportDeclarationRParenOne) ('<#elseif' .*? '>' (( singleTypeImportDeclaration      )  | fm_LParensingleTypeImportDeclarationRParenOne) )* '<#else>' (( singleTypeImportDeclaration      )  | fm_LParensingleTypeImportDeclarationRParenOne) '</#if>';
fm_LParenassignmentOperatorRParenOne: '<#if' .*? '>' (( assignmentOperator      )  | fm_LParenassignmentOperatorRParenOne) ('<#elseif' .*? '>' (( assignmentOperator      )  | fm_LParenassignmentOperatorRParenOne) )* '<#else>' (( assignmentOperator      )  | fm_LParenassignmentOperatorRParenOne) '</#if>';
fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne: '<#if' .*? '>' (( primaryNoNewArray_lfno_arrayAccess      )  | fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne) ('<#elseif' .*? '>' (( primaryNoNewArray_lfno_arrayAccess      )  | fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne) )* '<#else>' (( primaryNoNewArray_lfno_arrayAccess      )  | fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne) '</#if>';
fm_LParenenumBodyRParenOne: '<#if' .*? '>' (( enumBody      )  | fm_LParenenumBodyRParenOne) ('<#elseif' .*? '>' (( enumBody      )  | fm_LParenenumBodyRParenOne) )* '<#else>' (( enumBody      )  | fm_LParenenumBodyRParenOne) '</#if>';
fm_LParenexpressionStatementRParenOne: '<#if' .*? '>' (( expressionStatement      )  | fm_LParenexpressionStatementRParenOne) ('<#elseif' .*? '>' (( expressionStatement      )  | fm_LParenexpressionStatementRParenOne) )* '<#else>' (( expressionStatement      )  | fm_LParenexpressionStatementRParenOne) '</#if>';
fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne: '<#if' .*? '>' (( postDecrementExpression_lf_postfixExpression      )  | fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne) ('<#elseif' .*? '>' (( postDecrementExpression_lf_postfixExpression      )  | fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne) )* '<#else>' (( postDecrementExpression_lf_postfixExpression      )  | fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne) '</#if>';
fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne: '<#if' .*? '>' (( fm_PROTECTEDPlaceHolder     | PROTECTED      )  | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne) ('<#elseif' .*? '>' (( fm_PROTECTEDPlaceHolder     | PROTECTED      )  | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne) )* '<#else>' (( fm_PROTECTEDPlaceHolder     | PROTECTED      )  | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne) '</#if>';
fm_LParentryWithResourcesStatementRParenOne: '<#if' .*? '>' (( tryWithResourcesStatement      )  | fm_LParentryWithResourcesStatementRParenOne) ('<#elseif' .*? '>' (( tryWithResourcesStatement      )  | fm_LParentryWithResourcesStatementRParenOne) )* '<#else>' (( tryWithResourcesStatement      )  | fm_LParentryWithResourcesStatementRParenOne) '</#if>';
fm_LParenconstantDeclarationRParenOne: '<#if' .*? '>' (( constantDeclaration      )  | fm_LParenconstantDeclarationRParenOne) ('<#elseif' .*? '>' (( constantDeclaration      )  | fm_LParenconstantDeclarationRParenOne) )* '<#else>' (( constantDeclaration      )  | fm_LParenconstantDeclarationRParenOne) '</#if>';
fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne: '<#if' .*? '>' (( fm_CharacterLiteralPlaceHolder     | CharacterLiteral      )  | fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne) ('<#elseif' .*? '>' (( fm_CharacterLiteralPlaceHolder     | CharacterLiteral      )  | fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne) )* '<#else>' (( fm_CharacterLiteralPlaceHolder     | CharacterLiteral      )  | fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne) '</#if>';
fm_LParenfieldAccessRParenOne: '<#if' .*? '>' (( fieldAccess      )  | fm_LParenfieldAccessRParenOne) ('<#elseif' .*? '>' (( fieldAccess      )  | fm_LParenfieldAccessRParenOne) )* '<#else>' (( fieldAccess      )  | fm_LParenfieldAccessRParenOne) '</#if>';
fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne: '<#if' .*? '>' (( fm_ASSERTPlaceHolder     | ASSERT      )  | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne) ('<#elseif' .*? '>' (( fm_ASSERTPlaceHolder     | ASSERT      )  | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne) )* '<#else>' (( fm_ASSERTPlaceHolder     | ASSERT      )  | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne) '</#if>';
fm_LParenfloatingPointTypeRParenOne: '<#if' .*? '>' (( floatingPointType      )  | fm_LParenfloatingPointTypeRParenOne) ('<#elseif' .*? '>' (( floatingPointType      )  | fm_LParenfloatingPointTypeRParenOne) )* '<#else>' (( floatingPointType      )  | fm_LParenfloatingPointTypeRParenOne) '</#if>';
fm_LParendimExprRParenOne: '<#if' .*? '>' (( dimExpr      )  | fm_LParendimExprRParenOne) ('<#elseif' .*? '>' (( dimExpr      )  | fm_LParendimExprRParenOne) )* '<#else>' (( dimExpr      )  | fm_LParendimExprRParenOne) '</#if>';
fm_LParenmethodInvocation_lfno_primaryRParenOne: '<#if' .*? '>' (( methodInvocation_lfno_primary      )  | fm_LParenmethodInvocation_lfno_primaryRParenOne) ('<#elseif' .*? '>' (( methodInvocation_lfno_primary      )  | fm_LParenmethodInvocation_lfno_primaryRParenOne) )* '<#else>' (( methodInvocation_lfno_primary      )  | fm_LParenmethodInvocation_lfno_primaryRParenOne) '</#if>';
fm_LParenformalParametersRParenOne: '<#if' .*? '>' (( formalParameters      )  | fm_LParenformalParametersRParenOne) ('<#elseif' .*? '>' (( formalParameters      )  | fm_LParenformalParametersRParenOne) )* '<#else>' (( formalParameters      )  | fm_LParenformalParametersRParenOne) '</#if>';
fm_LParenelementValuePairRParenOne: '<#if' .*? '>' (( elementValuePair      )  | fm_LParenelementValuePairRParenOne) ('<#elseif' .*? '>' (( elementValuePair      )  | fm_LParenelementValuePairRParenOne) )* '<#else>' (( elementValuePair      )  | fm_LParenelementValuePairRParenOne) '</#if>';
fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne: '<#if' .*? '>' (( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )  | fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )  | fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne) )* '<#else>' (( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )  | fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne) '</#if>';
fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne: '<#if' .*? '>' (( fm_BREAKPlaceHolder     | BREAK      )  | fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne) ('<#elseif' .*? '>' (( fm_BREAKPlaceHolder     | BREAK      )  | fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne) )* '<#else>' (( fm_BREAKPlaceHolder     | BREAK      )  | fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne) '</#if>';
fm_LParensynchronizedStatementRParenOne: '<#if' .*? '>' (( synchronizedStatement      )  | fm_LParensynchronizedStatementRParenOne) ('<#elseif' .*? '>' (( synchronizedStatement      )  | fm_LParensynchronizedStatementRParenOne) )* '<#else>' (( synchronizedStatement      )  | fm_LParensynchronizedStatementRParenOne) '</#if>';
fm_LParenfieldAccess_lf_primaryRParenOne: '<#if' .*? '>' (( fieldAccess_lf_primary      )  | fm_LParenfieldAccess_lf_primaryRParenOne) ('<#elseif' .*? '>' (( fieldAccess_lf_primary      )  | fm_LParenfieldAccess_lf_primaryRParenOne) )* '<#else>' (( fieldAccess_lf_primary      )  | fm_LParenfieldAccess_lf_primaryRParenOne) '</#if>';
fm_LParenprimaryNoNewArray_lf_primaryRParenOne: '<#if' .*? '>' (( primaryNoNewArray_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primaryRParenOne) ('<#elseif' .*? '>' (( primaryNoNewArray_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primaryRParenOne) )* '<#else>' (( primaryNoNewArray_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primaryRParenOne) '</#if>';
fm_LParenlabeledStatementRParenOne: '<#if' .*? '>' (( labeledStatement      )  | fm_LParenlabeledStatementRParenOne) ('<#elseif' .*? '>' (( labeledStatement      )  | fm_LParenlabeledStatementRParenOne) )* '<#else>' (( labeledStatement      )  | fm_LParenlabeledStatementRParenOne) '</#if>';
fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne: '<#if' .*? '>' (( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )  | fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )  | fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne) )* '<#else>' (( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )  | fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne) '</#if>';
fm_LParenarrayTypeRParenOne: '<#if' .*? '>' (( arrayType      )  | fm_LParenarrayTypeRParenOne) ('<#elseif' .*? '>' (( arrayType      )  | fm_LParenarrayTypeRParenOne) )* '<#else>' (( arrayType      )  | fm_LParenarrayTypeRParenOne) '</#if>';
fm_LParenclassDeclarationRParenOne: '<#if' .*? '>' (( classDeclaration      )  | fm_LParenclassDeclarationRParenOne) ('<#elseif' .*? '>' (( classDeclaration      )  | fm_LParenclassDeclarationRParenOne) )* '<#else>' (( classDeclaration      )  | fm_LParenclassDeclarationRParenOne) '</#if>';
fm_LParenunannClassTypeRParenOne: '<#if' .*? '>' (( unannClassType      )  | fm_LParenunannClassTypeRParenOne) ('<#elseif' .*? '>' (( unannClassType      )  | fm_LParenunannClassTypeRParenOne) )* '<#else>' (( unannClassType      )  | fm_LParenunannClassTypeRParenOne) '</#if>';
fm_LParenunannTypeRParenOne: '<#if' .*? '>' (( unannType      )  | fm_LParenunannTypeRParenOne) ('<#elseif' .*? '>' (( unannType      )  | fm_LParenunannTypeRParenOne) )* '<#else>' (( unannType      )  | fm_LParenunannTypeRParenOne) '</#if>';
fm_LParenresourceListRParenOne: '<#if' .*? '>' (( resourceList      )  | fm_LParenresourceListRParenOne) ('<#elseif' .*? '>' (( resourceList      )  | fm_LParenresourceListRParenOne) )* '<#else>' (( resourceList      )  | fm_LParenresourceListRParenOne) '</#if>';
fm_LParentypeArgumentListRParenOne: '<#if' .*? '>' (( typeArgumentList      )  | fm_LParentypeArgumentListRParenOne) ('<#elseif' .*? '>' (( typeArgumentList      )  | fm_LParentypeArgumentListRParenOne) )* '<#else>' (( typeArgumentList      )  | fm_LParentypeArgumentListRParenOne) '</#if>';
fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne: '<#if' .*? '>' (( fm_LBRACKPlaceHolder     | LBRACK      )  | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ('<#elseif' .*? '>' (( fm_LBRACKPlaceHolder     | LBRACK      )  | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) )* '<#else>' (( fm_LBRACKPlaceHolder     | LBRACK      )  | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) '</#if>';
fm_LParenprimitiveTypeRParenOne: '<#if' .*? '>' (( primitiveType      )  | fm_LParenprimitiveTypeRParenOne) ('<#elseif' .*? '>' (( primitiveType      )  | fm_LParenprimitiveTypeRParenOne) )* '<#else>' (( primitiveType      )  | fm_LParenprimitiveTypeRParenOne) '</#if>';
fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne: '<#if' .*? '>' (( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )  | fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )  | fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne) )* '<#else>' (( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )  | fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne) '</#if>';
fm_LParenassignmentRParenOne: '<#if' .*? '>' (( assignment      )  | fm_LParenassignmentRParenOne) ('<#elseif' .*? '>' (( assignment      )  | fm_LParenassignmentRParenOne) )* '<#else>' (( assignment      )  | fm_LParenassignmentRParenOne) '</#if>';
fm_LParentypeParametersRParenOne: '<#if' .*? '>' (( typeParameters      )  | fm_LParentypeParametersRParenOne) ('<#elseif' .*? '>' (( typeParameters      )  | fm_LParentypeParametersRParenOne) )* '<#else>' (( typeParameters      )  | fm_LParentypeParametersRParenOne) '</#if>';
fm_LParenenhancedForStatementRParenOne: '<#if' .*? '>' (( enhancedForStatement      )  | fm_LParenenhancedForStatementRParenOne) ('<#elseif' .*? '>' (( enhancedForStatement      )  | fm_LParenenhancedForStatementRParenOne) )* '<#else>' (( enhancedForStatement      )  | fm_LParenenhancedForStatementRParenOne) '</#if>';
fm_LParenresourceRParenOne: '<#if' .*? '>' (( resource      )  | fm_LParenresourceRParenOne) ('<#elseif' .*? '>' (( resource      )  | fm_LParenresourceRParenOne) )* '<#else>' (( resource      )  | fm_LParenresourceRParenOne) '</#if>';
fm_LParenfieldDeclarationRParenOne: '<#if' .*? '>' (( fieldDeclaration      )  | fm_LParenfieldDeclarationRParenOne) ('<#elseif' .*? '>' (( fieldDeclaration      )  | fm_LParenfieldDeclarationRParenOne) )* '<#else>' (( fieldDeclaration      )  | fm_LParenfieldDeclarationRParenOne) '</#if>';
fm_LParenconditionalExpressionRParenOne: '<#if' .*? '>' (( conditionalExpression      )  | fm_LParenconditionalExpressionRParenOne) ('<#elseif' .*? '>' (( conditionalExpression      )  | fm_LParenconditionalExpressionRParenOne) )* '<#else>' (( conditionalExpression      )  | fm_LParenconditionalExpressionRParenOne) '</#if>';
fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne: '<#if' .*? '>' (( fm_THROWPlaceHolder     | THROW      )  | fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne) ('<#elseif' .*? '>' (( fm_THROWPlaceHolder     | THROW      )  | fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne) )* '<#else>' (( fm_THROWPlaceHolder     | THROW      )  | fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne) '</#if>';
fm_LParenfm_DOTPlaceHolderOrDOTRParenOne: '<#if' .*? '>' (( fm_DOTPlaceHolder     | DOT      )  | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ('<#elseif' .*? '>' (( fm_DOTPlaceHolder     | DOT      )  | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) )* '<#else>' (( fm_DOTPlaceHolder     | DOT      )  | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) '</#if>';
fm_LPareninterfaceMethodDeclarationRParenOne: '<#if' .*? '>' (( interfaceMethodDeclaration      )  | fm_LPareninterfaceMethodDeclarationRParenOne) ('<#elseif' .*? '>' (( interfaceMethodDeclaration      )  | fm_LPareninterfaceMethodDeclarationRParenOne) )* '<#else>' (( interfaceMethodDeclaration      )  | fm_LPareninterfaceMethodDeclarationRParenOne) '</#if>';
fm_LPareninstanceInitializerRParenOne: '<#if' .*? '>' (( instanceInitializer      )  | fm_LPareninstanceInitializerRParenOne) ('<#elseif' .*? '>' (( instanceInitializer      )  | fm_LPareninstanceInitializerRParenOne) )* '<#else>' (( instanceInitializer      )  | fm_LPareninstanceInitializerRParenOne) '</#if>';
fm_LParenfm_INTPlaceHolderOrINTRParenOne: '<#if' .*? '>' (( fm_INTPlaceHolder     | INT      )  | fm_LParenfm_INTPlaceHolderOrINTRParenOne) ('<#elseif' .*? '>' (( fm_INTPlaceHolder     | INT      )  | fm_LParenfm_INTPlaceHolderOrINTRParenOne) )* '<#else>' (( fm_INTPlaceHolder     | INT      )  | fm_LParenfm_INTPlaceHolderOrINTRParenOne) '</#if>';
fm_LParenelementValueArrayInitializerRParenOne: '<#if' .*? '>' (( elementValueArrayInitializer      )  | fm_LParenelementValueArrayInitializerRParenOne) ('<#elseif' .*? '>' (( elementValueArrayInitializer      )  | fm_LParenelementValueArrayInitializerRParenOne) )* '<#else>' (( elementValueArrayInitializer      )  | fm_LParenelementValueArrayInitializerRParenOne) '</#if>';
fm_LParenfm_DOPlaceHolderOrDORParenOne: '<#if' .*? '>' (( fm_DOPlaceHolder     | DO      )  | fm_LParenfm_DOPlaceHolderOrDORParenOne) ('<#elseif' .*? '>' (( fm_DOPlaceHolder     | DO      )  | fm_LParenfm_DOPlaceHolderOrDORParenOne) )* '<#else>' (( fm_DOPlaceHolder     | DO      )  | fm_LParenfm_DOPlaceHolderOrDORParenOne) '</#if>';
fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne: '<#if' .*? '>' (( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )  | fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )  | fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne) )* '<#else>' (( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )  | fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne) '</#if>';
fm_LParenpostDecrementExpressionRParenOne: '<#if' .*? '>' (( postDecrementExpression      )  | fm_LParenpostDecrementExpressionRParenOne) ('<#elseif' .*? '>' (( postDecrementExpression      )  | fm_LParenpostDecrementExpressionRParenOne) )* '<#else>' (( postDecrementExpression      )  | fm_LParenpostDecrementExpressionRParenOne) '</#if>';
fm_LParenadditiveExpressionRParenOne: '<#if' .*? '>' (( additiveExpression      )  | fm_LParenadditiveExpressionRParenOne) ('<#elseif' .*? '>' (( additiveExpression      )  | fm_LParenadditiveExpressionRParenOne) )* '<#else>' (( additiveExpression      )  | fm_LParenadditiveExpressionRParenOne) '</#if>';
fm_LParenstatementWithoutTrailingSubstatementRParenOne: '<#if' .*? '>' (( statementWithoutTrailingSubstatement      )  | fm_LParenstatementWithoutTrailingSubstatementRParenOne) ('<#elseif' .*? '>' (( statementWithoutTrailingSubstatement      )  | fm_LParenstatementWithoutTrailingSubstatementRParenOne) )* '<#else>' (( statementWithoutTrailingSubstatement      )  | fm_LParenstatementWithoutTrailingSubstatementRParenOne) '</#if>';
fm_LPareninferredFormalParameterListRParenOne: '<#if' .*? '>' (( inferredFormalParameterList      )  | fm_LPareninferredFormalParameterListRParenOne) ('<#elseif' .*? '>' (( inferredFormalParameterList      )  | fm_LPareninferredFormalParameterListRParenOne) )* '<#else>' (( inferredFormalParameterList      )  | fm_LPareninferredFormalParameterListRParenOne) '</#if>';
fm_LParenstatementExpressionListRParenOne: '<#if' .*? '>' (( statementExpressionList      )  | fm_LParenstatementExpressionListRParenOne) ('<#elseif' .*? '>' (( statementExpressionList      )  | fm_LParenstatementExpressionListRParenOne) )* '<#else>' (( statementExpressionList      )  | fm_LParenstatementExpressionListRParenOne) '</#if>';
fm_LParenmultiplicativeExpressionRParenOne: '<#if' .*? '>' (( multiplicativeExpression      )  | fm_LParenmultiplicativeExpressionRParenOne) ('<#elseif' .*? '>' (( multiplicativeExpression      )  | fm_LParenmultiplicativeExpressionRParenOne) )* '<#else>' (( multiplicativeExpression      )  | fm_LParenmultiplicativeExpressionRParenOne) '</#if>';
fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne: '<#if' .*? '>' (( fm_SWITCHPlaceHolder     | SWITCH      )  | fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne) ('<#elseif' .*? '>' (( fm_SWITCHPlaceHolder     | SWITCH      )  | fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne) )* '<#else>' (( fm_SWITCHPlaceHolder     | SWITCH      )  | fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne) '</#if>';
fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne: '<#if' .*? '>' (( fm_CONTINUEPlaceHolder     | CONTINUE      )  | fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne) ('<#elseif' .*? '>' (( fm_CONTINUEPlaceHolder     | CONTINUE      )  | fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne) )* '<#else>' (( fm_CONTINUEPlaceHolder     | CONTINUE      )  | fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne) '</#if>';
fm_LParenswitchBlockRParenOne: '<#if' .*? '>' (( switchBlock      )  | fm_LParenswitchBlockRParenOne) ('<#elseif' .*? '>' (( switchBlock      )  | fm_LParenswitchBlockRParenOne) )* '<#else>' (( switchBlock      )  | fm_LParenswitchBlockRParenOne) '</#if>';
fm_LParenmethodNameRParenOne: '<#if' .*? '>' (( methodName      )  | fm_LParenmethodNameRParenOne) ('<#elseif' .*? '>' (( methodName      )  | fm_LParenmethodNameRParenOne) )* '<#else>' (( methodName      )  | fm_LParenmethodNameRParenOne) '</#if>';
fm_LParenexceptionTypeListRParenOne: '<#if' .*? '>' (( exceptionTypeList      )  | fm_LParenexceptionTypeListRParenOne) ('<#elseif' .*? '>' (( exceptionTypeList      )  | fm_LParenexceptionTypeListRParenOne) )* '<#else>' (( exceptionTypeList      )  | fm_LParenexceptionTypeListRParenOne) '</#if>';
fm_LParenpackageOrTypeNameRParenOne: '<#if' .*? '>' (( packageOrTypeName      )  | fm_LParenpackageOrTypeNameRParenOne) ('<#elseif' .*? '>' (( packageOrTypeName      )  | fm_LParenpackageOrTypeNameRParenOne) )* '<#else>' (( packageOrTypeName      )  | fm_LParenpackageOrTypeNameRParenOne) '</#if>';
fm_LParenunaryExpressionNotPlusMinusRParenOne: '<#if' .*? '>' (( unaryExpressionNotPlusMinus      )  | fm_LParenunaryExpressionNotPlusMinusRParenOne) ('<#elseif' .*? '>' (( unaryExpressionNotPlusMinus      )  | fm_LParenunaryExpressionNotPlusMinusRParenOne) )* '<#else>' (( unaryExpressionNotPlusMinus      )  | fm_LParenunaryExpressionNotPlusMinusRParenOne) '</#if>';
fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne: '<#if' .*? '>' (( fm_BOOLEANPlaceHolder     | BOOLEAN      )  | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne) ('<#elseif' .*? '>' (( fm_BOOLEANPlaceHolder     | BOOLEAN      )  | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne) )* '<#else>' (( fm_BOOLEANPlaceHolder     | BOOLEAN      )  | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne) '</#if>';
fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne: '<#if' .*? '>' (( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne) ('<#elseif' .*? '>' (( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne) )* '<#else>' (( primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary      )  | fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne) '</#if>';
fm_LParenannotationTypeElementDeclarationRParenOne: '<#if' .*? '>' (( annotationTypeElementDeclaration      )  | fm_LParenannotationTypeElementDeclarationRParenOne) ('<#elseif' .*? '>' (( annotationTypeElementDeclaration      )  | fm_LParenannotationTypeElementDeclarationRParenOne) )* '<#else>' (( annotationTypeElementDeclaration      )  | fm_LParenannotationTypeElementDeclarationRParenOne) '</#if>';
fm_newRulexXXx7: '<#if' .*? '>' (( ( expressionName      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )     | ( primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx7) ('<#elseif' .*? '>' (( ( expressionName      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )     | ( primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx7) )* '<#else>' (( ( expressionName      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )     | ( primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary      )    ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  | fm_newRulexXXx7) '</#if>';
fm_LParenwhileStatementRParenOne: '<#if' .*? '>' (( whileStatement      )  | fm_LParenwhileStatementRParenOne) ('<#elseif' .*? '>' (( whileStatement      )  | fm_LParenwhileStatementRParenOne) )* '<#else>' (( whileStatement      )  | fm_LParenwhileStatementRParenOne) '</#if>';
fm_LParenmethodInvocationRParenOne: '<#if' .*? '>' (( methodInvocation      )  | fm_LParenmethodInvocationRParenOne) ('<#elseif' .*? '>' (( methodInvocation      )  | fm_LParenmethodInvocationRParenOne) )* '<#else>' (( methodInvocation      )  | fm_LParenmethodInvocationRParenOne) '</#if>';
fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne: '<#if' .*? '>' (( primaryNoNewArray_lf_arrayAccess      )  | fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne) ('<#elseif' .*? '>' (( primaryNoNewArray_lf_arrayAccess      )  | fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne) )* '<#else>' (( primaryNoNewArray_lf_arrayAccess      )  | fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne) '</#if>';
fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne: '<#if' .*? '>' (( fm_BooleanLiteralPlaceHolder     | BooleanLiteral      )  | fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne) ('<#elseif' .*? '>' (( fm_BooleanLiteralPlaceHolder     | BooleanLiteral      )  | fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne) )* '<#else>' (( fm_BooleanLiteralPlaceHolder     | BooleanLiteral      )  | fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne) '</#if>';
fm_LParenexceptionTypeRParenOne: '<#if' .*? '>' (( exceptionType      )  | fm_LParenexceptionTypeRParenOne) ('<#elseif' .*? '>' (( exceptionType      )  | fm_LParenexceptionTypeRParenOne) )* '<#else>' (( exceptionType      )  | fm_LParenexceptionTypeRParenOne) '</#if>';
fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne: '<#if' .*? '>' (( fm_EXTENDSPlaceHolder     | EXTENDS      )  | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ('<#elseif' .*? '>' (( fm_EXTENDSPlaceHolder     | EXTENDS      )  | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) )* '<#else>' (( fm_EXTENDSPlaceHolder     | EXTENDS      )  | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) '</#if>';
fm_LParenconditionalOrExpressionRParenOne: '<#if' .*? '>' (( conditionalOrExpression      )  | fm_LParenconditionalOrExpressionRParenOne) ('<#elseif' .*? '>' (( conditionalOrExpression      )  | fm_LParenconditionalOrExpressionRParenOne) )* '<#else>' (( conditionalOrExpression      )  | fm_LParenconditionalOrExpressionRParenOne) '</#if>';
fm_LParenannotationRParenOne: '<#if' .*? '>' (( annotation      )  | fm_LParenannotationRParenOne) ('<#elseif' .*? '>' (( annotation      )  | fm_LParenannotationRParenOne) )* '<#else>' (( annotation      )  | fm_LParenannotationRParenOne) '</#if>';
fm_LPareninterfaceTypeRParenOne: '<#if' .*? '>' (( interfaceType      )  | fm_LPareninterfaceTypeRParenOne) ('<#elseif' .*? '>' (( interfaceType      )  | fm_LPareninterfaceTypeRParenOne) )* '<#else>' (( interfaceType      )  | fm_LPareninterfaceTypeRParenOne) '</#if>';
fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne: '<#if' .*? '>' (( fm_NullLiteralPlaceHolder     | NullLiteral      )  | fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne) ('<#elseif' .*? '>' (( fm_NullLiteralPlaceHolder     | NullLiteral      )  | fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne) )* '<#else>' (( fm_NullLiteralPlaceHolder     | NullLiteral      )  | fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne) '</#if>';
fm_LParenforStatementNoShortIfRParenOne: '<#if' .*? '>' (( forStatementNoShortIf      )  | fm_LParenforStatementNoShortIfRParenOne) ('<#elseif' .*? '>' (( forStatementNoShortIf      )  | fm_LParenforStatementNoShortIfRParenOne) )* '<#else>' (( forStatementNoShortIf      )  | fm_LParenforStatementNoShortIfRParenOne) '</#if>';
fm_LParenexpressionNameRParenOne: '<#if' .*? '>' (( expressionName      )  | fm_LParenexpressionNameRParenOne) ('<#elseif' .*? '>' (( expressionName      )  | fm_LParenexpressionNameRParenOne) )* '<#else>' (( expressionName      )  | fm_LParenexpressionNameRParenOne) '</#if>';
fm_LParenfm_DIVPlaceHolderOrDIVRParenOne: '<#if' .*? '>' (( fm_DIVPlaceHolder     | DIV      )  | fm_LParenfm_DIVPlaceHolderOrDIVRParenOne) ('<#elseif' .*? '>' (( fm_DIVPlaceHolder     | DIV      )  | fm_LParenfm_DIVPlaceHolderOrDIVRParenOne) )* '<#else>' (( fm_DIVPlaceHolder     | DIV      )  | fm_LParenfm_DIVPlaceHolderOrDIVRParenOne) '</#if>';
fm_LParenassertStatementRParenOne: '<#if' .*? '>' (( assertStatement      )  | fm_LParenassertStatementRParenOne) ('<#elseif' .*? '>' (( assertStatement      )  | fm_LParenassertStatementRParenOne) )* '<#else>' (( assertStatement      )  | fm_LParenassertStatementRParenOne) '</#if>';
fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne: '<#if' .*? '>' (( fm_PUBLICPlaceHolder     | PUBLIC      )  | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne) ('<#elseif' .*? '>' (( fm_PUBLICPlaceHolder     | PUBLIC      )  | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne) )* '<#else>' (( fm_PUBLICPlaceHolder     | PUBLIC      )  | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne) '</#if>';
fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne: '<#if' .*? '>' (( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ('<#elseif' .*? '>' (( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) )* '<#else>' (( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) '</#if>';
fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne: '<#if' .*? '>' (( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )  | fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )  | fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne) )* '<#else>' (( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )  | fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne) '</#if>';
fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne: '<#if' .*? '>' (( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne) ('<#elseif' .*? '>' (( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne) )* '<#else>' (( primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary      )  | fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne) '</#if>';
fm_LParenbasicForStatementRParenOne: '<#if' .*? '>' (( basicForStatement      )  | fm_LParenbasicForStatementRParenOne) ('<#elseif' .*? '>' (( basicForStatement      )  | fm_LParenbasicForStatementRParenOne) )* '<#else>' (( basicForStatement      )  | fm_LParenbasicForStatementRParenOne) '</#if>';
fm_LParenlastFormalParameterRParenOne: '<#if' .*? '>' (( lastFormalParameter      )  | fm_LParenlastFormalParameterRParenOne) ('<#elseif' .*? '>' (( lastFormalParameter      )  | fm_LParenlastFormalParameterRParenOne) )* '<#else>' (( lastFormalParameter      )  | fm_LParenlastFormalParameterRParenOne) '</#if>';
fm_LParenclassInstanceCreationExpression_lf_primaryRParenOne: '<#if' .*? '>' (( classInstanceCreationExpression_lf_primary      )  | fm_LParenclassInstanceCreationExpression_lf_primaryRParenOne) ('<#elseif' .*? '>' (( classInstanceCreationExpression_lf_primary      )  | fm_LParenclassInstanceCreationExpression_lf_primaryRParenOne) )* '<#else>' (( classInstanceCreationExpression_lf_primary      )  | fm_LParenclassInstanceCreationExpression_lf_primaryRParenOne) '</#if>';
fm_LParenfm_BANGPlaceHolderOrBANGRParenOne: '<#if' .*? '>' (( fm_BANGPlaceHolder     | BANG      )  | fm_LParenfm_BANGPlaceHolderOrBANGRParenOne) ('<#elseif' .*? '>' (( fm_BANGPlaceHolder     | BANG      )  | fm_LParenfm_BANGPlaceHolderOrBANGRParenOne) )* '<#else>' (( fm_BANGPlaceHolder     | BANG      )  | fm_LParenfm_BANGPlaceHolderOrBANGRParenOne) '</#if>';
fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne: '<#if' .*? '>' (( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )  | fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )  | fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne) )* '<#else>' (( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )  | fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne) '</#if>';
fm_LParencatchesRParenOne: '<#if' .*? '>' (( catches      )  | fm_LParencatchesRParenOne) ('<#elseif' .*? '>' (( catches      )  | fm_LParencatchesRParenOne) )* '<#else>' (( catches      )  | fm_LParencatchesRParenOne) '</#if>';
fm_LParenclassType_lfno_classOrInterfaceTypeRParenOne: '<#if' .*? '>' (( classType_lfno_classOrInterfaceType      )  | fm_LParenclassType_lfno_classOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( classType_lfno_classOrInterfaceType      )  | fm_LParenclassType_lfno_classOrInterfaceTypeRParenOne) )* '<#else>' (( classType_lfno_classOrInterfaceType      )  | fm_LParenclassType_lfno_classOrInterfaceTypeRParenOne) '</#if>';
fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne: '<#if' .*? '>' (( fm_RETURNPlaceHolder     | RETURN      )  | fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne) ('<#elseif' .*? '>' (( fm_RETURNPlaceHolder     | RETURN      )  | fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne) )* '<#else>' (( fm_RETURNPlaceHolder     | RETURN      )  | fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne) '</#if>';
fm_LParendoStatementRParenOne: '<#if' .*? '>' (( doStatement      )  | fm_LParendoStatementRParenOne) ('<#elseif' .*? '>' (( doStatement      )  | fm_LParendoStatementRParenOne) )* '<#else>' (( doStatement      )  | fm_LParendoStatementRParenOne) '</#if>';
fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne: '<#if' .*? '>' (( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )  | fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne) ('<#elseif' .*? '>' (( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )  | fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne) )* '<#else>' (( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )  | fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne) '</#if>';
fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne: '<#if' .*? '>' (( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )  | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne) ('<#elseif' .*? '>' (( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )  | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne) )* '<#else>' (( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )  | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne) '</#if>';
fm_LParentryStatementRParenOne: '<#if' .*? '>' (( tryStatement      )  | fm_LParentryStatementRParenOne) ('<#elseif' .*? '>' (( tryStatement      )  | fm_LParentryStatementRParenOne) )* '<#else>' (( tryStatement      )  | fm_LParentryStatementRParenOne) '</#if>';
fm_LParenmethodReference_lf_primaryRParenOne: '<#if' .*? '>' (( methodReference_lf_primary      )  | fm_LParenmethodReference_lf_primaryRParenOne) ('<#elseif' .*? '>' (( methodReference_lf_primary      )  | fm_LParenmethodReference_lf_primaryRParenOne) )* '<#else>' (( methodReference_lf_primary      )  | fm_LParenmethodReference_lf_primaryRParenOne) '</#if>';
fm_LParenresultRParenOne: '<#if' .*? '>' (( result      )  | fm_LParenresultRParenOne) ('<#elseif' .*? '>' (( result      )  | fm_LParenresultRParenOne) )* '<#else>' (( result      )  | fm_LParenresultRParenOne) '</#if>';
fm_LParenclassType_lf_classOrInterfaceTypeRParenOne: '<#if' .*? '>' (( classType_lf_classOrInterfaceType      )  | fm_LParenclassType_lf_classOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( classType_lf_classOrInterfaceType      )  | fm_LParenclassType_lf_classOrInterfaceTypeRParenOne) )* '<#else>' (( classType_lf_classOrInterfaceType      )  | fm_LParenclassType_lf_classOrInterfaceTypeRParenOne) '</#if>';
fm_LParenfm_GEPlaceHolderOrGERParenOne: '<#if' .*? '>' (( fm_GEPlaceHolder     | GE      )  | fm_LParenfm_GEPlaceHolderOrGERParenOne) ('<#elseif' .*? '>' (( fm_GEPlaceHolder     | GE      )  | fm_LParenfm_GEPlaceHolderOrGERParenOne) )* '<#else>' (( fm_GEPlaceHolder     | GE      )  | fm_LParenfm_GEPlaceHolderOrGERParenOne) '</#if>';
fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne: '<#if' .*? '>' (( fm_COMMAPlaceHolder     | COMMA      )  | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ('<#elseif' .*? '>' (( fm_COMMAPlaceHolder     | COMMA      )  | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) )* '<#else>' (( fm_COMMAPlaceHolder     | COMMA      )  | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) '</#if>';
fm_LParendimsRParenOne: '<#if' .*? '>' (( dims      )  | fm_LParendimsRParenOne) ('<#elseif' .*? '>' (( dims      )  | fm_LParendimsRParenOne) )* '<#else>' (( dims      )  | fm_LParendimsRParenOne) '</#if>';
fm_newRulexXXx0: '<#if' .*? '>' (( ( unannClassType_lfno_unannClassOrInterfaceType      )     | ( unannInterfaceType_lfno_unannClassOrInterfaceType      )      )  | fm_newRulexXXx0) ('<#elseif' .*? '>' (( ( unannClassType_lfno_unannClassOrInterfaceType      )     | ( unannInterfaceType_lfno_unannClassOrInterfaceType      )      )  | fm_newRulexXXx0) )* '<#else>' (( ( unannClassType_lfno_unannClassOrInterfaceType      )     | ( unannInterfaceType_lfno_unannClassOrInterfaceType      )      )  | fm_newRulexXXx0) '</#if>';
fm_LParenpreIncrementExpressionRParenOne: '<#if' .*? '>' (( preIncrementExpression      )  | fm_LParenpreIncrementExpressionRParenOne) ('<#elseif' .*? '>' (( preIncrementExpression      )  | fm_LParenpreIncrementExpressionRParenOne) )* '<#else>' (( preIncrementExpression      )  | fm_LParenpreIncrementExpressionRParenOne) '</#if>';
fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne: '<#if' .*? '>' (( fm_TILDEPlaceHolder     | TILDE      )  | fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne) ('<#elseif' .*? '>' (( fm_TILDEPlaceHolder     | TILDE      )  | fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne) )* '<#else>' (( fm_TILDEPlaceHolder     | TILDE      )  | fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne) '</#if>';
fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne: '<#if' .*? '>' (( fm_COLONPlaceHolder     | COLON      )  | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) ('<#elseif' .*? '>' (( fm_COLONPlaceHolder     | COLON      )  | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) )* '<#else>' (( fm_COLONPlaceHolder     | COLON      )  | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) '</#if>';
fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne: '<#if' .*? '>' (( fm_FLOATPlaceHolder     | FLOAT      )  | fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne) ('<#elseif' .*? '>' (( fm_FLOATPlaceHolder     | FLOAT      )  | fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne) )* '<#else>' (( fm_FLOATPlaceHolder     | FLOAT      )  | fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne) '</#if>';
fm_LParenandExpressionRParenOne: '<#if' .*? '>' (( andExpression      )  | fm_LParenandExpressionRParenOne) ('<#elseif' .*? '>' (( andExpression      )  | fm_LParenandExpressionRParenOne) )* '<#else>' (( andExpression      )  | fm_LParenandExpressionRParenOne) '</#if>';
fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne: '<#if' .*? '>' (( fm_INTERFACEPlaceHolder     | INTERFACE      )  | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne) ('<#elseif' .*? '>' (( fm_INTERFACEPlaceHolder     | INTERFACE      )  | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne) )* '<#else>' (( fm_INTERFACEPlaceHolder     | INTERFACE      )  | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne) '</#if>';
fm_LParenwildcardRParenOne: '<#if' .*? '>' (( wildcard      )  | fm_LParenwildcardRParenOne) ('<#elseif' .*? '>' (( wildcard      )  | fm_LParenwildcardRParenOne) )* '<#else>' (( wildcard      )  | fm_LParenwildcardRParenOne) '</#if>';
fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne: '<#if' .*? '>' (( fm_NATIVEPlaceHolder     | NATIVE      )  | fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne) ('<#elseif' .*? '>' (( fm_NATIVEPlaceHolder     | NATIVE      )  | fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne) )* '<#else>' (( fm_NATIVEPlaceHolder     | NATIVE      )  | fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne) '</#if>';
fm_LParenfm_INCPlaceHolderOrINCRParenOne: '<#if' .*? '>' (( fm_INCPlaceHolder     | INC      )  | fm_LParenfm_INCPlaceHolderOrINCRParenOne) ('<#elseif' .*? '>' (( fm_INCPlaceHolder     | INC      )  | fm_LParenfm_INCPlaceHolderOrINCRParenOne) )* '<#else>' (( fm_INCPlaceHolder     | INC      )  | fm_LParenfm_INCPlaceHolderOrINCRParenOne) '</#if>';
fm_LParenarrayCreationExpressionRParenOne: '<#if' .*? '>' (( arrayCreationExpression      )  | fm_LParenarrayCreationExpressionRParenOne) ('<#elseif' .*? '>' (( arrayCreationExpression      )  | fm_LParenarrayCreationExpressionRParenOne) )* '<#else>' (( arrayCreationExpression      )  | fm_LParenarrayCreationExpressionRParenOne) '</#if>';
fm_LParenbreakStatementRParenOne: '<#if' .*? '>' (( breakStatement      )  | fm_LParenbreakStatementRParenOne) ('<#elseif' .*? '>' (( breakStatement      )  | fm_LParenbreakStatementRParenOne) )* '<#else>' (( breakStatement      )  | fm_LParenbreakStatementRParenOne) '</#if>';
fm_LParenfm_ADDPlaceHolderOrADDRParenOne: '<#if' .*? '>' (( fm_ADDPlaceHolder     | ADD      )  | fm_LParenfm_ADDPlaceHolderOrADDRParenOne) ('<#elseif' .*? '>' (( fm_ADDPlaceHolder     | ADD      )  | fm_LParenfm_ADDPlaceHolderOrADDRParenOne) )* '<#else>' (( fm_ADDPlaceHolder     | ADD      )  | fm_LParenfm_ADDPlaceHolderOrADDRParenOne) '</#if>';
fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne: '<#if' .*? '>' (( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )  | fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne) ('<#elseif' .*? '>' (( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )  | fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne) )* '<#else>' (( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )  | fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne) '</#if>';
fm_LParenfm_MODPlaceHolderOrMODRParenOne: '<#if' .*? '>' (( fm_MODPlaceHolder     | MOD      )  | fm_LParenfm_MODPlaceHolderOrMODRParenOne) ('<#elseif' .*? '>' (( fm_MODPlaceHolder     | MOD      )  | fm_LParenfm_MODPlaceHolderOrMODRParenOne) )* '<#else>' (( fm_MODPlaceHolder     | MOD      )  | fm_LParenfm_MODPlaceHolderOrMODRParenOne) '</#if>';
fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne: '<#if' .*? '>' (( fm_IntegerLiteralPlaceHolder     | IntegerLiteral      )  | fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne) ('<#elseif' .*? '>' (( fm_IntegerLiteralPlaceHolder     | IntegerLiteral      )  | fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne) )* '<#else>' (( fm_IntegerLiteralPlaceHolder     | IntegerLiteral      )  | fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne) '</#if>';
fm_LParenclassMemberDeclarationRParenOne: '<#if' .*? '>' (( classMemberDeclaration      )  | fm_LParenclassMemberDeclarationRParenOne) ('<#elseif' .*? '>' (( classMemberDeclaration      )  | fm_LParenclassMemberDeclarationRParenOne) )* '<#else>' (( classMemberDeclaration      )  | fm_LParenclassMemberDeclarationRParenOne) '</#if>';
fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne: '<#if' .*? '>' (( fm_SHORTPlaceHolder     | SHORT      )  | fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne) ('<#elseif' .*? '>' (( fm_SHORTPlaceHolder     | SHORT      )  | fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne) )* '<#else>' (( fm_SHORTPlaceHolder     | SHORT      )  | fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne) '</#if>';
fm_LParenfm_ATPlaceHolderOrATRParenOne: '<#if' .*? '>' (( fm_ATPlaceHolder     | AT      )  | fm_LParenfm_ATPlaceHolderOrATRParenOne) ('<#elseif' .*? '>' (( fm_ATPlaceHolder     | AT      )  | fm_LParenfm_ATPlaceHolderOrATRParenOne) )* '<#else>' (( fm_ATPlaceHolder     | AT      )  | fm_LParenfm_ATPlaceHolderOrATRParenOne) '</#if>';
fm_LParennormalClassDeclarationRParenOne: '<#if' .*? '>' (( normalClassDeclaration      )  | fm_LParennormalClassDeclarationRParenOne) ('<#elseif' .*? '>' (( normalClassDeclaration      )  | fm_LParennormalClassDeclarationRParenOne) )* '<#else>' (( normalClassDeclaration      )  | fm_LParennormalClassDeclarationRParenOne) '</#if>';
fm_LParenelementValueRParenOne: '<#if' .*? '>' (( elementValue      )  | fm_LParenelementValueRParenOne) ('<#elseif' .*? '>' (( elementValue      )  | fm_LParenelementValueRParenOne) )* '<#else>' (( elementValue      )  | fm_LParenelementValueRParenOne) '</#if>';
fm_LParencastExpressionRParenOne: '<#if' .*? '>' (( castExpression      )  | fm_LParencastExpressionRParenOne) ('<#elseif' .*? '>' (( castExpression      )  | fm_LParencastExpressionRParenOne) )* '<#else>' (( castExpression      )  | fm_LParencastExpressionRParenOne) '</#if>';
fm_LParenreceiverParameterRParenOne: '<#if' .*? '>' (( receiverParameter      )  | fm_LParenreceiverParameterRParenOne) ('<#elseif' .*? '>' (( receiverParameter      )  | fm_LParenreceiverParameterRParenOne) )* '<#else>' (( receiverParameter      )  | fm_LParenreceiverParameterRParenOne) '</#if>';
fm_LParenstaticInitializerRParenOne: '<#if' .*? '>' (( staticInitializer      )  | fm_LParenstaticInitializerRParenOne) ('<#elseif' .*? '>' (( staticInitializer      )  | fm_LParenstaticInitializerRParenOne) )* '<#else>' (( staticInitializer      )  | fm_LParenstaticInitializerRParenOne) '</#if>';
fm_LParenunannReferenceTypeRParenOne: '<#if' .*? '>' (( unannReferenceType      )  | fm_LParenunannReferenceTypeRParenOne) ('<#elseif' .*? '>' (( unannReferenceType      )  | fm_LParenunannReferenceTypeRParenOne) )* '<#else>' (( unannReferenceType      )  | fm_LParenunannReferenceTypeRParenOne) '</#if>';
fm_LPareninterfaceDeclarationRParenOne: '<#if' .*? '>' (( interfaceDeclaration      )  | fm_LPareninterfaceDeclarationRParenOne) ('<#elseif' .*? '>' (( interfaceDeclaration      )  | fm_LPareninterfaceDeclarationRParenOne) )* '<#else>' (( interfaceDeclaration      )  | fm_LPareninterfaceDeclarationRParenOne) '</#if>';
fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne: '<#if' .*? '>' (( fm_FINALLYPlaceHolder     | FINALLY      )  | fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne) ('<#elseif' .*? '>' (( fm_FINALLYPlaceHolder     | FINALLY      )  | fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne) )* '<#else>' (( fm_FINALLYPlaceHolder     | FINALLY      )  | fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne) '</#if>';
fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne: '<#if' .*? '>' (( fm_RBRACEPlaceHolder     | RBRACE      )  | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne) ('<#elseif' .*? '>' (( fm_RBRACEPlaceHolder     | RBRACE      )  | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne) )* '<#else>' (( fm_RBRACEPlaceHolder     | RBRACE      )  | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne) '</#if>';
fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne: '<#if' .*? '>' (( interfaceType_lfno_classOrInterfaceType      )  | fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne) ('<#elseif' .*? '>' (( interfaceType_lfno_classOrInterfaceType      )  | fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne) )* '<#else>' (( interfaceType_lfno_classOrInterfaceType      )  | fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne) '</#if>';
fm_LParensimpleTypeNameRParenOne: '<#if' .*? '>' (( simpleTypeName      )  | fm_LParensimpleTypeNameRParenOne) ('<#elseif' .*? '>' (( simpleTypeName      )  | fm_LParensimpleTypeNameRParenOne) )* '<#else>' (( simpleTypeName      )  | fm_LParensimpleTypeNameRParenOne) '</#if>';
fm_LParenvariableInitializerRParenOne: '<#if' .*? '>' (( variableInitializer      )  | fm_LParenvariableInitializerRParenOne) ('<#elseif' .*? '>' (( variableInitializer      )  | fm_LParenvariableInitializerRParenOne) )* '<#else>' (( variableInitializer      )  | fm_LParenvariableInitializerRParenOne) '</#if>';
fm_LParencatchFormalParameterRParenOne: '<#if' .*? '>' (( catchFormalParameter      )  | fm_LParencatchFormalParameterRParenOne) ('<#elseif' .*? '>' (( catchFormalParameter      )  | fm_LParencatchFormalParameterRParenOne) )* '<#else>' (( catchFormalParameter      )  | fm_LParencatchFormalParameterRParenOne) '</#if>';
fm_LParenleftHandSideRParenOne: '<#if' .*? '>' (( leftHandSide      )  | fm_LParenleftHandSideRParenOne) ('<#elseif' .*? '>' (( leftHandSide      )  | fm_LParenleftHandSideRParenOne) )* '<#else>' (( leftHandSide      )  | fm_LParenleftHandSideRParenOne) '</#if>';
fm_LParenequalityExpressionRParenOne: '<#if' .*? '>' (( equalityExpression      )  | fm_LParenequalityExpressionRParenOne) ('<#elseif' .*? '>' (( equalityExpression      )  | fm_LParenequalityExpressionRParenOne) )* '<#else>' (( equalityExpression      )  | fm_LParenequalityExpressionRParenOne) '</#if>';
fm_LParenforStatementRParenOne: '<#if' .*? '>' (( forStatement      )  | fm_LParenforStatementRParenOne) ('<#elseif' .*? '>' (( forStatement      )  | fm_LParenforStatementRParenOne) )* '<#else>' (( forStatement      )  | fm_LParenforStatementRParenOne) '</#if>';
fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne: '<#if' .*? '>' (( fm_BYTEPlaceHolder     | BYTE      )  | fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne) ('<#elseif' .*? '>' (( fm_BYTEPlaceHolder     | BYTE      )  | fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne) )* '<#else>' (( fm_BYTEPlaceHolder     | BYTE      )  | fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne) '</#if>';
fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne: '<#if' .*? '>' (( fm_STRICTFPPlaceHolder     | STRICTFP      )  | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne) ('<#elseif' .*? '>' (( fm_STRICTFPPlaceHolder     | STRICTFP      )  | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne) )* '<#else>' (( fm_STRICTFPPlaceHolder     | STRICTFP      )  | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne) '</#if>';
fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne: '<#if' .*? '>' (( ( primaryNoNewArray_lfno_primary      )     | ( arrayCreationExpression      )      )  | fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne) ('<#elseif' .*? '>' (( ( primaryNoNewArray_lfno_primary      )     | ( arrayCreationExpression      )      )  | fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne) )* '<#else>' (( ( primaryNoNewArray_lfno_primary      )     | ( arrayCreationExpression      )      )  | fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne) '</#if>';
fm_LParenlambdaBodyRParenOne: '<#if' .*? '>' (( lambdaBody      )  | fm_LParenlambdaBodyRParenOne) ('<#elseif' .*? '>' (( lambdaBody      )  | fm_LParenlambdaBodyRParenOne) )* '<#else>' (( lambdaBody      )  | fm_LParenlambdaBodyRParenOne) '</#if>';
fm_LParenvariableDeclaratorRParenOne: '<#if' .*? '>' (( variableDeclarator      )  | fm_LParenvariableDeclaratorRParenOne) ('<#elseif' .*? '>' (( variableDeclarator      )  | fm_LParenvariableDeclaratorRParenOne) )* '<#else>' (( variableDeclarator      )  | fm_LParenvariableDeclaratorRParenOne) '</#if>';
fm_LParenlabeledStatementNoShortIfRParenOne: '<#if' .*? '>' (( labeledStatementNoShortIf      )  | fm_LParenlabeledStatementNoShortIfRParenOne) ('<#elseif' .*? '>' (( labeledStatementNoShortIf      )  | fm_LParenlabeledStatementNoShortIfRParenOne) )* '<#else>' (( labeledStatementNoShortIf      )  | fm_LParenlabeledStatementNoShortIfRParenOne) '</#if>';
fm_LParenfm_CARETPlaceHolderOrCARETRParenOne: '<#if' .*? '>' (( fm_CARETPlaceHolder     | CARET      )  | fm_LParenfm_CARETPlaceHolderOrCARETRParenOne) ('<#elseif' .*? '>' (( fm_CARETPlaceHolder     | CARET      )  | fm_LParenfm_CARETPlaceHolderOrCARETRParenOne) )* '<#else>' (( fm_CARETPlaceHolder     | CARET      )  | fm_LParenfm_CARETPlaceHolderOrCARETRParenOne) '</#if>';
fm_LParenfm_NEWPlaceHolderOrNEWRParenOne: '<#if' .*? '>' (( fm_NEWPlaceHolder     | NEW      )  | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ('<#elseif' .*? '>' (( fm_NEWPlaceHolder     | NEW      )  | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) )* '<#else>' (( fm_NEWPlaceHolder     | NEW      )  | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) '</#if>';
fm_LParennumericTypeRParenOne: '<#if' .*? '>' (( numericType      )  | fm_LParennumericTypeRParenOne) ('<#elseif' .*? '>' (( numericType      )  | fm_LParennumericTypeRParenOne) )* '<#else>' (( numericType      )  | fm_LParennumericTypeRParenOne) '</#if>';
fm_LParenmethodInvocation_lf_primaryRParenOne: '<#if' .*? '>' (( methodInvocation_lf_primary      )  | fm_LParenmethodInvocation_lf_primaryRParenOne) ('<#elseif' .*? '>' (( methodInvocation_lf_primary      )  | fm_LParenmethodInvocation_lf_primaryRParenOne) )* '<#else>' (( methodInvocation_lf_primary      )  | fm_LParenmethodInvocation_lf_primaryRParenOne) '</#if>';
fm_LParenswitchLabelRParenOne: '<#if' .*? '>' (( switchLabel      )  | fm_LParenswitchLabelRParenOne) ('<#elseif' .*? '>' (( switchLabel      )  | fm_LParenswitchLabelRParenOne) )* '<#else>' (( switchLabel      )  | fm_LParenswitchLabelRParenOne) '</#if>';
fm_LParenshiftExpressionRParenOne: '<#if' .*? '>' (( shiftExpression      )  | fm_LParenshiftExpressionRParenOne) ('<#elseif' .*? '>' (( shiftExpression      )  | fm_LParenshiftExpressionRParenOne) )* '<#else>' (( shiftExpression      )  | fm_LParenshiftExpressionRParenOne) '</#if>';
fm_LParenlambdaExpressionRParenOne: '<#if' .*? '>' (( lambdaExpression      )  | fm_LParenlambdaExpressionRParenOne) ('<#elseif' .*? '>' (( lambdaExpression      )  | fm_LParenlambdaExpressionRParenOne) )* '<#else>' (( lambdaExpression      )  | fm_LParenlambdaExpressionRParenOne) '</#if>';
fm_LParenblockStatementRParenOne: '<#if' .*? '>' (( blockStatement      )  | fm_LParenblockStatementRParenOne) ('<#elseif' .*? '>' (( blockStatement      )  | fm_LParenblockStatementRParenOne) )* '<#else>' (( blockStatement      )  | fm_LParenblockStatementRParenOne) '</#if>';
fm_LParenblockRParenOne: '<#if' .*? '>' (( block      )  | fm_LParenblockRParenOne) ('<#elseif' .*? '>' (( block      )  | fm_LParenblockRParenOne) )* '<#else>' (( block      )  | fm_LParenblockRParenOne) '</#if>';
fm_LParenswitchStatementRParenOne: '<#if' .*? '>' (( switchStatement      )  | fm_LParenswitchStatementRParenOne) ('<#elseif' .*? '>' (( switchStatement      )  | fm_LParenswitchStatementRParenOne) )* '<#else>' (( switchStatement      )  | fm_LParenswitchStatementRParenOne) '</#if>';
fm_LParenconstructorBodyRParenOne: '<#if' .*? '>' (( constructorBody      )  | fm_LParenconstructorBodyRParenOne) ('<#elseif' .*? '>' (( constructorBody      )  | fm_LParenconstructorBodyRParenOne) )* '<#else>' (( constructorBody      )  | fm_LParenconstructorBodyRParenOne) '</#if>';
fm_LParenenhancedForStatementNoShortIfRParenOne: '<#if' .*? '>' (( enhancedForStatementNoShortIf      )  | fm_LParenenhancedForStatementNoShortIfRParenOne) ('<#elseif' .*? '>' (( enhancedForStatementNoShortIf      )  | fm_LParenenhancedForStatementNoShortIfRParenOne) )* '<#else>' (( enhancedForStatementNoShortIf      )  | fm_LParenenhancedForStatementNoShortIfRParenOne) '</#if>';
fm_LParenlocalVariableDeclarationRParenOne: '<#if' .*? '>' (( localVariableDeclaration      )  | fm_LParenlocalVariableDeclarationRParenOne) ('<#elseif' .*? '>' (( localVariableDeclaration      )  | fm_LParenlocalVariableDeclarationRParenOne) )* '<#else>' (( localVariableDeclaration      )  | fm_LParenlocalVariableDeclarationRParenOne) '</#if>';
fm_LParenannotationTypeDeclarationRParenOne: '<#if' .*? '>' (( annotationTypeDeclaration      )  | fm_LParenannotationTypeDeclarationRParenOne) ('<#elseif' .*? '>' (( annotationTypeDeclaration      )  | fm_LParenannotationTypeDeclarationRParenOne) )* '<#else>' (( annotationTypeDeclaration      )  | fm_LParenannotationTypeDeclarationRParenOne) '</#if>';
fm_LParenbasicForStatementNoShortIfRParenOne: '<#if' .*? '>' (( basicForStatementNoShortIf      )  | fm_LParenbasicForStatementNoShortIfRParenOne) ('<#elseif' .*? '>' (( basicForStatementNoShortIf      )  | fm_LParenbasicForStatementNoShortIfRParenOne) )* '<#else>' (( basicForStatementNoShortIf      )  | fm_LParenbasicForStatementNoShortIfRParenOne) '</#if>';
fm_LParentypeNameRParenOne: '<#if' .*? '>' (( typeName      )  | fm_LParentypeNameRParenOne) ('<#elseif' .*? '>' (( typeName      )  | fm_LParentypeNameRParenOne) )* '<#else>' (( typeName      )  | fm_LParentypeNameRParenOne) '</#if>';
fm_LParenthrowStatementRParenOne: '<#if' .*? '>' (( throwStatement      )  | fm_LParenthrowStatementRParenOne) ('<#elseif' .*? '>' (( throwStatement      )  | fm_LParenthrowStatementRParenOne) )* '<#else>' (( throwStatement      )  | fm_LParenthrowStatementRParenOne) '</#if>';