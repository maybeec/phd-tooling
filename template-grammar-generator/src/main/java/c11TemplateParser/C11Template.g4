/*
 [The "BSD licence"]
 Copyright (c) 2013 Sam Harwell
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

/** C 2011 grammar built from the C11 Spec */
grammar C11Template;

primaryExpression
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    |   ((fm_ConstantPlaceHolder | Constant) | fm_LParenfm_ConstantPlaceHolderOrConstantRParenOne)
    |   (fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop* ((fm_StringLiteralPlaceHolder | StringLiteral) | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus) (( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar)*)
    |   ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   ((genericSelection) | fm_LParengenericSelectionRParenOne)
    |   FM_ImplicitToken1 ? ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((compoundStatement) | fm_LParencompoundStatementRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) // Blocks (GCC extension)
    |   FM_ImplicitToken2  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   FM_ImplicitToken3  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    ;

genericSelection
    :   ((fm_GenericPlaceHolder | Generic ) | fm_LParenfm_GenericPlaceHolderOrGenericRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((genericAssocList) | fm_LParengenericAssocListRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    ;

genericAssocList
    :   ((genericAssociation) | fm_LParengenericAssociationRParenOne)
    |   genericAssocList ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((genericAssociation) | fm_LParengenericAssociationRParenOne)
    ;

genericAssociation
    :   ((typeName) | fm_LParentypeNameRParenOne) ((fm_ColonPlaceHolder | Colon ) | fm_LParenfm_ColonPlaceHolderOrColonRParenOne) ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne)
    |   ((fm_DefaultPlaceHolder | Default ) | fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne) ((fm_ColonPlaceHolder | Colon ) | fm_LParenfm_ColonPlaceHolderOrColonRParenOne) ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne)
    ;

postfixExpression
    :   ((primaryExpression) | fm_LParenprimaryExpressionRParenOne)
    |   postfixExpression ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   postfixExpression ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((argumentExpressionList) | fm_LParenargumentExpressionListRParenQuestion)? ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   postfixExpression ((fm_DotPlaceHolder | Dot ) | fm_LParenfm_DotPlaceHolderOrDotRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    |   postfixExpression ((fm_ArrowPlaceHolder | Arrow ) | fm_LParenfm_ArrowPlaceHolderOrArrowRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    |   postfixExpression ((fm_PlusPlusPlaceHolder | PlusPlus ) | fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne)
    |   postfixExpression ((fm_MinusMinusPlaceHolder | MinusMinus ) | fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne)
    |   ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((initializerList) | fm_LPareninitializerListRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    |   ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((initializerList) | fm_LPareninitializerListRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    |   FM_ImplicitToken4  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((initializerList) | fm_LPareninitializerListRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    |   FM_ImplicitToken5  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((initializerList) | fm_LPareninitializerListRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    ;

argumentExpressionList
    :   ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne)
    |   argumentExpressionList ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne)
    ;

unaryExpression
    :   ((postfixExpression) | fm_LParenpostfixExpressionRParenOne)
    |   ((fm_PlusPlusPlaceHolder | PlusPlus ) | fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne) unaryExpression
    |   ((fm_MinusMinusPlaceHolder | MinusMinus ) | fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne) unaryExpression
    |   ((unaryOperator) | fm_LParenunaryOperatorRParenOne) ((castExpression) | fm_LParencastExpressionRParenOne)
    |   ((fm_SizeofPlaceHolder | Sizeof ) | fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne) unaryExpression
    |   ((fm_SizeofPlaceHolder | Sizeof ) | fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   ((fm_AlignofPlaceHolder | Alignof ) | fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   ((fm_AndAndPlaceHolder | AndAnd ) | fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) // GCC extension address of label
    ;

unaryOperator
    :   ((fm_AndPlaceHolder | And ) | fm_LParenfm_AndPlaceHolderOrAndRParenOne) | ((fm_StarPlaceHolder | Star ) | fm_LParenfm_StarPlaceHolderOrStarRParenOne) | ((fm_PlusPlaceHolder | Plus ) | fm_LParenfm_PlusPlaceHolderOrPlusRParenOne) | ((fm_MinusPlaceHolder | Minus ) | fm_LParenfm_MinusPlaceHolderOrMinusRParenOne) | ((fm_TildePlaceHolder | Tilde ) | fm_LParenfm_TildePlaceHolderOrTildeRParenOne) | ((fm_NotPlaceHolder | Not ) | fm_LParenfm_NotPlaceHolderOrNotRParenOne)
    ;

castExpression
    :   ((unaryExpression) | fm_LParenunaryExpressionRParenOne)
    |   ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) castExpression
    |   FM_ImplicitToken6  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) castExpression
    ;

multiplicativeExpression
    :   ((castExpression) | fm_LParencastExpressionRParenOne)
    |   multiplicativeExpression ((fm_StarPlaceHolder | Star ) | fm_LParenfm_StarPlaceHolderOrStarRParenOne) ((castExpression) | fm_LParencastExpressionRParenOne)
    |   multiplicativeExpression ((fm_DivPlaceHolder | Div ) | fm_LParenfm_DivPlaceHolderOrDivRParenOne) ((castExpression) | fm_LParencastExpressionRParenOne)
    |   multiplicativeExpression ((fm_ModPlaceHolder | Mod ) | fm_LParenfm_ModPlaceHolderOrModRParenOne) ((castExpression) | fm_LParencastExpressionRParenOne)
    ;

additiveExpression
    :   ((multiplicativeExpression) | fm_LParenmultiplicativeExpressionRParenOne)
    |   additiveExpression ((fm_PlusPlaceHolder | Plus ) | fm_LParenfm_PlusPlaceHolderOrPlusRParenOne) ((multiplicativeExpression) | fm_LParenmultiplicativeExpressionRParenOne)
    |   additiveExpression ((fm_MinusPlaceHolder | Minus ) | fm_LParenfm_MinusPlaceHolderOrMinusRParenOne) ((multiplicativeExpression) | fm_LParenmultiplicativeExpressionRParenOne)
    ;

shiftExpression
    :   ((additiveExpression) | fm_LParenadditiveExpressionRParenOne)
    |   shiftExpression ((fm_LeftShiftPlaceHolder | LeftShift ) | fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne) ((additiveExpression) | fm_LParenadditiveExpressionRParenOne)
    |   shiftExpression ((fm_RightShiftPlaceHolder | RightShift ) | fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne) ((additiveExpression) | fm_LParenadditiveExpressionRParenOne)
    ;

relationalExpression
    :   ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
    |   relationalExpression ((fm_LessPlaceHolder | Less ) | fm_LParenfm_LessPlaceHolderOrLessRParenOne) ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
    |   relationalExpression ((fm_GreaterPlaceHolder | Greater ) | fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne) ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
    |   relationalExpression ((fm_LessEqualPlaceHolder | LessEqual ) | fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne) ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
    |   relationalExpression ((fm_GreaterEqualPlaceHolder | GreaterEqual ) | fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne) ((shiftExpression) | fm_LParenshiftExpressionRParenOne)
    ;

equalityExpression
    :   ((relationalExpression) | fm_LParenrelationalExpressionRParenOne)
    |   equalityExpression ((fm_EqualPlaceHolder | Equal ) | fm_LParenfm_EqualPlaceHolderOrEqualRParenOne) ((relationalExpression) | fm_LParenrelationalExpressionRParenOne)
    |   equalityExpression ((fm_NotEqualPlaceHolder | NotEqual ) | fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne) ((relationalExpression) | fm_LParenrelationalExpressionRParenOne)
    ;

andExpression
    :   ((equalityExpression) | fm_LParenequalityExpressionRParenOne)
    |   andExpression ((fm_AndPlaceHolder | And ) | fm_LParenfm_AndPlaceHolderOrAndRParenOne) ((equalityExpression) | fm_LParenequalityExpressionRParenOne)
    ;

exclusiveOrExpression
    :   ((andExpression) | fm_LParenandExpressionRParenOne)
    |   exclusiveOrExpression ((fm_CaretPlaceHolder | Caret ) | fm_LParenfm_CaretPlaceHolderOrCaretRParenOne) ((andExpression) | fm_LParenandExpressionRParenOne)
    ;

inclusiveOrExpression
    :   ((exclusiveOrExpression) | fm_LParenexclusiveOrExpressionRParenOne)
    |   inclusiveOrExpression ((fm_OrPlaceHolder | Or ) | fm_LParenfm_OrPlaceHolderOrOrRParenOne) ((exclusiveOrExpression) | fm_LParenexclusiveOrExpressionRParenOne)
    ;

logicalAndExpression
    :   ((inclusiveOrExpression) | fm_LPareninclusiveOrExpressionRParenOne)
    |   logicalAndExpression ((fm_AndAndPlaceHolder | AndAnd ) | fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne) ((inclusiveOrExpression) | fm_LPareninclusiveOrExpressionRParenOne)
    ;

logicalOrExpression
    :   ((logicalAndExpression) | fm_LParenlogicalAndExpressionRParenOne)
    |   logicalOrExpression ((fm_OrOrPlaceHolder | OrOr ) | fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne) ((logicalAndExpression) | fm_LParenlogicalAndExpressionRParenOne)
    ;

conditionalExpression
    :   ((logicalOrExpression) | fm_LParenlogicalOrExpressionRParenOne) ((((fm_QuestionPlaceHolder | Question ) | fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_ColonPlaceHolder | Colon ) | fm_LParenfm_ColonPlaceHolderOrColonRParenOne) conditionalExpression) | fm_newRulexXXx0)?
    ;

assignmentExpression
    :   ((conditionalExpression) | fm_LParenconditionalExpressionRParenOne)
    |   ((unaryExpression) | fm_LParenunaryExpressionRParenOne) ((assignmentOperator) | fm_LParenassignmentOperatorRParenOne) assignmentExpression
    ;

assignmentOperator
    :   ((fm_AssignPlaceHolder | Assign ) | fm_LParenfm_AssignPlaceHolderOrAssignRParenOne) | ((fm_StarAssignPlaceHolder | StarAssign ) | fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne) | ((fm_DivAssignPlaceHolder | DivAssign ) | fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne) | ((fm_ModAssignPlaceHolder | ModAssign ) | fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne) | ((fm_PlusAssignPlaceHolder | PlusAssign ) | fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne) | ((fm_MinusAssignPlaceHolder | MinusAssign ) | fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne) | ((fm_LeftShiftAssignPlaceHolder | LeftShiftAssign ) | fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne) | ((fm_RightShiftAssignPlaceHolder | RightShiftAssign ) | fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne) | ((fm_AndAssignPlaceHolder | AndAssign ) | fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne) | ((fm_XorAssignPlaceHolder | XorAssign ) | fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne) | ((fm_OrAssignPlaceHolder | OrAssign ) | fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne)
    ;

expression
    :   ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne)
    |   expression ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne)
    ;

constantExpression
    :   ((conditionalExpression) | fm_LParenconditionalExpressionRParenOne)
    ;

declaration
    :   ((declarationSpecifiers) | fm_LParendeclarationSpecifiersRParenOne) ((initDeclaratorList) | fm_LPareninitDeclaratorListRParenQuestion)? ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    |   ((staticAssertDeclaration) | fm_LParenstaticAssertDeclarationRParenOne)
    ;

declarationSpecifiers
    :   (fm_LParendeclarationSpecifierRParenIfLoop* ((declarationSpecifier) | fm_LParendeclarationSpecifierRParenOnePlus) (( declarationSpecifier      )  | fm_LParendeclarationSpecifierRParenStar)*)
    ;

declarationSpecifiers2
    :   (fm_LParendeclarationSpecifierRParenIfLoop* ((declarationSpecifier) | fm_LParendeclarationSpecifierRParenOnePlus) (( declarationSpecifier      )  | fm_LParendeclarationSpecifierRParenStar)*)
    ;

declarationSpecifier
    :   ((storageClassSpecifier) | fm_LParenstorageClassSpecifierRParenOne)
    |   ((typeSpecifier) | fm_LParentypeSpecifierRParenOne)
    |   ((typeQualifier) | fm_LParentypeQualifierRParenOne)
    |   ((functionSpecifier) | fm_LParenfunctionSpecifierRParenOne)
    |   ((alignmentSpecifier) | fm_LParenalignmentSpecifierRParenOne)
    ;

initDeclaratorList
    :   ((initDeclarator) | fm_LPareninitDeclaratorRParenOne)
    |   initDeclaratorList ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((initDeclarator) | fm_LPareninitDeclaratorRParenOne)
    ;

initDeclarator
    :   ((declarator) | fm_LParendeclaratorRParenOne)
    |   ((declarator) | fm_LParendeclaratorRParenOne) ((fm_AssignPlaceHolder | Assign ) | fm_LParenfm_AssignPlaceHolderOrAssignRParenOne) ((initializer) | fm_LPareninitializerRParenOne)
    ;

storageClassSpecifier
    :   ((fm_TypedefPlaceHolder | Typedef ) | fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne)
    |   ((fm_ExternPlaceHolder | Extern ) | fm_LParenfm_ExternPlaceHolderOrExternRParenOne)
    |   ((fm_StaticPlaceHolder | Static ) | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne)
    |   ((fm_ThreadLocalPlaceHolder | ThreadLocal ) | fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne)
    |   ((fm_AutoPlaceHolder | Auto ) | fm_LParenfm_AutoPlaceHolderOrAutoRParenOne)
    |   ((fm_RegisterPlaceHolder | Register ) | fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne)
    ;

typeSpecifier
    :   ((((fm_VoidPlaceHolder | Void ) | fm_LParenfm_VoidPlaceHolderOrVoidRParenOne)
    |   ((fm_CharPlaceHolder | Char ) | fm_LParenfm_CharPlaceHolderOrCharRParenOne)
    |   ((fm_ShortPlaceHolder | Short ) | fm_LParenfm_ShortPlaceHolderOrShortRParenOne)
    |   ((fm_IntPlaceHolder | Int ) | fm_LParenfm_IntPlaceHolderOrIntRParenOne)
    |   ((fm_LongPlaceHolder | Long ) | fm_LParenfm_LongPlaceHolderOrLongRParenOne)
    |   ((fm_FloatPlaceHolder | Float ) | fm_LParenfm_FloatPlaceHolderOrFloatRParenOne)
    |   ((fm_DoublePlaceHolder | Double ) | fm_LParenfm_DoublePlaceHolderOrDoubleRParenOne)
    |   ((fm_SignedPlaceHolder | Signed ) | fm_LParenfm_SignedPlaceHolderOrSignedRParenOne)
    |   ((fm_UnsignedPlaceHolder | Unsigned ) | fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne)
    |   ((fm_BoolPlaceHolder | Bool ) | fm_LParenfm_BoolPlaceHolderOrBoolRParenOne)
    |   ((fm_ComplexPlaceHolder | Complex ) | fm_LParenfm_ComplexPlaceHolderOrComplexRParenOne)
    |   FM_ImplicitToken7 
    |   FM_ImplicitToken8 
    |   FM_ImplicitToken9 ) | fm_newRulexXXx1)
    |   FM_ImplicitToken10  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((FM_ImplicitToken11  | FM_ImplicitToken12  | FM_ImplicitToken13 ) | fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   ((atomicTypeSpecifier) | fm_LParenatomicTypeSpecifierRParenOne)
    |   ((structOrUnionSpecifier) | fm_LParenstructOrUnionSpecifierRParenOne)
    |   ((enumSpecifier) | fm_LParenenumSpecifierRParenOne)
    |   ((typedefName) | fm_LParentypedefNameRParenOne)
    |   FM_ImplicitToken14  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) // GCC extension
    ;

structOrUnionSpecifier
    :   ((structOrUnion) | fm_LParenstructOrUnionRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion)? ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((structDeclarationList) | fm_LParenstructDeclarationListRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    |   ((structOrUnion) | fm_LParenstructOrUnionRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    ;

structOrUnion
    :   ((fm_StructPlaceHolder | Struct ) | fm_LParenfm_StructPlaceHolderOrStructRParenOne)
    |   ((fm_UnionPlaceHolder | Union ) | fm_LParenfm_UnionPlaceHolderOrUnionRParenOne)
    ;

structDeclarationList
    :   ((structDeclaration) | fm_LParenstructDeclarationRParenOne)
    |   structDeclarationList ((structDeclaration) | fm_LParenstructDeclarationRParenOne)
    ;

structDeclaration
    :   ((specifierQualifierList) | fm_LParenspecifierQualifierListRParenOne) ((structDeclaratorList) | fm_LParenstructDeclaratorListRParenQuestion)? ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    |   ((staticAssertDeclaration) | fm_LParenstaticAssertDeclarationRParenOne)
    ;

specifierQualifierList
    :   ((typeSpecifier) | fm_LParentypeSpecifierRParenOne) specifierQualifierList?
    |   ((typeQualifier) | fm_LParentypeQualifierRParenOne) specifierQualifierList?
    ;

structDeclaratorList
    :   ((structDeclarator) | fm_LParenstructDeclaratorRParenOne)
    |   structDeclaratorList ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((structDeclarator) | fm_LParenstructDeclaratorRParenOne)
    ;

structDeclarator
    :   ((declarator) | fm_LParendeclaratorRParenOne)
    |   ((declarator) | fm_LParendeclaratorRParenQuestion)? ((fm_ColonPlaceHolder | Colon ) | fm_LParenfm_ColonPlaceHolderOrColonRParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne)
    ;

enumSpecifier
    :   ((fm_EnumPlaceHolder | Enum ) | fm_LParenfm_EnumPlaceHolderOrEnumRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion)? ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((enumeratorList) | fm_LParenenumeratorListRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    |   ((fm_EnumPlaceHolder | Enum ) | fm_LParenfm_EnumPlaceHolderOrEnumRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion)? ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((enumeratorList) | fm_LParenenumeratorListRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    |   ((fm_EnumPlaceHolder | Enum ) | fm_LParenfm_EnumPlaceHolderOrEnumRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    ;

enumeratorList
    :   ((enumerator) | fm_LParenenumeratorRParenOne)
    |   enumeratorList ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((enumerator) | fm_LParenenumeratorRParenOne)
    ;

enumerator
    :   ((enumerationConstant) | fm_LParenenumerationConstantRParenOne)
    |   ((enumerationConstant) | fm_LParenenumerationConstantRParenOne) ((fm_AssignPlaceHolder | Assign ) | fm_LParenfm_AssignPlaceHolderOrAssignRParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne)
    ;

enumerationConstant
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    ;

atomicTypeSpecifier
    :   ((fm_AtomicPlaceHolder | Atomic ) | fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    ;

typeQualifier
    :   ((fm_ConstPlaceHolder | Const ) | fm_LParenfm_ConstPlaceHolderOrConstRParenOne)
    |   ((fm_RestrictPlaceHolder | Restrict ) | fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne)
    |   ((fm_VolatilePlaceHolder | Volatile ) | fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne)
    |   ((fm_AtomicPlaceHolder | Atomic ) | fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne)
    ;

functionSpecifier
    :   ((((fm_InlinePlaceHolder | Inline ) | fm_LParenfm_InlinePlaceHolderOrInlineRParenOne)
    |   ((fm_NoreturnPlaceHolder | Noreturn ) | fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne)
    |   FM_ImplicitToken15  // GCC extension
    |   FM_ImplicitToken16 ) | fm_newRulexXXx2)
    |   ((gccAttributeSpecifier) | fm_LParengccAttributeSpecifierRParenOne)
    |   FM_ImplicitToken17  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    ;

alignmentSpecifier
    :   ((fm_AlignasPlaceHolder | Alignas ) | fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((typeName) | fm_LParentypeNameRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   ((fm_AlignasPlaceHolder | Alignas ) | fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    ;

declarator
    :   ((pointer) | fm_LParenpointerRParenQuestion)? ((directDeclarator) | fm_LParendirectDeclaratorRParenOne) ((gccDeclaratorExtension) | fm_LParengccDeclaratorExtensionRParenStar)*
    ;

directDeclarator
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    |   ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((declarator) | fm_LParendeclaratorRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   directDeclarator ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? ((assignmentExpression) | fm_LParenassignmentExpressionRParenQuestion)? ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   directDeclarator ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((fm_StaticPlaceHolder | Static ) | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   directDeclarator ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenOne) ((fm_StaticPlaceHolder | Static ) | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne) ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   directDeclarator ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? ((fm_StarPlaceHolder | Star ) | fm_LParenfm_StarPlaceHolderOrStarRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   directDeclarator ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((parameterTypeList) | fm_LParenparameterTypeListRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   directDeclarator ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((identifierList) | fm_LParenidentifierListRParenQuestion)? ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    ;

gccDeclaratorExtension
    :   FM_ImplicitToken18  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) (fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop* ((fm_StringLiteralPlaceHolder | StringLiteral) | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus) (( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar)*) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    |   ((gccAttributeSpecifier) | fm_LParengccAttributeSpecifierRParenOne)
    ;

gccAttributeSpecifier
    :   FM_ImplicitToken19  ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((gccAttributeList) | fm_LParengccAttributeListRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
    ;

gccAttributeList
    :   ((gccAttribute) | fm_LParengccAttributeRParenOne) ((((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((gccAttribute) | fm_LParengccAttributeRParenOne)) | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar)*
    |   // empty
    ;

gccAttribute
    :   ~(',' | '(' | ')') // relaxed def for "identifier or reserved word"
        ((((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((argumentExpressionList) | fm_LParenargumentExpressionListRParenQuestion)? ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)) | fm_newRulexXXx3)?
    |   // empty
    ;

nestedParenthesesBlock
    :   ((   ~('(' | ')')
        |   ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) nestedParenthesesBlock ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)
        ) | fm_newRulexXXx4)*
    ;

pointer
    :   ((fm_StarPlaceHolder | Star ) | fm_LParenfm_StarPlaceHolderOrStarRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)?
    |   ((fm_StarPlaceHolder | Star ) | fm_LParenfm_StarPlaceHolderOrStarRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? pointer
    |   ((fm_CaretPlaceHolder | Caret ) | fm_LParenfm_CaretPlaceHolderOrCaretRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? // Blocks language extension
    |   ((fm_CaretPlaceHolder | Caret ) | fm_LParenfm_CaretPlaceHolderOrCaretRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? pointer // Blocks language extension
    ;

typeQualifierList
    :   ((typeQualifier) | fm_LParentypeQualifierRParenOne)
    |   typeQualifierList ((typeQualifier) | fm_LParentypeQualifierRParenOne)
    ;

parameterTypeList
    :   ((parameterList) | fm_LParenparameterListRParenOne)
    |   ((parameterList) | fm_LParenparameterListRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((fm_EllipsisPlaceHolder | Ellipsis ) | fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne)
    ;

parameterList
    :   ((parameterDeclaration) | fm_LParenparameterDeclarationRParenOne)
    |   parameterList ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((parameterDeclaration) | fm_LParenparameterDeclarationRParenOne)
    ;

parameterDeclaration
    :   ((declarationSpecifiers) | fm_LParendeclarationSpecifiersRParenOne) ((declarator) | fm_LParendeclaratorRParenOne)
    |   ((declarationSpecifiers2) | fm_LParendeclarationSpecifiers2RParenOne) ((abstractDeclarator) | fm_LParenabstractDeclaratorRParenQuestion)?
    ;

identifierList
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    |   identifierList ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    ;

typeName
    :   ((specifierQualifierList) | fm_LParenspecifierQualifierListRParenOne) ((abstractDeclarator) | fm_LParenabstractDeclaratorRParenQuestion)?
    ;

abstractDeclarator
    :   ((pointer) | fm_LParenpointerRParenOne)
    |   ((pointer) | fm_LParenpointerRParenQuestion)? ((directAbstractDeclarator) | fm_LParendirectAbstractDeclaratorRParenOne) ((gccDeclaratorExtension) | fm_LParengccDeclaratorExtensionRParenStar)*
    ;

directAbstractDeclarator
    :   ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((abstractDeclarator) | fm_LParenabstractDeclaratorRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((gccDeclaratorExtension) | fm_LParengccDeclaratorExtensionRParenStar)*
    |   ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? ((assignmentExpression) | fm_LParenassignmentExpressionRParenQuestion)? ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((fm_StaticPlaceHolder | Static ) | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenOne) ((fm_StaticPlaceHolder | Static ) | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne) ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((fm_StarPlaceHolder | Star ) | fm_LParenfm_StarPlaceHolderOrStarRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((parameterTypeList) | fm_LParenparameterTypeListRParenQuestion)? ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((gccDeclaratorExtension) | fm_LParengccDeclaratorExtensionRParenStar)*
    |   directAbstractDeclarator ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? ((assignmentExpression) | fm_LParenassignmentExpressionRParenQuestion)? ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   directAbstractDeclarator ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((fm_StaticPlaceHolder | Static ) | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenQuestion)? ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   directAbstractDeclarator ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((typeQualifierList) | fm_LParentypeQualifierListRParenOne) ((fm_StaticPlaceHolder | Static ) | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne) ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   directAbstractDeclarator ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((fm_StarPlaceHolder | Star ) | fm_LParenfm_StarPlaceHolderOrStarRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   directAbstractDeclarator ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((parameterTypeList) | fm_LParenparameterTypeListRParenQuestion)? ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((gccDeclaratorExtension) | fm_LParengccDeclaratorExtensionRParenStar)*
    ;

typedefName
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    ;

initializer
    :   ((assignmentExpression) | fm_LParenassignmentExpressionRParenOne)
    |   ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((initializerList) | fm_LPareninitializerListRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    |   ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((initializerList) | fm_LPareninitializerListRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    ;

initializerList
    :   ((designation) | fm_LParendesignationRParenQuestion)? ((initializer) | fm_LPareninitializerRParenOne)
    |   initializerList ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((designation) | fm_LParendesignationRParenQuestion)? ((initializer) | fm_LPareninitializerRParenOne)
    ;

designation
    :   ((designatorList) | fm_LParendesignatorListRParenOne) ((fm_AssignPlaceHolder | Assign ) | fm_LParenfm_AssignPlaceHolderOrAssignRParenOne)
    ;

designatorList
    :   ((designator) | fm_LParendesignatorRParenOne)
    |   designatorList ((designator) | fm_LParendesignatorRParenOne)
    ;

designator
    :   ((fm_LeftBracketPlaceHolder | LeftBracket ) | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne) ((fm_RightBracketPlaceHolder | RightBracket ) | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)
    |   ((fm_DotPlaceHolder | Dot ) | fm_LParenfm_DotPlaceHolderOrDotRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)
    ;

staticAssertDeclaration
    :   ((fm_StaticAssertPlaceHolder | StaticAssert ) | fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne) ((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) (fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop* ((fm_StringLiteralPlaceHolder | StringLiteral) | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus) (( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar)*) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    ;

statement
    :   ((labeledStatement) | fm_LParenlabeledStatementRParenOne)
    |   ((compoundStatement) | fm_LParencompoundStatementRParenOne)
    |   ((expressionStatement) | fm_LParenexpressionStatementRParenOne)
    |   ((selectionStatement) | fm_LParenselectionStatementRParenOne)
    |   ((iterationStatement) | fm_LPareniterationStatementRParenOne)
    |   ((jumpStatement) | fm_LParenjumpStatementRParenOne)
    |   ((FM_ImplicitToken20  | FM_ImplicitToken21 ) | fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne) ((((fm_VolatilePlaceHolder | Volatile ) | fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne) | FM_ImplicitToken22 ) | fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((((logicalOrExpression) | fm_LParenlogicalOrExpressionRParenOne) ((((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((logicalOrExpression) | fm_LParenlogicalOrExpressionRParenOne)) | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar)*) | fm_newRulexXXx5)? ((((fm_ColonPlaceHolder | Colon ) | fm_LParenfm_ColonPlaceHolderOrColonRParenOne) ((((logicalOrExpression) | fm_LParenlogicalOrExpressionRParenOne) ((((fm_CommaPlaceHolder | Comma ) | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne) ((logicalOrExpression) | fm_LParenlogicalOrExpressionRParenOne)) | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar)*) | fm_newRulexXXx5)?) | fm_newRulexXXx6)* ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    ;

labeledStatement
    :   ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_ColonPlaceHolder | Colon ) | fm_LParenfm_ColonPlaceHolderOrColonRParenOne) ((statement) | fm_LParenstatementRParenOne)
    |   ((fm_CasePlaceHolder | Case ) | fm_LParenfm_CasePlaceHolderOrCaseRParenOne) ((constantExpression) | fm_LParenconstantExpressionRParenOne) ((fm_ColonPlaceHolder | Colon ) | fm_LParenfm_ColonPlaceHolderOrColonRParenOne) ((statement) | fm_LParenstatementRParenOne)
    |   ((fm_DefaultPlaceHolder | Default ) | fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne) ((fm_ColonPlaceHolder | Colon ) | fm_LParenfm_ColonPlaceHolderOrColonRParenOne) ((statement) | fm_LParenstatementRParenOne)
    ;

compoundStatement
    :   ((fm_LeftBracePlaceHolder | LeftBrace ) | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne) ((blockItemList) | fm_LParenblockItemListRParenQuestion)? ((fm_RightBracePlaceHolder | RightBrace ) | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)
    ;

blockItemList
    :   ((blockItem) | fm_LParenblockItemRParenOne)
    |   blockItemList ((blockItem) | fm_LParenblockItemRParenOne)
    ;

blockItem
    :   ((declaration) | fm_LParendeclarationRParenOne)
    |   ((statement) | fm_LParenstatementRParenOne)
    ;

expressionStatement
    :   ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    ;

selectionStatement
    :   ((fm_IfPlaceHolder | If ) | fm_LParenfm_IfPlaceHolderOrIfRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((statement) | fm_LParenstatementRParenOne) ((((fm_ElsePlaceHolder | Else ) | fm_LParenfm_ElsePlaceHolderOrElseRParenOne) ((statement) | fm_LParenstatementRParenOne)) | fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion)?
    |   ((fm_SwitchPlaceHolder | Switch ) | fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((statement) | fm_LParenstatementRParenOne)
    ;

iterationStatement
    :   ((fm_WhilePlaceHolder | While ) | fm_LParenfm_WhilePlaceHolderOrWhileRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((statement) | fm_LParenstatementRParenOne)
    |   ((fm_DoPlaceHolder | Do ) | fm_LParenfm_DoPlaceHolderOrDoRParenOne) ((statement) | fm_LParenstatementRParenOne) ((fm_WhilePlaceHolder | While ) | fm_LParenfm_WhilePlaceHolderOrWhileRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((expression) | fm_LParenexpressionRParenOne) ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    |   ((fm_ForPlaceHolder | For ) | fm_LParenfm_ForPlaceHolderOrForRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((statement) | fm_LParenstatementRParenOne)
    |   ((fm_ForPlaceHolder | For ) | fm_LParenfm_ForPlaceHolderOrForRParenOne) ((fm_LeftParenPlaceHolder | LeftParen ) | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne) ((declaration) | fm_LParendeclarationRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_RightParenPlaceHolder | RightParen ) | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne) ((statement) | fm_LParenstatementRParenOne)
    ;

jumpStatement
    :   ((fm_GotoPlaceHolder | Goto ) | fm_LParenfm_GotoPlaceHolderOrGotoRParenOne) ((fm_IdentifierPlaceHolder | Identifier) | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne) ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    |   ((fm_ContinuePlaceHolder | Continue ) | fm_LParenfm_ContinuePlaceHolderOrContinueRParenOne) ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    |   ((fm_BreakPlaceHolder | Break ) | fm_LParenfm_BreakPlaceHolderOrBreakRParenOne) ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    |   ((fm_ReturnPlaceHolder | Return ) | fm_LParenfm_ReturnPlaceHolderOrReturnRParenOne) ((expression) | fm_LParenexpressionRParenQuestion)? ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)
    |   ((fm_GotoPlaceHolder | Goto ) | fm_LParenfm_GotoPlaceHolderOrGotoRParenOne) ((unaryExpression) | fm_LParenunaryExpressionRParenOne) ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne) // GCC extension
    ;

compilationUnit
    :   ((translationUnit) | fm_LParentranslationUnitRParenQuestion)? EOF
    ;

translationUnit
    :   ((externalDeclaration) | fm_LParenexternalDeclarationRParenOne)
    |   translationUnit ((externalDeclaration) | fm_LParenexternalDeclarationRParenOne)
    ;

externalDeclaration
    :   ((functionDefinition) | fm_LParenfunctionDefinitionRParenOne)
    |   ((declaration) | fm_LParendeclarationRParenOne)
    |   ((fm_SemiPlaceHolder | Semi ) | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne) // stray ;
    ;

functionDefinition
    :   ((declarationSpecifiers) | fm_LParendeclarationSpecifiersRParenQuestion)? ((declarator) | fm_LParendeclaratorRParenOne) ((declarationList) | fm_LParendeclarationListRParenQuestion)? ((compoundStatement) | fm_LParencompoundStatementRParenOne)
    ;

declarationList
    :   ((declaration) | fm_LParendeclarationRParenOne)
    |   declarationList ((declaration) | fm_LParendeclarationRParenOne)
    ;

Auto : 'auto';
fm_AutoPlaceHolder: FM_PlaceHolder; //language extension
Break : 'break';
fm_BreakPlaceHolder: FM_PlaceHolder; //language extension
Case : 'case';
fm_CasePlaceHolder: FM_PlaceHolder; //language extension
Char : 'char';
fm_CharPlaceHolder: FM_PlaceHolder; //language extension
Const : 'const';
fm_ConstPlaceHolder: FM_PlaceHolder; //language extension
Continue : 'continue';
fm_ContinuePlaceHolder: FM_PlaceHolder; //language extension
Default : 'default';
fm_DefaultPlaceHolder: FM_PlaceHolder; //language extension
Do : 'do';
fm_DoPlaceHolder: FM_PlaceHolder; //language extension
Double : 'double';
fm_DoublePlaceHolder: FM_PlaceHolder; //language extension
Else : 'else';
fm_ElsePlaceHolder: FM_PlaceHolder; //language extension
Enum : 'enum';
fm_EnumPlaceHolder: FM_PlaceHolder; //language extension
Extern : 'extern';
fm_ExternPlaceHolder: FM_PlaceHolder; //language extension
Float : 'float';
fm_FloatPlaceHolder: FM_PlaceHolder; //language extension
For : 'for';
fm_ForPlaceHolder: FM_PlaceHolder; //language extension
Goto : 'goto';
fm_GotoPlaceHolder: FM_PlaceHolder; //language extension
If : 'if';
fm_IfPlaceHolder: FM_PlaceHolder; //language extension
Inline : 'inline';
fm_InlinePlaceHolder: FM_PlaceHolder; //language extension
Int : 'int';
fm_IntPlaceHolder: FM_PlaceHolder; //language extension
Long : 'long';
fm_LongPlaceHolder: FM_PlaceHolder; //language extension
Register : 'register';
fm_RegisterPlaceHolder: FM_PlaceHolder; //language extension
Restrict : 'restrict';
fm_RestrictPlaceHolder: FM_PlaceHolder; //language extension
Return : 'return';
fm_ReturnPlaceHolder: FM_PlaceHolder; //language extension
Short : 'short';
fm_ShortPlaceHolder: FM_PlaceHolder; //language extension
Signed : 'signed';
fm_SignedPlaceHolder: FM_PlaceHolder; //language extension
Sizeof : 'sizeof';
fm_SizeofPlaceHolder: FM_PlaceHolder; //language extension
Static : 'static';
fm_StaticPlaceHolder: FM_PlaceHolder; //language extension
Struct : 'struct';
fm_StructPlaceHolder: FM_PlaceHolder; //language extension
Switch : 'switch';
fm_SwitchPlaceHolder: FM_PlaceHolder; //language extension
Typedef : 'typedef';
fm_TypedefPlaceHolder: FM_PlaceHolder; //language extension
Union : 'union';
fm_UnionPlaceHolder: FM_PlaceHolder; //language extension
Unsigned : 'unsigned';
fm_UnsignedPlaceHolder: FM_PlaceHolder; //language extension
Void : 'void';
fm_VoidPlaceHolder: FM_PlaceHolder; //language extension
Volatile : 'volatile';
fm_VolatilePlaceHolder: FM_PlaceHolder; //language extension
While : 'while';
fm_WhilePlaceHolder: FM_PlaceHolder; //language extension

Alignas : '_Alignas';
fm_AlignasPlaceHolder: FM_PlaceHolder; //language extension
Alignof : '_Alignof';
fm_AlignofPlaceHolder: FM_PlaceHolder; //language extension
Atomic : '_Atomic';
fm_AtomicPlaceHolder: FM_PlaceHolder; //language extension
Bool : '_Bool';
fm_BoolPlaceHolder: FM_PlaceHolder; //language extension
Complex : '_Complex';
fm_ComplexPlaceHolder: FM_PlaceHolder; //language extension
Generic : '_Generic';
fm_GenericPlaceHolder: FM_PlaceHolder; //language extension
Imaginary : '_Imaginary';
fm_ImaginaryPlaceHolder: FM_PlaceHolder; //language extension
Noreturn : '_Noreturn';
fm_NoreturnPlaceHolder: FM_PlaceHolder; //language extension
StaticAssert : '_Static_assert';
fm_StaticAssertPlaceHolder: FM_PlaceHolder; //language extension
ThreadLocal : '_Thread_local';
fm_ThreadLocalPlaceHolder: FM_PlaceHolder; //language extension

LeftParen : '(';
fm_LeftParenPlaceHolder: FM_PlaceHolder; //language extension
RightParen : ')';
fm_RightParenPlaceHolder: FM_PlaceHolder; //language extension
LeftBracket : '[';
fm_LeftBracketPlaceHolder: FM_PlaceHolder; //language extension
RightBracket : ']';
fm_RightBracketPlaceHolder: FM_PlaceHolder; //language extension
LeftBrace : '{';
fm_LeftBracePlaceHolder: FM_PlaceHolder; //language extension
RightBrace : '}';
fm_RightBracePlaceHolder: FM_PlaceHolder; //language extension

Less : '<';
fm_LessPlaceHolder: FM_PlaceHolder; //language extension
LessEqual : '<=';
fm_LessEqualPlaceHolder: FM_PlaceHolder; //language extension
Greater : '>';
fm_GreaterPlaceHolder: FM_PlaceHolder; //language extension
GreaterEqual : '>=';
fm_GreaterEqualPlaceHolder: FM_PlaceHolder; //language extension
LeftShift : '<<';
fm_LeftShiftPlaceHolder: FM_PlaceHolder; //language extension
RightShift : '>>';
fm_RightShiftPlaceHolder: FM_PlaceHolder; //language extension

Plus : '+';
fm_PlusPlaceHolder: FM_PlaceHolder; //language extension
PlusPlus : '++';
fm_PlusPlusPlaceHolder: FM_PlaceHolder; //language extension
Minus : '-';
fm_MinusPlaceHolder: FM_PlaceHolder; //language extension
MinusMinus : '--';
fm_MinusMinusPlaceHolder: FM_PlaceHolder; //language extension
Star : '*';
fm_StarPlaceHolder: FM_PlaceHolder; //language extension
Div : '/';
fm_DivPlaceHolder: FM_PlaceHolder; //language extension
Mod : '%';
fm_ModPlaceHolder: FM_PlaceHolder; //language extension

And : '&';
fm_AndPlaceHolder: FM_PlaceHolder; //language extension
Or : '|';
fm_OrPlaceHolder: FM_PlaceHolder; //language extension
AndAnd : '&&';
fm_AndAndPlaceHolder: FM_PlaceHolder; //language extension
OrOr : '||';
fm_OrOrPlaceHolder: FM_PlaceHolder; //language extension
Caret : '^';
fm_CaretPlaceHolder: FM_PlaceHolder; //language extension
Not : '!';
fm_NotPlaceHolder: FM_PlaceHolder; //language extension
Tilde : '~';
fm_TildePlaceHolder: FM_PlaceHolder; //language extension

Question : '?';
fm_QuestionPlaceHolder: FM_PlaceHolder; //language extension
Colon : ':';
fm_ColonPlaceHolder: FM_PlaceHolder; //language extension
Semi : ';';
fm_SemiPlaceHolder: FM_PlaceHolder; //language extension
Comma : ',';
fm_CommaPlaceHolder: FM_PlaceHolder; //language extension

Assign : '=';
fm_AssignPlaceHolder: FM_PlaceHolder; //language extension
// '*=' | '/=' | '%=' | '+=' | '-=' | '<<=' | '>>=' | '&=' | '^=' | '|='
StarAssign : '*=';
fm_StarAssignPlaceHolder: FM_PlaceHolder; //language extension
DivAssign : '/=';
fm_DivAssignPlaceHolder: FM_PlaceHolder; //language extension
ModAssign : '%=';
fm_ModAssignPlaceHolder: FM_PlaceHolder; //language extension
PlusAssign : '+=';
fm_PlusAssignPlaceHolder: FM_PlaceHolder; //language extension
MinusAssign : '-=';
fm_MinusAssignPlaceHolder: FM_PlaceHolder; //language extension
LeftShiftAssign : '<<=';
fm_LeftShiftAssignPlaceHolder: FM_PlaceHolder; //language extension
RightShiftAssign : '>>=';
fm_RightShiftAssignPlaceHolder: FM_PlaceHolder; //language extension
AndAssign : '&=';
fm_AndAssignPlaceHolder: FM_PlaceHolder; //language extension
XorAssign : '^=';
fm_XorAssignPlaceHolder: FM_PlaceHolder; //language extension
OrAssign : '|=';
fm_OrAssignPlaceHolder: FM_PlaceHolder; //language extension

Equal : '==';
fm_EqualPlaceHolder: FM_PlaceHolder; //language extension
NotEqual : '!=';
fm_NotEqualPlaceHolder: FM_PlaceHolder; //language extension

Arrow : '->';
fm_ArrowPlaceHolder: FM_PlaceHolder; //language extension
Dot : '.';
fm_DotPlaceHolder: FM_PlaceHolder; //language extension
Ellipsis : '...';
fm_EllipsisPlaceHolder: FM_PlaceHolder; //language extension

Identifier
    :   IdentifierNondigit
        (   IdentifierNondigit
        |   Digit
        )*
    ;
fm_IdentifierPlaceHolder: FM_PlaceHolder; //language extension

fragment
IdentifierNondigit
    :   Nondigit
    |   UniversalCharacterName
    //|   // other implementation-defined characters...
    ;

fragment
Nondigit
    :   [a-zA-Z_]
    ;

fragment
Digit
    :   [0-9]
    ;

fragment
UniversalCharacterName
    :   '\\u' HexQuad
    |   '\\U' HexQuad HexQuad
    ;

fragment
HexQuad
    :   HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit
    ;

Constant
    :   IntegerConstant
    |   FloatingConstant
    //|   EnumerationConstant
    |   CharacterConstant
    ;
fm_ConstantPlaceHolder: FM_PlaceHolder; //language extension

fragment
IntegerConstant
    :   DecimalConstant IntegerSuffix?
    |   OctalConstant IntegerSuffix?
    |   HexadecimalConstant IntegerSuffix?
    |	BinaryConstant
    ;

fragment
BinaryConstant
	:	'0' [bB] [0-1]+
	;

fragment
DecimalConstant
    :   NonzeroDigit Digit*
    ;

fragment
OctalConstant
    :   '0' OctalDigit*
    ;

fragment
HexadecimalConstant
    :   HexadecimalPrefix HexadecimalDigit+
    ;

fragment
HexadecimalPrefix
    :   '0' [xX]
    ;

fragment
NonzeroDigit
    :   [1-9]
    ;

fragment
OctalDigit
    :   [0-7]
    ;

fragment
HexadecimalDigit
    :   [0-9a-fA-F]
    ;

fragment
IntegerSuffix
    :   UnsignedSuffix LongSuffix?
    |   UnsignedSuffix LongLongSuffix
    |   LongSuffix UnsignedSuffix?
    |   LongLongSuffix UnsignedSuffix?
    ;

fragment
UnsignedSuffix
    :   [uU]
    ;

fragment
LongSuffix
    :   [lL]
    ;

fragment
LongLongSuffix
    :   'll' | 'LL'
    ;

fragment
FloatingConstant
    :   DecimalFloatingConstant
    |   HexadecimalFloatingConstant
    ;

fragment
DecimalFloatingConstant
    :   FractionalConstant ExponentPart? FloatingSuffix?
    |   DigitSequence ExponentPart FloatingSuffix?
    ;

fragment
HexadecimalFloatingConstant
    :   HexadecimalPrefix HexadecimalFractionalConstant BinaryExponentPart FloatingSuffix?
    |   HexadecimalPrefix HexadecimalDigitSequence BinaryExponentPart FloatingSuffix?
    ;

fragment
FractionalConstant
    :   DigitSequence? '.' DigitSequence
    |   DigitSequence '.'
    ;

fragment
ExponentPart
    :   'e' Sign? DigitSequence
    |   'E' Sign? DigitSequence
    ;

fragment
Sign
    :   '+' | '-'
    ;

fragment
DigitSequence
    :   Digit+
    ;

fragment
HexadecimalFractionalConstant
    :   HexadecimalDigitSequence? '.' HexadecimalDigitSequence
    |   HexadecimalDigitSequence '.'
    ;

fragment
BinaryExponentPart
    :   'p' Sign? DigitSequence
    |   'P' Sign? DigitSequence
    ;

fragment
HexadecimalDigitSequence
    :   HexadecimalDigit+
    ;

fragment
FloatingSuffix
    :   'f' | 'l' | 'F' | 'L'
    ;

fragment
CharacterConstant
    :   '\'' CCharSequence '\''
    |   'L\'' CCharSequence '\''
    |   'u\'' CCharSequence '\''
    |   'U\'' CCharSequence '\''
    ;

fragment
CCharSequence
    :   CChar+
    ;

fragment
CChar
    :   ~['\\\r\n]
    |   EscapeSequence
    ;
fragment
EscapeSequence
    :   SimpleEscapeSequence
    |   OctalEscapeSequence
    |   HexadecimalEscapeSequence
    |   UniversalCharacterName
    ;
fragment
SimpleEscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;
fragment
OctalEscapeSequence
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' OctalDigit OctalDigit OctalDigit
    ;
fragment
HexadecimalEscapeSequence
    :   '\\x' HexadecimalDigit+
    ;
StringLiteral
    :   EncodingPrefix? '"' SCharSequence? '"'
    ;
fm_StringLiteralPlaceHolder: FM_PlaceHolder; //language extension
fragment
EncodingPrefix
    :   'u8'
    |   'u'
    |   'U'
    |   'L'
    ;
fragment
SCharSequence
    :   SChar+
    ;
fragment
SChar
    :   ~["\\\r\n]
    |   EscapeSequence
    |   '\\\n'   // Added line
    |   '\\\r\n' // Added line
    ;

ComplexDefine
    :   '#' Whitespace? 'define'  ~[#]*
        -> skip
    ;
fm_ComplexDefinePlaceHolder: FM_PlaceHolder; //language extension

// ignore the following asm blocks:
/*
    asm
    {
        mfspr x, 286;
    }
 */
AsmBlock
    :   'asm' ~['{']* '{' ~['}']* '}'
	-> skip
    ;
fm_AsmBlockPlaceHolder: FM_PlaceHolder; //language extension

// ignore the lines generated by c preprocessor
// sample line : '#line 1 "/home/dm/files/dk1.h" 1'
LineAfterPreprocessing
    :   '#line' Whitespace* ~[\r\n]*
        -> skip
    ;
fm_LineAfterPreprocessingPlaceHolder: FM_PlaceHolder; //language extension

LineDirective
    :   '#' Whitespace? DecimalConstant Whitespace? StringLiteral ~[\r\n]*
        -> skip
    ;
fm_LineDirectivePlaceHolder: FM_PlaceHolder; //language extension

PragmaDirective
    :   '#' Whitespace? 'pragma' Whitespace ~[\r\n]*
        -> skip
    ;
fm_PragmaDirectivePlaceHolder: FM_PlaceHolder; //language extension

Whitespace
    :   [ \t]+
        -> skip
    ;
fm_WhitespacePlaceHolder: FM_PlaceHolder; //language extension

Newline
    :   (   '\r' '\n'?
        |   '\n'
        )
        -> skip
    ;
fm_NewlinePlaceHolder: FM_PlaceHolder; //language extension

BlockComment
    :   '/*' .*? '*/'
        -> skip
    ;
fm_BlockCommentPlaceHolder: FM_PlaceHolder; //language extension

LineComment
    :   '//' ~[\r\n]*
        -> skip
;
fm_LineCommentPlaceHolder: FM_PlaceHolder; //language extension
FM_ImplicitToken22:'__volatile__';
FM_ImplicitToken21:'__asm__';
FM_ImplicitToken20:'__asm';
FM_ImplicitToken19:'__attribute__';
FM_ImplicitToken18:'__asm';
FM_ImplicitToken17:'__declspec';
FM_ImplicitToken16:'__stdcall';
FM_ImplicitToken15:'__inline__';
FM_ImplicitToken14:'__typeof__';
FM_ImplicitToken13:'__m128i';
FM_ImplicitToken12:'__m128d';
FM_ImplicitToken11:'__m128';
FM_ImplicitToken10:'__extension__';
FM_ImplicitToken9:'__m128i';
FM_ImplicitToken8:'__m128d';
FM_ImplicitToken7:'__m128';
FM_ImplicitToken6:'__extension__';
FM_ImplicitToken5:'__extension__';
FM_ImplicitToken4:'__extension__';
FM_ImplicitToken3:'__builtin_offsetof';
FM_ImplicitToken2:'__builtin_va_arg';
FM_ImplicitToken1:'__extension__';
FM_PlaceHolder: '${' .*? '}'  ;
fm_LParendeclarationSpecifierRParenIfLoop: '<#if' .*?'>'(( declarationSpecifier      ) * | fm_LParendeclarationSpecifierRParenIfLoop*)('<#elseif' .*?'>'(( declarationSpecifier      ) * | fm_LParendeclarationSpecifierRParenIfLoop*))*'</#if>'| '<#list' .*? 'as' .*? '>'(( declarationSpecifier      ) * | fm_LParendeclarationSpecifierRParenIfLoop*)'</#list>';
fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop: '<#if' .*?'>'(( fm_StringLiteralPlaceHolder     | StringLiteral      ) * | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop*)('<#elseif' .*?'>'(( fm_StringLiteralPlaceHolder     | StringLiteral      ) * | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop*))*'</#if>'| '<#list' .*? 'as' .*? '>'(( fm_StringLiteralPlaceHolder     | StringLiteral      ) * | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop*)'</#list>';
fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar: '<#if' .*?'>'(( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      ) * | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      ) * | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar*))*('<#else>'(( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      ) * | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      ) * | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar*)'</#list>';
fm_LParendeclarationSpecifierRParenStar: '<#if' .*?'>'(( declarationSpecifier      ) * | fm_LParendeclarationSpecifierRParenStar*)('<#elseif' .*?'>'(( declarationSpecifier      ) * | fm_LParendeclarationSpecifierRParenStar*))*('<#else>'(( declarationSpecifier      ) * | fm_LParendeclarationSpecifierRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( declarationSpecifier      ) * | fm_LParendeclarationSpecifierRParenStar*)'</#list>';
fm_newRulexXXx4: '<#if' .*?'>'(( ~ ( '('  | ')'  )      | ( fm_LeftParenPlaceHolder     | LeftParen      )    nestedParenthesesBlock    ( fm_RightParenPlaceHolder     | RightParen      )      ) * | fm_newRulexXXx4*)('<#elseif' .*?'>'(( ~ ( '('  | ')'  )      | ( fm_LeftParenPlaceHolder     | LeftParen      )    nestedParenthesesBlock    ( fm_RightParenPlaceHolder     | RightParen      )      ) * | fm_newRulexXXx4*))*('<#else>'(( ~ ( '('  | ')'  )      | ( fm_LeftParenPlaceHolder     | LeftParen      )    nestedParenthesesBlock    ( fm_RightParenPlaceHolder     | RightParen      )      ) * | fm_newRulexXXx4*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ~ ( '('  | ')'  )      | ( fm_LeftParenPlaceHolder     | LeftParen      )    nestedParenthesesBlock    ( fm_RightParenPlaceHolder     | RightParen      )      ) * | fm_newRulexXXx4*)'</#list>';
fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar: '<#if' .*?'>'(( fm_StringLiteralPlaceHolder     | StringLiteral      ) * | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar*)('<#elseif' .*?'>'(( fm_StringLiteralPlaceHolder     | StringLiteral      ) * | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar*))*('<#else>'(( fm_StringLiteralPlaceHolder     | StringLiteral      ) * | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( fm_StringLiteralPlaceHolder     | StringLiteral      ) * | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar*)'</#list>';
fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar: '<#if' .*?'>'(( ( fm_CommaPlaceHolder     | Comma      )    ( gccAttribute      )      ) * | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar*)('<#elseif' .*?'>'(( ( fm_CommaPlaceHolder     | Comma      )    ( gccAttribute      )      ) * | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar*))*('<#else>'(( ( fm_CommaPlaceHolder     | Comma      )    ( gccAttribute      )      ) * | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_CommaPlaceHolder     | Comma      )    ( gccAttribute      )      ) * | fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar*)'</#list>';
fm_LParengccDeclaratorExtensionRParenStar: '<#if' .*?'>'(( gccDeclaratorExtension      ) * | fm_LParengccDeclaratorExtensionRParenStar*)('<#elseif' .*?'>'(( gccDeclaratorExtension      ) * | fm_LParengccDeclaratorExtensionRParenStar*))*('<#else>'(( gccDeclaratorExtension      ) * | fm_LParengccDeclaratorExtensionRParenStar*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( gccDeclaratorExtension      ) * | fm_LParengccDeclaratorExtensionRParenStar*)'</#list>';
fm_newRulexXXx6: '<#if' .*?'>'(( ( fm_ColonPlaceHolder     | Colon      )    ( ( logicalOrExpression      )    ( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      )  *       )  ?       ) * | fm_newRulexXXx6*)('<#elseif' .*?'>'(( ( fm_ColonPlaceHolder     | Colon      )    ( ( logicalOrExpression      )    ( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      )  *       )  ?       ) * | fm_newRulexXXx6*))*('<#else>'(( ( fm_ColonPlaceHolder     | Colon      )    ( ( logicalOrExpression      )    ( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      )  *       )  ?       ) * | fm_newRulexXXx6*))?'</#if>'| '<#list' .*? 'as' .*? '>'(( ( fm_ColonPlaceHolder     | Colon      )    ( ( logicalOrExpression      )    ( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      )  *       )  ?       ) * | fm_newRulexXXx6*)'</#list>';
fm_LParenexpressionRParenQuestion: '<#if' .*?'>'(( expression      ) ? | fm_LParenexpressionRParenQuestion?)('<#elseif' .*?'>'(( expression      ) ? | fm_LParenexpressionRParenQuestion?))*('<#else>'(( expression      ) ? | fm_LParenexpressionRParenQuestion?))?'</#if>';
fm_newRulexXXx3: '<#if' .*?'>'(( ( fm_LeftParenPlaceHolder     | LeftParen      )    ( argumentExpressionList      )  ?     ( fm_RightParenPlaceHolder     | RightParen      )      ) ? | fm_newRulexXXx3?)('<#elseif' .*?'>'(( ( fm_LeftParenPlaceHolder     | LeftParen      )    ( argumentExpressionList      )  ?     ( fm_RightParenPlaceHolder     | RightParen      )      ) ? | fm_newRulexXXx3?))*('<#else>'(( ( fm_LeftParenPlaceHolder     | LeftParen      )    ( argumentExpressionList      )  ?     ( fm_RightParenPlaceHolder     | RightParen      )      ) ? | fm_newRulexXXx3?))?'</#if>';
fm_LParendesignationRParenQuestion: '<#if' .*?'>'(( designation      ) ? | fm_LParendesignationRParenQuestion?)('<#elseif' .*?'>'(( designation      ) ? | fm_LParendesignationRParenQuestion?))*('<#else>'(( designation      ) ? | fm_LParendesignationRParenQuestion?))?'</#if>';
fm_LParendeclarationListRParenQuestion: '<#if' .*?'>'(( declarationList      ) ? | fm_LParendeclarationListRParenQuestion?)('<#elseif' .*?'>'(( declarationList      ) ? | fm_LParendeclarationListRParenQuestion?))*('<#else>'(( declarationList      ) ? | fm_LParendeclarationListRParenQuestion?))?'</#if>';
fm_LParentranslationUnitRParenQuestion: '<#if' .*?'>'(( translationUnit      ) ? | fm_LParentranslationUnitRParenQuestion?)('<#elseif' .*?'>'(( translationUnit      ) ? | fm_LParentranslationUnitRParenQuestion?))*('<#else>'(( translationUnit      ) ? | fm_LParentranslationUnitRParenQuestion?))?'</#if>';
fm_LParenblockItemListRParenQuestion: '<#if' .*?'>'(( blockItemList      ) ? | fm_LParenblockItemListRParenQuestion?)('<#elseif' .*?'>'(( blockItemList      ) ? | fm_LParenblockItemListRParenQuestion?))*('<#else>'(( blockItemList      ) ? | fm_LParenblockItemListRParenQuestion?))?'</#if>';
fm_LParenabstractDeclaratorRParenQuestion: '<#if' .*?'>'(( abstractDeclarator      ) ? | fm_LParenabstractDeclaratorRParenQuestion?)('<#elseif' .*?'>'(( abstractDeclarator      ) ? | fm_LParenabstractDeclaratorRParenQuestion?))*('<#else>'(( abstractDeclarator      ) ? | fm_LParenabstractDeclaratorRParenQuestion?))?'</#if>';
fm_LParenassignmentExpressionRParenQuestion: '<#if' .*?'>'(( assignmentExpression      ) ? | fm_LParenassignmentExpressionRParenQuestion?)('<#elseif' .*?'>'(( assignmentExpression      ) ? | fm_LParenassignmentExpressionRParenQuestion?))*('<#else>'(( assignmentExpression      ) ? | fm_LParenassignmentExpressionRParenQuestion?))?'</#if>';
fm_LParenstructDeclaratorListRParenQuestion: '<#if' .*?'>'(( structDeclaratorList      ) ? | fm_LParenstructDeclaratorListRParenQuestion?)('<#elseif' .*?'>'(( structDeclaratorList      ) ? | fm_LParenstructDeclaratorListRParenQuestion?))*('<#else>'(( structDeclaratorList      ) ? | fm_LParenstructDeclaratorListRParenQuestion?))?'</#if>';
fm_LParendeclarationSpecifiersRParenQuestion: '<#if' .*?'>'(( declarationSpecifiers      ) ? | fm_LParendeclarationSpecifiersRParenQuestion?)('<#elseif' .*?'>'(( declarationSpecifiers      ) ? | fm_LParendeclarationSpecifiersRParenQuestion?))*('<#else>'(( declarationSpecifiers      ) ? | fm_LParendeclarationSpecifiersRParenQuestion?))?'</#if>';
fm_LParendeclaratorRParenQuestion: '<#if' .*?'>'(( declarator      ) ? | fm_LParendeclaratorRParenQuestion?)('<#elseif' .*?'>'(( declarator      ) ? | fm_LParendeclaratorRParenQuestion?))*('<#else>'(( declarator      ) ? | fm_LParendeclaratorRParenQuestion?))?'</#if>';
fm_newRulexXXx0: '<#if' .*?'>'(( ( fm_QuestionPlaceHolder     | Question      )    ( expression      )    ( fm_ColonPlaceHolder     | Colon      )    conditionalExpression      ) ? | fm_newRulexXXx0?)('<#elseif' .*?'>'(( ( fm_QuestionPlaceHolder     | Question      )    ( expression      )    ( fm_ColonPlaceHolder     | Colon      )    conditionalExpression      ) ? | fm_newRulexXXx0?))*('<#else>'(( ( fm_QuestionPlaceHolder     | Question      )    ( expression      )    ( fm_ColonPlaceHolder     | Colon      )    conditionalExpression      ) ? | fm_newRulexXXx0?))?'</#if>';
fm_LParenargumentExpressionListRParenQuestion: '<#if' .*?'>'(( argumentExpressionList      ) ? | fm_LParenargumentExpressionListRParenQuestion?)('<#elseif' .*?'>'(( argumentExpressionList      ) ? | fm_LParenargumentExpressionListRParenQuestion?))*('<#else>'(( argumentExpressionList      ) ? | fm_LParenargumentExpressionListRParenQuestion?))?'</#if>';
fm_LParenpointerRParenQuestion: '<#if' .*?'>'(( pointer      ) ? | fm_LParenpointerRParenQuestion?)('<#elseif' .*?'>'(( pointer      ) ? | fm_LParenpointerRParenQuestion?))*('<#else>'(( pointer      ) ? | fm_LParenpointerRParenQuestion?))?'</#if>';
fm_LParenidentifierListRParenQuestion: '<#if' .*?'>'(( identifierList      ) ? | fm_LParenidentifierListRParenQuestion?)('<#elseif' .*?'>'(( identifierList      ) ? | fm_LParenidentifierListRParenQuestion?))*('<#else>'(( identifierList      ) ? | fm_LParenidentifierListRParenQuestion?))?'</#if>';
fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion: '<#if' .*?'>'(( ( fm_ElsePlaceHolder     | Else      )    ( statement      )      ) ? | fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion?)('<#elseif' .*?'>'(( ( fm_ElsePlaceHolder     | Else      )    ( statement      )      ) ? | fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion?))*('<#else>'(( ( fm_ElsePlaceHolder     | Else      )    ( statement      )      ) ? | fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion?))?'</#if>';
fm_newRulexXXx5: '<#if' .*?'>'(( ( logicalOrExpression      )    ( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      )  *       ) ? | fm_newRulexXXx5?)('<#elseif' .*?'>'(( ( logicalOrExpression      )    ( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      )  *       ) ? | fm_newRulexXXx5?))*('<#else>'(( ( logicalOrExpression      )    ( ( fm_CommaPlaceHolder     | Comma      )    ( logicalOrExpression      )      )  *       ) ? | fm_newRulexXXx5?))?'</#if>';
fm_LPareninitDeclaratorListRParenQuestion: '<#if' .*?'>'(( initDeclaratorList      ) ? | fm_LPareninitDeclaratorListRParenQuestion?)('<#elseif' .*?'>'(( initDeclaratorList      ) ? | fm_LPareninitDeclaratorListRParenQuestion?))*('<#else>'(( initDeclaratorList      ) ? | fm_LPareninitDeclaratorListRParenQuestion?))?'</#if>';
fm_LParentypeQualifierListRParenQuestion: '<#if' .*?'>'(( typeQualifierList      ) ? | fm_LParentypeQualifierListRParenQuestion?)('<#elseif' .*?'>'(( typeQualifierList      ) ? | fm_LParentypeQualifierListRParenQuestion?))*('<#else>'(( typeQualifierList      ) ? | fm_LParentypeQualifierListRParenQuestion?))?'</#if>';
fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion: '<#if' .*?'>'(( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?)('<#elseif' .*?'>'(( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?))*('<#else>'(( fm_IdentifierPlaceHolder     | Identifier      ) ? | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion?))?'</#if>';
fm_LParenparameterTypeListRParenQuestion: '<#if' .*?'>'(( parameterTypeList      ) ? | fm_LParenparameterTypeListRParenQuestion?)('<#elseif' .*?'>'(( parameterTypeList      ) ? | fm_LParenparameterTypeListRParenQuestion?))*('<#else>'(( parameterTypeList      ) ? | fm_LParenparameterTypeListRParenQuestion?))?'</#if>';
fm_LParenfm_ElsePlaceHolderOrElseRParenOne: '<#if' .*?'>'(( fm_ElsePlaceHolder     | Else      )  | fm_LParenfm_ElsePlaceHolderOrElseRParenOne)('<#elseif' .*?'>'(( fm_ElsePlaceHolder     | Else      )  | fm_LParenfm_ElsePlaceHolderOrElseRParenOne))*'<#else>'(( fm_ElsePlaceHolder     | Else      )  | fm_LParenfm_ElsePlaceHolderOrElseRParenOne)'</#if>';
fm_LParenfm_GenericPlaceHolderOrGenericRParenOne: '<#if' .*?'>'(( fm_GenericPlaceHolder     | Generic      )  | fm_LParenfm_GenericPlaceHolderOrGenericRParenOne)('<#elseif' .*?'>'(( fm_GenericPlaceHolder     | Generic      )  | fm_LParenfm_GenericPlaceHolderOrGenericRParenOne))*'<#else>'(( fm_GenericPlaceHolder     | Generic      )  | fm_LParenfm_GenericPlaceHolderOrGenericRParenOne)'</#if>';
fm_LParenfm_FloatPlaceHolderOrFloatRParenOne: '<#if' .*?'>'(( fm_FloatPlaceHolder     | Float      )  | fm_LParenfm_FloatPlaceHolderOrFloatRParenOne)('<#elseif' .*?'>'(( fm_FloatPlaceHolder     | Float      )  | fm_LParenfm_FloatPlaceHolderOrFloatRParenOne))*'<#else>'(( fm_FloatPlaceHolder     | Float      )  | fm_LParenfm_FloatPlaceHolderOrFloatRParenOne)'</#if>';
fm_LParenfm_TildePlaceHolderOrTildeRParenOne: '<#if' .*?'>'(( fm_TildePlaceHolder     | Tilde      )  | fm_LParenfm_TildePlaceHolderOrTildeRParenOne)('<#elseif' .*?'>'(( fm_TildePlaceHolder     | Tilde      )  | fm_LParenfm_TildePlaceHolderOrTildeRParenOne))*'<#else>'(( fm_TildePlaceHolder     | Tilde      )  | fm_LParenfm_TildePlaceHolderOrTildeRParenOne)'</#if>';
fm_LParenfm_ColonPlaceHolderOrColonRParenOne: '<#if' .*?'>'(( fm_ColonPlaceHolder     | Colon      )  | fm_LParenfm_ColonPlaceHolderOrColonRParenOne)('<#elseif' .*?'>'(( fm_ColonPlaceHolder     | Colon      )  | fm_LParenfm_ColonPlaceHolderOrColonRParenOne))*'<#else>'(( fm_ColonPlaceHolder     | Colon      )  | fm_LParenfm_ColonPlaceHolderOrColonRParenOne)'</#if>';
fm_LParenfm_AutoPlaceHolderOrAutoRParenOne: '<#if' .*?'>'(( fm_AutoPlaceHolder     | Auto      )  | fm_LParenfm_AutoPlaceHolderOrAutoRParenOne)('<#elseif' .*?'>'(( fm_AutoPlaceHolder     | Auto      )  | fm_LParenfm_AutoPlaceHolderOrAutoRParenOne))*'<#else>'(( fm_AutoPlaceHolder     | Auto      )  | fm_LParenfm_AutoPlaceHolderOrAutoRParenOne)'</#if>';
fm_LParenlogicalOrExpressionRParenOne: '<#if' .*?'>'(( logicalOrExpression      )  | fm_LParenlogicalOrExpressionRParenOne)('<#elseif' .*?'>'(( logicalOrExpression      )  | fm_LParenlogicalOrExpressionRParenOne))*'<#else>'(( logicalOrExpression      )  | fm_LParenlogicalOrExpressionRParenOne)'</#if>';
fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne: '<#if' .*?'>'(( fm_RightParenPlaceHolder     | RightParen      )  | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)('<#elseif' .*?'>'(( fm_RightParenPlaceHolder     | RightParen      )  | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne))*'<#else>'(( fm_RightParenPlaceHolder     | RightParen      )  | fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne)'</#if>';
fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne: '<#if' .*?'>'(( fm_EllipsisPlaceHolder     | Ellipsis      )  | fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne)('<#elseif' .*?'>'(( fm_EllipsisPlaceHolder     | Ellipsis      )  | fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne))*'<#else>'(( fm_EllipsisPlaceHolder     | Ellipsis      )  | fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne)'</#if>';
fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne: '<#if' .*?'>'(( fm_RightBracketPlaceHolder     | RightBracket      )  | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)('<#elseif' .*?'>'(( fm_RightBracketPlaceHolder     | RightBracket      )  | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne))*'<#else>'(( fm_RightBracketPlaceHolder     | RightBracket      )  | fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne)'</#if>';
fm_LParenfm_DoPlaceHolderOrDoRParenOne: '<#if' .*?'>'(( fm_DoPlaceHolder     | Do      )  | fm_LParenfm_DoPlaceHolderOrDoRParenOne)('<#elseif' .*?'>'(( fm_DoPlaceHolder     | Do      )  | fm_LParenfm_DoPlaceHolderOrDoRParenOne))*'<#else>'(( fm_DoPlaceHolder     | Do      )  | fm_LParenfm_DoPlaceHolderOrDoRParenOne)'</#if>';
fm_LParenfm_OrPlaceHolderOrOrRParenOne: '<#if' .*?'>'(( fm_OrPlaceHolder     | Or      )  | fm_LParenfm_OrPlaceHolderOrOrRParenOne)('<#elseif' .*?'>'(( fm_OrPlaceHolder     | Or      )  | fm_LParenfm_OrPlaceHolderOrOrRParenOne))*'<#else>'(( fm_OrPlaceHolder     | Or      )  | fm_LParenfm_OrPlaceHolderOrOrRParenOne)'</#if>';
fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne: '<#if' .*?'>'(( fm_PlusPlusPlaceHolder     | PlusPlus      )  | fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne)('<#elseif' .*?'>'(( fm_PlusPlusPlaceHolder     | PlusPlus      )  | fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne))*'<#else>'(( fm_PlusPlusPlaceHolder     | PlusPlus      )  | fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne)'</#if>';
fm_LParenexternalDeclarationRParenOne: '<#if' .*?'>'(( externalDeclaration      )  | fm_LParenexternalDeclarationRParenOne)('<#elseif' .*?'>'(( externalDeclaration      )  | fm_LParenexternalDeclarationRParenOne))*'<#else>'(( externalDeclaration      )  | fm_LParenexternalDeclarationRParenOne)'</#if>';
fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne: '<#if' .*?'>'(( fm_RightShiftAssignPlaceHolder     | RightShiftAssign      )  | fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne)('<#elseif' .*?'>'(( fm_RightShiftAssignPlaceHolder     | RightShiftAssign      )  | fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne))*'<#else>'(( fm_RightShiftAssignPlaceHolder     | RightShiftAssign      )  | fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne)'</#if>';
fm_LParenstructDeclarationRParenOne: '<#if' .*?'>'(( structDeclaration      )  | fm_LParenstructDeclarationRParenOne)('<#elseif' .*?'>'(( structDeclaration      )  | fm_LParenstructDeclarationRParenOne))*'<#else>'(( structDeclaration      )  | fm_LParenstructDeclarationRParenOne)'</#if>';
fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne: '<#if' .*?'>'(( fm_MinusAssignPlaceHolder     | MinusAssign      )  | fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne)('<#elseif' .*?'>'(( fm_MinusAssignPlaceHolder     | MinusAssign      )  | fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne))*'<#else>'(( fm_MinusAssignPlaceHolder     | MinusAssign      )  | fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne)'</#if>';
fm_LParenlabeledStatementRParenOne: '<#if' .*?'>'(( labeledStatement      )  | fm_LParenlabeledStatementRParenOne)('<#elseif' .*?'>'(( labeledStatement      )  | fm_LParenlabeledStatementRParenOne))*'<#else>'(( labeledStatement      )  | fm_LParenlabeledStatementRParenOne)'</#if>';
fm_LParenfm_ShortPlaceHolderOrShortRParenOne: '<#if' .*?'>'(( fm_ShortPlaceHolder     | Short      )  | fm_LParenfm_ShortPlaceHolderOrShortRParenOne)('<#elseif' .*?'>'(( fm_ShortPlaceHolder     | Short      )  | fm_LParenfm_ShortPlaceHolderOrShortRParenOne))*'<#else>'(( fm_ShortPlaceHolder     | Short      )  | fm_LParenfm_ShortPlaceHolderOrShortRParenOne)'</#if>';
fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne: '<#if' .*?'>'(( fm_TypedefPlaceHolder     | Typedef      )  | fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne)('<#elseif' .*?'>'(( fm_TypedefPlaceHolder     | Typedef      )  | fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne))*'<#else>'(( fm_TypedefPlaceHolder     | Typedef      )  | fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne)'</#if>';
fm_LParenparameterListRParenOne: '<#if' .*?'>'(( parameterList      )  | fm_LParenparameterListRParenOne)('<#elseif' .*?'>'(( parameterList      )  | fm_LParenparameterListRParenOne))*'<#else>'(( parameterList      )  | fm_LParenparameterListRParenOne)'</#if>';
fm_LParenstorageClassSpecifierRParenOne: '<#if' .*?'>'(( storageClassSpecifier      )  | fm_LParenstorageClassSpecifierRParenOne)('<#elseif' .*?'>'(( storageClassSpecifier      )  | fm_LParenstorageClassSpecifierRParenOne))*'<#else>'(( storageClassSpecifier      )  | fm_LParenstorageClassSpecifierRParenOne)'</#if>';
fm_LParenfm_CasePlaceHolderOrCaseRParenOne: '<#if' .*?'>'(( fm_CasePlaceHolder     | Case      )  | fm_LParenfm_CasePlaceHolderOrCaseRParenOne)('<#elseif' .*?'>'(( fm_CasePlaceHolder     | Case      )  | fm_LParenfm_CasePlaceHolderOrCaseRParenOne))*'<#else>'(( fm_CasePlaceHolder     | Case      )  | fm_LParenfm_CasePlaceHolderOrCaseRParenOne)'</#if>';
fm_LParenenumerationConstantRParenOne: '<#if' .*?'>'(( enumerationConstant      )  | fm_LParenenumerationConstantRParenOne)('<#elseif' .*?'>'(( enumerationConstant      )  | fm_LParenenumerationConstantRParenOne))*'<#else>'(( enumerationConstant      )  | fm_LParenenumerationConstantRParenOne)'</#if>';
fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne: '<#if' .*?'>'(( fm_AndAssignPlaceHolder     | AndAssign      )  | fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne)('<#elseif' .*?'>'(( fm_AndAssignPlaceHolder     | AndAssign      )  | fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne))*'<#else>'(( fm_AndAssignPlaceHolder     | AndAssign      )  | fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne)'</#if>';
fm_LParengccAttributeRParenOne: '<#if' .*?'>'(( gccAttribute      )  | fm_LParengccAttributeRParenOne)('<#elseif' .*?'>'(( gccAttribute      )  | fm_LParengccAttributeRParenOne))*'<#else>'(( gccAttribute      )  | fm_LParengccAttributeRParenOne)'</#if>';
fm_LParenconditionalExpressionRParenOne: '<#if' .*?'>'(( conditionalExpression      )  | fm_LParenconditionalExpressionRParenOne)('<#elseif' .*?'>'(( conditionalExpression      )  | fm_LParenconditionalExpressionRParenOne))*'<#else>'(( conditionalExpression      )  | fm_LParenconditionalExpressionRParenOne)'</#if>';
fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne: '<#if' .*?'>'(( fm_OrOrPlaceHolder     | OrOr      )  | fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne)('<#elseif' .*?'>'(( fm_OrOrPlaceHolder     | OrOr      )  | fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne))*'<#else>'(( fm_OrOrPlaceHolder     | OrOr      )  | fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne)'</#if>';
fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne: '<#if' .*?'>'(( fm_StaticAssertPlaceHolder     | StaticAssert      )  | fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne)('<#elseif' .*?'>'(( fm_StaticAssertPlaceHolder     | StaticAssert      )  | fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne))*'<#else>'(( fm_StaticAssertPlaceHolder     | StaticAssert      )  | fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne)'</#if>';
fm_LParendirectAbstractDeclaratorRParenOne: '<#if' .*?'>'(( directAbstractDeclarator      )  | fm_LParendirectAbstractDeclaratorRParenOne)('<#elseif' .*?'>'(( directAbstractDeclarator      )  | fm_LParendirectAbstractDeclaratorRParenOne))*'<#else>'(( directAbstractDeclarator      )  | fm_LParendirectAbstractDeclaratorRParenOne)'</#if>';
fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne: '<#if' .*?'>'(( fm_NoreturnPlaceHolder     | Noreturn      )  | fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne)('<#elseif' .*?'>'(( fm_NoreturnPlaceHolder     | Noreturn      )  | fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne))*'<#else>'(( fm_NoreturnPlaceHolder     | Noreturn      )  | fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne)'</#if>';
fm_LParenfm_GotoPlaceHolderOrGotoRParenOne: '<#if' .*?'>'(( fm_GotoPlaceHolder     | Goto      )  | fm_LParenfm_GotoPlaceHolderOrGotoRParenOne)('<#elseif' .*?'>'(( fm_GotoPlaceHolder     | Goto      )  | fm_LParenfm_GotoPlaceHolderOrGotoRParenOne))*'<#else>'(( fm_GotoPlaceHolder     | Goto      )  | fm_LParenfm_GotoPlaceHolderOrGotoRParenOne)'</#if>';
fm_LParenabstractDeclaratorRParenOne: '<#if' .*?'>'(( abstractDeclarator      )  | fm_LParenabstractDeclaratorRParenOne)('<#elseif' .*?'>'(( abstractDeclarator      )  | fm_LParenabstractDeclaratorRParenOne))*'<#else>'(( abstractDeclarator      )  | fm_LParenabstractDeclaratorRParenOne)'</#if>';
fm_LParenstructDeclarationListRParenOne: '<#if' .*?'>'(( structDeclarationList      )  | fm_LParenstructDeclarationListRParenOne)('<#elseif' .*?'>'(( structDeclarationList      )  | fm_LParenstructDeclarationListRParenOne))*'<#else>'(( structDeclarationList      )  | fm_LParenstructDeclarationListRParenOne)'</#if>';
fm_LParenfm_InlinePlaceHolderOrInlineRParenOne: '<#if' .*?'>'(( fm_InlinePlaceHolder     | Inline      )  | fm_LParenfm_InlinePlaceHolderOrInlineRParenOne)('<#elseif' .*?'>'(( fm_InlinePlaceHolder     | Inline      )  | fm_LParenfm_InlinePlaceHolderOrInlineRParenOne))*'<#else>'(( fm_InlinePlaceHolder     | Inline      )  | fm_LParenfm_InlinePlaceHolderOrInlineRParenOne)'</#if>';
fm_LParenstructDeclaratorRParenOne: '<#if' .*?'>'(( structDeclarator      )  | fm_LParenstructDeclaratorRParenOne)('<#elseif' .*?'>'(( structDeclarator      )  | fm_LParenstructDeclaratorRParenOne))*'<#else>'(( structDeclarator      )  | fm_LParenstructDeclaratorRParenOne)'</#if>';
fm_LParenstatementRParenOne: '<#if' .*?'>'(( statement      )  | fm_LParenstatementRParenOne)('<#elseif' .*?'>'(( statement      )  | fm_LParenstatementRParenOne))*'<#else>'(( statement      )  | fm_LParenstatementRParenOne)'</#if>';
fm_LParenparameterDeclarationRParenOne: '<#if' .*?'>'(( parameterDeclaration      )  | fm_LParenparameterDeclarationRParenOne)('<#elseif' .*?'>'(( parameterDeclaration      )  | fm_LParenparameterDeclarationRParenOne))*'<#else>'(( parameterDeclaration      )  | fm_LParenparameterDeclarationRParenOne)'</#if>';
fm_LParenprimaryExpressionRParenOne: '<#if' .*?'>'(( primaryExpression      )  | fm_LParenprimaryExpressionRParenOne)('<#elseif' .*?'>'(( primaryExpression      )  | fm_LParenprimaryExpressionRParenOne))*'<#else>'(( primaryExpression      )  | fm_LParenprimaryExpressionRParenOne)'</#if>';
fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne: '<#if' .*?'>'(( fm_AlignofPlaceHolder     | Alignof      )  | fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne)('<#elseif' .*?'>'(( fm_AlignofPlaceHolder     | Alignof      )  | fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne))*'<#else>'(( fm_AlignofPlaceHolder     | Alignof      )  | fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne)'</#if>';
fm_LParenfm_UnionPlaceHolderOrUnionRParenOne: '<#if' .*?'>'(( fm_UnionPlaceHolder     | Union      )  | fm_LParenfm_UnionPlaceHolderOrUnionRParenOne)('<#elseif' .*?'>'(( fm_UnionPlaceHolder     | Union      )  | fm_LParenfm_UnionPlaceHolderOrUnionRParenOne))*'<#else>'(( fm_UnionPlaceHolder     | Union      )  | fm_LParenfm_UnionPlaceHolderOrUnionRParenOne)'</#if>';
fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne: '<#if' .*?'>'(( FM_ImplicitToken11     | FM_ImplicitToken12     | FM_ImplicitToken13      )  | fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne)('<#elseif' .*?'>'(( FM_ImplicitToken11     | FM_ImplicitToken12     | FM_ImplicitToken13      )  | fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne))*'<#else>'(( FM_ImplicitToken11     | FM_ImplicitToken12     | FM_ImplicitToken13      )  | fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne)'</#if>';
fm_LParendeclaratorRParenOne: '<#if' .*?'>'(( declarator      )  | fm_LParendeclaratorRParenOne)('<#elseif' .*?'>'(( declarator      )  | fm_LParendeclaratorRParenOne))*'<#else>'(( declarator      )  | fm_LParendeclaratorRParenOne)'</#if>';
fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne: '<#if' .*?'>'(( fm_DivAssignPlaceHolder     | DivAssign      )  | fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne)('<#elseif' .*?'>'(( fm_DivAssignPlaceHolder     | DivAssign      )  | fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne))*'<#else>'(( fm_DivAssignPlaceHolder     | DivAssign      )  | fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne)'</#if>';
fm_newRulexXXx1: '<#if' .*?'>'(( ( fm_VoidPlaceHolder     | Void      )     | ( fm_CharPlaceHolder     | Char      )     | ( fm_ShortPlaceHolder     | Short      )     | ( fm_IntPlaceHolder     | Int      )     | ( fm_LongPlaceHolder     | Long      )     | ( fm_FloatPlaceHolder     | Float      )     | ( fm_DoublePlaceHolder     | Double      )     | ( fm_SignedPlaceHolder     | Signed      )     | ( fm_UnsignedPlaceHolder     | Unsigned      )     | ( fm_BoolPlaceHolder     | Bool      )     | ( fm_ComplexPlaceHolder     | Complex      )     | FM_ImplicitToken7     | FM_ImplicitToken8     | FM_ImplicitToken9      )  | fm_newRulexXXx1)('<#elseif' .*?'>'(( ( fm_VoidPlaceHolder     | Void      )     | ( fm_CharPlaceHolder     | Char      )     | ( fm_ShortPlaceHolder     | Short      )     | ( fm_IntPlaceHolder     | Int      )     | ( fm_LongPlaceHolder     | Long      )     | ( fm_FloatPlaceHolder     | Float      )     | ( fm_DoublePlaceHolder     | Double      )     | ( fm_SignedPlaceHolder     | Signed      )     | ( fm_UnsignedPlaceHolder     | Unsigned      )     | ( fm_BoolPlaceHolder     | Bool      )     | ( fm_ComplexPlaceHolder     | Complex      )     | FM_ImplicitToken7     | FM_ImplicitToken8     | FM_ImplicitToken9      )  | fm_newRulexXXx1))*'<#else>'(( ( fm_VoidPlaceHolder     | Void      )     | ( fm_CharPlaceHolder     | Char      )     | ( fm_ShortPlaceHolder     | Short      )     | ( fm_IntPlaceHolder     | Int      )     | ( fm_LongPlaceHolder     | Long      )     | ( fm_FloatPlaceHolder     | Float      )     | ( fm_DoublePlaceHolder     | Double      )     | ( fm_SignedPlaceHolder     | Signed      )     | ( fm_UnsignedPlaceHolder     | Unsigned      )     | ( fm_BoolPlaceHolder     | Bool      )     | ( fm_ComplexPlaceHolder     | Complex      )     | FM_ImplicitToken7     | FM_ImplicitToken8     | FM_ImplicitToken9      )  | fm_newRulexXXx1)'</#if>';
fm_LParenfm_CommaPlaceHolderOrCommaRParenOne: '<#if' .*?'>'(( fm_CommaPlaceHolder     | Comma      )  | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne)('<#elseif' .*?'>'(( fm_CommaPlaceHolder     | Comma      )  | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne))*'<#else>'(( fm_CommaPlaceHolder     | Comma      )  | fm_LParenfm_CommaPlaceHolderOrCommaRParenOne)'</#if>';
fm_LParenexclusiveOrExpressionRParenOne: '<#if' .*?'>'(( exclusiveOrExpression      )  | fm_LParenexclusiveOrExpressionRParenOne)('<#elseif' .*?'>'(( exclusiveOrExpression      )  | fm_LParenexclusiveOrExpressionRParenOne))*'<#else>'(( exclusiveOrExpression      )  | fm_LParenexclusiveOrExpressionRParenOne)'</#if>';
fm_LParenfm_StructPlaceHolderOrStructRParenOne: '<#if' .*?'>'(( fm_StructPlaceHolder     | Struct      )  | fm_LParenfm_StructPlaceHolderOrStructRParenOne)('<#elseif' .*?'>'(( fm_StructPlaceHolder     | Struct      )  | fm_LParenfm_StructPlaceHolderOrStructRParenOne))*'<#else>'(( fm_StructPlaceHolder     | Struct      )  | fm_LParenfm_StructPlaceHolderOrStructRParenOne)'</#if>';
fm_LParenfm_ModPlaceHolderOrModRParenOne: '<#if' .*?'>'(( fm_ModPlaceHolder     | Mod      )  | fm_LParenfm_ModPlaceHolderOrModRParenOne)('<#elseif' .*?'>'(( fm_ModPlaceHolder     | Mod      )  | fm_LParenfm_ModPlaceHolderOrModRParenOne))*'<#else>'(( fm_ModPlaceHolder     | Mod      )  | fm_LParenfm_ModPlaceHolderOrModRParenOne)'</#if>';
fm_LParenfm_ComplexPlaceHolderOrComplexRParenOne: '<#if' .*?'>'(( fm_ComplexPlaceHolder     | Complex      )  | fm_LParenfm_ComplexPlaceHolderOrComplexRParenOne)('<#elseif' .*?'>'(( fm_ComplexPlaceHolder     | Complex      )  | fm_LParenfm_ComplexPlaceHolderOrComplexRParenOne))*'<#else>'(( fm_ComplexPlaceHolder     | Complex      )  | fm_LParenfm_ComplexPlaceHolderOrComplexRParenOne)'</#if>';
fm_LParenatomicTypeSpecifierRParenOne: '<#if' .*?'>'(( atomicTypeSpecifier      )  | fm_LParenatomicTypeSpecifierRParenOne)('<#elseif' .*?'>'(( atomicTypeSpecifier      )  | fm_LParenatomicTypeSpecifierRParenOne))*'<#else>'(( atomicTypeSpecifier      )  | fm_LParenatomicTypeSpecifierRParenOne)'</#if>';
fm_LParenfm_ArrowPlaceHolderOrArrowRParenOne: '<#if' .*?'>'(( fm_ArrowPlaceHolder     | Arrow      )  | fm_LParenfm_ArrowPlaceHolderOrArrowRParenOne)('<#elseif' .*?'>'(( fm_ArrowPlaceHolder     | Arrow      )  | fm_LParenfm_ArrowPlaceHolderOrArrowRParenOne))*'<#else>'(( fm_ArrowPlaceHolder     | Arrow      )  | fm_LParenfm_ArrowPlaceHolderOrArrowRParenOne)'</#if>';
fm_LParenfm_IfPlaceHolderOrIfRParenOne: '<#if' .*?'>'(( fm_IfPlaceHolder     | If      )  | fm_LParenfm_IfPlaceHolderOrIfRParenOne)('<#elseif' .*?'>'(( fm_IfPlaceHolder     | If      )  | fm_LParenfm_IfPlaceHolderOrIfRParenOne))*'<#else>'(( fm_IfPlaceHolder     | If      )  | fm_LParenfm_IfPlaceHolderOrIfRParenOne)'</#if>';
fm_newRulexXXx2: '<#if' .*?'>'(( ( fm_InlinePlaceHolder     | Inline      )     | ( fm_NoreturnPlaceHolder     | Noreturn      )     | FM_ImplicitToken15     | FM_ImplicitToken16      )  | fm_newRulexXXx2)('<#elseif' .*?'>'(( ( fm_InlinePlaceHolder     | Inline      )     | ( fm_NoreturnPlaceHolder     | Noreturn      )     | FM_ImplicitToken15     | FM_ImplicitToken16      )  | fm_newRulexXXx2))*'<#else>'(( ( fm_InlinePlaceHolder     | Inline      )     | ( fm_NoreturnPlaceHolder     | Noreturn      )     | FM_ImplicitToken15     | FM_ImplicitToken16      )  | fm_newRulexXXx2)'</#if>';
fm_LParenfm_ForPlaceHolderOrForRParenOne: '<#if' .*?'>'(( fm_ForPlaceHolder     | For      )  | fm_LParenfm_ForPlaceHolderOrForRParenOne)('<#elseif' .*?'>'(( fm_ForPlaceHolder     | For      )  | fm_LParenfm_ForPlaceHolderOrForRParenOne))*'<#else>'(( fm_ForPlaceHolder     | For      )  | fm_LParenfm_ForPlaceHolderOrForRParenOne)'</#if>';
fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus: '<#if' .*?'>'(( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus+)('<#elseif' .*?'>'(( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus+))*'<#else>'(( fm_StringLiteralPlaceHolder     | StringLiteral      )  | fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus+)'</#if>';
fm_LParenstructOrUnionRParenOne: '<#if' .*?'>'(( structOrUnion      )  | fm_LParenstructOrUnionRParenOne)('<#elseif' .*?'>'(( structOrUnion      )  | fm_LParenstructOrUnionRParenOne))*'<#else>'(( structOrUnion      )  | fm_LParenstructOrUnionRParenOne)'</#if>';
fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne: '<#if' .*?'>'(( fm_AtomicPlaceHolder     | Atomic      )  | fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne)('<#elseif' .*?'>'(( fm_AtomicPlaceHolder     | Atomic      )  | fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne))*'<#else>'(( fm_AtomicPlaceHolder     | Atomic      )  | fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne)'</#if>';
fm_LParenadditiveExpressionRParenOne: '<#if' .*?'>'(( additiveExpression      )  | fm_LParenadditiveExpressionRParenOne)('<#elseif' .*?'>'(( additiveExpression      )  | fm_LParenadditiveExpressionRParenOne))*'<#else>'(( additiveExpression      )  | fm_LParenadditiveExpressionRParenOne)'</#if>';
fm_LParenfm_StaticPlaceHolderOrStaticRParenOne: '<#if' .*?'>'(( fm_StaticPlaceHolder     | Static      )  | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne)('<#elseif' .*?'>'(( fm_StaticPlaceHolder     | Static      )  | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne))*'<#else>'(( fm_StaticPlaceHolder     | Static      )  | fm_LParenfm_StaticPlaceHolderOrStaticRParenOne)'</#if>';
fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne: '<#if' .*?'>'(( FM_ImplicitToken20     | FM_ImplicitToken21      )  | fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne)('<#elseif' .*?'>'(( FM_ImplicitToken20     | FM_ImplicitToken21      )  | fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne))*'<#else>'(( FM_ImplicitToken20     | FM_ImplicitToken21      )  | fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne)'</#if>';
fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne: '<#if' .*?'>'(( fm_DefaultPlaceHolder     | Default      )  | fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne)('<#elseif' .*?'>'(( fm_DefaultPlaceHolder     | Default      )  | fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne))*'<#else>'(( fm_DefaultPlaceHolder     | Default      )  | fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne)'</#if>';
fm_LParenpostfixExpressionRParenOne: '<#if' .*?'>'(( postfixExpression      )  | fm_LParenpostfixExpressionRParenOne)('<#elseif' .*?'>'(( postfixExpression      )  | fm_LParenpostfixExpressionRParenOne))*'<#else>'(( postfixExpression      )  | fm_LParenpostfixExpressionRParenOne)'</#if>';
fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne: '<#if' .*?'>'(( fm_StarAssignPlaceHolder     | StarAssign      )  | fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne)('<#elseif' .*?'>'(( fm_StarAssignPlaceHolder     | StarAssign      )  | fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne))*'<#else>'(( fm_StarAssignPlaceHolder     | StarAssign      )  | fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne)'</#if>';
fm_LParencompoundStatementRParenOne: '<#if' .*?'>'(( compoundStatement      )  | fm_LParencompoundStatementRParenOne)('<#elseif' .*?'>'(( compoundStatement      )  | fm_LParencompoundStatementRParenOne))*'<#else>'(( compoundStatement      )  | fm_LParencompoundStatementRParenOne)'</#if>';
fm_LParenfm_ContinuePlaceHolderOrContinueRParenOne: '<#if' .*?'>'(( fm_ContinuePlaceHolder     | Continue      )  | fm_LParenfm_ContinuePlaceHolderOrContinueRParenOne)('<#elseif' .*?'>'(( fm_ContinuePlaceHolder     | Continue      )  | fm_LParenfm_ContinuePlaceHolderOrContinueRParenOne))*'<#else>'(( fm_ContinuePlaceHolder     | Continue      )  | fm_LParenfm_ContinuePlaceHolderOrContinueRParenOne)'</#if>';
fm_LParenfm_LongPlaceHolderOrLongRParenOne: '<#if' .*?'>'(( fm_LongPlaceHolder     | Long      )  | fm_LParenfm_LongPlaceHolderOrLongRParenOne)('<#elseif' .*?'>'(( fm_LongPlaceHolder     | Long      )  | fm_LParenfm_LongPlaceHolderOrLongRParenOne))*'<#else>'(( fm_LongPlaceHolder     | Long      )  | fm_LParenfm_LongPlaceHolderOrLongRParenOne)'</#if>';
fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne: '<#if' .*?'>'(( ( fm_VolatilePlaceHolder     | Volatile      )     | FM_ImplicitToken22      )  | fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne)('<#elseif' .*?'>'(( ( fm_VolatilePlaceHolder     | Volatile      )     | FM_ImplicitToken22      )  | fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne))*'<#else>'(( ( fm_VolatilePlaceHolder     | Volatile      )     | FM_ImplicitToken22      )  | fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne)'</#if>';
fm_LParenmultiplicativeExpressionRParenOne: '<#if' .*?'>'(( multiplicativeExpression      )  | fm_LParenmultiplicativeExpressionRParenOne)('<#elseif' .*?'>'(( multiplicativeExpression      )  | fm_LParenmultiplicativeExpressionRParenOne))*'<#else>'(( multiplicativeExpression      )  | fm_LParenmultiplicativeExpressionRParenOne)'</#if>';
fm_LParenfm_LessPlaceHolderOrLessRParenOne: '<#if' .*?'>'(( fm_LessPlaceHolder     | Less      )  | fm_LParenfm_LessPlaceHolderOrLessRParenOne)('<#elseif' .*?'>'(( fm_LessPlaceHolder     | Less      )  | fm_LParenfm_LessPlaceHolderOrLessRParenOne))*'<#else>'(( fm_LessPlaceHolder     | Less      )  | fm_LParenfm_LessPlaceHolderOrLessRParenOne)'</#if>';
fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne: '<#if' .*?'>'(( fm_GreaterEqualPlaceHolder     | GreaterEqual      )  | fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne)('<#elseif' .*?'>'(( fm_GreaterEqualPlaceHolder     | GreaterEqual      )  | fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne))*'<#else>'(( fm_GreaterEqualPlaceHolder     | GreaterEqual      )  | fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne)'</#if>';
fm_LParenselectionStatementRParenOne: '<#if' .*?'>'(( selectionStatement      )  | fm_LParenselectionStatementRParenOne)('<#elseif' .*?'>'(( selectionStatement      )  | fm_LParenselectionStatementRParenOne))*'<#else>'(( selectionStatement      )  | fm_LParenselectionStatementRParenOne)'</#if>';
fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne: '<#if' .*?'>'(( fm_ModAssignPlaceHolder     | ModAssign      )  | fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne)('<#elseif' .*?'>'(( fm_ModAssignPlaceHolder     | ModAssign      )  | fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne))*'<#else>'(( fm_ModAssignPlaceHolder     | ModAssign      )  | fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne)'</#if>';
fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne: '<#if' .*?'>'(( fm_LeftBracePlaceHolder     | LeftBrace      )  | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne)('<#elseif' .*?'>'(( fm_LeftBracePlaceHolder     | LeftBrace      )  | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne))*'<#else>'(( fm_LeftBracePlaceHolder     | LeftBrace      )  | fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne)'</#if>';
fm_LPareniterationStatementRParenOne: '<#if' .*?'>'(( iterationStatement      )  | fm_LPareniterationStatementRParenOne)('<#elseif' .*?'>'(( iterationStatement      )  | fm_LPareniterationStatementRParenOne))*'<#else>'(( iterationStatement      )  | fm_LPareniterationStatementRParenOne)'</#if>';
fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne: '<#if' .*?'>'(( fm_OrAssignPlaceHolder     | OrAssign      )  | fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne)('<#elseif' .*?'>'(( fm_OrAssignPlaceHolder     | OrAssign      )  | fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne))*'<#else>'(( fm_OrAssignPlaceHolder     | OrAssign      )  | fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne)'</#if>';
fm_LParengccAttributeSpecifierRParenOne: '<#if' .*?'>'(( gccAttributeSpecifier      )  | fm_LParengccAttributeSpecifierRParenOne)('<#elseif' .*?'>'(( gccAttributeSpecifier      )  | fm_LParengccAttributeSpecifierRParenOne))*'<#else>'(( gccAttributeSpecifier      )  | fm_LParengccAttributeSpecifierRParenOne)'</#if>';
fm_LParendeclarationSpecifierRParenOnePlus: '<#if' .*?'>'(( declarationSpecifier      )  | fm_LParendeclarationSpecifierRParenOnePlus+)('<#elseif' .*?'>'(( declarationSpecifier      )  | fm_LParendeclarationSpecifierRParenOnePlus+))*'<#else>'(( declarationSpecifier      )  | fm_LParendeclarationSpecifierRParenOnePlus+)'</#if>';
fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne: '<#if' .*?'>'(( fm_NotEqualPlaceHolder     | NotEqual      )  | fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne)('<#elseif' .*?'>'(( fm_NotEqualPlaceHolder     | NotEqual      )  | fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne))*'<#else>'(( fm_NotEqualPlaceHolder     | NotEqual      )  | fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne)'</#if>';
fm_LParendeclarationSpecifiersRParenOne: '<#if' .*?'>'(( declarationSpecifiers      )  | fm_LParendeclarationSpecifiersRParenOne)('<#elseif' .*?'>'(( declarationSpecifiers      )  | fm_LParendeclarationSpecifiersRParenOne))*'<#else>'(( declarationSpecifiers      )  | fm_LParendeclarationSpecifiersRParenOne)'</#if>';
fm_LParenfunctionSpecifierRParenOne: '<#if' .*?'>'(( functionSpecifier      )  | fm_LParenfunctionSpecifierRParenOne)('<#elseif' .*?'>'(( functionSpecifier      )  | fm_LParenfunctionSpecifierRParenOne))*'<#else>'(( functionSpecifier      )  | fm_LParenfunctionSpecifierRParenOne)'</#if>';
fm_LPareninclusiveOrExpressionRParenOne: '<#if' .*?'>'(( inclusiveOrExpression      )  | fm_LPareninclusiveOrExpressionRParenOne)('<#elseif' .*?'>'(( inclusiveOrExpression      )  | fm_LPareninclusiveOrExpressionRParenOne))*'<#else>'(( inclusiveOrExpression      )  | fm_LPareninclusiveOrExpressionRParenOne)'</#if>';
fm_LParenfm_PlusPlaceHolderOrPlusRParenOne: '<#if' .*?'>'(( fm_PlusPlaceHolder     | Plus      )  | fm_LParenfm_PlusPlaceHolderOrPlusRParenOne)('<#elseif' .*?'>'(( fm_PlusPlaceHolder     | Plus      )  | fm_LParenfm_PlusPlaceHolderOrPlusRParenOne))*'<#else>'(( fm_PlusPlaceHolder     | Plus      )  | fm_LParenfm_PlusPlaceHolderOrPlusRParenOne)'</#if>';
fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne: '<#if' .*?'>'(( fm_SizeofPlaceHolder     | Sizeof      )  | fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne)('<#elseif' .*?'>'(( fm_SizeofPlaceHolder     | Sizeof      )  | fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne))*'<#else>'(( fm_SizeofPlaceHolder     | Sizeof      )  | fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne)'</#if>';
fm_LParenfm_SemiPlaceHolderOrSemiRParenOne: '<#if' .*?'>'(( fm_SemiPlaceHolder     | Semi      )  | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)('<#elseif' .*?'>'(( fm_SemiPlaceHolder     | Semi      )  | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne))*'<#else>'(( fm_SemiPlaceHolder     | Semi      )  | fm_LParenfm_SemiPlaceHolderOrSemiRParenOne)'</#if>';
fm_LParenblockItemRParenOne: '<#if' .*?'>'(( blockItem      )  | fm_LParenblockItemRParenOne)('<#elseif' .*?'>'(( blockItem      )  | fm_LParenblockItemRParenOne))*'<#else>'(( blockItem      )  | fm_LParenblockItemRParenOne)'</#if>';
fm_LParentypeQualifierListRParenOne: '<#if' .*?'>'(( typeQualifierList      )  | fm_LParentypeQualifierListRParenOne)('<#elseif' .*?'>'(( typeQualifierList      )  | fm_LParentypeQualifierListRParenOne))*'<#else>'(( typeQualifierList      )  | fm_LParentypeQualifierListRParenOne)'</#if>';
fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne: '<#if' .*?'>'(( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)('<#elseif' .*?'>'(( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne))*'<#else>'(( fm_IdentifierPlaceHolder     | Identifier      )  | fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne)'</#if>';
fm_LParendesignatorListRParenOne: '<#if' .*?'>'(( designatorList      )  | fm_LParendesignatorListRParenOne)('<#elseif' .*?'>'(( designatorList      )  | fm_LParendesignatorListRParenOne))*'<#else>'(( designatorList      )  | fm_LParendesignatorListRParenOne)'</#if>';
fm_LParenfunctionDefinitionRParenOne: '<#if' .*?'>'(( functionDefinition      )  | fm_LParenfunctionDefinitionRParenOne)('<#elseif' .*?'>'(( functionDefinition      )  | fm_LParenfunctionDefinitionRParenOne))*'<#else>'(( functionDefinition      )  | fm_LParenfunctionDefinitionRParenOne)'</#if>';
fm_LParenfm_BoolPlaceHolderOrBoolRParenOne: '<#if' .*?'>'(( fm_BoolPlaceHolder     | Bool      )  | fm_LParenfm_BoolPlaceHolderOrBoolRParenOne)('<#elseif' .*?'>'(( fm_BoolPlaceHolder     | Bool      )  | fm_LParenfm_BoolPlaceHolderOrBoolRParenOne))*'<#else>'(( fm_BoolPlaceHolder     | Bool      )  | fm_LParenfm_BoolPlaceHolderOrBoolRParenOne)'</#if>';
fm_LParenenumeratorRParenOne: '<#if' .*?'>'(( enumerator      )  | fm_LParenenumeratorRParenOne)('<#elseif' .*?'>'(( enumerator      )  | fm_LParenenumeratorRParenOne))*'<#else>'(( enumerator      )  | fm_LParenenumeratorRParenOne)'</#if>';
fm_LParenexpressionRParenOne: '<#if' .*?'>'(( expression      )  | fm_LParenexpressionRParenOne)('<#elseif' .*?'>'(( expression      )  | fm_LParenexpressionRParenOne))*'<#else>'(( expression      )  | fm_LParenexpressionRParenOne)'</#if>';
fm_LParenconstantExpressionRParenOne: '<#if' .*?'>'(( constantExpression      )  | fm_LParenconstantExpressionRParenOne)('<#elseif' .*?'>'(( constantExpression      )  | fm_LParenconstantExpressionRParenOne))*'<#else>'(( constantExpression      )  | fm_LParenconstantExpressionRParenOne)'</#if>';
fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne: '<#if' .*?'>'(( fm_MinusMinusPlaceHolder     | MinusMinus      )  | fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne)('<#elseif' .*?'>'(( fm_MinusMinusPlaceHolder     | MinusMinus      )  | fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne))*'<#else>'(( fm_MinusMinusPlaceHolder     | MinusMinus      )  | fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne)'</#if>';
fm_LParenfm_CaretPlaceHolderOrCaretRParenOne: '<#if' .*?'>'(( fm_CaretPlaceHolder     | Caret      )  | fm_LParenfm_CaretPlaceHolderOrCaretRParenOne)('<#elseif' .*?'>'(( fm_CaretPlaceHolder     | Caret      )  | fm_LParenfm_CaretPlaceHolderOrCaretRParenOne))*'<#else>'(( fm_CaretPlaceHolder     | Caret      )  | fm_LParenfm_CaretPlaceHolderOrCaretRParenOne)'</#if>';
fm_LParenfm_StarPlaceHolderOrStarRParenOne: '<#if' .*?'>'(( fm_StarPlaceHolder     | Star      )  | fm_LParenfm_StarPlaceHolderOrStarRParenOne)('<#elseif' .*?'>'(( fm_StarPlaceHolder     | Star      )  | fm_LParenfm_StarPlaceHolderOrStarRParenOne))*'<#else>'(( fm_StarPlaceHolder     | Star      )  | fm_LParenfm_StarPlaceHolderOrStarRParenOne)'</#if>';
fm_LParentypeSpecifierRParenOne: '<#if' .*?'>'(( typeSpecifier      )  | fm_LParentypeSpecifierRParenOne)('<#elseif' .*?'>'(( typeSpecifier      )  | fm_LParentypeSpecifierRParenOne))*'<#else>'(( typeSpecifier      )  | fm_LParentypeSpecifierRParenOne)'</#if>';
fm_LParendeclarationRParenOne: '<#if' .*?'>'(( declaration      )  | fm_LParendeclarationRParenOne)('<#elseif' .*?'>'(( declaration      )  | fm_LParendeclarationRParenOne))*'<#else>'(( declaration      )  | fm_LParendeclarationRParenOne)'</#if>';
fm_LParenfm_DotPlaceHolderOrDotRParenOne: '<#if' .*?'>'(( fm_DotPlaceHolder     | Dot      )  | fm_LParenfm_DotPlaceHolderOrDotRParenOne)('<#elseif' .*?'>'(( fm_DotPlaceHolder     | Dot      )  | fm_LParenfm_DotPlaceHolderOrDotRParenOne))*'<#else>'(( fm_DotPlaceHolder     | Dot      )  | fm_LParenfm_DotPlaceHolderOrDotRParenOne)'</#if>';
fm_LPareninitializerRParenOne: '<#if' .*?'>'(( initializer      )  | fm_LPareninitializerRParenOne)('<#elseif' .*?'>'(( initializer      )  | fm_LPareninitializerRParenOne))*'<#else>'(( initializer      )  | fm_LPareninitializerRParenOne)'</#if>';
fm_LParenenumSpecifierRParenOne: '<#if' .*?'>'(( enumSpecifier      )  | fm_LParenenumSpecifierRParenOne)('<#elseif' .*?'>'(( enumSpecifier      )  | fm_LParenenumSpecifierRParenOne))*'<#else>'(( enumSpecifier      )  | fm_LParenenumSpecifierRParenOne)'</#if>';
fm_LParenjumpStatementRParenOne: '<#if' .*?'>'(( jumpStatement      )  | fm_LParenjumpStatementRParenOne)('<#elseif' .*?'>'(( jumpStatement      )  | fm_LParenjumpStatementRParenOne))*'<#else>'(( jumpStatement      )  | fm_LParenjumpStatementRParenOne)'</#if>';
fm_LParenfm_IntPlaceHolderOrIntRParenOne: '<#if' .*?'>'(( fm_IntPlaceHolder     | Int      )  | fm_LParenfm_IntPlaceHolderOrIntRParenOne)('<#elseif' .*?'>'(( fm_IntPlaceHolder     | Int      )  | fm_LParenfm_IntPlaceHolderOrIntRParenOne))*'<#else>'(( fm_IntPlaceHolder     | Int      )  | fm_LParenfm_IntPlaceHolderOrIntRParenOne)'</#if>';
fm_LParenfm_ConstantPlaceHolderOrConstantRParenOne: '<#if' .*?'>'(( fm_ConstantPlaceHolder     | Constant      )  | fm_LParenfm_ConstantPlaceHolderOrConstantRParenOne)('<#elseif' .*?'>'(( fm_ConstantPlaceHolder     | Constant      )  | fm_LParenfm_ConstantPlaceHolderOrConstantRParenOne))*'<#else>'(( fm_ConstantPlaceHolder     | Constant      )  | fm_LParenfm_ConstantPlaceHolderOrConstantRParenOne)'</#if>';
fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne: '<#if' .*?'>'(( fm_AlignasPlaceHolder     | Alignas      )  | fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne)('<#elseif' .*?'>'(( fm_AlignasPlaceHolder     | Alignas      )  | fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne))*'<#else>'(( fm_AlignasPlaceHolder     | Alignas      )  | fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne)'</#if>';
fm_LParenfm_SignedPlaceHolderOrSignedRParenOne: '<#if' .*?'>'(( fm_SignedPlaceHolder     | Signed      )  | fm_LParenfm_SignedPlaceHolderOrSignedRParenOne)('<#elseif' .*?'>'(( fm_SignedPlaceHolder     | Signed      )  | fm_LParenfm_SignedPlaceHolderOrSignedRParenOne))*'<#else>'(( fm_SignedPlaceHolder     | Signed      )  | fm_LParenfm_SignedPlaceHolderOrSignedRParenOne)'</#if>';
fm_LParenandExpressionRParenOne: '<#if' .*?'>'(( andExpression      )  | fm_LParenandExpressionRParenOne)('<#elseif' .*?'>'(( andExpression      )  | fm_LParenandExpressionRParenOne))*'<#else>'(( andExpression      )  | fm_LParenandExpressionRParenOne)'</#if>';
fm_LParendesignatorRParenOne: '<#if' .*?'>'(( designator      )  | fm_LParendesignatorRParenOne)('<#elseif' .*?'>'(( designator      )  | fm_LParendesignatorRParenOne))*'<#else>'(( designator      )  | fm_LParendesignatorRParenOne)'</#if>';
fm_LParenstaticAssertDeclarationRParenOne: '<#if' .*?'>'(( staticAssertDeclaration      )  | fm_LParenstaticAssertDeclarationRParenOne)('<#elseif' .*?'>'(( staticAssertDeclaration      )  | fm_LParenstaticAssertDeclarationRParenOne))*'<#else>'(( staticAssertDeclaration      )  | fm_LParenstaticAssertDeclarationRParenOne)'</#if>';
fm_LParenfm_CharPlaceHolderOrCharRParenOne: '<#if' .*?'>'(( fm_CharPlaceHolder     | Char      )  | fm_LParenfm_CharPlaceHolderOrCharRParenOne)('<#elseif' .*?'>'(( fm_CharPlaceHolder     | Char      )  | fm_LParenfm_CharPlaceHolderOrCharRParenOne))*'<#else>'(( fm_CharPlaceHolder     | Char      )  | fm_LParenfm_CharPlaceHolderOrCharRParenOne)'</#if>';
fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne: '<#if' .*?'>'(( fm_PlusAssignPlaceHolder     | PlusAssign      )  | fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne)('<#elseif' .*?'>'(( fm_PlusAssignPlaceHolder     | PlusAssign      )  | fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne))*'<#else>'(( fm_PlusAssignPlaceHolder     | PlusAssign      )  | fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne)'</#if>';
fm_LParenfm_EqualPlaceHolderOrEqualRParenOne: '<#if' .*?'>'(( fm_EqualPlaceHolder     | Equal      )  | fm_LParenfm_EqualPlaceHolderOrEqualRParenOne)('<#elseif' .*?'>'(( fm_EqualPlaceHolder     | Equal      )  | fm_LParenfm_EqualPlaceHolderOrEqualRParenOne))*'<#else>'(( fm_EqualPlaceHolder     | Equal      )  | fm_LParenfm_EqualPlaceHolderOrEqualRParenOne)'</#if>';
fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne: '<#if' .*?'>'(( fm_GreaterPlaceHolder     | Greater      )  | fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne)('<#elseif' .*?'>'(( fm_GreaterPlaceHolder     | Greater      )  | fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne))*'<#else>'(( fm_GreaterPlaceHolder     | Greater      )  | fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne)'</#if>';
fm_LParenfm_WhilePlaceHolderOrWhileRParenOne: '<#if' .*?'>'(( fm_WhilePlaceHolder     | While      )  | fm_LParenfm_WhilePlaceHolderOrWhileRParenOne)('<#elseif' .*?'>'(( fm_WhilePlaceHolder     | While      )  | fm_LParenfm_WhilePlaceHolderOrWhileRParenOne))*'<#else>'(( fm_WhilePlaceHolder     | While      )  | fm_LParenfm_WhilePlaceHolderOrWhileRParenOne)'</#if>';
fm_LParendirectDeclaratorRParenOne: '<#if' .*?'>'(( directDeclarator      )  | fm_LParendirectDeclaratorRParenOne)('<#elseif' .*?'>'(( directDeclarator      )  | fm_LParendirectDeclaratorRParenOne))*'<#else>'(( directDeclarator      )  | fm_LParendirectDeclaratorRParenOne)'</#if>';
fm_LParenassignmentExpressionRParenOne: '<#if' .*?'>'(( assignmentExpression      )  | fm_LParenassignmentExpressionRParenOne)('<#elseif' .*?'>'(( assignmentExpression      )  | fm_LParenassignmentExpressionRParenOne))*'<#else>'(( assignmentExpression      )  | fm_LParenassignmentExpressionRParenOne)'</#if>';
fm_LParenfm_EnumPlaceHolderOrEnumRParenOne: '<#if' .*?'>'(( fm_EnumPlaceHolder     | Enum      )  | fm_LParenfm_EnumPlaceHolderOrEnumRParenOne)('<#elseif' .*?'>'(( fm_EnumPlaceHolder     | Enum      )  | fm_LParenfm_EnumPlaceHolderOrEnumRParenOne))*'<#else>'(( fm_EnumPlaceHolder     | Enum      )  | fm_LParenfm_EnumPlaceHolderOrEnumRParenOne)'</#if>';
fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne: '<#if' .*?'>'(( fm_QuestionPlaceHolder     | Question      )  | fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne)('<#elseif' .*?'>'(( fm_QuestionPlaceHolder     | Question      )  | fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne))*'<#else>'(( fm_QuestionPlaceHolder     | Question      )  | fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne)'</#if>';
fm_LParenfm_ExternPlaceHolderOrExternRParenOne: '<#if' .*?'>'(( fm_ExternPlaceHolder     | Extern      )  | fm_LParenfm_ExternPlaceHolderOrExternRParenOne)('<#elseif' .*?'>'(( fm_ExternPlaceHolder     | Extern      )  | fm_LParenfm_ExternPlaceHolderOrExternRParenOne))*'<#else>'(( fm_ExternPlaceHolder     | Extern      )  | fm_LParenfm_ExternPlaceHolderOrExternRParenOne)'</#if>';
fm_LParenfm_ReturnPlaceHolderOrReturnRParenOne: '<#if' .*?'>'(( fm_ReturnPlaceHolder     | Return      )  | fm_LParenfm_ReturnPlaceHolderOrReturnRParenOne)('<#elseif' .*?'>'(( fm_ReturnPlaceHolder     | Return      )  | fm_LParenfm_ReturnPlaceHolderOrReturnRParenOne))*'<#else>'(( fm_ReturnPlaceHolder     | Return      )  | fm_LParenfm_ReturnPlaceHolderOrReturnRParenOne)'</#if>';
fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne: '<#if' .*?'>'(( fm_LeftBracketPlaceHolder     | LeftBracket      )  | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne)('<#elseif' .*?'>'(( fm_LeftBracketPlaceHolder     | LeftBracket      )  | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne))*'<#else>'(( fm_LeftBracketPlaceHolder     | LeftBracket      )  | fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne)'</#if>';
fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne: '<#if' .*?'>'(( fm_RestrictPlaceHolder     | Restrict      )  | fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne)('<#elseif' .*?'>'(( fm_RestrictPlaceHolder     | Restrict      )  | fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne))*'<#else>'(( fm_RestrictPlaceHolder     | Restrict      )  | fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne)'</#if>';
fm_LParencastExpressionRParenOne: '<#if' .*?'>'(( castExpression      )  | fm_LParencastExpressionRParenOne)('<#elseif' .*?'>'(( castExpression      )  | fm_LParencastExpressionRParenOne))*'<#else>'(( castExpression      )  | fm_LParencastExpressionRParenOne)'</#if>';
fm_LParenfm_VoidPlaceHolderOrVoidRParenOne: '<#if' .*?'>'(( fm_VoidPlaceHolder     | Void      )  | fm_LParenfm_VoidPlaceHolderOrVoidRParenOne)('<#elseif' .*?'>'(( fm_VoidPlaceHolder     | Void      )  | fm_LParenfm_VoidPlaceHolderOrVoidRParenOne))*'<#else>'(( fm_VoidPlaceHolder     | Void      )  | fm_LParenfm_VoidPlaceHolderOrVoidRParenOne)'</#if>';
fm_LParenspecifierQualifierListRParenOne: '<#if' .*?'>'(( specifierQualifierList      )  | fm_LParenspecifierQualifierListRParenOne)('<#elseif' .*?'>'(( specifierQualifierList      )  | fm_LParenspecifierQualifierListRParenOne))*'<#else>'(( specifierQualifierList      )  | fm_LParenspecifierQualifierListRParenOne)'</#if>';
fm_LParenfm_BreakPlaceHolderOrBreakRParenOne: '<#if' .*?'>'(( fm_BreakPlaceHolder     | Break      )  | fm_LParenfm_BreakPlaceHolderOrBreakRParenOne)('<#elseif' .*?'>'(( fm_BreakPlaceHolder     | Break      )  | fm_LParenfm_BreakPlaceHolderOrBreakRParenOne))*'<#else>'(( fm_BreakPlaceHolder     | Break      )  | fm_LParenfm_BreakPlaceHolderOrBreakRParenOne)'</#if>';
fm_LParenfm_NotPlaceHolderOrNotRParenOne: '<#if' .*?'>'(( fm_NotPlaceHolder     | Not      )  | fm_LParenfm_NotPlaceHolderOrNotRParenOne)('<#elseif' .*?'>'(( fm_NotPlaceHolder     | Not      )  | fm_LParenfm_NotPlaceHolderOrNotRParenOne))*'<#else>'(( fm_NotPlaceHolder     | Not      )  | fm_LParenfm_NotPlaceHolderOrNotRParenOne)'</#if>';
fm_LParenfm_MinusPlaceHolderOrMinusRParenOne: '<#if' .*?'>'(( fm_MinusPlaceHolder     | Minus      )  | fm_LParenfm_MinusPlaceHolderOrMinusRParenOne)('<#elseif' .*?'>'(( fm_MinusPlaceHolder     | Minus      )  | fm_LParenfm_MinusPlaceHolderOrMinusRParenOne))*'<#else>'(( fm_MinusPlaceHolder     | Minus      )  | fm_LParenfm_MinusPlaceHolderOrMinusRParenOne)'</#if>';
fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne: '<#if' .*?'>'(( fm_XorAssignPlaceHolder     | XorAssign      )  | fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne)('<#elseif' .*?'>'(( fm_XorAssignPlaceHolder     | XorAssign      )  | fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne))*'<#else>'(( fm_XorAssignPlaceHolder     | XorAssign      )  | fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne)'</#if>';
fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne: '<#if' .*?'>'(( fm_RegisterPlaceHolder     | Register      )  | fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne)('<#elseif' .*?'>'(( fm_RegisterPlaceHolder     | Register      )  | fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne))*'<#else>'(( fm_RegisterPlaceHolder     | Register      )  | fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne)'</#if>';
fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne: '<#if' .*?'>'(( fm_LessEqualPlaceHolder     | LessEqual      )  | fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne)('<#elseif' .*?'>'(( fm_LessEqualPlaceHolder     | LessEqual      )  | fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne))*'<#else>'(( fm_LessEqualPlaceHolder     | LessEqual      )  | fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne)'</#if>';
fm_LParenfm_AndPlaceHolderOrAndRParenOne: '<#if' .*?'>'(( fm_AndPlaceHolder     | And      )  | fm_LParenfm_AndPlaceHolderOrAndRParenOne)('<#elseif' .*?'>'(( fm_AndPlaceHolder     | And      )  | fm_LParenfm_AndPlaceHolderOrAndRParenOne))*'<#else>'(( fm_AndPlaceHolder     | And      )  | fm_LParenfm_AndPlaceHolderOrAndRParenOne)'</#if>';
fm_LParentypeQualifierRParenOne: '<#if' .*?'>'(( typeQualifier      )  | fm_LParentypeQualifierRParenOne)('<#elseif' .*?'>'(( typeQualifier      )  | fm_LParentypeQualifierRParenOne))*'<#else>'(( typeQualifier      )  | fm_LParentypeQualifierRParenOne)'</#if>';
fm_LParenfm_DoublePlaceHolderOrDoubleRParenOne: '<#if' .*?'>'(( fm_DoublePlaceHolder     | Double      )  | fm_LParenfm_DoublePlaceHolderOrDoubleRParenOne)('<#elseif' .*?'>'(( fm_DoublePlaceHolder     | Double      )  | fm_LParenfm_DoublePlaceHolderOrDoubleRParenOne))*'<#else>'(( fm_DoublePlaceHolder     | Double      )  | fm_LParenfm_DoublePlaceHolderOrDoubleRParenOne)'</#if>';
fm_LParenunaryExpressionRParenOne: '<#if' .*?'>'(( unaryExpression      )  | fm_LParenunaryExpressionRParenOne)('<#elseif' .*?'>'(( unaryExpression      )  | fm_LParenunaryExpressionRParenOne))*'<#else>'(( unaryExpression      )  | fm_LParenunaryExpressionRParenOne)'</#if>';
fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne: '<#if' .*?'>'(( fm_LeftShiftPlaceHolder     | LeftShift      )  | fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne)('<#elseif' .*?'>'(( fm_LeftShiftPlaceHolder     | LeftShift      )  | fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne))*'<#else>'(( fm_LeftShiftPlaceHolder     | LeftShift      )  | fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne)'</#if>';
fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne: '<#if' .*?'>'(( fm_VolatilePlaceHolder     | Volatile      )  | fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne)('<#elseif' .*?'>'(( fm_VolatilePlaceHolder     | Volatile      )  | fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne))*'<#else>'(( fm_VolatilePlaceHolder     | Volatile      )  | fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne)'</#if>';
fm_LParenenumeratorListRParenOne: '<#if' .*?'>'(( enumeratorList      )  | fm_LParenenumeratorListRParenOne)('<#elseif' .*?'>'(( enumeratorList      )  | fm_LParenenumeratorListRParenOne))*'<#else>'(( enumeratorList      )  | fm_LParenenumeratorListRParenOne)'</#if>';
fm_LParentypedefNameRParenOne: '<#if' .*?'>'(( typedefName      )  | fm_LParentypedefNameRParenOne)('<#elseif' .*?'>'(( typedefName      )  | fm_LParentypedefNameRParenOne))*'<#else>'(( typedefName      )  | fm_LParentypedefNameRParenOne)'</#if>';
fm_LParenrelationalExpressionRParenOne: '<#if' .*?'>'(( relationalExpression      )  | fm_LParenrelationalExpressionRParenOne)('<#elseif' .*?'>'(( relationalExpression      )  | fm_LParenrelationalExpressionRParenOne))*'<#else>'(( relationalExpression      )  | fm_LParenrelationalExpressionRParenOne)'</#if>';
fm_LPareninitializerListRParenOne: '<#if' .*?'>'(( initializerList      )  | fm_LPareninitializerListRParenOne)('<#elseif' .*?'>'(( initializerList      )  | fm_LPareninitializerListRParenOne))*'<#else>'(( initializerList      )  | fm_LPareninitializerListRParenOne)'</#if>';
fm_LParenpointerRParenOne: '<#if' .*?'>'(( pointer      )  | fm_LParenpointerRParenOne)('<#elseif' .*?'>'(( pointer      )  | fm_LParenpointerRParenOne))*'<#else>'(( pointer      )  | fm_LParenpointerRParenOne)'</#if>';
fm_LParenfm_DivPlaceHolderOrDivRParenOne: '<#if' .*?'>'(( fm_DivPlaceHolder     | Div      )  | fm_LParenfm_DivPlaceHolderOrDivRParenOne)('<#elseif' .*?'>'(( fm_DivPlaceHolder     | Div      )  | fm_LParenfm_DivPlaceHolderOrDivRParenOne))*'<#else>'(( fm_DivPlaceHolder     | Div      )  | fm_LParenfm_DivPlaceHolderOrDivRParenOne)'</#if>';
fm_LParenequalityExpressionRParenOne: '<#if' .*?'>'(( equalityExpression      )  | fm_LParenequalityExpressionRParenOne)('<#elseif' .*?'>'(( equalityExpression      )  | fm_LParenequalityExpressionRParenOne))*'<#else>'(( equalityExpression      )  | fm_LParenequalityExpressionRParenOne)'</#if>';
fm_LPareninitDeclaratorRParenOne: '<#if' .*?'>'(( initDeclarator      )  | fm_LPareninitDeclaratorRParenOne)('<#elseif' .*?'>'(( initDeclarator      )  | fm_LPareninitDeclaratorRParenOne))*'<#else>'(( initDeclarator      )  | fm_LPareninitDeclaratorRParenOne)'</#if>';
fm_LParengenericAssociationRParenOne: '<#if' .*?'>'(( genericAssociation      )  | fm_LParengenericAssociationRParenOne)('<#elseif' .*?'>'(( genericAssociation      )  | fm_LParengenericAssociationRParenOne))*'<#else>'(( genericAssociation      )  | fm_LParengenericAssociationRParenOne)'</#if>';
fm_LParengenericSelectionRParenOne: '<#if' .*?'>'(( genericSelection      )  | fm_LParengenericSelectionRParenOne)('<#elseif' .*?'>'(( genericSelection      )  | fm_LParengenericSelectionRParenOne))*'<#else>'(( genericSelection      )  | fm_LParengenericSelectionRParenOne)'</#if>';
fm_LParenunaryOperatorRParenOne: '<#if' .*?'>'(( unaryOperator      )  | fm_LParenunaryOperatorRParenOne)('<#elseif' .*?'>'(( unaryOperator      )  | fm_LParenunaryOperatorRParenOne))*'<#else>'(( unaryOperator      )  | fm_LParenunaryOperatorRParenOne)'</#if>';
fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne: '<#if' .*?'>'(( fm_AndAndPlaceHolder     | AndAnd      )  | fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne)('<#elseif' .*?'>'(( fm_AndAndPlaceHolder     | AndAnd      )  | fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne))*'<#else>'(( fm_AndAndPlaceHolder     | AndAnd      )  | fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne)'</#if>';
fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne: '<#if' .*?'>'(( fm_SwitchPlaceHolder     | Switch      )  | fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne)('<#elseif' .*?'>'(( fm_SwitchPlaceHolder     | Switch      )  | fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne))*'<#else>'(( fm_SwitchPlaceHolder     | Switch      )  | fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne)'</#if>';
fm_LParenalignmentSpecifierRParenOne: '<#if' .*?'>'(( alignmentSpecifier      )  | fm_LParenalignmentSpecifierRParenOne)('<#elseif' .*?'>'(( alignmentSpecifier      )  | fm_LParenalignmentSpecifierRParenOne))*'<#else>'(( alignmentSpecifier      )  | fm_LParenalignmentSpecifierRParenOne)'</#if>';
fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne: '<#if' .*?'>'(( fm_LeftParenPlaceHolder     | LeftParen      )  | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne)('<#elseif' .*?'>'(( fm_LeftParenPlaceHolder     | LeftParen      )  | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne))*'<#else>'(( fm_LeftParenPlaceHolder     | LeftParen      )  | fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne)'</#if>';
fm_LParengenericAssocListRParenOne: '<#if' .*?'>'(( genericAssocList      )  | fm_LParengenericAssocListRParenOne)('<#elseif' .*?'>'(( genericAssocList      )  | fm_LParengenericAssocListRParenOne))*'<#else>'(( genericAssocList      )  | fm_LParengenericAssocListRParenOne)'</#if>';
fm_LParengccAttributeListRParenOne: '<#if' .*?'>'(( gccAttributeList      )  | fm_LParengccAttributeListRParenOne)('<#elseif' .*?'>'(( gccAttributeList      )  | fm_LParengccAttributeListRParenOne))*'<#else>'(( gccAttributeList      )  | fm_LParengccAttributeListRParenOne)'</#if>';
fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne: '<#if' .*?'>'(( fm_UnsignedPlaceHolder     | Unsigned      )  | fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne)('<#elseif' .*?'>'(( fm_UnsignedPlaceHolder     | Unsigned      )  | fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne))*'<#else>'(( fm_UnsignedPlaceHolder     | Unsigned      )  | fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne)'</#if>';
fm_LParenshiftExpressionRParenOne: '<#if' .*?'>'(( shiftExpression      )  | fm_LParenshiftExpressionRParenOne)('<#elseif' .*?'>'(( shiftExpression      )  | fm_LParenshiftExpressionRParenOne))*'<#else>'(( shiftExpression      )  | fm_LParenshiftExpressionRParenOne)'</#if>';
fm_LParendeclarationSpecifiers2RParenOne: '<#if' .*?'>'(( declarationSpecifiers2      )  | fm_LParendeclarationSpecifiers2RParenOne)('<#elseif' .*?'>'(( declarationSpecifiers2      )  | fm_LParendeclarationSpecifiers2RParenOne))*'<#else>'(( declarationSpecifiers2      )  | fm_LParendeclarationSpecifiers2RParenOne)'</#if>';
fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne: '<#if' .*?'>'(( fm_RightShiftPlaceHolder     | RightShift      )  | fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne)('<#elseif' .*?'>'(( fm_RightShiftPlaceHolder     | RightShift      )  | fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne))*'<#else>'(( fm_RightShiftPlaceHolder     | RightShift      )  | fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne)'</#if>';
fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne: '<#if' .*?'>'(( fm_LeftShiftAssignPlaceHolder     | LeftShiftAssign      )  | fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne)('<#elseif' .*?'>'(( fm_LeftShiftAssignPlaceHolder     | LeftShiftAssign      )  | fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne))*'<#else>'(( fm_LeftShiftAssignPlaceHolder     | LeftShiftAssign      )  | fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne)'</#if>';
fm_LParenassignmentOperatorRParenOne: '<#if' .*?'>'(( assignmentOperator      )  | fm_LParenassignmentOperatorRParenOne)('<#elseif' .*?'>'(( assignmentOperator      )  | fm_LParenassignmentOperatorRParenOne))*'<#else>'(( assignmentOperator      )  | fm_LParenassignmentOperatorRParenOne)'</#if>';
fm_LParenexpressionStatementRParenOne: '<#if' .*?'>'(( expressionStatement      )  | fm_LParenexpressionStatementRParenOne)('<#elseif' .*?'>'(( expressionStatement      )  | fm_LParenexpressionStatementRParenOne))*'<#else>'(( expressionStatement      )  | fm_LParenexpressionStatementRParenOne)'</#if>';
fm_LParenfm_AssignPlaceHolderOrAssignRParenOne: '<#if' .*?'>'(( fm_AssignPlaceHolder     | Assign      )  | fm_LParenfm_AssignPlaceHolderOrAssignRParenOne)('<#elseif' .*?'>'(( fm_AssignPlaceHolder     | Assign      )  | fm_LParenfm_AssignPlaceHolderOrAssignRParenOne))*'<#else>'(( fm_AssignPlaceHolder     | Assign      )  | fm_LParenfm_AssignPlaceHolderOrAssignRParenOne)'</#if>';
fm_LParenfm_ConstPlaceHolderOrConstRParenOne: '<#if' .*?'>'(( fm_ConstPlaceHolder     | Const      )  | fm_LParenfm_ConstPlaceHolderOrConstRParenOne)('<#elseif' .*?'>'(( fm_ConstPlaceHolder     | Const      )  | fm_LParenfm_ConstPlaceHolderOrConstRParenOne))*'<#else>'(( fm_ConstPlaceHolder     | Const      )  | fm_LParenfm_ConstPlaceHolderOrConstRParenOne)'</#if>';
fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne: '<#if' .*?'>'(( fm_ThreadLocalPlaceHolder     | ThreadLocal      )  | fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne)('<#elseif' .*?'>'(( fm_ThreadLocalPlaceHolder     | ThreadLocal      )  | fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne))*'<#else>'(( fm_ThreadLocalPlaceHolder     | ThreadLocal      )  | fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne)'</#if>';
fm_LParenstructOrUnionSpecifierRParenOne: '<#if' .*?'>'(( structOrUnionSpecifier      )  | fm_LParenstructOrUnionSpecifierRParenOne)('<#elseif' .*?'>'(( structOrUnionSpecifier      )  | fm_LParenstructOrUnionSpecifierRParenOne))*'<#else>'(( structOrUnionSpecifier      )  | fm_LParenstructOrUnionSpecifierRParenOne)'</#if>';
fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne: '<#if' .*?'>'(( fm_RightBracePlaceHolder     | RightBrace      )  | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)('<#elseif' .*?'>'(( fm_RightBracePlaceHolder     | RightBrace      )  | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne))*'<#else>'(( fm_RightBracePlaceHolder     | RightBrace      )  | fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne)'</#if>';
fm_LParenparameterTypeListRParenOne: '<#if' .*?'>'(( parameterTypeList      )  | fm_LParenparameterTypeListRParenOne)('<#elseif' .*?'>'(( parameterTypeList      )  | fm_LParenparameterTypeListRParenOne))*'<#else>'(( parameterTypeList      )  | fm_LParenparameterTypeListRParenOne)'</#if>';
fm_LParenlogicalAndExpressionRParenOne: '<#if' .*?'>'(( logicalAndExpression      )  | fm_LParenlogicalAndExpressionRParenOne)('<#elseif' .*?'>'(( logicalAndExpression      )  | fm_LParenlogicalAndExpressionRParenOne))*'<#else>'(( logicalAndExpression      )  | fm_LParenlogicalAndExpressionRParenOne)'</#if>';
fm_LParentypeNameRParenOne: '<#if' .*?'>'(( typeName      )  | fm_LParentypeNameRParenOne)('<#elseif' .*?'>'(( typeName      )  | fm_LParentypeNameRParenOne))*'<#else>'(( typeName      )  | fm_LParentypeNameRParenOne)'</#if>';