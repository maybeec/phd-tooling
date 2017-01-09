/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
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

/** A Java 1.7 grammar for ANTLR v4 derived from ANTLR v3 Java grammar.
 *  Uses ANTLR v4's left-recursive expression notation.
 *  It parses ECJ, Netbeans, JDK etc...
 *
 *  Sam Harwell cleaned this up significantly and updated to 1.7!
 *
 *  You can test with
 *
 *  $ antlr4 Java.g4
 *  $ javac *.java
 *  $ grun Java compilationUnit *.java
 */
grammar Java7Template;

// starting point for parsing a java file
compilationUnit
    :   ((packageDeclaration) | fm_LParenpackageDeclarationRParenQuestion)? ((importDeclaration) | fm_LParenimportDeclarationRParenStar)* ((typeDeclaration) | fm_LParentypeDeclarationRParenStar)* EOF
    ;

packageDeclaration
    :   ((annotation) | fm_LParenannotationRParenStar)* ((fm_PACKAGEPlaceHolder | PACKAGE ) | fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne) ((qualifiedName) | fm_LParenqualifiedNameRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    ;

importDeclaration
    :   ((fm_IMPORTPlaceHolder | IMPORT ) | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne) ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion)? ((qualifiedName) | fm_LParenqualifiedNameRParenOne) ((((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_MULPlaceHolder | MUL ) | fm_LParenfm_MULPlaceHolderOrMULRParenOne)) | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    ;

typeDeclaration
    :   ((classOrInterfaceModifier) | fm_LParenclassOrInterfaceModifierRParenStar)* ((classDeclaration) | fm_LParenclassDeclarationRParenOne)
    |   ((classOrInterfaceModifier) | fm_LParenclassOrInterfaceModifierRParenStar)* ((enumDeclaration) | fm_LParenenumDeclarationRParenOne)
    |   ((classOrInterfaceModifier) | fm_LParenclassOrInterfaceModifierRParenStar)* ((interfaceDeclaration) | fm_LPareninterfaceDeclarationRParenOne)
    |   ((classOrInterfaceModifier) | fm_LParenclassOrInterfaceModifierRParenStar)* ((annotationTypeDeclaration) | fm_LParenannotationTypeDeclarationRParenOne)
    |   ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    ;

modifier
    :   ((classOrInterfaceModifier) | fm_LParenclassOrInterfaceModifierRParenOne)
    |   ((   ((fm_NATIVEPlaceHolder | NATIVE ) | fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne)
        |   ((fm_SYNCHRONIZEDPlaceHolder | SYNCHRONIZED ) | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne)
        |   ((fm_TRANSIENTPlaceHolder | TRANSIENT ) | fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne)
        |   ((fm_VOLATILEPlaceHolder | VOLATILE ) | fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne)
        ) | fm_newRulexXXx0)
    ;

classOrInterfaceModifier
    :   ((annotation) | fm_LParenannotationRParenOne)       // class or interface
    |   ((   ((fm_PUBLICPlaceHolder | PUBLIC ) | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)     // class or interface
        |   ((fm_PROTECTEDPlaceHolder | PROTECTED ) | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne)  // class or interface
        |   ((fm_PRIVATEPlaceHolder | PRIVATE ) | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne)    // class or interface
        |   ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)     // class or interface
        |   ((fm_ABSTRACTPlaceHolder | ABSTRACT ) | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne)   // class or interface
        |   ((fm_FINALPlaceHolder | FINAL ) | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)      // class only -- does not apply to interfaces
        |   ((fm_STRICTFPPlaceHolder | STRICTFP ) | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne)   // class or interface
        ) | fm_newRulexXXx1)
    ;

variableModifier
    :   ((fm_FINALPlaceHolder | FINAL ) | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)
    |   ((annotation) | fm_LParenannotationRParenOne)
    ;

classDeclaration
    :   ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeParameters) | fm_LParentypeParametersRParenQuestion)?
        ((((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ((type) | fm_LParentypeRParenOne)) | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion)?
        ((((fm_IMPLEMENTSPlaceHolder | IMPLEMENTS ) | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne) ((typeList) | fm_LParentypeListRParenOne)) | fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion)?
        ((classBody) | fm_LParenclassBodyRParenOne)
    ;

typeParameters
    :   ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((typeParameter) | fm_LParentypeParameterRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((typeParameter) | fm_LParentypeParameterRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar)* ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)
    ;

typeParameter
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ((typeBound) | fm_LParentypeBoundRParenOne)) | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion)?
    ;

typeBound
    :   ((type) | fm_LParentypeRParenOne) ((((fm_BITANDPlaceHolder | BITAND ) | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne) ((type) | fm_LParentypeRParenOne)) | fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar)*
    ;

enumDeclaration
    :   ((fm_ENUMPlaceHolder | ENUM) | fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_IMPLEMENTSPlaceHolder | IMPLEMENTS ) | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne) ((typeList) | fm_LParentypeListRParenOne)) | fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion)?
        ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((enumConstants) | fm_LParenenumConstantsRParenQuestion)? ((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion)? ((enumBodyDeclarations) | fm_LParenenumBodyDeclarationsRParenQuestion)? ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
    ;

enumConstants
    :   ((enumConstant) | fm_LParenenumConstantRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((enumConstant) | fm_LParenenumConstantRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar)*
    ;

enumConstant
    :   ((annotation) | fm_LParenannotationRParenStar)* ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((arguments) | fm_LParenargumentsRParenQuestion)? ((classBody) | fm_LParenclassBodyRParenQuestion)?
    ;

enumBodyDeclarations
    :   ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((classBodyDeclaration) | fm_LParenclassBodyDeclarationRParenStar)*
    ;

interfaceDeclaration
    :   ((fm_INTERFACEPlaceHolder | INTERFACE ) | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeParameters) | fm_LParentypeParametersRParenQuestion)? ((((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) ((typeList) | fm_LParentypeListRParenOne)) | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion)? ((interfaceBody) | fm_LPareninterfaceBodyRParenOne)
    ;

typeList
    :   ((type) | fm_LParentypeRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((type) | fm_LParentypeRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar)*
    ;

classBody
    :   ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((classBodyDeclaration) | fm_LParenclassBodyDeclarationRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
    ;

interfaceBody
    :   ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((interfaceBodyDeclaration) | fm_LPareninterfaceBodyDeclarationRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
    ;

classBodyDeclaration
    :   ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((fm_STATICPlaceHolder | STATIC ) | fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion)? ((block) | fm_LParenblockRParenOne)
    |   ((modifier) | fm_LParenmodifierRParenStar)* ((memberDeclaration) | fm_LParenmemberDeclarationRParenOne)
    ;

memberDeclaration
    :   ((methodDeclaration) | fm_LParenmethodDeclarationRParenOne)
    |   ((genericMethodDeclaration) | fm_LParengenericMethodDeclarationRParenOne)
    |   ((fieldDeclaration) | fm_LParenfieldDeclarationRParenOne)
    |   ((constructorDeclaration) | fm_LParenconstructorDeclarationRParenOne)
    |   ((genericConstructorDeclaration) | fm_LParengenericConstructorDeclarationRParenOne)
    |   ((interfaceDeclaration) | fm_LPareninterfaceDeclarationRParenOne)
    |   ((annotationTypeDeclaration) | fm_LParenannotationTypeDeclarationRParenOne)
    |   ((classDeclaration) | fm_LParenclassDeclarationRParenOne)
    |   ((enumDeclaration) | fm_LParenenumDeclarationRParenOne)
    ;

/* We use rule this even for void methods which cannot have [] after parameters.
   This simplifies grammar and we can consider void to be a type, which
   renders the [] matching as a context-sensitive issue or a semantic check
   for invalid return type after parsing.
 */
methodDeclaration
    :   ((((type) | fm_LParentypeRParenOne)|((fm_VOIDPlaceHolder | VOID ) | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne)) | fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((formalParameters) | fm_LParenformalParametersRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)*
        ((((fm_THROWSPlaceHolder | THROWS ) | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne) ((qualifiedNameList) | fm_LParenqualifiedNameListRParenOne)) | fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion)?
        ((   ((methodBody) | fm_LParenmethodBodyRParenOne)
        |   ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
        ) | fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne)
    ;

genericMethodDeclaration
    :   ((typeParameters) | fm_LParentypeParametersRParenOne) ((methodDeclaration) | fm_LParenmethodDeclarationRParenOne)
    ;

constructorDeclaration
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((formalParameters) | fm_LParenformalParametersRParenOne) ((((fm_THROWSPlaceHolder | THROWS ) | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne) ((qualifiedNameList) | fm_LParenqualifiedNameListRParenOne)) | fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion)?
        ((constructorBody) | fm_LParenconstructorBodyRParenOne)
    ;

genericConstructorDeclaration
    :   ((typeParameters) | fm_LParentypeParametersRParenOne) ((constructorDeclaration) | fm_LParenconstructorDeclarationRParenOne)
    ;

fieldDeclaration
    :   ((type) | fm_LParentypeRParenOne) ((variableDeclarators) | fm_LParenvariableDeclaratorsRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    ;

interfaceBodyDeclaration
    :   ((modifier) | fm_LParenmodifierRParenStar)* ((interfaceMemberDeclaration) | fm_LPareninterfaceMemberDeclarationRParenOne)
    |   ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    ;

interfaceMemberDeclaration
    :   ((constDeclaration) | fm_LParenconstDeclarationRParenOne)
    |   ((interfaceMethodDeclaration) | fm_LPareninterfaceMethodDeclarationRParenOne)
    |   ((genericInterfaceMethodDeclaration) | fm_LParengenericInterfaceMethodDeclarationRParenOne)
    |   ((interfaceDeclaration) | fm_LPareninterfaceDeclarationRParenOne)
    |   ((annotationTypeDeclaration) | fm_LParenannotationTypeDeclarationRParenOne)
    |   ((classDeclaration) | fm_LParenclassDeclarationRParenOne)
    |   ((enumDeclaration) | fm_LParenenumDeclarationRParenOne)
    ;

constDeclaration
    :   ((type) | fm_LParentypeRParenOne) ((constantDeclarator) | fm_LParenconstantDeclaratorRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((constantDeclarator) | fm_LParenconstantDeclaratorRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar)* ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    ;

constantDeclarator
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) ((variableInitializer) | fm_LParenvariableInitializerRParenOne)
    ;

// see matching of [] comment in methodDeclaratorRest
interfaceMethodDeclaration
    :   ((((type) | fm_LParentypeRParenOne)|((fm_VOIDPlaceHolder | VOID ) | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne)) | fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((formalParameters) | fm_LParenformalParametersRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)*
        ((((fm_THROWSPlaceHolder | THROWS ) | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne) ((qualifiedNameList) | fm_LParenqualifiedNameListRParenOne)) | fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion)?
        ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    ;

genericInterfaceMethodDeclaration
    :   ((typeParameters) | fm_LParentypeParametersRParenOne) ((interfaceMethodDeclaration) | fm_LPareninterfaceMethodDeclarationRParenOne)
    ;

variableDeclarators
    :   ((variableDeclarator) | fm_LParenvariableDeclaratorRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((variableDeclarator) | fm_LParenvariableDeclaratorRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar)*
    ;

variableDeclarator
    :   ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne) ((((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) ((variableInitializer) | fm_LParenvariableInitializerRParenOne)) | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion)?
    ;

variableDeclaratorId
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)*
    ;

variableInitializer
    :   ((arrayInitializer) | fm_LParenarrayInitializerRParenOne)
    |   ((expression) | fm_LParenexpressionRParenOne)
    ;

arrayInitializer
    :   ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((((variableInitializer) | fm_LParenvariableInitializerRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((variableInitializer) | fm_LParenvariableInitializerRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar)* ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion)? ) | fm_newRulexXXx2)? ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
    ;

enumConstantName
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    ;

type
    :   ((classOrInterfaceType) | fm_LParenclassOrInterfaceTypeRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)*
    |   ((primitiveType) | fm_LParenprimitiveTypeRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)*
    ;

classOrInterfaceType
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ((((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArguments) | fm_LParentypeArgumentsRParenQuestion)? ) | fm_newRulexXXx3)*
    ;

primitiveType
    :   ((fm_BOOLEANPlaceHolder | BOOLEAN ) | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne)
    |   ((fm_CHARPlaceHolder | CHAR ) | fm_LParenfm_CHARPlaceHolderOrCHARRParenOne)
    |   ((fm_BYTEPlaceHolder | BYTE ) | fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne)
    |   ((fm_SHORTPlaceHolder | SHORT ) | fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne)
    |   ((fm_INTPlaceHolder | INT ) | fm_LParenfm_INTPlaceHolderOrINTRParenOne)
    |   ((fm_LONGPlaceHolder | LONG ) | fm_LParenfm_LONGPlaceHolderOrLONGRParenOne)
    |   ((fm_FLOATPlaceHolder | FLOAT ) | fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne)
    |   ((fm_DOUBLEPlaceHolder | DOUBLE ) | fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne)
    ;

typeArguments
    :   ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((typeArgument) | fm_LParentypeArgumentRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((typeArgument) | fm_LParentypeArgumentRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar)* ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)
    ;

typeArgument
    :   ((type) | fm_LParentypeRParenOne)
    |   ((fm_QUESTIONPlaceHolder | QUESTION ) | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne) ((((((fm_EXTENDSPlaceHolder | EXTENDS ) | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne) | ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne)) | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne) ((type) | fm_LParentypeRParenOne)) | fm_newRulexXXx4)?
    ;

qualifiedNameList
    :   ((qualifiedName) | fm_LParenqualifiedNameRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((qualifiedName) | fm_LParenqualifiedNameRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar)*
    ;

formalParameters
    :   ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((formalParameterList) | fm_LParenformalParameterListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
    ;

formalParameterList
    :   ((formalParameter) | fm_LParenformalParameterRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((formalParameter) | fm_LParenformalParameterRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar)* ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((lastFormalParameter) | fm_LParenlastFormalParameterRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion)?
    |   ((lastFormalParameter) | fm_LParenlastFormalParameterRParenOne)
    ;

formalParameter
    :   ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((type) | fm_LParentypeRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne)
    ;

lastFormalParameter
    :   ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((type) | fm_LParentypeRParenOne) ((fm_ELLIPSISPlaceHolder | ELLIPSIS ) | fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne)
    ;

methodBody
    :   ((block) | fm_LParenblockRParenOne)
    ;

constructorBody
    :   ((block) | fm_LParenblockRParenOne)
    ;

qualifiedName
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)) | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar)*
    ;

literal
    :   ((fm_IntegerLiteralPlaceHolder | IntegerLiteral) | fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne)
    |   ((fm_FloatingPointLiteralPlaceHolder | FloatingPointLiteral) | fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne)
    |   ((fm_CharacterLiteralPlaceHolder | CharacterLiteral) | fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne)
    |   ((fm_StringLiteralPlaceHolder | StringLiteral) | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne)
    |   ((fm_BooleanLiteralPlaceHolder | BooleanLiteral) | fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne)
    |   ((fm_NullLiteralPlaceHolder | NullLiteral ) | fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne)
    ;

// ANNOTATIONS

annotation
    :   ((fm_ATPlaceHolder | AT ) | fm_LParenfm_ATPlaceHolderOrATRParenOne) ((annotationName) | fm_LParenannotationNameRParenOne) (( ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) (( ((elementValuePairs) | fm_LParenelementValuePairsRParenOne) | ((elementValue) | fm_LParenelementValueRParenOne) ) | fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ) | fm_newRulexXXx5)?
    ;

annotationName : ((qualifiedName) | fm_LParenqualifiedNameRParenOne) ;

elementValuePairs
    :   ((elementValuePair) | fm_LParenelementValuePairRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((elementValuePair) | fm_LParenelementValuePairRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar)*
    ;

elementValuePair
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) ((elementValue) | fm_LParenelementValueRParenOne)
    ;

elementValue
    :   ((expression) | fm_LParenexpressionRParenOne)
    |   ((annotation) | fm_LParenannotationRParenOne)
    |   ((elementValueArrayInitializer) | fm_LParenelementValueArrayInitializerRParenOne)
    ;

elementValueArrayInitializer
    :   ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((((elementValue) | fm_LParenelementValueRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((elementValue) | fm_LParenelementValueRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar)*) | fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion)? ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion)? ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
    ;

annotationTypeDeclaration
    :   ((fm_ATPlaceHolder | AT ) | fm_LParenfm_ATPlaceHolderOrATRParenOne) ((fm_INTERFACEPlaceHolder | INTERFACE ) | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((annotationTypeBody) | fm_LParenannotationTypeBodyRParenOne)
    ;

annotationTypeBody
    :   ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((((annotationTypeElementDeclaration) | fm_LParenannotationTypeElementDeclarationRParenOne)) | fm_LParenLParenannotationTypeElementDeclarationRParenRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
    ;

annotationTypeElementDeclaration
    :   ((modifier) | fm_LParenmodifierRParenStar)* ((annotationTypeElementRest) | fm_LParenannotationTypeElementRestRParenOne)
    |   ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) // this is not allowed by the grammar, but apparently allowed by the actual compiler
    ;

annotationTypeElementRest
    :   ((type) | fm_LParentypeRParenOne) ((annotationMethodOrConstantRest) | fm_LParenannotationMethodOrConstantRestRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((classDeclaration) | fm_LParenclassDeclarationRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion)?
    |   ((interfaceDeclaration) | fm_LPareninterfaceDeclarationRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion)?
    |   ((enumDeclaration) | fm_LParenenumDeclarationRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion)?
    |   ((annotationTypeDeclaration) | fm_LParenannotationTypeDeclarationRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion)?
    ;

annotationMethodOrConstantRest
    :   ((annotationMethodRest) | fm_LParenannotationMethodRestRParenOne)
    |   ((annotationConstantRest) | fm_LParenannotationConstantRestRParenOne)
    ;

annotationMethodRest
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((defaultValue) | fm_LParendefaultValueRParenQuestion)?
    ;

annotationConstantRest
    :   ((variableDeclarators) | fm_LParenvariableDeclaratorsRParenOne)
    ;

defaultValue
    :   ((fm_DEFAULTPlaceHolder | DEFAULT ) | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne) ((elementValue) | fm_LParenelementValueRParenOne)
    ;

// STATEMENTS / BLOCKS

block
    :   ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((blockStatement) | fm_LParenblockStatementRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
    ;

blockStatement
    :   ((localVariableDeclarationStatement) | fm_LParenlocalVariableDeclarationStatementRParenOne)
    |   ((statement) | fm_LParenstatementRParenOne)
    |   ((typeDeclaration) | fm_LParentypeDeclarationRParenOne)
    ;

localVariableDeclarationStatement
    :    ((localVariableDeclaration) | fm_LParenlocalVariableDeclarationRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    ;

localVariableDeclaration
    :   ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((type) | fm_LParentypeRParenOne) ((variableDeclarators) | fm_LParenvariableDeclaratorsRParenOne)
    ;

statement
    :   ((block) | fm_LParenblockRParenOne)
    |   ((fm_ASSERTPlaceHolder | ASSERT) | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) ((expression) | fm_LParenexpressionRParenOne)) | fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((fm_IFPlaceHolder | IF ) | fm_LParenfm_IFPlaceHolderOrIFRParenOne) ((parExpression) | fm_LParenparExpressionRParenOne) statement ((((fm_ELSEPlaceHolder | ELSE ) | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne) statement) | fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion)?
    |   ((fm_FORPlaceHolder | FOR ) | fm_LParenfm_FORPlaceHolderOrFORRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((forControl) | fm_LParenforControlRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) statement
    |   ((fm_WHILEPlaceHolder | WHILE ) | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne) ((parExpression) | fm_LParenparExpressionRParenOne) statement
    |   ((fm_DOPlaceHolder | DO ) | fm_LParenfm_DOPlaceHolderOrDORParenOne) statement ((fm_WHILEPlaceHolder | WHILE ) | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne) ((parExpression) | fm_LParenparExpressionRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((fm_TRYPlaceHolder | TRY ) | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne) ((block) | fm_LParenblockRParenOne) (((fm_LParencatchClauseRParenIfLoop* ((catchClause) | fm_LParencatchClauseRParenOnePlus) (( catchClause      )  | fm_LParencatchClauseRParenStar)*) ((finallyBlock) | fm_LParenfinallyBlockRParenQuestion)? | ((finallyBlock) | fm_LParenfinallyBlockRParenOne)) | fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne)
    |   ((fm_TRYPlaceHolder | TRY ) | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne) ((resourceSpecification) | fm_LParenresourceSpecificationRParenOne) ((block) | fm_LParenblockRParenOne) ((catchClause) | fm_LParencatchClauseRParenStar)* ((finallyBlock) | fm_LParenfinallyBlockRParenQuestion)?
    |   ((fm_SWITCHPlaceHolder | SWITCH ) | fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne) ((parExpression) | fm_LParenparExpressionRParenOne) ((fm_LBRACEPlaceHolder | LBRACE ) | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne) ((switchBlockStatementGroup) | fm_LParenswitchBlockStatementGroupRParenStar)* ((switchLabel) | fm_LParenswitchLabelRParenStar)* ((fm_RBRACEPlaceHolder | RBRACE ) | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)
    |   ((fm_SYNCHRONIZEDPlaceHolder | SYNCHRONIZED ) | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne) ((parExpression) | fm_LParenparExpressionRParenOne) ((block) | fm_LParenblockRParenOne)
    |   ((fm_RETURNPlaceHolder | RETURN ) | fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((fm_THROWPlaceHolder | THROW ) | fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((fm_BREAKPlaceHolder | BREAK ) | fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((fm_CONTINUEPlaceHolder | CONTINUE ) | fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((statementExpression) | fm_LParenstatementExpressionRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)
    |   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) statement
    ;

catchClause
    :   ((fm_CATCHPlaceHolder | CATCH ) | fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne) ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((catchType) | fm_LParencatchTypeRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) ((block) | fm_LParenblockRParenOne)
    ;

catchType
    :   ((qualifiedName) | fm_LParenqualifiedNameRParenOne) ((((fm_BITORPlaceHolder | BITOR ) | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne) ((qualifiedName) | fm_LParenqualifiedNameRParenOne)) | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar)*
    ;

finallyBlock
    :   ((fm_FINALLYPlaceHolder | FINALLY ) | fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne) ((block) | fm_LParenblockRParenOne)
    ;

resourceSpecification
    :   ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((resources) | fm_LParenresourcesRParenOne) ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
    ;

resources
    :   ((resource) | fm_LParenresourceRParenOne) ((((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((resource) | fm_LParenresourceRParenOne)) | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar)*
    ;

resource
    :   ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((classOrInterfaceType) | fm_LParenclassOrInterfaceTypeRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne) ((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne) ((expression) | fm_LParenexpressionRParenOne)
    ;

/** Matches cases then statements, both of which are mandatory.
 *  To handle empty cases at the end, we add switchLabel* to statement.
 */
switchBlockStatementGroup
    :   (fm_LParenswitchLabelRParenIfLoop* ((switchLabel) | fm_LParenswitchLabelRParenOnePlus) (( switchLabel      )  | fm_LParenswitchLabelRParenStar)*) (fm_LParenblockStatementRParenIfLoop* ((blockStatement) | fm_LParenblockStatementRParenOnePlus) (( blockStatement      )  | fm_LParenblockStatementRParenStar)*)
    ;

switchLabel
    :   ((fm_CASEPlaceHolder | CASE ) | fm_LParenfm_CASEPlaceHolderOrCASERParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne)
    |   ((fm_CASEPlaceHolder | CASE ) | fm_LParenfm_CASEPlaceHolderOrCASERParenOne) ((enumConstantName) | fm_LParenenumConstantNameRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne)
    |   ((fm_DEFAULTPlaceHolder | DEFAULT ) | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne)
    ;

forControl
    :   ((enhancedForControl) | fm_LParenenhancedForControlRParenOne)
    |   ((forInit) | fm_LParenforInitRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SEMIPlaceHolder | SEMI ) | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne) ((forUpdate) | fm_LParenforUpdateRParenQuestion)?
    ;

forInit
    :   ((localVariableDeclaration) | fm_LParenlocalVariableDeclarationRParenOne)
    |   ((expressionList) | fm_LParenexpressionListRParenOne)
    ;

enhancedForControl
    :   ((variableModifier) | fm_LParenvariableModifierRParenStar)* ((type) | fm_LParentypeRParenOne) ((variableDeclaratorId) | fm_LParenvariableDeclaratorIdRParenOne) ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) ((expression) | fm_LParenexpressionRParenOne)
    ;

forUpdate
    :   ((expressionList) | fm_LParenexpressionListRParenOne)
    ;

// EXPRESSIONS

parExpression
    :   ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
    ;

expressionList
    :   ((expression) | fm_LParenexpressionRParenOne) ((((fm_COMMAPlaceHolder | COMMA ) | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne) ((expression) | fm_LParenexpressionRParenOne)) | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar)*
    ;

statementExpression
    :   ((expression) | fm_LParenexpressionRParenOne)
    ;

constantExpression
    :   ((expression) | fm_LParenexpressionRParenOne)
    ;

expression
    :   ((primary) | fm_LParenprimaryRParenOne)
    |   expression ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    |   expression ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
    |   expression ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((nonWildcardTypeArguments) | fm_LParennonWildcardTypeArgumentsRParenQuestion)? ((innerCreator) | fm_LPareninnerCreatorRParenOne)
    |   expression ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((superSuffix) | fm_LParensuperSuffixRParenOne)
    |   expression ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((explicitGenericInvocation) | fm_LParenexplicitGenericInvocationRParenOne)
    |   expression ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) expression ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)
    |   expression ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expressionList) | fm_LParenexpressionListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
    |   ((fm_NEWPlaceHolder | NEW ) | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne) ((creator) | fm_LParencreatorRParenOne)
    |   ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((type) | fm_LParentypeRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne) expression
    |   expression ((((fm_INCPlaceHolder | INC ) | fm_LParenfm_INCPlaceHolderOrINCRParenOne) | ((fm_DECPlaceHolder | DEC ) | fm_LParenfm_DECPlaceHolderOrDECRParenOne)) | fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne)
    |   ((((fm_ADDPlaceHolder | ADD ) | fm_LParenfm_ADDPlaceHolderOrADDRParenOne)|((fm_SUBPlaceHolder | SUB ) | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne)|((fm_INCPlaceHolder | INC ) | fm_LParenfm_INCPlaceHolderOrINCRParenOne)|((fm_DECPlaceHolder | DEC ) | fm_LParenfm_DECPlaceHolderOrDECRParenOne)) | fm_newRulexXXx6) expression
    |   ((((fm_TILDEPlaceHolder | TILDE ) | fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne)|((fm_BANGPlaceHolder | BANG ) | fm_LParenfm_BANGPlaceHolderOrBANGRParenOne)) | fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne) expression
    |   expression ((((fm_MULPlaceHolder | MUL ) | fm_LParenfm_MULPlaceHolderOrMULRParenOne)|((fm_DIVPlaceHolder | DIV ) | fm_LParenfm_DIVPlaceHolderOrDIVRParenOne)|((fm_MODPlaceHolder | MOD ) | fm_LParenfm_MODPlaceHolderOrMODRParenOne)) | fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne) expression
    |   expression ((((fm_ADDPlaceHolder | ADD ) | fm_LParenfm_ADDPlaceHolderOrADDRParenOne)|((fm_SUBPlaceHolder | SUB ) | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne)) | fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne) expression
    |   expression ((((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) | ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) | ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)) | fm_newRulexXXx7) expression
    |   expression ((((fm_LEPlaceHolder | LE ) | fm_LParenfm_LEPlaceHolderOrLERParenOne) | ((fm_GEPlaceHolder | GE ) | fm_LParenfm_GEPlaceHolderOrGERParenOne) | ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne) | ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne)) | fm_newRulexXXx8) expression
    |   expression ((fm_INSTANCEOFPlaceHolder | INSTANCEOF ) | fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne) ((type) | fm_LParentypeRParenOne)
    |   expression ((((fm_EQUALPlaceHolder | EQUAL ) | fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne) | ((fm_NOTEQUALPlaceHolder | NOTEQUAL ) | fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne)) | fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne) expression
    |   expression ((fm_BITANDPlaceHolder | BITAND ) | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne) expression
    |   expression ((fm_CARETPlaceHolder | CARET ) | fm_LParenfm_CARETPlaceHolderOrCARETRParenOne) expression
    |   expression ((fm_BITORPlaceHolder | BITOR ) | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne) expression
    |   expression ((fm_ANDPlaceHolder | AND ) | fm_LParenfm_ANDPlaceHolderOrANDRParenOne) expression
    |   expression ((fm_ORPlaceHolder | OR ) | fm_LParenfm_ORPlaceHolderOrORRParenOne) expression
    |   expression ((fm_QUESTIONPlaceHolder | QUESTION ) | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne) expression ((fm_COLONPlaceHolder | COLON ) | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne) expression
    |   <assoc=right> expression
        ((   ((fm_ASSIGNPlaceHolder | ASSIGN ) | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne)
        |   ((fm_ADD_ASSIGNPlaceHolder | ADD_ASSIGN ) | fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne)
        |   ((fm_SUB_ASSIGNPlaceHolder | SUB_ASSIGN ) | fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne)
        |   ((fm_MUL_ASSIGNPlaceHolder | MUL_ASSIGN ) | fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne)
        |   ((fm_DIV_ASSIGNPlaceHolder | DIV_ASSIGN ) | fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne)
        |   ((fm_AND_ASSIGNPlaceHolder | AND_ASSIGN ) | fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne)
        |   ((fm_OR_ASSIGNPlaceHolder | OR_ASSIGN ) | fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne)
        |   ((fm_XOR_ASSIGNPlaceHolder | XOR_ASSIGN ) | fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne)
        |   ((fm_RSHIFT_ASSIGNPlaceHolder | RSHIFT_ASSIGN ) | fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne)
        |   ((fm_URSHIFT_ASSIGNPlaceHolder | URSHIFT_ASSIGN ) | fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne)
        |   ((fm_LSHIFT_ASSIGNPlaceHolder | LSHIFT_ASSIGN ) | fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne)
        |   ((fm_MOD_ASSIGNPlaceHolder | MOD_ASSIGN ) | fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne)
        ) | fm_newRulexXXx9)
        expression
    ;

primary
    :   ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
    |   ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)
    |   ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne)
    |   ((literal) | fm_LParenliteralRParenOne)
    |   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    |   ((type) | fm_LParentypeRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
    |   ((fm_VOIDPlaceHolder | VOID ) | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne) ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_CLASSPlaceHolder | CLASS ) | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)
    |   ((nonWildcardTypeArguments) | fm_LParennonWildcardTypeArgumentsRParenOne) ((((explicitGenericInvocationSuffix) | fm_LParenexplicitGenericInvocationSuffixRParenOne) | ((fm_THISPlaceHolder | THIS ) | fm_LParenfm_THISPlaceHolderOrTHISRParenOne) ((arguments) | fm_LParenargumentsRParenOne)) | fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne)
    ;

creator
    :   ((nonWildcardTypeArguments) | fm_LParennonWildcardTypeArgumentsRParenOne) ((createdName) | fm_LParencreatedNameRParenOne) ((classCreatorRest) | fm_LParenclassCreatorRestRParenOne)
    |   ((createdName) | fm_LParencreatedNameRParenOne) ((((arrayCreatorRest) | fm_LParenarrayCreatorRestRParenOne) | ((classCreatorRest) | fm_LParenclassCreatorRestRParenOne)) | fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne)
    ;

createdName
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArgumentsOrDiamond) | fm_LParentypeArgumentsOrDiamondRParenQuestion)? ((((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((typeArgumentsOrDiamond) | fm_LParentypeArgumentsOrDiamondRParenQuestion)?) | fm_newRulexXXx10)*
    |   ((primitiveType) | fm_LParenprimitiveTypeRParenOne)
    ;

innerCreator
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((nonWildcardTypeArgumentsOrDiamond) | fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion)? ((classCreatorRest) | fm_LParenclassCreatorRestRParenOne)
    ;

arrayCreatorRest
    :   ((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne)
        ((   ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((arrayInitializer) | fm_LParenarrayInitializerRParenOne)
        |   ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne) ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)* ((((fm_LBRACKPlaceHolder | LBRACK ) | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne) ((fm_RBRACKPlaceHolder | RBRACK ) | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)) | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar)*
        ) | fm_newRulexXXx11)
    ;

classCreatorRest
    :   ((arguments) | fm_LParenargumentsRParenOne) ((classBody) | fm_LParenclassBodyRParenQuestion)?
    ;

explicitGenericInvocation
    :   ((nonWildcardTypeArguments) | fm_LParennonWildcardTypeArgumentsRParenOne) ((explicitGenericInvocationSuffix) | fm_LParenexplicitGenericInvocationSuffixRParenOne)
    ;

nonWildcardTypeArguments
    :   ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((typeList) | fm_LParentypeListRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)
    ;

typeArgumentsOrDiamond
    :   ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)
    |   ((typeArguments) | fm_LParentypeArgumentsRParenOne)
    ;

nonWildcardTypeArgumentsOrDiamond
    :   ((fm_LTPlaceHolder | LT ) | fm_LParenfm_LTPlaceHolderOrLTRParenOne) ((fm_GTPlaceHolder | GT ) | fm_LParenfm_GTPlaceHolderOrGTRParenOne)
    |   ((nonWildcardTypeArguments) | fm_LParennonWildcardTypeArgumentsRParenOne)
    ;

superSuffix
    :   ((arguments) | fm_LParenargumentsRParenOne)
    |   ((fm_DOTPlaceHolder | DOT ) | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((arguments) | fm_LParenargumentsRParenQuestion)?
    ;

explicitGenericInvocationSuffix
    :   ((fm_SUPERPlaceHolder | SUPER ) | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne) ((superSuffix) | fm_LParensuperSuffixRParenOne)
    |   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((arguments) | fm_LParenargumentsRParenOne)
    ;

arguments
    :   ((fm_LPARENPlaceHolder | LPAREN ) | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne) ((expressionList) | fm_LParenexpressionListRParenQuestion)? ((fm_RPARENPlaceHolder | RPAREN ) | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)
    ;

// LEXER

// §3.9 Keywords

ABSTRACT      : 'abstract';
fm_ABSTRACTPlaceHolder: FM_PlaceHolder; //language extension
ASSERT        : 'assert';
fm_ASSERTPlaceHolder: FM_PlaceHolder; //language extension
BOOLEAN       : 'boolean';
fm_BOOLEANPlaceHolder: FM_PlaceHolder; //language extension
BREAK         : 'break';
fm_BREAKPlaceHolder: FM_PlaceHolder; //language extension
BYTE          : 'byte';
fm_BYTEPlaceHolder: FM_PlaceHolder; //language extension
CASE          : 'case';
fm_CASEPlaceHolder: FM_PlaceHolder; //language extension
CATCH         : 'catch';
fm_CATCHPlaceHolder: FM_PlaceHolder; //language extension
CHAR          : 'char';
fm_CHARPlaceHolder: FM_PlaceHolder; //language extension
CLASS         : 'class';
fm_CLASSPlaceHolder: FM_PlaceHolder; //language extension
CONST         : 'const';
fm_CONSTPlaceHolder: FM_PlaceHolder; //language extension
CONTINUE      : 'continue';
fm_CONTINUEPlaceHolder: FM_PlaceHolder; //language extension
DEFAULT       : 'default';
fm_DEFAULTPlaceHolder: FM_PlaceHolder; //language extension
DO            : 'do';
fm_DOPlaceHolder: FM_PlaceHolder; //language extension
DOUBLE        : 'double';
fm_DOUBLEPlaceHolder: FM_PlaceHolder; //language extension
ELSE          : 'else';
fm_ELSEPlaceHolder: FM_PlaceHolder; //language extension
ENUM          : 'enum';
fm_ENUMPlaceHolder: FM_PlaceHolder; //language extension
EXTENDS       : 'extends';
fm_EXTENDSPlaceHolder: FM_PlaceHolder; //language extension
FINAL         : 'final';
fm_FINALPlaceHolder: FM_PlaceHolder; //language extension
FINALLY       : 'finally';
fm_FINALLYPlaceHolder: FM_PlaceHolder; //language extension
FLOAT         : 'float';
fm_FLOATPlaceHolder: FM_PlaceHolder; //language extension
FOR           : 'for';
fm_FORPlaceHolder: FM_PlaceHolder; //language extension
IF            : 'if';
fm_IFPlaceHolder: FM_PlaceHolder; //language extension
GOTO          : 'goto';
fm_GOTOPlaceHolder: FM_PlaceHolder; //language extension
IMPLEMENTS    : 'implements';
fm_IMPLEMENTSPlaceHolder: FM_PlaceHolder; //language extension
IMPORT        : 'import';
fm_IMPORTPlaceHolder: FM_PlaceHolder; //language extension
INSTANCEOF    : 'instanceof';
fm_INSTANCEOFPlaceHolder: FM_PlaceHolder; //language extension
INT           : 'int';
fm_INTPlaceHolder: FM_PlaceHolder; //language extension
INTERFACE     : 'interface';
fm_INTERFACEPlaceHolder: FM_PlaceHolder; //language extension
LONG          : 'long';
fm_LONGPlaceHolder: FM_PlaceHolder; //language extension
NATIVE        : 'native';
fm_NATIVEPlaceHolder: FM_PlaceHolder; //language extension
NEW           : 'new';
fm_NEWPlaceHolder: FM_PlaceHolder; //language extension
PACKAGE       : 'package';
fm_PACKAGEPlaceHolder: FM_PlaceHolder; //language extension
PRIVATE       : 'private';
fm_PRIVATEPlaceHolder: FM_PlaceHolder; //language extension
PROTECTED     : 'protected';
fm_PROTECTEDPlaceHolder: FM_PlaceHolder; //language extension
PUBLIC        : 'public';
fm_PUBLICPlaceHolder: FM_PlaceHolder; //language extension
RETURN        : 'return';
fm_RETURNPlaceHolder: FM_PlaceHolder; //language extension
SHORT         : 'short';
fm_SHORTPlaceHolder: FM_PlaceHolder; //language extension
STATIC        : 'static';
fm_STATICPlaceHolder: FM_PlaceHolder; //language extension
STRICTFP      : 'strictfp';
fm_STRICTFPPlaceHolder: FM_PlaceHolder; //language extension
SUPER         : 'super';
fm_SUPERPlaceHolder: FM_PlaceHolder; //language extension
SWITCH        : 'switch';
fm_SWITCHPlaceHolder: FM_PlaceHolder; //language extension
SYNCHRONIZED  : 'synchronized';
fm_SYNCHRONIZEDPlaceHolder: FM_PlaceHolder; //language extension
THIS          : 'this';
fm_THISPlaceHolder: FM_PlaceHolder; //language extension
THROW         : 'throw';
fm_THROWPlaceHolder: FM_PlaceHolder; //language extension
THROWS        : 'throws';
fm_THROWSPlaceHolder: FM_PlaceHolder; //language extension
TRANSIENT     : 'transient';
fm_TRANSIENTPlaceHolder: FM_PlaceHolder; //language extension
TRY           : 'try';
fm_TRYPlaceHolder: FM_PlaceHolder; //language extension
VOID          : 'void';
fm_VOIDPlaceHolder: FM_PlaceHolder; //language extension
VOLATILE      : 'volatile';
fm_VOLATILEPlaceHolder: FM_PlaceHolder; //language extension
WHILE         : 'while';
fm_WHILEPlaceHolder: FM_PlaceHolder; //language extension

// §3.10.1 Integer Literals

IntegerLiteral
    :   DecimalIntegerLiteral
    |   HexIntegerLiteral
    |   OctalIntegerLiteral
    |   BinaryIntegerLiteral
    ;
fm_IntegerLiteralPlaceHolder: FM_PlaceHolder; //language extension

fragment
DecimalIntegerLiteral
    :   DecimalNumeral IntegerTypeSuffix?
    ;

fragment
HexIntegerLiteral
    :   HexNumeral IntegerTypeSuffix?
    ;

fragment
OctalIntegerLiteral
    :   OctalNumeral IntegerTypeSuffix?
    ;

fragment
BinaryIntegerLiteral
    :   BinaryNumeral IntegerTypeSuffix?
    ;

fragment
IntegerTypeSuffix
    :   [lL]
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

fragment
Digits
    :   Digit (DigitOrUnderscore* Digit)?
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;

fragment
Underscores
    :   '_'+
    ;

fragment
HexNumeral
    :   '0' [xX] HexDigits
    ;

fragment
HexDigits
    :   HexDigit (HexDigitOrUnderscore* HexDigit)?
    ;

fragment
HexDigit
    :   [0-9a-fA-F]
    ;

fragment
HexDigitOrUnderscore
    :   HexDigit
    |   '_'
    ;

fragment
OctalNumeral
    :   '0' Underscores? OctalDigits
    ;

fragment
OctalDigits
    :   OctalDigit (OctalDigitOrUnderscore* OctalDigit)?
    ;

fragment
OctalDigit
    :   [0-7]
    ;

fragment
OctalDigitOrUnderscore
    :   OctalDigit
    |   '_'
    ;

fragment
BinaryNumeral
    :   '0' [bB] BinaryDigits
    ;

fragment
BinaryDigits
    :   BinaryDigit (BinaryDigitOrUnderscore* BinaryDigit)?
    ;

fragment
BinaryDigit
    :   [01]
    ;

fragment
BinaryDigitOrUnderscore
    :   BinaryDigit
    |   '_'
    ;

// §3.10.2 Floating-Point Literals

FloatingPointLiteral
    :   DecimalFloatingPointLiteral
    |   HexadecimalFloatingPointLiteral
    ;
fm_FloatingPointLiteralPlaceHolder: FM_PlaceHolder; //language extension

fragment
DecimalFloatingPointLiteral
    :   Digits '.' Digits? ExponentPart? FloatTypeSuffix?
    |   '.' Digits ExponentPart? FloatTypeSuffix?
    |   Digits ExponentPart FloatTypeSuffix?
    |   Digits FloatTypeSuffix
    ;

fragment
ExponentPart
    :   ExponentIndicator SignedInteger
    ;

fragment
ExponentIndicator
    :   [eE]
    ;

fragment
SignedInteger
    :   Sign? Digits
    ;

fragment
Sign
    :   [+-]
    ;

fragment
FloatTypeSuffix
    :   [fFdD]
    ;

fragment
HexadecimalFloatingPointLiteral
    :   HexSignificand BinaryExponent FloatTypeSuffix?
    ;

fragment
HexSignificand
    :   HexNumeral '.'?
    |   '0' [xX] HexDigits? '.' HexDigits
    ;

fragment
BinaryExponent
    :   BinaryExponentIndicator SignedInteger
    ;

fragment
BinaryExponentIndicator
    :   [pP]
    ;

// §3.10.3 Boolean Literals

BooleanLiteral
    :   'true'
    |   'false'
    ;
fm_BooleanLiteralPlaceHolder: FM_PlaceHolder; //language extension

// §3.10.4 Character Literals

CharacterLiteral
    :   '\'' SingleCharacter '\''
    |   '\'' EscapeSequence '\''
    ;
fm_CharacterLiteralPlaceHolder: FM_PlaceHolder; //language extension

fragment
SingleCharacter
    :   ~['\\]
    ;
// §3.10.5 String Literals
StringLiteral
    :   '"' StringCharacters? '"'
    ;
fm_StringLiteralPlaceHolder: FM_PlaceHolder; //language extension
fragment
StringCharacters
    :   StringCharacter+
    ;
fragment
StringCharacter
    :   ~["\\]
    |   EscapeSequence
    ;
// §3.10.6 Escape Sequences for Character and String Literals
fragment
EscapeSequence
    :   '\\' [btnfr"'\\]
    |   OctalEscape
    |   UnicodeEscape
    ;

fragment
OctalEscape
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' ZeroToThree OctalDigit OctalDigit
    ;

fragment
UnicodeEscape
    :   '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment
ZeroToThree
    :   [0-3]
    ;

// §3.10.7 The Null Literal

NullLiteral
    :   'null'
    ;
fm_NullLiteralPlaceHolder: FM_PlaceHolder; //language extension

// §3.11 Separators

LPAREN          : '(';
fm_LPARENPlaceHolder: FM_PlaceHolder; //language extension
RPAREN          : ')';
fm_RPARENPlaceHolder: FM_PlaceHolder; //language extension
LBRACE          : '{';
fm_LBRACEPlaceHolder: FM_PlaceHolder; //language extension
RBRACE          : '}';
fm_RBRACEPlaceHolder: FM_PlaceHolder; //language extension
LBRACK          : '[';
fm_LBRACKPlaceHolder: FM_PlaceHolder; //language extension
RBRACK          : ']';
fm_RBRACKPlaceHolder: FM_PlaceHolder; //language extension
SEMI            : ';';
fm_SEMIPlaceHolder: FM_PlaceHolder; //language extension
COMMA           : ',';
fm_COMMAPlaceHolder: FM_PlaceHolder; //language extension
DOT             : '.';
fm_DOTPlaceHolder: FM_PlaceHolder; //language extension

// §3.12 Operators

ASSIGN          : '=';
fm_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
GT              : '>';
fm_GTPlaceHolder: FM_PlaceHolder; //language extension
LT              : '<';
fm_LTPlaceHolder: FM_PlaceHolder; //language extension
BANG            : '!';
fm_BANGPlaceHolder: FM_PlaceHolder; //language extension
TILDE           : '~';
fm_TILDEPlaceHolder: FM_PlaceHolder; //language extension
QUESTION        : '?';
fm_QUESTIONPlaceHolder: FM_PlaceHolder; //language extension
COLON           : ':';
fm_COLONPlaceHolder: FM_PlaceHolder; //language extension
EQUAL           : '==';
fm_EQUALPlaceHolder: FM_PlaceHolder; //language extension
LE              : '<=';
fm_LEPlaceHolder: FM_PlaceHolder; //language extension
GE              : '>=';
fm_GEPlaceHolder: FM_PlaceHolder; //language extension
NOTEQUAL        : '!=';
fm_NOTEQUALPlaceHolder: FM_PlaceHolder; //language extension
AND             : '&&';
fm_ANDPlaceHolder: FM_PlaceHolder; //language extension
OR              : '||';
fm_ORPlaceHolder: FM_PlaceHolder; //language extension
INC             : '++';
fm_INCPlaceHolder: FM_PlaceHolder; //language extension
DEC             : '--';
fm_DECPlaceHolder: FM_PlaceHolder; //language extension
ADD             : '+';
fm_ADDPlaceHolder: FM_PlaceHolder; //language extension
SUB             : '-';
fm_SUBPlaceHolder: FM_PlaceHolder; //language extension
MUL             : '*';
fm_MULPlaceHolder: FM_PlaceHolder; //language extension
DIV             : '/';
fm_DIVPlaceHolder: FM_PlaceHolder; //language extension
BITAND          : '&';
fm_BITANDPlaceHolder: FM_PlaceHolder; //language extension
BITOR           : '|';
fm_BITORPlaceHolder: FM_PlaceHolder; //language extension
CARET           : '^';
fm_CARETPlaceHolder: FM_PlaceHolder; //language extension
MOD             : '%';
fm_MODPlaceHolder: FM_PlaceHolder; //language extension

ADD_ASSIGN      : '+=';
fm_ADD_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
SUB_ASSIGN      : '-=';
fm_SUB_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
MUL_ASSIGN      : '*=';
fm_MUL_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
DIV_ASSIGN      : '/=';
fm_DIV_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
AND_ASSIGN      : '&=';
fm_AND_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
OR_ASSIGN       : '|=';
fm_OR_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
XOR_ASSIGN      : '^=';
fm_XOR_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
MOD_ASSIGN      : '%=';
fm_MOD_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
LSHIFT_ASSIGN   : '<<=';
fm_LSHIFT_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
RSHIFT_ASSIGN   : '>>=';
fm_RSHIFT_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension
URSHIFT_ASSIGN  : '>>>=';
fm_URSHIFT_ASSIGNPlaceHolder: FM_PlaceHolder; //language extension

// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;
fm_IdentifierPlaceHolder: FM_PlaceHolder; //language extension

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
        {Character.isJavaIdentifierStart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
        {Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)))}?
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
        {Character.isJavaIdentifierPart(_input.LA(-1))}?
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
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
FM_PlaceHolder: '${' .*? '}'  ;
fm_LParenblockStatementRParenIfLoop: '<#if' .*?'>'(( blockStatement      ) * | fm_LParenblockStatementRParenIfLoop*)('<#elseif' .*?'>'(( blockStatement      ) * | fm_LParenblockStatementRParenIfLoop*))*'</#if>'| '<#list' .*? 'as' .*? '>'(( blockStatement      ) * | fm_LParenblockStatementRParenIfLoop*)'</#list>';
fm_LParenswitchLabelRParenIfLoop: '<#if' .*?'>'(( switchLabel      ) * | fm_LParenswitchLabelRParenIfLoop*)('<#elseif' .*?'>'(( switchLabel      ) * | fm_LParenswitchLabelRParenIfLoop*))*'</#if>'| '<#list' .*? 'as' .*? '>'(( switchLabel      ) * | fm_LParenswitchLabelRParenIfLoop*)'</#list>';
fm_LParencatchClauseRParenIfLoop: '<#if' .*?'>'(( catchClause      ) * | fm_LParencatchClauseRParenIfLoop*)('<#elseif' .*?'>'(( catchClause      ) * | fm_LParencatchClauseRParenIfLoop*))*'</#if>'| '<#list' .*? 'as' .*? '>'(( catchClause      ) * | fm_LParencatchClauseRParenIfLoop*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar*)'</#list>';
fm_LParenLParenannotationTypeElementDeclarationRParenRParenStar: '<#if' .*?'>'(( ( annotationTypeElementDeclaration      )      ) * | fm_LParenLParenannotationTypeElementDeclarationRParenRParenStar*)('<#elseif' .*?'>'(( ( annotationTypeElementDeclaration      )      ) * | fm_LParenLParenannotationTypeElementDeclarationRParenRParenStar*))*('<#else>'(( ( annotationTypeElementDeclaration      )      ) * | fm_LParenLParenannotationTypeElementDeclarationRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( annotationTypeElementDeclaration      )      ) * | fm_LParenLParenannotationTypeElementDeclarationRParenRParenStar*)'</#list>';
fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar: '<#if' .*?'>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*))*('<#else>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )      ) * | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar*)'</#list>';
fm_LParenvariableModifierRParenStar: '<#if' .*?'>'(( variableModifier      ) * | fm_LParenvariableModifierRParenStar*)('<#elseif' .*?'>'(( variableModifier      ) * | fm_LParenvariableModifierRParenStar*))*('<#else>'(( variableModifier      ) * | fm_LParenvariableModifierRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( variableModifier      ) * | fm_LParenvariableModifierRParenStar*)'</#list>';
fm_LParenmodifierRParenStar: '<#if' .*?'>'(( modifier      ) * | fm_LParenmodifierRParenStar*)('<#elseif' .*?'>'(( modifier      ) * | fm_LParenmodifierRParenStar*))*('<#else>'(( modifier      ) * | fm_LParenmodifierRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( modifier      ) * | fm_LParenmodifierRParenStar*)'</#list>';
fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar: '<#if' .*?'>'(( ( fm_BITANDPlaceHolder     | BITAND      )    ( type      )      ) * | fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_BITANDPlaceHolder     | BITAND      )    ( type      )      ) * | fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar*))*('<#else>'(( ( fm_BITANDPlaceHolder     | BITAND      )    ( type      )      ) * | fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_BITANDPlaceHolder     | BITAND      )    ( type      )      ) * | fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( typeArgument      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar*)'</#list>';
fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar: '<#if' .*?'>'(( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*))*('<#else>'(( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_SEMIPlaceHolder     | SEMI      )    ( resource      )      ) * | fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar*)'</#list>';
fm_LParenswitchBlockStatementGroupRParenStar: '<#if' .*?'>'(( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*)('<#elseif' .*?'>'(( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*))*('<#else>'(( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( switchBlockStatementGroup      ) * | fm_LParenswitchBlockStatementGroupRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( constantDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( constantDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( constantDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( constantDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar*)'</#list>';
fm_LParencatchClauseRParenStar: '<#if' .*?'>'(( catchClause      ) * | fm_LParencatchClauseRParenStar*)('<#elseif' .*?'>'(( catchClause      ) * | fm_LParencatchClauseRParenStar*))*('<#else>'(( catchClause      ) * | fm_LParencatchClauseRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( catchClause      ) * | fm_LParencatchClauseRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( formalParameter      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar*)'</#list>';
fm_newRulexXXx10: '<#if' .*?'>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )    ( typeArgumentsOrDiamond      )  ?       ) * | fm_newRulexXXx10*)('<#elseif' .*?'>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )    ( typeArgumentsOrDiamond      )  ?       ) * | fm_newRulexXXx10*))*('<#else>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )    ( typeArgumentsOrDiamond      )  ?       ) * | fm_newRulexXXx10*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )    ( typeArgumentsOrDiamond      )  ?       ) * | fm_newRulexXXx10*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( expression      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar*)'</#list>';
fm_LParenimportDeclarationRParenStar: '<#if' .*?'>'(( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*)('<#elseif' .*?'>'(( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*))*('<#else>'(( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( importDeclaration      ) * | fm_LParenimportDeclarationRParenStar*)'</#list>';
fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar: '<#if' .*?'>'(( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*))*('<#else>'(( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*)'</#list>';
fm_LParenswitchLabelRParenStar: '<#if' .*?'>'(( switchLabel      ) * | fm_LParenswitchLabelRParenStar*)('<#elseif' .*?'>'(( switchLabel      ) * | fm_LParenswitchLabelRParenStar*))*('<#else>'(( switchLabel      ) * | fm_LParenswitchLabelRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( switchLabel      ) * | fm_LParenswitchLabelRParenStar*)'</#list>';
fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar: '<#if' .*?'>'(( ( fm_BITORPlaceHolder     | BITOR      )    ( qualifiedName      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_BITORPlaceHolder     | BITOR      )    ( qualifiedName      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar*))*('<#else>'(( ( fm_BITORPlaceHolder     | BITOR      )    ( qualifiedName      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_BITORPlaceHolder     | BITOR      )    ( qualifiedName      )      ) * | fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar*)'</#list>';
fm_LParenclassOrInterfaceModifierRParenStar: '<#if' .*?'>'(( classOrInterfaceModifier      ) * | fm_LParenclassOrInterfaceModifierRParenStar*)('<#elseif' .*?'>'(( classOrInterfaceModifier      ) * | fm_LParenclassOrInterfaceModifierRParenStar*))*('<#else>'(( classOrInterfaceModifier      ) * | fm_LParenclassOrInterfaceModifierRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( classOrInterfaceModifier      ) * | fm_LParenclassOrInterfaceModifierRParenStar*)'</#list>';
fm_LParentypeDeclarationRParenStar: '<#if' .*?'>'(( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*)('<#elseif' .*?'>'(( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*))*('<#else>'(( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( typeDeclaration      ) * | fm_LParentypeDeclarationRParenStar*)'</#list>';
fm_newRulexXXx3: '<#if' .*?'>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )    ( typeArguments      )  ?       ) * | fm_newRulexXXx3*)('<#elseif' .*?'>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )    ( typeArguments      )  ?       ) * | fm_newRulexXXx3*))*('<#else>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )    ( typeArguments      )  ?       ) * | fm_newRulexXXx3*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_IdentifierPlaceHolder     | Identifier      )    ( typeArguments      )  ?       ) * | fm_newRulexXXx3*)'</#list>';
fm_LParenclassBodyDeclarationRParenStar: '<#if' .*?'>'(( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*)('<#elseif' .*?'>'(( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*))*('<#else>'(( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( classBodyDeclaration      ) * | fm_LParenclassBodyDeclarationRParenStar*)'</#list>';
fm_LParenblockStatementRParenStar: '<#if' .*?'>'(( blockStatement      ) * | fm_LParenblockStatementRParenStar*)('<#elseif' .*?'>'(( blockStatement      ) * | fm_LParenblockStatementRParenStar*))*('<#else>'(( blockStatement      ) * | fm_LParenblockStatementRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( blockStatement      ) * | fm_LParenblockStatementRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( type      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( type      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( type      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( type      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar*)'</#list>';
fm_LParenannotationRParenStar: '<#if' .*?'>'(( annotation      ) * | fm_LParenannotationRParenStar*)('<#elseif' .*?'>'(( annotation      ) * | fm_LParenannotationRParenStar*))*('<#else>'(( annotation      ) * | fm_LParenannotationRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( annotation      ) * | fm_LParenannotationRParenStar*)'</#list>';
fm_LPareninterfaceBodyDeclarationRParenStar: '<#if' .*?'>'(( interfaceBodyDeclaration      ) * | fm_LPareninterfaceBodyDeclarationRParenStar*)('<#elseif' .*?'>'(( interfaceBodyDeclaration      ) * | fm_LPareninterfaceBodyDeclarationRParenStar*))*('<#else>'(( interfaceBodyDeclaration      ) * | fm_LPareninterfaceBodyDeclarationRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( interfaceBodyDeclaration      ) * | fm_LPareninterfaceBodyDeclarationRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( enumConstant      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValuePair      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableDeclarator      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar*)'</#list>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( qualifiedName      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( qualifiedName      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar*))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( qualifiedName      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( qualifiedName      )      ) * | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar*)'</#list>';
fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar: '<#if' .*?'>'(( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*))*('<#else>'(( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      ) * | fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar*)'</#list>';
fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion: '<#if' .*?'>'(( nonWildcardTypeArgumentsOrDiamond      ) ? | fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion?)('<#elseif' .*?'>'(( nonWildcardTypeArgumentsOrDiamond      ) ? | fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion?))*('<#else>'(( nonWildcardTypeArgumentsOrDiamond      ) ? | fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion?))?'</#if>';
fm_LParenexpressionRParenQuestion: '<#if' .*?'>'(( expression      ) ? | fm_LParenexpressionRParenQuestion?)('<#elseif' .*?'>'(( expression      ) ? | fm_LParenexpressionRParenQuestion?))*('<#else>'(( expression      ) ? | fm_LParenexpressionRParenQuestion?))?'</#if>';
fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion: '<#if' .*?'>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( type      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( type      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion?))*('<#else>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( type      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion?))?'</#if>';
fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion: '<#if' .*?'>'(( ( fm_ELSEPlaceHolder     | ELSE      )    statement      ) ? | fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion?)('<#elseif' .*?'>'(( ( fm_ELSEPlaceHolder     | ELSE      )    statement      ) ? | fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion?))*('<#else>'(( ( fm_ELSEPlaceHolder     | ELSE      )    statement      ) ? | fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion?))?'</#if>';
fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion: '<#if' .*?'>'(( ( fm_ASSIGNPlaceHolder     | ASSIGN      )    ( variableInitializer      )      ) ? | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_ASSIGNPlaceHolder     | ASSIGN      )    ( variableInitializer      )      ) ? | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion?))*('<#else>'(( ( fm_ASSIGNPlaceHolder     | ASSIGN      )    ( variableInitializer      )      ) ? | fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion?))?'</#if>';
fm_LParenexpressionListRParenQuestion: '<#if' .*?'>'(( expressionList      ) ? | fm_LParenexpressionListRParenQuestion?)('<#elseif' .*?'>'(( expressionList      ) ? | fm_LParenexpressionListRParenQuestion?))*('<#else>'(( expressionList      ) ? | fm_LParenexpressionListRParenQuestion?))?'</#if>';
fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion: '<#if' .*?'>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( typeList      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( typeList      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion?))*('<#else>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( typeList      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion?))?'</#if>';
fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion: '<#if' .*?'>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( typeBound      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( typeBound      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion?))*('<#else>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )    ( typeBound      )      ) ? | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion?))?'</#if>';
fm_LParenforUpdateRParenQuestion: '<#if' .*?'>'(( forUpdate      ) ? | fm_LParenforUpdateRParenQuestion?)('<#elseif' .*?'>'(( forUpdate      ) ? | fm_LParenforUpdateRParenQuestion?))*('<#else>'(( forUpdate      ) ? | fm_LParenforUpdateRParenQuestion?))?'</#if>';
fm_LParentypeArgumentsOrDiamondRParenQuestion: '<#if' .*?'>'(( typeArgumentsOrDiamond      ) ? | fm_LParentypeArgumentsOrDiamondRParenQuestion?)('<#elseif' .*?'>'(( typeArgumentsOrDiamond      ) ? | fm_LParentypeArgumentsOrDiamondRParenQuestion?))*('<#else>'(( typeArgumentsOrDiamond      ) ? | fm_LParentypeArgumentsOrDiamondRParenQuestion?))?'</#if>';
fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion: '<#if' .*?'>'(( fm_COMMAPlaceHolder     | COMMA      ) ? | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion?)('<#elseif' .*?'>'(( fm_COMMAPlaceHolder     | COMMA      ) ? | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion?))*('<#else>'(( fm_COMMAPlaceHolder     | COMMA      ) ? | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion?))?'</#if>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )      ) ? | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )      ) ? | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion?))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )      ) ? | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion?))?'</#if>';
fm_LParenpackageDeclarationRParenQuestion: '<#if' .*?'>'(( packageDeclaration      ) ? | fm_LParenpackageDeclarationRParenQuestion?)('<#elseif' .*?'>'(( packageDeclaration      ) ? | fm_LParenpackageDeclarationRParenQuestion?))*('<#else>'(( packageDeclaration      ) ? | fm_LParenpackageDeclarationRParenQuestion?))?'</#if>';
fm_LParenenumConstantsRParenQuestion: '<#if' .*?'>'(( enumConstants      ) ? | fm_LParenenumConstantsRParenQuestion?)('<#elseif' .*?'>'(( enumConstants      ) ? | fm_LParenenumConstantsRParenQuestion?))*('<#else>'(( enumConstants      ) ? | fm_LParenenumConstantsRParenQuestion?))?'</#if>';
fm_LParennonWildcardTypeArgumentsRParenQuestion: '<#if' .*?'>'(( nonWildcardTypeArguments      ) ? | fm_LParennonWildcardTypeArgumentsRParenQuestion?)('<#elseif' .*?'>'(( nonWildcardTypeArguments      ) ? | fm_LParennonWildcardTypeArgumentsRParenQuestion?))*('<#else>'(( nonWildcardTypeArguments      ) ? | fm_LParennonWildcardTypeArgumentsRParenQuestion?))?'</#if>';
fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion: '<#if' .*?'>'(( fm_SEMIPlaceHolder     | SEMI      ) ? | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion?)('<#elseif' .*?'>'(( fm_SEMIPlaceHolder     | SEMI      ) ? | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion?))*('<#else>'(( fm_SEMIPlaceHolder     | SEMI      ) ? | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion?))?'</#if>';
fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion: '<#if' .*?'>'(( fm_STATICPlaceHolder     | STATIC      ) ? | fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion?)('<#elseif' .*?'>'(( fm_STATICPlaceHolder     | STATIC      ) ? | fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion?))*('<#else>'(( fm_STATICPlaceHolder     | STATIC      ) ? | fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion?))?'</#if>';
fm_LParenargumentsRParenQuestion: '<#if' .*?'>'(( arguments      ) ? | fm_LParenargumentsRParenQuestion?)('<#elseif' .*?'>'(( arguments      ) ? | fm_LParenargumentsRParenQuestion?))*('<#else>'(( arguments      ) ? | fm_LParenargumentsRParenQuestion?))?'</#if>';
fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion: '<#if' .*?'>'(( ( fm_THROWSPlaceHolder     | THROWS      )    ( qualifiedNameList      )      ) ? | fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_THROWSPlaceHolder     | THROWS      )    ( qualifiedNameList      )      ) ? | fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion?))*('<#else>'(( ( fm_THROWSPlaceHolder     | THROWS      )    ( qualifiedNameList      )      ) ? | fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion?))?'</#if>';
fm_LParentypeParametersRParenQuestion: '<#if' .*?'>'(( typeParameters      ) ? | fm_LParentypeParametersRParenQuestion?)('<#elseif' .*?'>'(( typeParameters      ) ? | fm_LParentypeParametersRParenQuestion?))*('<#else>'(( typeParameters      ) ? | fm_LParentypeParametersRParenQuestion?))?'</#if>';
fm_LParendefaultValueRParenQuestion: '<#if' .*?'>'(( defaultValue      ) ? | fm_LParendefaultValueRParenQuestion?)('<#elseif' .*?'>'(( defaultValue      ) ? | fm_LParendefaultValueRParenQuestion?))*('<#else>'(( defaultValue      ) ? | fm_LParendefaultValueRParenQuestion?))?'</#if>';
fm_newRulexXXx4: '<#if' .*?'>'(( ( ( fm_EXTENDSPlaceHolder     | EXTENDS      )     | ( fm_SUPERPlaceHolder     | SUPER      )      )    ( type      )      ) ? | fm_newRulexXXx4?)('<#elseif' .*?'>'(( ( ( fm_EXTENDSPlaceHolder     | EXTENDS      )     | ( fm_SUPERPlaceHolder     | SUPER      )      )    ( type      )      ) ? | fm_newRulexXXx4?))*('<#else>'(( ( ( fm_EXTENDSPlaceHolder     | EXTENDS      )     | ( fm_SUPERPlaceHolder     | SUPER      )      )    ( type      )      ) ? | fm_newRulexXXx4?))?'</#if>';
fm_LParenenumBodyDeclarationsRParenQuestion: '<#if' .*?'>'(( enumBodyDeclarations      ) ? | fm_LParenenumBodyDeclarationsRParenQuestion?)('<#elseif' .*?'>'(( enumBodyDeclarations      ) ? | fm_LParenenumBodyDeclarationsRParenQuestion?))*('<#else>'(( enumBodyDeclarations      ) ? | fm_LParenenumBodyDeclarationsRParenQuestion?))?'</#if>';
fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion: '<#if' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( lastFormalParameter      )      ) ? | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( lastFormalParameter      )      ) ? | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion?))*('<#else>'(( ( fm_COMMAPlaceHolder     | COMMA      )    ( lastFormalParameter      )      ) ? | fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion?))?'</#if>';
fm_LParenclassBodyRParenQuestion: '<#if' .*?'>'(( classBody      ) ? | fm_LParenclassBodyRParenQuestion?)('<#elseif' .*?'>'(( classBody      ) ? | fm_LParenclassBodyRParenQuestion?))*('<#else>'(( classBody      ) ? | fm_LParenclassBodyRParenQuestion?))?'</#if>';
fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion: '<#if' .*?'>'(( ( elementValuePairs      )     | ( elementValue      )      ) ? | fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion?)('<#elseif' .*?'>'(( ( elementValuePairs      )     | ( elementValue      )      ) ? | fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion?))*('<#else>'(( ( elementValuePairs      )     | ( elementValue      )      ) ? | fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion?))?'</#if>';
fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion: '<#if' .*?'>'(( ( fm_COLONPlaceHolder     | COLON      )    ( expression      )      ) ? | fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_COLONPlaceHolder     | COLON      )    ( expression      )      ) ? | fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion?))*('<#else>'(( ( fm_COLONPlaceHolder     | COLON      )    ( expression      )      ) ? | fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion?))?'</#if>';
fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion: '<#if' .*?'>'(( ( elementValue      )    ( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      )  *       ) ? | fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion?)('<#elseif' .*?'>'(( ( elementValue      )    ( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      )  *       ) ? | fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion?))*('<#else>'(( ( elementValue      )    ( ( fm_COMMAPlaceHolder     | COMMA      )    ( elementValue      )      )  *       ) ? | fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion?))?'</#if>';
fm_newRulexXXx5: '<#if' .*?'>'(( ( fm_LPARENPlaceHolder     | LPAREN      )    ( ( elementValuePairs      )     | ( elementValue      )      )  ?     ( fm_RPARENPlaceHolder     | RPAREN      )      ) ? | fm_newRulexXXx5?)('<#elseif' .*?'>'(( ( fm_LPARENPlaceHolder     | LPAREN      )    ( ( elementValuePairs      )     | ( elementValue      )      )  ?     ( fm_RPARENPlaceHolder     | RPAREN      )      ) ? | fm_newRulexXXx5?))*('<#else>'(( ( fm_LPARENPlaceHolder     | LPAREN      )    ( ( elementValuePairs      )     | ( elementValue      )      )  ?     ( fm_RPARENPlaceHolder     | RPAREN      )      ) ? | fm_newRulexXXx5?))?'</#if>';
fm_LParentypeArgumentsRParenQuestion: '<#if' .*?'>'(( typeArguments      ) ? | fm_LParentypeArgumentsRParenQuestion?)('<#elseif' .*?'>'(( typeArguments      ) ? | fm_LParentypeArgumentsRParenQuestion?))*('<#else>'(( typeArguments      ) ? | fm_LParentypeArgumentsRParenQuestion?))?'</#if>';
fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion: '<#if' .*?'>'(( ( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )    ( typeList      )      ) ? | fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )    ( typeList      )      ) ? | fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion?))*('<#else>'(( ( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )    ( typeList      )      ) ? | fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion?))?'</#if>';
fm_LParenforInitRParenQuestion: '<#if' .*?'>'(( forInit      ) ? | fm_LParenforInitRParenQuestion?)('<#elseif' .*?'>'(( forInit      ) ? | fm_LParenforInitRParenQuestion?))*('<#else>'(( forInit      ) ? | fm_LParenforInitRParenQuestion?))?'</#if>';
fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion: '<#if' .*?'>'(( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?)('<#elseif' .*?'>'(( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?))*('<#else>'(( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?))?'</#if>';
fm_newRulexXXx2: '<#if' .*?'>'(( ( variableInitializer      )    ( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      )  *     ( ( fm_COMMAPlaceHolder     | COMMA      )      )  ?       ) ? | fm_newRulexXXx2?)('<#elseif' .*?'>'(( ( variableInitializer      )    ( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      )  *     ( ( fm_COMMAPlaceHolder     | COMMA      )      )  ?       ) ? | fm_newRulexXXx2?))*('<#else>'(( ( variableInitializer      )    ( ( fm_COMMAPlaceHolder     | COMMA      )    ( variableInitializer      )      )  *     ( ( fm_COMMAPlaceHolder     | COMMA      )      )  ?       ) ? | fm_newRulexXXx2?))?'</#if>';
fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion: '<#if' .*?'>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_MULPlaceHolder     | MUL      )      ) ? | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_MULPlaceHolder     | MUL      )      ) ? | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion?))*('<#else>'(( ( fm_DOTPlaceHolder     | DOT      )    ( fm_MULPlaceHolder     | MUL      )      ) ? | fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion?))?'</#if>';
fm_LParenfinallyBlockRParenQuestion: '<#if' .*?'>'(( finallyBlock      ) ? | fm_LParenfinallyBlockRParenQuestion?)('<#elseif' .*?'>'(( finallyBlock      ) ? | fm_LParenfinallyBlockRParenQuestion?))*('<#else>'(( finallyBlock      ) ? | fm_LParenfinallyBlockRParenQuestion?))?'</#if>';
fm_LParenformalParameterListRParenQuestion: '<#if' .*?'>'(( formalParameterList      ) ? | fm_LParenformalParameterListRParenQuestion?)('<#elseif' .*?'>'(( formalParameterList      ) ? | fm_LParenformalParameterListRParenQuestion?))*('<#else>'(( formalParameterList      ) ? | fm_LParenformalParameterListRParenQuestion?))?'</#if>';
fm_LParenfm_LEPlaceHolderOrLERParenOne: '<#if' .*?'>'(( fm_LEPlaceHolder     | LE      )  | fm_LParenfm_LEPlaceHolderOrLERParenOne)('<#elseif' .*?'>'(( fm_LEPlaceHolder     | LE      )  | fm_LParenfm_LEPlaceHolderOrLERParenOne))*'<#else>'(( fm_LEPlaceHolder     | LE      )  | fm_LParenfm_LEPlaceHolderOrLERParenOne)'</#if>';
fm_LParenforControlRParenOne: '<#if' .*?'>'(( forControl      )  | fm_LParenforControlRParenOne)('<#elseif' .*?'>'(( forControl      )  | fm_LParenforControlRParenOne))*'<#else>'(( forControl      )  | fm_LParenforControlRParenOne)'</#if>';
fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne: '<#if' .*?'>'(( fm_WHILEPlaceHolder     | WHILE      )  | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne)('<#elseif' .*?'>'(( fm_WHILEPlaceHolder     | WHILE      )  | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne))*'<#else>'(( fm_WHILEPlaceHolder     | WHILE      )  | fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne)'</#if>';
fm_LParenarrayCreatorRestRParenOne: '<#if' .*?'>'(( arrayCreatorRest      )  | fm_LParenarrayCreatorRestRParenOne)('<#elseif' .*?'>'(( arrayCreatorRest      )  | fm_LParenarrayCreatorRestRParenOne))*'<#else>'(( arrayCreatorRest      )  | fm_LParenarrayCreatorRestRParenOne)'</#if>';
fm_LParencreatorRParenOne: '<#if' .*?'>'(( creator      )  | fm_LParencreatorRParenOne)('<#elseif' .*?'>'(( creator      )  | fm_LParencreatorRParenOne))*'<#else>'(( creator      )  | fm_LParencreatorRParenOne)'</#if>';
fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne: '<#if' .*?'>'(( fm_VOIDPlaceHolder     | VOID      )  | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne)('<#elseif' .*?'>'(( fm_VOIDPlaceHolder     | VOID      )  | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne))*'<#else>'(( fm_VOIDPlaceHolder     | VOID      )  | fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne)'</#if>';
fm_LParenfm_CHARPlaceHolderOrCHARRParenOne: '<#if' .*?'>'(( fm_CHARPlaceHolder     | CHAR      )  | fm_LParenfm_CHARPlaceHolderOrCHARRParenOne)('<#elseif' .*?'>'(( fm_CHARPlaceHolder     | CHAR      )  | fm_LParenfm_CHARPlaceHolderOrCHARRParenOne))*'<#else>'(( fm_CHARPlaceHolder     | CHAR      )  | fm_LParenfm_CHARPlaceHolderOrCHARRParenOne)'</#if>';
fm_LParenannotationConstantRestRParenOne: '<#if' .*?'>'(( annotationConstantRest      )  | fm_LParenannotationConstantRestRParenOne)('<#elseif' .*?'>'(( annotationConstantRest      )  | fm_LParenannotationConstantRestRParenOne))*'<#else>'(( annotationConstantRest      )  | fm_LParenannotationConstantRestRParenOne)'</#if>';
fm_LParenfm_IFPlaceHolderOrIFRParenOne: '<#if' .*?'>'(( fm_IFPlaceHolder     | IF      )  | fm_LParenfm_IFPlaceHolderOrIFRParenOne)('<#elseif' .*?'>'(( fm_IFPlaceHolder     | IF      )  | fm_LParenfm_IFPlaceHolderOrIFRParenOne))*'<#else>'(( fm_IFPlaceHolder     | IF      )  | fm_LParenfm_IFPlaceHolderOrIFRParenOne)'</#if>';
fm_newRulexXXx7: '<#if' .*?'>'(( ( fm_LTPlaceHolder     | LT      )    ( fm_LTPlaceHolder     | LT      )     | ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )     | ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )      )  | fm_newRulexXXx7)('<#elseif' .*?'>'(( ( fm_LTPlaceHolder     | LT      )    ( fm_LTPlaceHolder     | LT      )     | ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )     | ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )      )  | fm_newRulexXXx7))*'<#else>'(( ( fm_LTPlaceHolder     | LT      )    ( fm_LTPlaceHolder     | LT      )     | ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )     | ( fm_GTPlaceHolder     | GT      )    ( fm_GTPlaceHolder     | GT      )      )  | fm_newRulexXXx7)'</#if>';
fm_LParengenericMethodDeclarationRParenOne: '<#if' .*?'>'(( genericMethodDeclaration      )  | fm_LParengenericMethodDeclarationRParenOne)('<#elseif' .*?'>'(( genericMethodDeclaration      )  | fm_LParengenericMethodDeclarationRParenOne))*'<#else>'(( genericMethodDeclaration      )  | fm_LParengenericMethodDeclarationRParenOne)'</#if>';
fm_LParengenericInterfaceMethodDeclarationRParenOne: '<#if' .*?'>'(( genericInterfaceMethodDeclaration      )  | fm_LParengenericInterfaceMethodDeclarationRParenOne)('<#elseif' .*?'>'(( genericInterfaceMethodDeclaration      )  | fm_LParengenericInterfaceMethodDeclarationRParenOne))*'<#else>'(( genericInterfaceMethodDeclaration      )  | fm_LParengenericInterfaceMethodDeclarationRParenOne)'</#if>';
fm_LParenannotationTypeBodyRParenOne: '<#if' .*?'>'(( annotationTypeBody      )  | fm_LParenannotationTypeBodyRParenOne)('<#elseif' .*?'>'(( annotationTypeBody      )  | fm_LParenannotationTypeBodyRParenOne))*'<#else>'(( annotationTypeBody      )  | fm_LParenannotationTypeBodyRParenOne)'</#if>';
fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne: '<#if' .*?'>'(( ( arrayCreatorRest      )     | ( classCreatorRest      )      )  | fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne)('<#elseif' .*?'>'(( ( arrayCreatorRest      )     | ( classCreatorRest      )      )  | fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne))*'<#else>'(( ( arrayCreatorRest      )     | ( classCreatorRest      )      )  | fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne)'</#if>';
fm_LParenfm_TRYPlaceHolderOrTRYRParenOne: '<#if' .*?'>'(( fm_TRYPlaceHolder     | TRY      )  | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne)('<#elseif' .*?'>'(( fm_TRYPlaceHolder     | TRY      )  | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne))*'<#else>'(( fm_TRYPlaceHolder     | TRY      )  | fm_LParenfm_TRYPlaceHolderOrTRYRParenOne)'</#if>';
fm_LParenfm_FINALPlaceHolderOrFINALRParenOne: '<#if' .*?'>'(( fm_FINALPlaceHolder     | FINAL      )  | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)('<#elseif' .*?'>'(( fm_FINALPlaceHolder     | FINAL      )  | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne))*'<#else>'(( fm_FINALPlaceHolder     | FINAL      )  | fm_LParenfm_FINALPlaceHolderOrFINALRParenOne)'</#if>';
fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne: '<#if' .*?'>'(( fm_QUESTIONPlaceHolder     | QUESTION      )  | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne)('<#elseif' .*?'>'(( fm_QUESTIONPlaceHolder     | QUESTION      )  | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne))*'<#else>'(( fm_QUESTIONPlaceHolder     | QUESTION      )  | fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne)'</#if>';
fm_LParenfm_SUBPlaceHolderOrSUBRParenOne: '<#if' .*?'>'(( fm_SUBPlaceHolder     | SUB      )  | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne)('<#elseif' .*?'>'(( fm_SUBPlaceHolder     | SUB      )  | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne))*'<#else>'(( fm_SUBPlaceHolder     | SUB      )  | fm_LParenfm_SUBPlaceHolderOrSUBRParenOne)'</#if>';
fm_LParenprimaryRParenOne: '<#if' .*?'>'(( primary      )  | fm_LParenprimaryRParenOne)('<#elseif' .*?'>'(( primary      )  | fm_LParenprimaryRParenOne))*'<#else>'(( primary      )  | fm_LParenprimaryRParenOne)'</#if>';
fm_LParenclassOrInterfaceTypeRParenOne: '<#if' .*?'>'(( classOrInterfaceType      )  | fm_LParenclassOrInterfaceTypeRParenOne)('<#elseif' .*?'>'(( classOrInterfaceType      )  | fm_LParenclassOrInterfaceTypeRParenOne))*'<#else>'(( classOrInterfaceType      )  | fm_LParenclassOrInterfaceTypeRParenOne)'</#if>';
fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne: '<#if' .*?'>'(( fm_TRANSIENTPlaceHolder     | TRANSIENT      )  | fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne)('<#elseif' .*?'>'(( fm_TRANSIENTPlaceHolder     | TRANSIENT      )  | fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne))*'<#else>'(( fm_TRANSIENTPlaceHolder     | TRANSIENT      )  | fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne)'</#if>';
fm_LParenclassOrInterfaceModifierRParenOne: '<#if' .*?'>'(( classOrInterfaceModifier      )  | fm_LParenclassOrInterfaceModifierRParenOne)('<#elseif' .*?'>'(( classOrInterfaceModifier      )  | fm_LParenclassOrInterfaceModifierRParenOne))*'<#else>'(( classOrInterfaceModifier      )  | fm_LParenclassOrInterfaceModifierRParenOne)'</#if>';
fm_LParenstatementRParenOne: '<#if' .*?'>'(( statement      )  | fm_LParenstatementRParenOne)('<#elseif' .*?'>'(( statement      )  | fm_LParenstatementRParenOne))*'<#else>'(( statement      )  | fm_LParenstatementRParenOne)'</#if>';
fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne: '<#if' .*?'>'(( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )  | fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )  | fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne))*'<#else>'(( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )  | fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne)'</#if>';
fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne: '<#if' .*?'>'(( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )  | fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )  | fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne))*'<#else>'(( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )  | fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne)'</#if>';
fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne: '<#if' .*?'>'(( fm_EQUALPlaceHolder     | EQUAL      )  | fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne)('<#elseif' .*?'>'(( fm_EQUALPlaceHolder     | EQUAL      )  | fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne))*'<#else>'(( fm_EQUALPlaceHolder     | EQUAL      )  | fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne)'</#if>';
fm_LParenenumDeclarationRParenOne: '<#if' .*?'>'(( enumDeclaration      )  | fm_LParenenumDeclarationRParenOne)('<#elseif' .*?'>'(( enumDeclaration      )  | fm_LParenenumDeclarationRParenOne))*'<#else>'(( enumDeclaration      )  | fm_LParenenumDeclarationRParenOne)'</#if>';
fm_LParenresourceSpecificationRParenOne: '<#if' .*?'>'(( resourceSpecification      )  | fm_LParenresourceSpecificationRParenOne)('<#elseif' .*?'>'(( resourceSpecification      )  | fm_LParenresourceSpecificationRParenOne))*'<#else>'(( resourceSpecification      )  | fm_LParenresourceSpecificationRParenOne)'</#if>';
fm_LParentypeArgumentsRParenOne: '<#if' .*?'>'(( typeArguments      )  | fm_LParentypeArgumentsRParenOne)('<#elseif' .*?'>'(( typeArguments      )  | fm_LParentypeArgumentsRParenOne))*'<#else>'(( typeArguments      )  | fm_LParentypeArgumentsRParenOne)'</#if>';
fm_LParenconstantDeclaratorRParenOne: '<#if' .*?'>'(( constantDeclarator      )  | fm_LParenconstantDeclaratorRParenOne)('<#elseif' .*?'>'(( constantDeclarator      )  | fm_LParenconstantDeclaratorRParenOne))*'<#else>'(( constantDeclarator      )  | fm_LParenconstantDeclaratorRParenOne)'</#if>';
fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne: '<#if' .*?'>'(( fm_RPARENPlaceHolder     | RPAREN      )  | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)('<#elseif' .*?'>'(( fm_RPARENPlaceHolder     | RPAREN      )  | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne))*'<#else>'(( fm_RPARENPlaceHolder     | RPAREN      )  | fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne)'</#if>';
fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne: '<#if' .*?'>'(( fm_ABSTRACTPlaceHolder     | ABSTRACT      )  | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne)('<#elseif' .*?'>'(( fm_ABSTRACTPlaceHolder     | ABSTRACT      )  | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne))*'<#else>'(( fm_ABSTRACTPlaceHolder     | ABSTRACT      )  | fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne)'</#if>';
fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne: '<#if' .*?'>'(( ( fm_EQUALPlaceHolder     | EQUAL      )     | ( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )      )  | fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne)('<#elseif' .*?'>'(( ( fm_EQUALPlaceHolder     | EQUAL      )     | ( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )      )  | fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne))*'<#else>'(( ( fm_EQUALPlaceHolder     | EQUAL      )     | ( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )      )  | fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne)'</#if>';
fm_LParentypeBoundRParenOne: '<#if' .*?'>'(( typeBound      )  | fm_LParentypeBoundRParenOne)('<#elseif' .*?'>'(( typeBound      )  | fm_LParentypeBoundRParenOne))*'<#else>'(( typeBound      )  | fm_LParentypeBoundRParenOne)'</#if>';
fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne: '<#if' .*?'>'(( fm_ASSIGNPlaceHolder     | ASSIGN      )  | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne)('<#elseif' .*?'>'(( fm_ASSIGNPlaceHolder     | ASSIGN      )  | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne))*'<#else>'(( fm_ASSIGNPlaceHolder     | ASSIGN      )  | fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne)'</#if>';
fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne: '<#if' .*?'>'(( fm_CLASSPlaceHolder     | CLASS      )  | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)('<#elseif' .*?'>'(( fm_CLASSPlaceHolder     | CLASS      )  | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne))*'<#else>'(( fm_CLASSPlaceHolder     | CLASS      )  | fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne)'</#if>';
fm_LParenfm_CASEPlaceHolderOrCASERParenOne: '<#if' .*?'>'(( fm_CASEPlaceHolder     | CASE      )  | fm_LParenfm_CASEPlaceHolderOrCASERParenOne)('<#elseif' .*?'>'(( fm_CASEPlaceHolder     | CASE      )  | fm_LParenfm_CASEPlaceHolderOrCASERParenOne))*'<#else>'(( fm_CASEPlaceHolder     | CASE      )  | fm_LParenfm_CASEPlaceHolderOrCASERParenOne)'</#if>';
fm_LParenfm_BITORPlaceHolderOrBITORRParenOne: '<#if' .*?'>'(( fm_BITORPlaceHolder     | BITOR      )  | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne)('<#elseif' .*?'>'(( fm_BITORPlaceHolder     | BITOR      )  | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne))*'<#else>'(( fm_BITORPlaceHolder     | BITOR      )  | fm_LParenfm_BITORPlaceHolderOrBITORRParenOne)'</#if>';
fm_LParencatchTypeRParenOne: '<#if' .*?'>'(( catchType      )  | fm_LParencatchTypeRParenOne)('<#elseif' .*?'>'(( catchType      )  | fm_LParencatchTypeRParenOne))*'<#else>'(( catchType      )  | fm_LParencatchTypeRParenOne)'</#if>';
fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne: '<#if' .*?'>'(( fm_CATCHPlaceHolder     | CATCH      )  | fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne)('<#elseif' .*?'>'(( fm_CATCHPlaceHolder     | CATCH      )  | fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne))*'<#else>'(( fm_CATCHPlaceHolder     | CATCH      )  | fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne)'</#if>';
fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne: '<#if' .*?'>'(( fm_PACKAGEPlaceHolder     | PACKAGE      )  | fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne)('<#elseif' .*?'>'(( fm_PACKAGEPlaceHolder     | PACKAGE      )  | fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne))*'<#else>'(( fm_PACKAGEPlaceHolder     | PACKAGE      )  | fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne)'</#if>';
fm_LParenfm_LTPlaceHolderOrLTRParenOne: '<#if' .*?'>'(( fm_LTPlaceHolder     | LT      )  | fm_LParenfm_LTPlaceHolderOrLTRParenOne)('<#elseif' .*?'>'(( fm_LTPlaceHolder     | LT      )  | fm_LParenfm_LTPlaceHolderOrLTRParenOne))*'<#else>'(( fm_LTPlaceHolder     | LT      )  | fm_LParenfm_LTPlaceHolderOrLTRParenOne)'</#if>';
fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne: '<#if' .*?'>'(( fm_DOUBLEPlaceHolder     | DOUBLE      )  | fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne)('<#elseif' .*?'>'(( fm_DOUBLEPlaceHolder     | DOUBLE      )  | fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne))*'<#else>'(( fm_DOUBLEPlaceHolder     | DOUBLE      )  | fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne)'</#if>';
fm_LParenlocalVariableDeclarationStatementRParenOne: '<#if' .*?'>'(( localVariableDeclarationStatement      )  | fm_LParenlocalVariableDeclarationStatementRParenOne)('<#elseif' .*?'>'(( localVariableDeclarationStatement      )  | fm_LParenlocalVariableDeclarationStatementRParenOne))*'<#else>'(( localVariableDeclarationStatement      )  | fm_LParenlocalVariableDeclarationStatementRParenOne)'</#if>';
fm_LPareninterfaceBodyRParenOne: '<#if' .*?'>'(( interfaceBody      )  | fm_LPareninterfaceBodyRParenOne)('<#elseif' .*?'>'(( interfaceBody      )  | fm_LPareninterfaceBodyRParenOne))*'<#else>'(( interfaceBody      )  | fm_LPareninterfaceBodyRParenOne)'</#if>';
fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne: '<#if' .*?'>'(( fm_PRIVATEPlaceHolder     | PRIVATE      )  | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne)('<#elseif' .*?'>'(( fm_PRIVATEPlaceHolder     | PRIVATE      )  | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne))*'<#else>'(( fm_PRIVATEPlaceHolder     | PRIVATE      )  | fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne)'</#if>';
fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne: '<#if' .*?'>'(( fm_DEFAULTPlaceHolder     | DEFAULT      )  | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne)('<#elseif' .*?'>'(( fm_DEFAULTPlaceHolder     | DEFAULT      )  | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne))*'<#else>'(( fm_DEFAULTPlaceHolder     | DEFAULT      )  | fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne)'</#if>';
fm_LParennonWildcardTypeArgumentsRParenOne: '<#if' .*?'>'(( nonWildcardTypeArguments      )  | fm_LParennonWildcardTypeArgumentsRParenOne)('<#elseif' .*?'>'(( nonWildcardTypeArguments      )  | fm_LParennonWildcardTypeArgumentsRParenOne))*'<#else>'(( nonWildcardTypeArguments      )  | fm_LParennonWildcardTypeArgumentsRParenOne)'</#if>';
fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne: '<#if' .*?'>'(( fm_SEMIPlaceHolder     | SEMI      )  | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)('<#elseif' .*?'>'(( fm_SEMIPlaceHolder     | SEMI      )  | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne))*'<#else>'(( fm_SEMIPlaceHolder     | SEMI      )  | fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne)'</#if>';
fm_LParenstatementExpressionRParenOne: '<#if' .*?'>'(( statementExpression      )  | fm_LParenstatementExpressionRParenOne)('<#elseif' .*?'>'(( statementExpression      )  | fm_LParenstatementExpressionRParenOne))*'<#else>'(( statementExpression      )  | fm_LParenstatementExpressionRParenOne)'</#if>';
fm_LParenformalParameterRParenOne: '<#if' .*?'>'(( formalParameter      )  | fm_LParenformalParameterRParenOne)('<#elseif' .*?'>'(( formalParameter      )  | fm_LParenformalParameterRParenOne))*'<#else>'(( formalParameter      )  | fm_LParenformalParameterRParenOne)'</#if>';
fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne: '<#if' .*?'>'(( fm_LPARENPlaceHolder     | LPAREN      )  | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne)('<#elseif' .*?'>'(( fm_LPARENPlaceHolder     | LPAREN      )  | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne))*'<#else>'(( fm_LPARENPlaceHolder     | LPAREN      )  | fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne)'</#if>';
fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne: '<#if' .*?'>'(( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne)('<#elseif' .*?'>'(( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne))*'<#else>'(( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne)'</#if>';
fm_LParenmethodBodyRParenOne: '<#if' .*?'>'(( methodBody      )  | fm_LParenmethodBodyRParenOne)('<#elseif' .*?'>'(( methodBody      )  | fm_LParenmethodBodyRParenOne))*'<#else>'(( methodBody      )  | fm_LParenmethodBodyRParenOne)'</#if>';
fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne: '<#if' .*?'>'(( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )  | fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )  | fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne))*'<#else>'(( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )  | fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne)'</#if>';
fm_LParenfm_ANDPlaceHolderOrANDRParenOne: '<#if' .*?'>'(( fm_ANDPlaceHolder     | AND      )  | fm_LParenfm_ANDPlaceHolderOrANDRParenOne)('<#elseif' .*?'>'(( fm_ANDPlaceHolder     | AND      )  | fm_LParenfm_ANDPlaceHolderOrANDRParenOne))*'<#else>'(( fm_ANDPlaceHolder     | AND      )  | fm_LParenfm_ANDPlaceHolderOrANDRParenOne)'</#if>';
fm_LParenconstructorDeclarationRParenOne: '<#if' .*?'>'(( constructorDeclaration      )  | fm_LParenconstructorDeclarationRParenOne)('<#elseif' .*?'>'(( constructorDeclaration      )  | fm_LParenconstructorDeclarationRParenOne))*'<#else>'(( constructorDeclaration      )  | fm_LParenconstructorDeclarationRParenOne)'</#if>';
fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne: '<#if' .*?'>'(( fm_LBRACEPlaceHolder     | LBRACE      )  | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne)('<#elseif' .*?'>'(( fm_LBRACEPlaceHolder     | LBRACE      )  | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne))*'<#else>'(( fm_LBRACEPlaceHolder     | LBRACE      )  | fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne)'</#if>';
fm_LParenfm_GTPlaceHolderOrGTRParenOne: '<#if' .*?'>'(( fm_GTPlaceHolder     | GT      )  | fm_LParenfm_GTPlaceHolderOrGTRParenOne)('<#elseif' .*?'>'(( fm_GTPlaceHolder     | GT      )  | fm_LParenfm_GTPlaceHolderOrGTRParenOne))*'<#else>'(( fm_GTPlaceHolder     | GT      )  | fm_LParenfm_GTPlaceHolderOrGTRParenOne)'</#if>';
fm_LParenqualifiedNameRParenOne: '<#if' .*?'>'(( qualifiedName      )  | fm_LParenqualifiedNameRParenOne)('<#elseif' .*?'>'(( qualifiedName      )  | fm_LParenqualifiedNameRParenOne))*'<#else>'(( qualifiedName      )  | fm_LParenqualifiedNameRParenOne)'</#if>';
fm_LParenfm_LONGPlaceHolderOrLONGRParenOne: '<#if' .*?'>'(( fm_LONGPlaceHolder     | LONG      )  | fm_LParenfm_LONGPlaceHolderOrLONGRParenOne)('<#elseif' .*?'>'(( fm_LONGPlaceHolder     | LONG      )  | fm_LParenfm_LONGPlaceHolderOrLONGRParenOne))*'<#else>'(( fm_LONGPlaceHolder     | LONG      )  | fm_LParenfm_LONGPlaceHolderOrLONGRParenOne)'</#if>';
fm_LParenexpressionRParenOne: '<#if' .*?'>'(( expression      )  | fm_LParenexpressionRParenOne)('<#elseif' .*?'>'(( expression      )  | fm_LParenexpressionRParenOne))*'<#else>'(( expression      )  | fm_LParenexpressionRParenOne)'</#if>';
fm_LParenconstantExpressionRParenOne: '<#if' .*?'>'(( constantExpression      )  | fm_LParenconstantExpressionRParenOne)('<#elseif' .*?'>'(( constantExpression      )  | fm_LParenconstantExpressionRParenOne))*'<#else>'(( constantExpression      )  | fm_LParenconstantExpressionRParenOne)'</#if>';
fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne: '<#if' .*?'>'(( fm_IMPORTPlaceHolder     | IMPORT      )  | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne)('<#elseif' .*?'>'(( fm_IMPORTPlaceHolder     | IMPORT      )  | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne))*'<#else>'(( fm_IMPORTPlaceHolder     | IMPORT      )  | fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne)'</#if>';
fm_LParentypeArgumentRParenOne: '<#if' .*?'>'(( typeArgument      )  | fm_LParentypeArgumentRParenOne)('<#elseif' .*?'>'(( typeArgument      )  | fm_LParentypeArgumentRParenOne))*'<#else>'(( typeArgument      )  | fm_LParentypeArgumentRParenOne)'</#if>';
fm_LParencreatedNameRParenOne: '<#if' .*?'>'(( createdName      )  | fm_LParencreatedNameRParenOne)('<#elseif' .*?'>'(( createdName      )  | fm_LParencreatedNameRParenOne))*'<#else>'(( createdName      )  | fm_LParencreatedNameRParenOne)'</#if>';
fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne: '<#if' .*?'>'(( fm_ELLIPSISPlaceHolder     | ELLIPSIS      )  | fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne)('<#elseif' .*?'>'(( fm_ELLIPSISPlaceHolder     | ELLIPSIS      )  | fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne))*'<#else>'(( fm_ELLIPSISPlaceHolder     | ELLIPSIS      )  | fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne)'</#if>';
fm_LParenannotationMethodRestRParenOne: '<#if' .*?'>'(( annotationMethodRest      )  | fm_LParenannotationMethodRestRParenOne)('<#elseif' .*?'>'(( annotationMethodRest      )  | fm_LParenannotationMethodRestRParenOne))*'<#else>'(( annotationMethodRest      )  | fm_LParenannotationMethodRestRParenOne)'</#if>';
fm_LParenarrayInitializerRParenOne: '<#if' .*?'>'(( arrayInitializer      )  | fm_LParenarrayInitializerRParenOne)('<#elseif' .*?'>'(( arrayInitializer      )  | fm_LParenarrayInitializerRParenOne))*'<#else>'(( arrayInitializer      )  | fm_LParenarrayInitializerRParenOne)'</#if>';
fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne: '<#if' .*?'>'(( fm_RBRACKPlaceHolder     | RBRACK      )  | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)('<#elseif' .*?'>'(( fm_RBRACKPlaceHolder     | RBRACK      )  | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne))*'<#else>'(( fm_RBRACKPlaceHolder     | RBRACK      )  | fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne)'</#if>';
fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne: '<#if' .*?'>'(( fm_BITANDPlaceHolder     | BITAND      )  | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne)('<#elseif' .*?'>'(( fm_BITANDPlaceHolder     | BITAND      )  | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne))*'<#else>'(( fm_BITANDPlaceHolder     | BITAND      )  | fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne)'</#if>';
fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne: '<#if' .*?'>'(( fm_FloatingPointLiteralPlaceHolder     | FloatingPointLiteral      )  | fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne)('<#elseif' .*?'>'(( fm_FloatingPointLiteralPlaceHolder     | FloatingPointLiteral      )  | fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne))*'<#else>'(( fm_FloatingPointLiteralPlaceHolder     | FloatingPointLiteral      )  | fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne)'</#if>';
fm_LParentypeParameterRParenOne: '<#if' .*?'>'(( typeParameter      )  | fm_LParentypeParameterRParenOne)('<#elseif' .*?'>'(( typeParameter      )  | fm_LParentypeParameterRParenOne))*'<#else>'(( typeParameter      )  | fm_LParentypeParameterRParenOne)'</#if>';
fm_LParenliteralRParenOne: '<#if' .*?'>'(( literal      )  | fm_LParenliteralRParenOne)('<#elseif' .*?'>'(( literal      )  | fm_LParenliteralRParenOne))*'<#else>'(( literal      )  | fm_LParenliteralRParenOne)'</#if>';
fm_LParenfm_THISPlaceHolderOrTHISRParenOne: '<#if' .*?'>'(( fm_THISPlaceHolder     | THIS      )  | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)('<#elseif' .*?'>'(( fm_THISPlaceHolder     | THIS      )  | fm_LParenfm_THISPlaceHolderOrTHISRParenOne))*'<#else>'(( fm_THISPlaceHolder     | THIS      )  | fm_LParenfm_THISPlaceHolderOrTHISRParenOne)'</#if>';
fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne: '<#if' .*?'>'(( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )  | fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )  | fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne))*'<#else>'(( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )  | fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne)'</#if>';
fm_LParenclassBodyRParenOne: '<#if' .*?'>'(( classBody      )  | fm_LParenclassBodyRParenOne)('<#elseif' .*?'>'(( classBody      )  | fm_LParenclassBodyRParenOne))*'<#else>'(( classBody      )  | fm_LParenclassBodyRParenOne)'</#if>';
fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne: '<#if' .*?'>'(( ( methodBody      )     | ( fm_SEMIPlaceHolder     | SEMI      )      )  | fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne)('<#elseif' .*?'>'(( ( methodBody      )     | ( fm_SEMIPlaceHolder     | SEMI      )      )  | fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne))*'<#else>'(( ( methodBody      )     | ( fm_SEMIPlaceHolder     | SEMI      )      )  | fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne)'</#if>';
fm_LParentypeRParenOne: '<#if' .*?'>'(( type      )  | fm_LParentypeRParenOne)('<#elseif' .*?'>'(( type      )  | fm_LParentypeRParenOne))*'<#else>'(( type      )  | fm_LParentypeRParenOne)'</#if>';
fm_LParenvariableDeclaratorIdRParenOne: '<#if' .*?'>'(( variableDeclaratorId      )  | fm_LParenvariableDeclaratorIdRParenOne)('<#elseif' .*?'>'(( variableDeclaratorId      )  | fm_LParenvariableDeclaratorIdRParenOne))*'<#else>'(( variableDeclaratorId      )  | fm_LParenvariableDeclaratorIdRParenOne)'</#if>';
fm_LParenenumConstantNameRParenOne: '<#if' .*?'>'(( enumConstantName      )  | fm_LParenenumConstantNameRParenOne)('<#elseif' .*?'>'(( enumConstantName      )  | fm_LParenenumConstantNameRParenOne))*'<#else>'(( enumConstantName      )  | fm_LParenenumConstantNameRParenOne)'</#if>';
fm_LParenswitchLabelRParenOnePlus: '<#if' .*?'>'(( switchLabel      )  | fm_LParenswitchLabelRParenOnePlus+)('<#elseif' .*?'>'(( switchLabel      )  | fm_LParenswitchLabelRParenOnePlus+))*'<#else>'(( switchLabel      )  | fm_LParenswitchLabelRParenOnePlus+)'</#if>';
fm_LParenfm_MULPlaceHolderOrMULRParenOne: '<#if' .*?'>'(( fm_MULPlaceHolder     | MUL      )  | fm_LParenfm_MULPlaceHolderOrMULRParenOne)('<#elseif' .*?'>'(( fm_MULPlaceHolder     | MUL      )  | fm_LParenfm_MULPlaceHolderOrMULRParenOne))*'<#else>'(( fm_MULPlaceHolder     | MUL      )  | fm_LParenfm_MULPlaceHolderOrMULRParenOne)'</#if>';
fm_LParenenumConstantRParenOne: '<#if' .*?'>'(( enumConstant      )  | fm_LParenenumConstantRParenOne)('<#elseif' .*?'>'(( enumConstant      )  | fm_LParenenumConstantRParenOne))*'<#else>'(( enumConstant      )  | fm_LParenenumConstantRParenOne)'</#if>';
fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne: '<#if' .*?'>'(( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )  | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne)('<#elseif' .*?'>'(( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )  | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne))*'<#else>'(( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )  | fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne)'</#if>';
fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne: '<#if' .*?'>'(( fm_INSTANCEOFPlaceHolder     | INSTANCEOF      )  | fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne)('<#elseif' .*?'>'(( fm_INSTANCEOFPlaceHolder     | INSTANCEOF      )  | fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne))*'<#else>'(( fm_INSTANCEOFPlaceHolder     | INSTANCEOF      )  | fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne)'</#if>';
fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne: '<#if' .*?'>'(( ( catchClause      )  +     ( finallyBlock      )  ?      | ( finallyBlock      )      )  | fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne)('<#elseif' .*?'>'(( ( catchClause      )  +     ( finallyBlock      )  ?      | ( finallyBlock      )      )  | fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne))*'<#else>'(( ( catchClause      )  +     ( finallyBlock      )  ?      | ( finallyBlock      )      )  | fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne)'</#if>';
fm_LParenfm_ORPlaceHolderOrORRParenOne: '<#if' .*?'>'(( fm_ORPlaceHolder     | OR      )  | fm_LParenfm_ORPlaceHolderOrORRParenOne)('<#elseif' .*?'>'(( fm_ORPlaceHolder     | OR      )  | fm_LParenfm_ORPlaceHolderOrORRParenOne))*'<#else>'(( fm_ORPlaceHolder     | OR      )  | fm_LParenfm_ORPlaceHolderOrORRParenOne)'</#if>';
fm_newRulexXXx1: '<#if' .*?'>'(( ( fm_PUBLICPlaceHolder     | PUBLIC      )     | ( fm_PROTECTEDPlaceHolder     | PROTECTED      )     | ( fm_PRIVATEPlaceHolder     | PRIVATE      )     | ( fm_STATICPlaceHolder     | STATIC      )     | ( fm_ABSTRACTPlaceHolder     | ABSTRACT      )     | ( fm_FINALPlaceHolder     | FINAL      )     | ( fm_STRICTFPPlaceHolder     | STRICTFP      )      )  | fm_newRulexXXx1)('<#elseif' .*?'>'(( ( fm_PUBLICPlaceHolder     | PUBLIC      )     | ( fm_PROTECTEDPlaceHolder     | PROTECTED      )     | ( fm_PRIVATEPlaceHolder     | PRIVATE      )     | ( fm_STATICPlaceHolder     | STATIC      )     | ( fm_ABSTRACTPlaceHolder     | ABSTRACT      )     | ( fm_FINALPlaceHolder     | FINAL      )     | ( fm_STRICTFPPlaceHolder     | STRICTFP      )      )  | fm_newRulexXXx1))*'<#else>'(( ( fm_PUBLICPlaceHolder     | PUBLIC      )     | ( fm_PROTECTEDPlaceHolder     | PROTECTED      )     | ( fm_PRIVATEPlaceHolder     | PRIVATE      )     | ( fm_STATICPlaceHolder     | STATIC      )     | ( fm_ABSTRACTPlaceHolder     | ABSTRACT      )     | ( fm_FINALPlaceHolder     | FINAL      )     | ( fm_STRICTFPPlaceHolder     | STRICTFP      )      )  | fm_newRulexXXx1)'</#if>';
fm_LParenannotationMethodOrConstantRestRParenOne: '<#if' .*?'>'(( annotationMethodOrConstantRest      )  | fm_LParenannotationMethodOrConstantRestRParenOne)('<#elseif' .*?'>'(( annotationMethodOrConstantRest      )  | fm_LParenannotationMethodOrConstantRestRParenOne))*'<#else>'(( annotationMethodOrConstantRest      )  | fm_LParenannotationMethodOrConstantRestRParenOne)'</#if>';
fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne: '<#if' .*?'>'(( fm_ENUMPlaceHolder     | ENUM      )  | fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne)('<#elseif' .*?'>'(( fm_ENUMPlaceHolder     | ENUM      )  | fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne))*'<#else>'(( fm_ENUMPlaceHolder     | ENUM      )  | fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne)'</#if>';
fm_LParenexpressionListRParenOne: '<#if' .*?'>'(( expressionList      )  | fm_LParenexpressionListRParenOne)('<#elseif' .*?'>'(( expressionList      )  | fm_LParenexpressionListRParenOne))*'<#else>'(( expressionList      )  | fm_LParenexpressionListRParenOne)'</#if>';
fm_LParenfm_DECPlaceHolderOrDECRParenOne: '<#if' .*?'>'(( fm_DECPlaceHolder     | DEC      )  | fm_LParenfm_DECPlaceHolderOrDECRParenOne)('<#elseif' .*?'>'(( fm_DECPlaceHolder     | DEC      )  | fm_LParenfm_DECPlaceHolderOrDECRParenOne))*'<#else>'(( fm_DECPlaceHolder     | DEC      )  | fm_LParenfm_DECPlaceHolderOrDECRParenOne)'</#if>';
fm_LParenmethodDeclarationRParenOne: '<#if' .*?'>'(( methodDeclaration      )  | fm_LParenmethodDeclarationRParenOne)('<#elseif' .*?'>'(( methodDeclaration      )  | fm_LParenmethodDeclarationRParenOne))*'<#else>'(( methodDeclaration      )  | fm_LParenmethodDeclarationRParenOne)'</#if>';
fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne: '<#if' .*?'>'(( fm_VOLATILEPlaceHolder     | VOLATILE      )  | fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne)('<#elseif' .*?'>'(( fm_VOLATILEPlaceHolder     | VOLATILE      )  | fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne))*'<#else>'(( fm_VOLATILEPlaceHolder     | VOLATILE      )  | fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne)'</#if>';
fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne: '<#if' .*?'>'(( ( type      )     | ( fm_VOIDPlaceHolder     | VOID      )      )  | fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne)('<#elseif' .*?'>'(( ( type      )     | ( fm_VOIDPlaceHolder     | VOID      )      )  | fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne))*'<#else>'(( ( type      )     | ( fm_VOIDPlaceHolder     | VOID      )      )  | fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne)'</#if>';
fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne: '<#if' .*?'>'(( fm_STATICPlaceHolder     | STATIC      )  | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)('<#elseif' .*?'>'(( fm_STATICPlaceHolder     | STATIC      )  | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne))*'<#else>'(( fm_STATICPlaceHolder     | STATIC      )  | fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne)'</#if>';
fm_LParenfm_ELSEPlaceHolderOrELSERParenOne: '<#if' .*?'>'(( fm_ELSEPlaceHolder     | ELSE      )  | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne)('<#elseif' .*?'>'(( fm_ELSEPlaceHolder     | ELSE      )  | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne))*'<#else>'(( fm_ELSEPlaceHolder     | ELSE      )  | fm_LParenfm_ELSEPlaceHolderOrELSERParenOne)'</#if>';
fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne: '<#if' .*?'>'(( fm_THROWSPlaceHolder     | THROWS      )  | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne)('<#elseif' .*?'>'(( fm_THROWSPlaceHolder     | THROWS      )  | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne))*'<#else>'(( fm_THROWSPlaceHolder     | THROWS      )  | fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne)'</#if>';
fm_LParengenericConstructorDeclarationRParenOne: '<#if' .*?'>'(( genericConstructorDeclaration      )  | fm_LParengenericConstructorDeclarationRParenOne)('<#elseif' .*?'>'(( genericConstructorDeclaration      )  | fm_LParengenericConstructorDeclarationRParenOne))*'<#else>'(( genericConstructorDeclaration      )  | fm_LParengenericConstructorDeclarationRParenOne)'</#if>';
fm_newRulexXXx6: '<#if' .*?'>'(( ( fm_ADDPlaceHolder     | ADD      )     | ( fm_SUBPlaceHolder     | SUB      )     | ( fm_INCPlaceHolder     | INC      )     | ( fm_DECPlaceHolder     | DEC      )      )  | fm_newRulexXXx6)('<#elseif' .*?'>'(( ( fm_ADDPlaceHolder     | ADD      )     | ( fm_SUBPlaceHolder     | SUB      )     | ( fm_INCPlaceHolder     | INC      )     | ( fm_DECPlaceHolder     | DEC      )      )  | fm_newRulexXXx6))*'<#else>'(( ( fm_ADDPlaceHolder     | ADD      )     | ( fm_SUBPlaceHolder     | SUB      )     | ( fm_INCPlaceHolder     | INC      )     | ( fm_DECPlaceHolder     | DEC      )      )  | fm_newRulexXXx6)'</#if>';
fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne: '<#if' .*?'>'(( fm_SUPERPlaceHolder     | SUPER      )  | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne)('<#elseif' .*?'>'(( fm_SUPERPlaceHolder     | SUPER      )  | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne))*'<#else>'(( fm_SUPERPlaceHolder     | SUPER      )  | fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne)'</#if>';
fm_LParenfm_FORPlaceHolderOrFORRParenOne: '<#if' .*?'>'(( fm_FORPlaceHolder     | FOR      )  | fm_LParenfm_FORPlaceHolderOrFORRParenOne)('<#elseif' .*?'>'(( fm_FORPlaceHolder     | FOR      )  | fm_LParenfm_FORPlaceHolderOrFORRParenOne))*'<#else>'(( fm_FORPlaceHolder     | FOR      )  | fm_LParenfm_FORPlaceHolderOrFORRParenOne)'</#if>';
fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne: '<#if' .*?'>'(( fm_PROTECTEDPlaceHolder     | PROTECTED      )  | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne)('<#elseif' .*?'>'(( fm_PROTECTEDPlaceHolder     | PROTECTED      )  | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne))*'<#else>'(( fm_PROTECTEDPlaceHolder     | PROTECTED      )  | fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne)'</#if>';
fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne: '<#if' .*?'>'(( fm_CharacterLiteralPlaceHolder     | CharacterLiteral      )  | fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne)('<#elseif' .*?'>'(( fm_CharacterLiteralPlaceHolder     | CharacterLiteral      )  | fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne))*'<#else>'(( fm_CharacterLiteralPlaceHolder     | CharacterLiteral      )  | fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne)'</#if>';
fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne: '<#if' .*?'>'(( ( explicitGenericInvocationSuffix      )     | ( fm_THISPlaceHolder     | THIS      )    ( arguments      )      )  | fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne)('<#elseif' .*?'>'(( ( explicitGenericInvocationSuffix      )     | ( fm_THISPlaceHolder     | THIS      )    ( arguments      )      )  | fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne))*'<#else>'(( ( explicitGenericInvocationSuffix      )     | ( fm_THISPlaceHolder     | THIS      )    ( arguments      )      )  | fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne)'</#if>';
fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne: '<#if' .*?'>'(( fm_ASSERTPlaceHolder     | ASSERT      )  | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne)('<#elseif' .*?'>'(( fm_ASSERTPlaceHolder     | ASSERT      )  | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne))*'<#else>'(( fm_ASSERTPlaceHolder     | ASSERT      )  | fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne)'</#if>';
fm_LParenenhancedForControlRParenOne: '<#if' .*?'>'(( enhancedForControl      )  | fm_LParenenhancedForControlRParenOne)('<#elseif' .*?'>'(( enhancedForControl      )  | fm_LParenenhancedForControlRParenOne))*'<#else>'(( enhancedForControl      )  | fm_LParenenhancedForControlRParenOne)'</#if>';
fm_LParenformalParametersRParenOne: '<#if' .*?'>'(( formalParameters      )  | fm_LParenformalParametersRParenOne)('<#elseif' .*?'>'(( formalParameters      )  | fm_LParenformalParametersRParenOne))*'<#else>'(( formalParameters      )  | fm_LParenformalParametersRParenOne)'</#if>';
fm_LParenelementValuePairRParenOne: '<#if' .*?'>'(( elementValuePair      )  | fm_LParenelementValuePairRParenOne)('<#elseif' .*?'>'(( elementValuePair      )  | fm_LParenelementValuePairRParenOne))*'<#else>'(( elementValuePair      )  | fm_LParenelementValuePairRParenOne)'</#if>';
fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne: '<#if' .*?'>'(( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )  | fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )  | fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne))*'<#else>'(( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )  | fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne)'</#if>';
fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne: '<#if' .*?'>'(( ( fm_INCPlaceHolder     | INC      )     | ( fm_DECPlaceHolder     | DEC      )      )  | fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne)('<#elseif' .*?'>'(( ( fm_INCPlaceHolder     | INC      )     | ( fm_DECPlaceHolder     | DEC      )      )  | fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne))*'<#else>'(( ( fm_INCPlaceHolder     | INC      )     | ( fm_DECPlaceHolder     | DEC      )      )  | fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne)'</#if>';
fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne: '<#if' .*?'>'(( fm_BREAKPlaceHolder     | BREAK      )  | fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne)('<#elseif' .*?'>'(( fm_BREAKPlaceHolder     | BREAK      )  | fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne))*'<#else>'(( fm_BREAKPlaceHolder     | BREAK      )  | fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne)'</#if>';
fm_newRulexXXx11: '<#if' .*?'>'(( ( fm_RBRACKPlaceHolder     | RBRACK      )    ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *     ( arrayInitializer      )     | ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )    ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *     ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *       )  | fm_newRulexXXx11)('<#elseif' .*?'>'(( ( fm_RBRACKPlaceHolder     | RBRACK      )    ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *     ( arrayInitializer      )     | ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )    ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *     ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *       )  | fm_newRulexXXx11))*'<#else>'(( ( fm_RBRACKPlaceHolder     | RBRACK      )    ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *     ( arrayInitializer      )     | ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )    ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( expression      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *     ( ( fm_LBRACKPlaceHolder     | LBRACK      )    ( fm_RBRACKPlaceHolder     | RBRACK      )      )  *       )  | fm_newRulexXXx11)'</#if>';
fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne: '<#if' .*?'>'(( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )  | fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )  | fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne))*'<#else>'(( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )  | fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne)'</#if>';
fm_LParenclassDeclarationRParenOne: '<#if' .*?'>'(( classDeclaration      )  | fm_LParenclassDeclarationRParenOne)('<#elseif' .*?'>'(( classDeclaration      )  | fm_LParenclassDeclarationRParenOne))*'<#else>'(( classDeclaration      )  | fm_LParenclassDeclarationRParenOne)'</#if>';
fm_LParensuperSuffixRParenOne: '<#if' .*?'>'(( superSuffix      )  | fm_LParensuperSuffixRParenOne)('<#elseif' .*?'>'(( superSuffix      )  | fm_LParensuperSuffixRParenOne))*'<#else>'(( superSuffix      )  | fm_LParensuperSuffixRParenOne)'</#if>';
fm_LParenannotationTypeElementRestRParenOne: '<#if' .*?'>'(( annotationTypeElementRest      )  | fm_LParenannotationTypeElementRestRParenOne)('<#elseif' .*?'>'(( annotationTypeElementRest      )  | fm_LParenannotationTypeElementRestRParenOne))*'<#else>'(( annotationTypeElementRest      )  | fm_LParenannotationTypeElementRestRParenOne)'</#if>';
fm_LParenprimitiveTypeRParenOne: '<#if' .*?'>'(( primitiveType      )  | fm_LParenprimitiveTypeRParenOne)('<#elseif' .*?'>'(( primitiveType      )  | fm_LParenprimitiveTypeRParenOne))*'<#else>'(( primitiveType      )  | fm_LParenprimitiveTypeRParenOne)'</#if>';
fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne: '<#if' .*?'>'(( fm_LBRACKPlaceHolder     | LBRACK      )  | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne)('<#elseif' .*?'>'(( fm_LBRACKPlaceHolder     | LBRACK      )  | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne))*'<#else>'(( fm_LBRACKPlaceHolder     | LBRACK      )  | fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne)'</#if>';
fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne: '<#if' .*?'>'(( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )  | fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )  | fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne))*'<#else>'(( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )  | fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne)'</#if>';
fm_LParentypeParametersRParenOne: '<#if' .*?'>'(( typeParameters      )  | fm_LParentypeParametersRParenOne)('<#elseif' .*?'>'(( typeParameters      )  | fm_LParentypeParametersRParenOne))*'<#else>'(( typeParameters      )  | fm_LParentypeParametersRParenOne)'</#if>';
fm_LParenresourceRParenOne: '<#if' .*?'>'(( resource      )  | fm_LParenresourceRParenOne)('<#elseif' .*?'>'(( resource      )  | fm_LParenresourceRParenOne))*'<#else>'(( resource      )  | fm_LParenresourceRParenOne)'</#if>';
fm_LParenfieldDeclarationRParenOne: '<#if' .*?'>'(( fieldDeclaration      )  | fm_LParenfieldDeclarationRParenOne)('<#elseif' .*?'>'(( fieldDeclaration      )  | fm_LParenfieldDeclarationRParenOne))*'<#else>'(( fieldDeclaration      )  | fm_LParenfieldDeclarationRParenOne)'</#if>';
fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne: '<#if' .*?'>'(( fm_THROWPlaceHolder     | THROW      )  | fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne)('<#elseif' .*?'>'(( fm_THROWPlaceHolder     | THROW      )  | fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne))*'<#else>'(( fm_THROWPlaceHolder     | THROW      )  | fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne)'</#if>';
fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne: '<#if' .*?'>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )     | ( fm_SUPERPlaceHolder     | SUPER      )      )  | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne)('<#elseif' .*?'>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )     | ( fm_SUPERPlaceHolder     | SUPER      )      )  | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne))*'<#else>'(( ( fm_EXTENDSPlaceHolder     | EXTENDS      )     | ( fm_SUPERPlaceHolder     | SUPER      )      )  | fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne)'</#if>';
fm_LParenblockStatementRParenOnePlus: '<#if' .*?'>'(( blockStatement      )  | fm_LParenblockStatementRParenOnePlus+)('<#elseif' .*?'>'(( blockStatement      )  | fm_LParenblockStatementRParenOnePlus+))*'<#else>'(( blockStatement      )  | fm_LParenblockStatementRParenOnePlus+)'</#if>';
fm_newRulexXXx0: '<#if' .*?'>'(( ( fm_NATIVEPlaceHolder     | NATIVE      )     | ( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )     | ( fm_TRANSIENTPlaceHolder     | TRANSIENT      )     | ( fm_VOLATILEPlaceHolder     | VOLATILE      )      )  | fm_newRulexXXx0)('<#elseif' .*?'>'(( ( fm_NATIVEPlaceHolder     | NATIVE      )     | ( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )     | ( fm_TRANSIENTPlaceHolder     | TRANSIENT      )     | ( fm_VOLATILEPlaceHolder     | VOLATILE      )      )  | fm_newRulexXXx0))*'<#else>'(( ( fm_NATIVEPlaceHolder     | NATIVE      )     | ( fm_SYNCHRONIZEDPlaceHolder     | SYNCHRONIZED      )     | ( fm_TRANSIENTPlaceHolder     | TRANSIENT      )     | ( fm_VOLATILEPlaceHolder     | VOLATILE      )      )  | fm_newRulexXXx0)'</#if>';
fm_LParenfm_DOTPlaceHolderOrDOTRParenOne: '<#if' .*?'>'(( fm_DOTPlaceHolder     | DOT      )  | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne)('<#elseif' .*?'>'(( fm_DOTPlaceHolder     | DOT      )  | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne))*'<#else>'(( fm_DOTPlaceHolder     | DOT      )  | fm_LParenfm_DOTPlaceHolderOrDOTRParenOne)'</#if>';
fm_LPareninterfaceMethodDeclarationRParenOne: '<#if' .*?'>'(( interfaceMethodDeclaration      )  | fm_LPareninterfaceMethodDeclarationRParenOne)('<#elseif' .*?'>'(( interfaceMethodDeclaration      )  | fm_LPareninterfaceMethodDeclarationRParenOne))*'<#else>'(( interfaceMethodDeclaration      )  | fm_LPareninterfaceMethodDeclarationRParenOne)'</#if>';
fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne: '<#if' .*?'>'(( ( fm_ADDPlaceHolder     | ADD      )     | ( fm_SUBPlaceHolder     | SUB      )      )  | fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne)('<#elseif' .*?'>'(( ( fm_ADDPlaceHolder     | ADD      )     | ( fm_SUBPlaceHolder     | SUB      )      )  | fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne))*'<#else>'(( ( fm_ADDPlaceHolder     | ADD      )     | ( fm_SUBPlaceHolder     | SUB      )      )  | fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne)'</#if>';
fm_LParenannotationNameRParenOne: '<#if' .*?'>'(( annotationName      )  | fm_LParenannotationNameRParenOne)('<#elseif' .*?'>'(( annotationName      )  | fm_LParenannotationNameRParenOne))*'<#else>'(( annotationName      )  | fm_LParenannotationNameRParenOne)'</#if>';
fm_LPareninnerCreatorRParenOne: '<#if' .*?'>'(( innerCreator      )  | fm_LPareninnerCreatorRParenOne)('<#elseif' .*?'>'(( innerCreator      )  | fm_LPareninnerCreatorRParenOne))*'<#else>'(( innerCreator      )  | fm_LPareninnerCreatorRParenOne)'</#if>';
fm_LParenfm_INTPlaceHolderOrINTRParenOne: '<#if' .*?'>'(( fm_INTPlaceHolder     | INT      )  | fm_LParenfm_INTPlaceHolderOrINTRParenOne)('<#elseif' .*?'>'(( fm_INTPlaceHolder     | INT      )  | fm_LParenfm_INTPlaceHolderOrINTRParenOne))*'<#else>'(( fm_INTPlaceHolder     | INT      )  | fm_LParenfm_INTPlaceHolderOrINTRParenOne)'</#if>';
fm_LParenelementValueArrayInitializerRParenOne: '<#if' .*?'>'(( elementValueArrayInitializer      )  | fm_LParenelementValueArrayInitializerRParenOne)('<#elseif' .*?'>'(( elementValueArrayInitializer      )  | fm_LParenelementValueArrayInitializerRParenOne))*'<#else>'(( elementValueArrayInitializer      )  | fm_LParenelementValueArrayInitializerRParenOne)'</#if>';
fm_LParenfm_DOPlaceHolderOrDORParenOne: '<#if' .*?'>'(( fm_DOPlaceHolder     | DO      )  | fm_LParenfm_DOPlaceHolderOrDORParenOne)('<#elseif' .*?'>'(( fm_DOPlaceHolder     | DO      )  | fm_LParenfm_DOPlaceHolderOrDORParenOne))*'<#else>'(( fm_DOPlaceHolder     | DO      )  | fm_LParenfm_DOPlaceHolderOrDORParenOne)'</#if>';
fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne: '<#if' .*?'>'(( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )  | fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )  | fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne))*'<#else>'(( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )  | fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne)'</#if>';
fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne: '<#if' .*?'>'(( fm_SWITCHPlaceHolder     | SWITCH      )  | fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne)('<#elseif' .*?'>'(( fm_SWITCHPlaceHolder     | SWITCH      )  | fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne))*'<#else>'(( fm_SWITCHPlaceHolder     | SWITCH      )  | fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne)'</#if>';
fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne: '<#if' .*?'>'(( fm_CONTINUEPlaceHolder     | CONTINUE      )  | fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne)('<#elseif' .*?'>'(( fm_CONTINUEPlaceHolder     | CONTINUE      )  | fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne))*'<#else>'(( fm_CONTINUEPlaceHolder     | CONTINUE      )  | fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne)'</#if>';
fm_LParenparExpressionRParenOne: '<#if' .*?'>'(( parExpression      )  | fm_LParenparExpressionRParenOne)('<#elseif' .*?'>'(( parExpression      )  | fm_LParenparExpressionRParenOne))*'<#else>'(( parExpression      )  | fm_LParenparExpressionRParenOne)'</#if>';
fm_LParenmemberDeclarationRParenOne: '<#if' .*?'>'(( memberDeclaration      )  | fm_LParenmemberDeclarationRParenOne)('<#elseif' .*?'>'(( memberDeclaration      )  | fm_LParenmemberDeclarationRParenOne))*'<#else>'(( memberDeclaration      )  | fm_LParenmemberDeclarationRParenOne)'</#if>';
fm_LParencatchClauseRParenOnePlus: '<#if' .*?'>'(( catchClause      )  | fm_LParencatchClauseRParenOnePlus+)('<#elseif' .*?'>'(( catchClause      )  | fm_LParencatchClauseRParenOnePlus+))*'<#else>'(( catchClause      )  | fm_LParencatchClauseRParenOnePlus+)'</#if>';
fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne: '<#if' .*?'>'(( ( fm_TILDEPlaceHolder     | TILDE      )     | ( fm_BANGPlaceHolder     | BANG      )      )  | fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne)('<#elseif' .*?'>'(( ( fm_TILDEPlaceHolder     | TILDE      )     | ( fm_BANGPlaceHolder     | BANG      )      )  | fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne))*'<#else>'(( ( fm_TILDEPlaceHolder     | TILDE      )     | ( fm_BANGPlaceHolder     | BANG      )      )  | fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne)'</#if>';
fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne: '<#if' .*?'>'(( fm_BOOLEANPlaceHolder     | BOOLEAN      )  | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne)('<#elseif' .*?'>'(( fm_BOOLEANPlaceHolder     | BOOLEAN      )  | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne))*'<#else>'(( fm_BOOLEANPlaceHolder     | BOOLEAN      )  | fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne)'</#if>';
fm_LParenannotationTypeElementDeclarationRParenOne: '<#if' .*?'>'(( annotationTypeElementDeclaration      )  | fm_LParenannotationTypeElementDeclarationRParenOne)('<#elseif' .*?'>'(( annotationTypeElementDeclaration      )  | fm_LParenannotationTypeElementDeclarationRParenOne))*'<#else>'(( annotationTypeElementDeclaration      )  | fm_LParenannotationTypeElementDeclarationRParenOne)'</#if>';
fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne: '<#if' .*?'>'(( fm_BooleanLiteralPlaceHolder     | BooleanLiteral      )  | fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne)('<#elseif' .*?'>'(( fm_BooleanLiteralPlaceHolder     | BooleanLiteral      )  | fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne))*'<#else>'(( fm_BooleanLiteralPlaceHolder     | BooleanLiteral      )  | fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne)'</#if>';
fm_LParenelementValuePairsRParenOne: '<#if' .*?'>'(( elementValuePairs      )  | fm_LParenelementValuePairsRParenOne)('<#elseif' .*?'>'(( elementValuePairs      )  | fm_LParenelementValuePairsRParenOne))*'<#else>'(( elementValuePairs      )  | fm_LParenelementValuePairsRParenOne)'</#if>';
fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne: '<#if' .*?'>'(( fm_EXTENDSPlaceHolder     | EXTENDS      )  | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne)('<#elseif' .*?'>'(( fm_EXTENDSPlaceHolder     | EXTENDS      )  | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne))*'<#else>'(( fm_EXTENDSPlaceHolder     | EXTENDS      )  | fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne)'</#if>';
fm_LPareninterfaceMemberDeclarationRParenOne: '<#if' .*?'>'(( interfaceMemberDeclaration      )  | fm_LPareninterfaceMemberDeclarationRParenOne)('<#elseif' .*?'>'(( interfaceMemberDeclaration      )  | fm_LPareninterfaceMemberDeclarationRParenOne))*'<#else>'(( interfaceMemberDeclaration      )  | fm_LPareninterfaceMemberDeclarationRParenOne)'</#if>';
fm_LParenannotationRParenOne: '<#if' .*?'>'(( annotation      )  | fm_LParenannotationRParenOne)('<#elseif' .*?'>'(( annotation      )  | fm_LParenannotationRParenOne))*'<#else>'(( annotation      )  | fm_LParenannotationRParenOne)'</#if>';
fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne: '<#if' .*?'>'(( fm_NullLiteralPlaceHolder     | NullLiteral      )  | fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne)('<#elseif' .*?'>'(( fm_NullLiteralPlaceHolder     | NullLiteral      )  | fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne))*'<#else>'(( fm_NullLiteralPlaceHolder     | NullLiteral      )  | fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne)'</#if>';
fm_LParenvariableDeclaratorsRParenOne: '<#if' .*?'>'(( variableDeclarators      )  | fm_LParenvariableDeclaratorsRParenOne)('<#elseif' .*?'>'(( variableDeclarators      )  | fm_LParenvariableDeclaratorsRParenOne))*'<#else>'(( variableDeclarators      )  | fm_LParenvariableDeclaratorsRParenOne)'</#if>';
fm_LParenfm_DIVPlaceHolderOrDIVRParenOne: '<#if' .*?'>'(( fm_DIVPlaceHolder     | DIV      )  | fm_LParenfm_DIVPlaceHolderOrDIVRParenOne)('<#elseif' .*?'>'(( fm_DIVPlaceHolder     | DIV      )  | fm_LParenfm_DIVPlaceHolderOrDIVRParenOne))*'<#else>'(( fm_DIVPlaceHolder     | DIV      )  | fm_LParenfm_DIVPlaceHolderOrDIVRParenOne)'</#if>';
fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne: '<#if' .*?'>'(( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)('<#elseif' .*?'>'(( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne))*'<#else>'(( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)'</#if>';
fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne: '<#if' .*?'>'(( fm_PUBLICPlaceHolder     | PUBLIC      )  | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)('<#elseif' .*?'>'(( fm_PUBLICPlaceHolder     | PUBLIC      )  | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne))*'<#else>'(( fm_PUBLICPlaceHolder     | PUBLIC      )  | fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne)'</#if>';
fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne: '<#if' .*?'>'(( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )  | fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )  | fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne))*'<#else>'(( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )  | fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne)'</#if>';
fm_LParenlastFormalParameterRParenOne: '<#if' .*?'>'(( lastFormalParameter      )  | fm_LParenlastFormalParameterRParenOne)('<#elseif' .*?'>'(( lastFormalParameter      )  | fm_LParenlastFormalParameterRParenOne))*'<#else>'(( lastFormalParameter      )  | fm_LParenlastFormalParameterRParenOne)'</#if>';
fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne: '<#if' .*?'>'(( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )  | fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )  | fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne))*'<#else>'(( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )  | fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne)'</#if>';
fm_LParenfm_BANGPlaceHolderOrBANGRParenOne: '<#if' .*?'>'(( fm_BANGPlaceHolder     | BANG      )  | fm_LParenfm_BANGPlaceHolderOrBANGRParenOne)('<#elseif' .*?'>'(( fm_BANGPlaceHolder     | BANG      )  | fm_LParenfm_BANGPlaceHolderOrBANGRParenOne))*'<#else>'(( fm_BANGPlaceHolder     | BANG      )  | fm_LParenfm_BANGPlaceHolderOrBANGRParenOne)'</#if>';
fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne: '<#if' .*?'>'(( fm_RETURNPlaceHolder     | RETURN      )  | fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne)('<#elseif' .*?'>'(( fm_RETURNPlaceHolder     | RETURN      )  | fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne))*'<#else>'(( fm_RETURNPlaceHolder     | RETURN      )  | fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne)'</#if>';
fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne: '<#if' .*?'>'(( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )  | fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne)('<#elseif' .*?'>'(( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )  | fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne))*'<#else>'(( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )  | fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne)'</#if>';
fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne: '<#if' .*?'>'(( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )  | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne)('<#elseif' .*?'>'(( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )  | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne))*'<#else>'(( fm_IMPLEMENTSPlaceHolder     | IMPLEMENTS      )  | fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne)'</#if>';
fm_LParentypeListRParenOne: '<#if' .*?'>'(( typeList      )  | fm_LParentypeListRParenOne)('<#elseif' .*?'>'(( typeList      )  | fm_LParentypeListRParenOne))*'<#else>'(( typeList      )  | fm_LParentypeListRParenOne)'</#if>';
fm_LParenfm_GEPlaceHolderOrGERParenOne: '<#if' .*?'>'(( fm_GEPlaceHolder     | GE      )  | fm_LParenfm_GEPlaceHolderOrGERParenOne)('<#elseif' .*?'>'(( fm_GEPlaceHolder     | GE      )  | fm_LParenfm_GEPlaceHolderOrGERParenOne))*'<#else>'(( fm_GEPlaceHolder     | GE      )  | fm_LParenfm_GEPlaceHolderOrGERParenOne)'</#if>';
fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne: '<#if' .*?'>'(( fm_COMMAPlaceHolder     | COMMA      )  | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne)('<#elseif' .*?'>'(( fm_COMMAPlaceHolder     | COMMA      )  | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne))*'<#else>'(( fm_COMMAPlaceHolder     | COMMA      )  | fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne)'</#if>';
fm_newRulexXXx8: '<#if' .*?'>'(( ( fm_LEPlaceHolder     | LE      )     | ( fm_GEPlaceHolder     | GE      )     | ( fm_GTPlaceHolder     | GT      )     | ( fm_LTPlaceHolder     | LT      )      )  | fm_newRulexXXx8)('<#elseif' .*?'>'(( ( fm_LEPlaceHolder     | LE      )     | ( fm_GEPlaceHolder     | GE      )     | ( fm_GTPlaceHolder     | GT      )     | ( fm_LTPlaceHolder     | LT      )      )  | fm_newRulexXXx8))*'<#else>'(( ( fm_LEPlaceHolder     | LE      )     | ( fm_GEPlaceHolder     | GE      )     | ( fm_GTPlaceHolder     | GT      )     | ( fm_LTPlaceHolder     | LT      )      )  | fm_newRulexXXx8)'</#if>';
fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne: '<#if' .*?'>'(( fm_TILDEPlaceHolder     | TILDE      )  | fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne)('<#elseif' .*?'>'(( fm_TILDEPlaceHolder     | TILDE      )  | fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne))*'<#else>'(( fm_TILDEPlaceHolder     | TILDE      )  | fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne)'</#if>';
fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne: '<#if' .*?'>'(( fm_COLONPlaceHolder     | COLON      )  | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne)('<#elseif' .*?'>'(( fm_COLONPlaceHolder     | COLON      )  | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne))*'<#else>'(( fm_COLONPlaceHolder     | COLON      )  | fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne)'</#if>';
fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne: '<#if' .*?'>'(( fm_FLOATPlaceHolder     | FLOAT      )  | fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne)('<#elseif' .*?'>'(( fm_FLOATPlaceHolder     | FLOAT      )  | fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne))*'<#else>'(( fm_FLOATPlaceHolder     | FLOAT      )  | fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne)'</#if>';
fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne: '<#if' .*?'>'(( fm_INTERFACEPlaceHolder     | INTERFACE      )  | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne)('<#elseif' .*?'>'(( fm_INTERFACEPlaceHolder     | INTERFACE      )  | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne))*'<#else>'(( fm_INTERFACEPlaceHolder     | INTERFACE      )  | fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne)'</#if>';
fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne: '<#if' .*?'>'(( fm_NATIVEPlaceHolder     | NATIVE      )  | fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne)('<#elseif' .*?'>'(( fm_NATIVEPlaceHolder     | NATIVE      )  | fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne))*'<#else>'(( fm_NATIVEPlaceHolder     | NATIVE      )  | fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne)'</#if>';
fm_LParenfm_INCPlaceHolderOrINCRParenOne: '<#if' .*?'>'(( fm_INCPlaceHolder     | INC      )  | fm_LParenfm_INCPlaceHolderOrINCRParenOne)('<#elseif' .*?'>'(( fm_INCPlaceHolder     | INC      )  | fm_LParenfm_INCPlaceHolderOrINCRParenOne))*'<#else>'(( fm_INCPlaceHolder     | INC      )  | fm_LParenfm_INCPlaceHolderOrINCRParenOne)'</#if>';
fm_LParenfm_ADDPlaceHolderOrADDRParenOne: '<#if' .*?'>'(( fm_ADDPlaceHolder     | ADD      )  | fm_LParenfm_ADDPlaceHolderOrADDRParenOne)('<#elseif' .*?'>'(( fm_ADDPlaceHolder     | ADD      )  | fm_LParenfm_ADDPlaceHolderOrADDRParenOne))*'<#else>'(( fm_ADDPlaceHolder     | ADD      )  | fm_LParenfm_ADDPlaceHolderOrADDRParenOne)'</#if>';
fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne: '<#if' .*?'>'(( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )  | fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne)('<#elseif' .*?'>'(( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )  | fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne))*'<#else>'(( fm_NOTEQUALPlaceHolder     | NOTEQUAL      )  | fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne)'</#if>';
fm_LParentypeDeclarationRParenOne: '<#if' .*?'>'(( typeDeclaration      )  | fm_LParentypeDeclarationRParenOne)('<#elseif' .*?'>'(( typeDeclaration      )  | fm_LParentypeDeclarationRParenOne))*'<#else>'(( typeDeclaration      )  | fm_LParentypeDeclarationRParenOne)'</#if>';
fm_LParenfm_MODPlaceHolderOrMODRParenOne: '<#if' .*?'>'(( fm_MODPlaceHolder     | MOD      )  | fm_LParenfm_MODPlaceHolderOrMODRParenOne)('<#elseif' .*?'>'(( fm_MODPlaceHolder     | MOD      )  | fm_LParenfm_MODPlaceHolderOrMODRParenOne))*'<#else>'(( fm_MODPlaceHolder     | MOD      )  | fm_LParenfm_MODPlaceHolderOrMODRParenOne)'</#if>';
fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne: '<#if' .*?'>'(( fm_IntegerLiteralPlaceHolder     | IntegerLiteral      )  | fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne)('<#elseif' .*?'>'(( fm_IntegerLiteralPlaceHolder     | IntegerLiteral      )  | fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne))*'<#else>'(( fm_IntegerLiteralPlaceHolder     | IntegerLiteral      )  | fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne)'</#if>';
fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne: '<#if' .*?'>'(( fm_SHORTPlaceHolder     | SHORT      )  | fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne)('<#elseif' .*?'>'(( fm_SHORTPlaceHolder     | SHORT      )  | fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne))*'<#else>'(( fm_SHORTPlaceHolder     | SHORT      )  | fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne)'</#if>';
fm_LParenfm_ATPlaceHolderOrATRParenOne: '<#if' .*?'>'(( fm_ATPlaceHolder     | AT      )  | fm_LParenfm_ATPlaceHolderOrATRParenOne)('<#elseif' .*?'>'(( fm_ATPlaceHolder     | AT      )  | fm_LParenfm_ATPlaceHolderOrATRParenOne))*'<#else>'(( fm_ATPlaceHolder     | AT      )  | fm_LParenfm_ATPlaceHolderOrATRParenOne)'</#if>';
fm_LParenclassCreatorRestRParenOne: '<#if' .*?'>'(( classCreatorRest      )  | fm_LParenclassCreatorRestRParenOne)('<#elseif' .*?'>'(( classCreatorRest      )  | fm_LParenclassCreatorRestRParenOne))*'<#else>'(( classCreatorRest      )  | fm_LParenclassCreatorRestRParenOne)'</#if>';
fm_LParenelementValueRParenOne: '<#if' .*?'>'(( elementValue      )  | fm_LParenelementValueRParenOne)('<#elseif' .*?'>'(( elementValue      )  | fm_LParenelementValueRParenOne))*'<#else>'(( elementValue      )  | fm_LParenelementValueRParenOne)'</#if>';
fm_LParenfinallyBlockRParenOne: '<#if' .*?'>'(( finallyBlock      )  | fm_LParenfinallyBlockRParenOne)('<#elseif' .*?'>'(( finallyBlock      )  | fm_LParenfinallyBlockRParenOne))*'<#else>'(( finallyBlock      )  | fm_LParenfinallyBlockRParenOne)'</#if>';
fm_LParenexplicitGenericInvocationRParenOne: '<#if' .*?'>'(( explicitGenericInvocation      )  | fm_LParenexplicitGenericInvocationRParenOne)('<#elseif' .*?'>'(( explicitGenericInvocation      )  | fm_LParenexplicitGenericInvocationRParenOne))*'<#else>'(( explicitGenericInvocation      )  | fm_LParenexplicitGenericInvocationRParenOne)'</#if>';
fm_LParenconstDeclarationRParenOne: '<#if' .*?'>'(( constDeclaration      )  | fm_LParenconstDeclarationRParenOne)('<#elseif' .*?'>'(( constDeclaration      )  | fm_LParenconstDeclarationRParenOne))*'<#else>'(( constDeclaration      )  | fm_LParenconstDeclarationRParenOne)'</#if>';
fm_LPareninterfaceDeclarationRParenOne: '<#if' .*?'>'(( interfaceDeclaration      )  | fm_LPareninterfaceDeclarationRParenOne)('<#elseif' .*?'>'(( interfaceDeclaration      )  | fm_LPareninterfaceDeclarationRParenOne))*'<#else>'(( interfaceDeclaration      )  | fm_LPareninterfaceDeclarationRParenOne)'</#if>';
fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne: '<#if' .*?'>'(( fm_FINALLYPlaceHolder     | FINALLY      )  | fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne)('<#elseif' .*?'>'(( fm_FINALLYPlaceHolder     | FINALLY      )  | fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne))*'<#else>'(( fm_FINALLYPlaceHolder     | FINALLY      )  | fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne)'</#if>';
fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne: '<#if' .*?'>'(( fm_RBRACEPlaceHolder     | RBRACE      )  | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)('<#elseif' .*?'>'(( fm_RBRACEPlaceHolder     | RBRACE      )  | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne))*'<#else>'(( fm_RBRACEPlaceHolder     | RBRACE      )  | fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne)'</#if>';
fm_newRulexXXx9: '<#if' .*?'>'(( ( fm_ASSIGNPlaceHolder     | ASSIGN      )     | ( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )     | ( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )     | ( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )     | ( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )     | ( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )     | ( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )     | ( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )     | ( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )     | ( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )     | ( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )     | ( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )      )  | fm_newRulexXXx9)('<#elseif' .*?'>'(( ( fm_ASSIGNPlaceHolder     | ASSIGN      )     | ( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )     | ( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )     | ( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )     | ( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )     | ( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )     | ( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )     | ( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )     | ( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )     | ( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )     | ( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )     | ( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )      )  | fm_newRulexXXx9))*'<#else>'(( ( fm_ASSIGNPlaceHolder     | ASSIGN      )     | ( fm_ADD_ASSIGNPlaceHolder     | ADD_ASSIGN      )     | ( fm_SUB_ASSIGNPlaceHolder     | SUB_ASSIGN      )     | ( fm_MUL_ASSIGNPlaceHolder     | MUL_ASSIGN      )     | ( fm_DIV_ASSIGNPlaceHolder     | DIV_ASSIGN      )     | ( fm_AND_ASSIGNPlaceHolder     | AND_ASSIGN      )     | ( fm_OR_ASSIGNPlaceHolder     | OR_ASSIGN      )     | ( fm_XOR_ASSIGNPlaceHolder     | XOR_ASSIGN      )     | ( fm_RSHIFT_ASSIGNPlaceHolder     | RSHIFT_ASSIGN      )     | ( fm_URSHIFT_ASSIGNPlaceHolder     | URSHIFT_ASSIGN      )     | ( fm_LSHIFT_ASSIGNPlaceHolder     | LSHIFT_ASSIGN      )     | ( fm_MOD_ASSIGNPlaceHolder     | MOD_ASSIGN      )      )  | fm_newRulexXXx9)'</#if>';
fm_LParenvariableInitializerRParenOne: '<#if' .*?'>'(( variableInitializer      )  | fm_LParenvariableInitializerRParenOne)('<#elseif' .*?'>'(( variableInitializer      )  | fm_LParenvariableInitializerRParenOne))*'<#else>'(( variableInitializer      )  | fm_LParenvariableInitializerRParenOne)'</#if>';
fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne: '<#if' .*?'>'(( fm_BYTEPlaceHolder     | BYTE      )  | fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne)('<#elseif' .*?'>'(( fm_BYTEPlaceHolder     | BYTE      )  | fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne))*'<#else>'(( fm_BYTEPlaceHolder     | BYTE      )  | fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne)'</#if>';
fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne: '<#if' .*?'>'(( fm_STRICTFPPlaceHolder     | STRICTFP      )  | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne)('<#elseif' .*?'>'(( fm_STRICTFPPlaceHolder     | STRICTFP      )  | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne))*'<#else>'(( fm_STRICTFPPlaceHolder     | STRICTFP      )  | fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne)'</#if>';
fm_LParenargumentsRParenOne: '<#if' .*?'>'(( arguments      )  | fm_LParenargumentsRParenOne)('<#elseif' .*?'>'(( arguments      )  | fm_LParenargumentsRParenOne))*'<#else>'(( arguments      )  | fm_LParenargumentsRParenOne)'</#if>';
fm_LParenvariableDeclaratorRParenOne: '<#if' .*?'>'(( variableDeclarator      )  | fm_LParenvariableDeclaratorRParenOne)('<#elseif' .*?'>'(( variableDeclarator      )  | fm_LParenvariableDeclaratorRParenOne))*'<#else>'(( variableDeclarator      )  | fm_LParenvariableDeclaratorRParenOne)'</#if>';
fm_LParenfm_CARETPlaceHolderOrCARETRParenOne: '<#if' .*?'>'(( fm_CARETPlaceHolder     | CARET      )  | fm_LParenfm_CARETPlaceHolderOrCARETRParenOne)('<#elseif' .*?'>'(( fm_CARETPlaceHolder     | CARET      )  | fm_LParenfm_CARETPlaceHolderOrCARETRParenOne))*'<#else>'(( fm_CARETPlaceHolder     | CARET      )  | fm_LParenfm_CARETPlaceHolderOrCARETRParenOne)'</#if>';
fm_LParenfm_NEWPlaceHolderOrNEWRParenOne: '<#if' .*?'>'(( fm_NEWPlaceHolder     | NEW      )  | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne)('<#elseif' .*?'>'(( fm_NEWPlaceHolder     | NEW      )  | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne))*'<#else>'(( fm_NEWPlaceHolder     | NEW      )  | fm_LParenfm_NEWPlaceHolderOrNEWRParenOne)'</#if>';
fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne: '<#if' .*?'>'(( ( fm_MULPlaceHolder     | MUL      )     | ( fm_DIVPlaceHolder     | DIV      )     | ( fm_MODPlaceHolder     | MOD      )      )  | fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne)('<#elseif' .*?'>'(( ( fm_MULPlaceHolder     | MUL      )     | ( fm_DIVPlaceHolder     | DIV      )     | ( fm_MODPlaceHolder     | MOD      )      )  | fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne))*'<#else>'(( ( fm_MULPlaceHolder     | MUL      )     | ( fm_DIVPlaceHolder     | DIV      )     | ( fm_MODPlaceHolder     | MOD      )      )  | fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne)'</#if>';
fm_LParenqualifiedNameListRParenOne: '<#if' .*?'>'(( qualifiedNameList      )  | fm_LParenqualifiedNameListRParenOne)('<#elseif' .*?'>'(( qualifiedNameList      )  | fm_LParenqualifiedNameListRParenOne))*'<#else>'(( qualifiedNameList      )  | fm_LParenqualifiedNameListRParenOne)'</#if>';
fm_LParenexplicitGenericInvocationSuffixRParenOne: '<#if' .*?'>'(( explicitGenericInvocationSuffix      )  | fm_LParenexplicitGenericInvocationSuffixRParenOne)('<#elseif' .*?'>'(( explicitGenericInvocationSuffix      )  | fm_LParenexplicitGenericInvocationSuffixRParenOne))*'<#else>'(( explicitGenericInvocationSuffix      )  | fm_LParenexplicitGenericInvocationSuffixRParenOne)'</#if>';
fm_LParenresourcesRParenOne: '<#if' .*?'>'(( resources      )  | fm_LParenresourcesRParenOne)('<#elseif' .*?'>'(( resources      )  | fm_LParenresourcesRParenOne))*'<#else>'(( resources      )  | fm_LParenresourcesRParenOne)'</#if>';
fm_LParenblockRParenOne: '<#if' .*?'>'(( block      )  | fm_LParenblockRParenOne)('<#elseif' .*?'>'(( block      )  | fm_LParenblockRParenOne))*'<#else>'(( block      )  | fm_LParenblockRParenOne)'</#if>';
fm_LParenconstructorBodyRParenOne: '<#if' .*?'>'(( constructorBody      )  | fm_LParenconstructorBodyRParenOne)('<#elseif' .*?'>'(( constructorBody      )  | fm_LParenconstructorBodyRParenOne))*'<#else>'(( constructorBody      )  | fm_LParenconstructorBodyRParenOne)'</#if>';
fm_LParenlocalVariableDeclarationRParenOne: '<#if' .*?'>'(( localVariableDeclaration      )  | fm_LParenlocalVariableDeclarationRParenOne)('<#elseif' .*?'>'(( localVariableDeclaration      )  | fm_LParenlocalVariableDeclarationRParenOne))*'<#else>'(( localVariableDeclaration      )  | fm_LParenlocalVariableDeclarationRParenOne)'</#if>';
fm_LParenannotationTypeDeclarationRParenOne: '<#if' .*?'>'(( annotationTypeDeclaration      )  | fm_LParenannotationTypeDeclarationRParenOne)('<#elseif' .*?'>'(( annotationTypeDeclaration      )  | fm_LParenannotationTypeDeclarationRParenOne))*'<#else>'(( annotationTypeDeclaration      )  | fm_LParenannotationTypeDeclarationRParenOne)'</#if>';