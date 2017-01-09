// Generated from C:\Projects\cobigen\workspaces\approach2\cobigen\MA_manual_merge\manual_merge\src\main\java\c11TemplateParser\C11Template.g4 by ANTLR 4.5.1
package c11TemplateParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link C11TemplateParser}.
 */
public interface C11TemplateListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpression(C11TemplateParser.PrimaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#primaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpression(C11TemplateParser.PrimaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#genericSelection}.
	 * @param ctx the parse tree
	 */
	void enterGenericSelection(C11TemplateParser.GenericSelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#genericSelection}.
	 * @param ctx the parse tree
	 */
	void exitGenericSelection(C11TemplateParser.GenericSelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#genericAssocList}.
	 * @param ctx the parse tree
	 */
	void enterGenericAssocList(C11TemplateParser.GenericAssocListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#genericAssocList}.
	 * @param ctx the parse tree
	 */
	void exitGenericAssocList(C11TemplateParser.GenericAssocListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#genericAssociation}.
	 * @param ctx the parse tree
	 */
	void enterGenericAssociation(C11TemplateParser.GenericAssociationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#genericAssociation}.
	 * @param ctx the parse tree
	 */
	void exitGenericAssociation(C11TemplateParser.GenericAssociationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(C11TemplateParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(C11TemplateParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentExpressionList(C11TemplateParser.ArgumentExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#argumentExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentExpressionList(C11TemplateParser.ArgumentExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(C11TemplateParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(C11TemplateParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(C11TemplateParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(C11TemplateParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(C11TemplateParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(C11TemplateParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(C11TemplateParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(C11TemplateParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(C11TemplateParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(C11TemplateParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(C11TemplateParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(C11TemplateParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(C11TemplateParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(C11TemplateParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(C11TemplateParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(C11TemplateParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(C11TemplateParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(C11TemplateParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(C11TemplateParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(C11TemplateParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(C11TemplateParser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(C11TemplateParser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(C11TemplateParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#logicalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(C11TemplateParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(C11TemplateParser.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#logicalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(C11TemplateParser.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(C11TemplateParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(C11TemplateParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(C11TemplateParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(C11TemplateParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(C11TemplateParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(C11TemplateParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(C11TemplateParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(C11TemplateParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(C11TemplateParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(C11TemplateParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(C11TemplateParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(C11TemplateParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifiers(C11TemplateParser.DeclarationSpecifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#declarationSpecifiers}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifiers(C11TemplateParser.DeclarationSpecifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#declarationSpecifiers2}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifiers2(C11TemplateParser.DeclarationSpecifiers2Context ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#declarationSpecifiers2}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifiers2(C11TemplateParser.DeclarationSpecifiers2Context ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationSpecifier(C11TemplateParser.DeclarationSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#declarationSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationSpecifier(C11TemplateParser.DeclarationSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclaratorList(C11TemplateParser.InitDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#initDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclaratorList(C11TemplateParser.InitDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterInitDeclarator(C11TemplateParser.InitDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#initDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitInitDeclarator(C11TemplateParser.InitDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#storageClassSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterStorageClassSpecifier(C11TemplateParser.StorageClassSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#storageClassSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitStorageClassSpecifier(C11TemplateParser.StorageClassSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(C11TemplateParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(C11TemplateParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#structOrUnionSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterStructOrUnionSpecifier(C11TemplateParser.StructOrUnionSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#structOrUnionSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitStructOrUnionSpecifier(C11TemplateParser.StructOrUnionSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#structOrUnion}.
	 * @param ctx the parse tree
	 */
	void enterStructOrUnion(C11TemplateParser.StructOrUnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#structOrUnion}.
	 * @param ctx the parse tree
	 */
	void exitStructOrUnion(C11TemplateParser.StructOrUnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#structDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclarationList(C11TemplateParser.StructDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#structDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclarationList(C11TemplateParser.StructDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaration(C11TemplateParser.StructDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#structDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaration(C11TemplateParser.StructDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 */
	void enterSpecifierQualifierList(C11TemplateParser.SpecifierQualifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#specifierQualifierList}.
	 * @param ctx the parse tree
	 */
	void exitSpecifierQualifierList(C11TemplateParser.SpecifierQualifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#structDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclaratorList(C11TemplateParser.StructDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#structDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclaratorList(C11TemplateParser.StructDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#structDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclarator(C11TemplateParser.StructDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#structDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclarator(C11TemplateParser.StructDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#enumSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumSpecifier(C11TemplateParser.EnumSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#enumSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumSpecifier(C11TemplateParser.EnumSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#enumeratorList}.
	 * @param ctx the parse tree
	 */
	void enterEnumeratorList(C11TemplateParser.EnumeratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#enumeratorList}.
	 * @param ctx the parse tree
	 */
	void exitEnumeratorList(C11TemplateParser.EnumeratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#enumerator}.
	 * @param ctx the parse tree
	 */
	void enterEnumerator(C11TemplateParser.EnumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#enumerator}.
	 * @param ctx the parse tree
	 */
	void exitEnumerator(C11TemplateParser.EnumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#enumerationConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumerationConstant(C11TemplateParser.EnumerationConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#enumerationConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumerationConstant(C11TemplateParser.EnumerationConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#atomicTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterAtomicTypeSpecifier(C11TemplateParser.AtomicTypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#atomicTypeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitAtomicTypeSpecifier(C11TemplateParser.AtomicTypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#typeQualifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeQualifier(C11TemplateParser.TypeQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#typeQualifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeQualifier(C11TemplateParser.TypeQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#functionSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterFunctionSpecifier(C11TemplateParser.FunctionSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#functionSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitFunctionSpecifier(C11TemplateParser.FunctionSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#alignmentSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterAlignmentSpecifier(C11TemplateParser.AlignmentSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#alignmentSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitAlignmentSpecifier(C11TemplateParser.AlignmentSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(C11TemplateParser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(C11TemplateParser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectDeclarator(C11TemplateParser.DirectDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#directDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectDeclarator(C11TemplateParser.DirectDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#gccDeclaratorExtension}.
	 * @param ctx the parse tree
	 */
	void enterGccDeclaratorExtension(C11TemplateParser.GccDeclaratorExtensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#gccDeclaratorExtension}.
	 * @param ctx the parse tree
	 */
	void exitGccDeclaratorExtension(C11TemplateParser.GccDeclaratorExtensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#gccAttributeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterGccAttributeSpecifier(C11TemplateParser.GccAttributeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#gccAttributeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitGccAttributeSpecifier(C11TemplateParser.GccAttributeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#gccAttributeList}.
	 * @param ctx the parse tree
	 */
	void enterGccAttributeList(C11TemplateParser.GccAttributeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#gccAttributeList}.
	 * @param ctx the parse tree
	 */
	void exitGccAttributeList(C11TemplateParser.GccAttributeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#gccAttribute}.
	 * @param ctx the parse tree
	 */
	void enterGccAttribute(C11TemplateParser.GccAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#gccAttribute}.
	 * @param ctx the parse tree
	 */
	void exitGccAttribute(C11TemplateParser.GccAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#nestedParenthesesBlock}.
	 * @param ctx the parse tree
	 */
	void enterNestedParenthesesBlock(C11TemplateParser.NestedParenthesesBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#nestedParenthesesBlock}.
	 * @param ctx the parse tree
	 */
	void exitNestedParenthesesBlock(C11TemplateParser.NestedParenthesesBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#pointer}.
	 * @param ctx the parse tree
	 */
	void enterPointer(C11TemplateParser.PointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#pointer}.
	 * @param ctx the parse tree
	 */
	void exitPointer(C11TemplateParser.PointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#typeQualifierList}.
	 * @param ctx the parse tree
	 */
	void enterTypeQualifierList(C11TemplateParser.TypeQualifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#typeQualifierList}.
	 * @param ctx the parse tree
	 */
	void exitTypeQualifierList(C11TemplateParser.TypeQualifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#parameterTypeList}.
	 * @param ctx the parse tree
	 */
	void enterParameterTypeList(C11TemplateParser.ParameterTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#parameterTypeList}.
	 * @param ctx the parse tree
	 */
	void exitParameterTypeList(C11TemplateParser.ParameterTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(C11TemplateParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(C11TemplateParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(C11TemplateParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(C11TemplateParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(C11TemplateParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(C11TemplateParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(C11TemplateParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(C11TemplateParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterAbstractDeclarator(C11TemplateParser.AbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#abstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitAbstractDeclarator(C11TemplateParser.AbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#directAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterDirectAbstractDeclarator(C11TemplateParser.DirectAbstractDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#directAbstractDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitDirectAbstractDeclarator(C11TemplateParser.DirectAbstractDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void enterTypedefName(C11TemplateParser.TypedefNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#typedefName}.
	 * @param ctx the parse tree
	 */
	void exitTypedefName(C11TemplateParser.TypedefNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(C11TemplateParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(C11TemplateParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void enterInitializerList(C11TemplateParser.InitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#initializerList}.
	 * @param ctx the parse tree
	 */
	void exitInitializerList(C11TemplateParser.InitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#designation}.
	 * @param ctx the parse tree
	 */
	void enterDesignation(C11TemplateParser.DesignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#designation}.
	 * @param ctx the parse tree
	 */
	void exitDesignation(C11TemplateParser.DesignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#designatorList}.
	 * @param ctx the parse tree
	 */
	void enterDesignatorList(C11TemplateParser.DesignatorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#designatorList}.
	 * @param ctx the parse tree
	 */
	void exitDesignatorList(C11TemplateParser.DesignatorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#designator}.
	 * @param ctx the parse tree
	 */
	void enterDesignator(C11TemplateParser.DesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#designator}.
	 * @param ctx the parse tree
	 */
	void exitDesignator(C11TemplateParser.DesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#staticAssertDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticAssertDeclaration(C11TemplateParser.StaticAssertDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#staticAssertDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticAssertDeclaration(C11TemplateParser.StaticAssertDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(C11TemplateParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(C11TemplateParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(C11TemplateParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(C11TemplateParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(C11TemplateParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(C11TemplateParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void enterBlockItemList(C11TemplateParser.BlockItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#blockItemList}.
	 * @param ctx the parse tree
	 */
	void exitBlockItemList(C11TemplateParser.BlockItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(C11TemplateParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(C11TemplateParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(C11TemplateParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(C11TemplateParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(C11TemplateParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(C11TemplateParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterIterationStatement(C11TemplateParser.IterationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitIterationStatement(C11TemplateParser.IterationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterJumpStatement(C11TemplateParser.JumpStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitJumpStatement(C11TemplateParser.JumpStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(C11TemplateParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(C11TemplateParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(C11TemplateParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(C11TemplateParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#externalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExternalDeclaration(C11TemplateParser.ExternalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#externalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExternalDeclaration(C11TemplateParser.ExternalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(C11TemplateParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(C11TemplateParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationList(C11TemplateParser.DeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#declarationList}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationList(C11TemplateParser.DeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AutoPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AutoPlaceHolder(C11TemplateParser.Fm_AutoPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AutoPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AutoPlaceHolder(C11TemplateParser.Fm_AutoPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_BreakPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BreakPlaceHolder(C11TemplateParser.Fm_BreakPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_BreakPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BreakPlaceHolder(C11TemplateParser.Fm_BreakPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_CasePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CasePlaceHolder(C11TemplateParser.Fm_CasePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_CasePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CasePlaceHolder(C11TemplateParser.Fm_CasePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_CharPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CharPlaceHolder(C11TemplateParser.Fm_CharPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_CharPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CharPlaceHolder(C11TemplateParser.Fm_CharPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ConstPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ConstPlaceHolder(C11TemplateParser.Fm_ConstPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ConstPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ConstPlaceHolder(C11TemplateParser.Fm_ConstPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ContinuePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ContinuePlaceHolder(C11TemplateParser.Fm_ContinuePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ContinuePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ContinuePlaceHolder(C11TemplateParser.Fm_ContinuePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_DefaultPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DefaultPlaceHolder(C11TemplateParser.Fm_DefaultPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_DefaultPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DefaultPlaceHolder(C11TemplateParser.Fm_DefaultPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_DoPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DoPlaceHolder(C11TemplateParser.Fm_DoPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_DoPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DoPlaceHolder(C11TemplateParser.Fm_DoPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_DoublePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DoublePlaceHolder(C11TemplateParser.Fm_DoublePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_DoublePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DoublePlaceHolder(C11TemplateParser.Fm_DoublePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ElsePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ElsePlaceHolder(C11TemplateParser.Fm_ElsePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ElsePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ElsePlaceHolder(C11TemplateParser.Fm_ElsePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_EnumPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_EnumPlaceHolder(C11TemplateParser.Fm_EnumPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_EnumPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_EnumPlaceHolder(C11TemplateParser.Fm_EnumPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ExternPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ExternPlaceHolder(C11TemplateParser.Fm_ExternPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ExternPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ExternPlaceHolder(C11TemplateParser.Fm_ExternPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_FloatPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FloatPlaceHolder(C11TemplateParser.Fm_FloatPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_FloatPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FloatPlaceHolder(C11TemplateParser.Fm_FloatPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ForPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ForPlaceHolder(C11TemplateParser.Fm_ForPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ForPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ForPlaceHolder(C11TemplateParser.Fm_ForPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_GotoPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GotoPlaceHolder(C11TemplateParser.Fm_GotoPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_GotoPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GotoPlaceHolder(C11TemplateParser.Fm_GotoPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_IfPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IfPlaceHolder(C11TemplateParser.Fm_IfPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_IfPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IfPlaceHolder(C11TemplateParser.Fm_IfPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_InlinePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_InlinePlaceHolder(C11TemplateParser.Fm_InlinePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_InlinePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_InlinePlaceHolder(C11TemplateParser.Fm_InlinePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_IntPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IntPlaceHolder(C11TemplateParser.Fm_IntPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_IntPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IntPlaceHolder(C11TemplateParser.Fm_IntPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LongPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LongPlaceHolder(C11TemplateParser.Fm_LongPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LongPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LongPlaceHolder(C11TemplateParser.Fm_LongPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_RegisterPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RegisterPlaceHolder(C11TemplateParser.Fm_RegisterPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_RegisterPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RegisterPlaceHolder(C11TemplateParser.Fm_RegisterPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_RestrictPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RestrictPlaceHolder(C11TemplateParser.Fm_RestrictPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_RestrictPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RestrictPlaceHolder(C11TemplateParser.Fm_RestrictPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ReturnPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ReturnPlaceHolder(C11TemplateParser.Fm_ReturnPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ReturnPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ReturnPlaceHolder(C11TemplateParser.Fm_ReturnPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ShortPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ShortPlaceHolder(C11TemplateParser.Fm_ShortPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ShortPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ShortPlaceHolder(C11TemplateParser.Fm_ShortPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_SignedPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SignedPlaceHolder(C11TemplateParser.Fm_SignedPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_SignedPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SignedPlaceHolder(C11TemplateParser.Fm_SignedPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_SizeofPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SizeofPlaceHolder(C11TemplateParser.Fm_SizeofPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_SizeofPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SizeofPlaceHolder(C11TemplateParser.Fm_SizeofPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_StaticPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_StaticPlaceHolder(C11TemplateParser.Fm_StaticPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_StaticPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_StaticPlaceHolder(C11TemplateParser.Fm_StaticPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_StructPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_StructPlaceHolder(C11TemplateParser.Fm_StructPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_StructPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_StructPlaceHolder(C11TemplateParser.Fm_StructPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_SwitchPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SwitchPlaceHolder(C11TemplateParser.Fm_SwitchPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_SwitchPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SwitchPlaceHolder(C11TemplateParser.Fm_SwitchPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_TypedefPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_TypedefPlaceHolder(C11TemplateParser.Fm_TypedefPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_TypedefPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_TypedefPlaceHolder(C11TemplateParser.Fm_TypedefPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_UnionPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_UnionPlaceHolder(C11TemplateParser.Fm_UnionPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_UnionPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_UnionPlaceHolder(C11TemplateParser.Fm_UnionPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_UnsignedPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_UnsignedPlaceHolder(C11TemplateParser.Fm_UnsignedPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_UnsignedPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_UnsignedPlaceHolder(C11TemplateParser.Fm_UnsignedPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_VoidPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_VoidPlaceHolder(C11TemplateParser.Fm_VoidPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_VoidPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_VoidPlaceHolder(C11TemplateParser.Fm_VoidPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_VolatilePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_VolatilePlaceHolder(C11TemplateParser.Fm_VolatilePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_VolatilePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_VolatilePlaceHolder(C11TemplateParser.Fm_VolatilePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_WhilePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_WhilePlaceHolder(C11TemplateParser.Fm_WhilePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_WhilePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_WhilePlaceHolder(C11TemplateParser.Fm_WhilePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AlignasPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AlignasPlaceHolder(C11TemplateParser.Fm_AlignasPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AlignasPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AlignasPlaceHolder(C11TemplateParser.Fm_AlignasPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AlignofPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AlignofPlaceHolder(C11TemplateParser.Fm_AlignofPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AlignofPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AlignofPlaceHolder(C11TemplateParser.Fm_AlignofPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AtomicPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AtomicPlaceHolder(C11TemplateParser.Fm_AtomicPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AtomicPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AtomicPlaceHolder(C11TemplateParser.Fm_AtomicPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_BoolPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BoolPlaceHolder(C11TemplateParser.Fm_BoolPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_BoolPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BoolPlaceHolder(C11TemplateParser.Fm_BoolPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ComplexPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ComplexPlaceHolder(C11TemplateParser.Fm_ComplexPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ComplexPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ComplexPlaceHolder(C11TemplateParser.Fm_ComplexPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_GenericPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GenericPlaceHolder(C11TemplateParser.Fm_GenericPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_GenericPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GenericPlaceHolder(C11TemplateParser.Fm_GenericPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ImaginaryPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ImaginaryPlaceHolder(C11TemplateParser.Fm_ImaginaryPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ImaginaryPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ImaginaryPlaceHolder(C11TemplateParser.Fm_ImaginaryPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_NoreturnPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NoreturnPlaceHolder(C11TemplateParser.Fm_NoreturnPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_NoreturnPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NoreturnPlaceHolder(C11TemplateParser.Fm_NoreturnPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_StaticAssertPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_StaticAssertPlaceHolder(C11TemplateParser.Fm_StaticAssertPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_StaticAssertPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_StaticAssertPlaceHolder(C11TemplateParser.Fm_StaticAssertPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ThreadLocalPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ThreadLocalPlaceHolder(C11TemplateParser.Fm_ThreadLocalPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ThreadLocalPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ThreadLocalPlaceHolder(C11TemplateParser.Fm_ThreadLocalPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LeftParenPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LeftParenPlaceHolder(C11TemplateParser.Fm_LeftParenPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LeftParenPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LeftParenPlaceHolder(C11TemplateParser.Fm_LeftParenPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_RightParenPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RightParenPlaceHolder(C11TemplateParser.Fm_RightParenPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_RightParenPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RightParenPlaceHolder(C11TemplateParser.Fm_RightParenPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LeftBracketPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LeftBracketPlaceHolder(C11TemplateParser.Fm_LeftBracketPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LeftBracketPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LeftBracketPlaceHolder(C11TemplateParser.Fm_LeftBracketPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_RightBracketPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RightBracketPlaceHolder(C11TemplateParser.Fm_RightBracketPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_RightBracketPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RightBracketPlaceHolder(C11TemplateParser.Fm_RightBracketPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LeftBracePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LeftBracePlaceHolder(C11TemplateParser.Fm_LeftBracePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LeftBracePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LeftBracePlaceHolder(C11TemplateParser.Fm_LeftBracePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_RightBracePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RightBracePlaceHolder(C11TemplateParser.Fm_RightBracePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_RightBracePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RightBracePlaceHolder(C11TemplateParser.Fm_RightBracePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LessPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LessPlaceHolder(C11TemplateParser.Fm_LessPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LessPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LessPlaceHolder(C11TemplateParser.Fm_LessPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LessEqualPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LessEqualPlaceHolder(C11TemplateParser.Fm_LessEqualPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LessEqualPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LessEqualPlaceHolder(C11TemplateParser.Fm_LessEqualPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_GreaterPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GreaterPlaceHolder(C11TemplateParser.Fm_GreaterPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_GreaterPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GreaterPlaceHolder(C11TemplateParser.Fm_GreaterPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_GreaterEqualPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GreaterEqualPlaceHolder(C11TemplateParser.Fm_GreaterEqualPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_GreaterEqualPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GreaterEqualPlaceHolder(C11TemplateParser.Fm_GreaterEqualPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LeftShiftPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LeftShiftPlaceHolder(C11TemplateParser.Fm_LeftShiftPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LeftShiftPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LeftShiftPlaceHolder(C11TemplateParser.Fm_LeftShiftPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_RightShiftPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RightShiftPlaceHolder(C11TemplateParser.Fm_RightShiftPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_RightShiftPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RightShiftPlaceHolder(C11TemplateParser.Fm_RightShiftPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_PlusPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PlusPlaceHolder(C11TemplateParser.Fm_PlusPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_PlusPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PlusPlaceHolder(C11TemplateParser.Fm_PlusPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_PlusPlusPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PlusPlusPlaceHolder(C11TemplateParser.Fm_PlusPlusPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_PlusPlusPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PlusPlusPlaceHolder(C11TemplateParser.Fm_PlusPlusPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_MinusPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MinusPlaceHolder(C11TemplateParser.Fm_MinusPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_MinusPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MinusPlaceHolder(C11TemplateParser.Fm_MinusPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_MinusMinusPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MinusMinusPlaceHolder(C11TemplateParser.Fm_MinusMinusPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_MinusMinusPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MinusMinusPlaceHolder(C11TemplateParser.Fm_MinusMinusPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_StarPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_StarPlaceHolder(C11TemplateParser.Fm_StarPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_StarPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_StarPlaceHolder(C11TemplateParser.Fm_StarPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_DivPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DivPlaceHolder(C11TemplateParser.Fm_DivPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_DivPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DivPlaceHolder(C11TemplateParser.Fm_DivPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ModPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ModPlaceHolder(C11TemplateParser.Fm_ModPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ModPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ModPlaceHolder(C11TemplateParser.Fm_ModPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AndPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AndPlaceHolder(C11TemplateParser.Fm_AndPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AndPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AndPlaceHolder(C11TemplateParser.Fm_AndPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_OrPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_OrPlaceHolder(C11TemplateParser.Fm_OrPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_OrPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_OrPlaceHolder(C11TemplateParser.Fm_OrPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AndAndPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AndAndPlaceHolder(C11TemplateParser.Fm_AndAndPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AndAndPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AndAndPlaceHolder(C11TemplateParser.Fm_AndAndPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_OrOrPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_OrOrPlaceHolder(C11TemplateParser.Fm_OrOrPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_OrOrPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_OrOrPlaceHolder(C11TemplateParser.Fm_OrOrPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_CaretPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CaretPlaceHolder(C11TemplateParser.Fm_CaretPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_CaretPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CaretPlaceHolder(C11TemplateParser.Fm_CaretPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_NotPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NotPlaceHolder(C11TemplateParser.Fm_NotPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_NotPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NotPlaceHolder(C11TemplateParser.Fm_NotPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_TildePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_TildePlaceHolder(C11TemplateParser.Fm_TildePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_TildePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_TildePlaceHolder(C11TemplateParser.Fm_TildePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_QuestionPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_QuestionPlaceHolder(C11TemplateParser.Fm_QuestionPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_QuestionPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_QuestionPlaceHolder(C11TemplateParser.Fm_QuestionPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ColonPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ColonPlaceHolder(C11TemplateParser.Fm_ColonPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ColonPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ColonPlaceHolder(C11TemplateParser.Fm_ColonPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_SemiPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SemiPlaceHolder(C11TemplateParser.Fm_SemiPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_SemiPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SemiPlaceHolder(C11TemplateParser.Fm_SemiPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_CommaPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CommaPlaceHolder(C11TemplateParser.Fm_CommaPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_CommaPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CommaPlaceHolder(C11TemplateParser.Fm_CommaPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AssignPlaceHolder(C11TemplateParser.Fm_AssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AssignPlaceHolder(C11TemplateParser.Fm_AssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_StarAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_StarAssignPlaceHolder(C11TemplateParser.Fm_StarAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_StarAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_StarAssignPlaceHolder(C11TemplateParser.Fm_StarAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_DivAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DivAssignPlaceHolder(C11TemplateParser.Fm_DivAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_DivAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DivAssignPlaceHolder(C11TemplateParser.Fm_DivAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ModAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ModAssignPlaceHolder(C11TemplateParser.Fm_ModAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ModAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ModAssignPlaceHolder(C11TemplateParser.Fm_ModAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_PlusAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PlusAssignPlaceHolder(C11TemplateParser.Fm_PlusAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_PlusAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PlusAssignPlaceHolder(C11TemplateParser.Fm_PlusAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_MinusAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MinusAssignPlaceHolder(C11TemplateParser.Fm_MinusAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_MinusAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MinusAssignPlaceHolder(C11TemplateParser.Fm_MinusAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LeftShiftAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LeftShiftAssignPlaceHolder(C11TemplateParser.Fm_LeftShiftAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LeftShiftAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LeftShiftAssignPlaceHolder(C11TemplateParser.Fm_LeftShiftAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_RightShiftAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RightShiftAssignPlaceHolder(C11TemplateParser.Fm_RightShiftAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_RightShiftAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RightShiftAssignPlaceHolder(C11TemplateParser.Fm_RightShiftAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AndAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AndAssignPlaceHolder(C11TemplateParser.Fm_AndAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AndAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AndAssignPlaceHolder(C11TemplateParser.Fm_AndAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_XorAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_XorAssignPlaceHolder(C11TemplateParser.Fm_XorAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_XorAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_XorAssignPlaceHolder(C11TemplateParser.Fm_XorAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_OrAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_OrAssignPlaceHolder(C11TemplateParser.Fm_OrAssignPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_OrAssignPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_OrAssignPlaceHolder(C11TemplateParser.Fm_OrAssignPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_EqualPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_EqualPlaceHolder(C11TemplateParser.Fm_EqualPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_EqualPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_EqualPlaceHolder(C11TemplateParser.Fm_EqualPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_NotEqualPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NotEqualPlaceHolder(C11TemplateParser.Fm_NotEqualPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_NotEqualPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NotEqualPlaceHolder(C11TemplateParser.Fm_NotEqualPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ArrowPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ArrowPlaceHolder(C11TemplateParser.Fm_ArrowPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ArrowPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ArrowPlaceHolder(C11TemplateParser.Fm_ArrowPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_DotPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DotPlaceHolder(C11TemplateParser.Fm_DotPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_DotPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DotPlaceHolder(C11TemplateParser.Fm_DotPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_EllipsisPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_EllipsisPlaceHolder(C11TemplateParser.Fm_EllipsisPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_EllipsisPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_EllipsisPlaceHolder(C11TemplateParser.Fm_EllipsisPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_IdentifierPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IdentifierPlaceHolder(C11TemplateParser.Fm_IdentifierPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_IdentifierPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IdentifierPlaceHolder(C11TemplateParser.Fm_IdentifierPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ConstantPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ConstantPlaceHolder(C11TemplateParser.Fm_ConstantPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ConstantPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ConstantPlaceHolder(C11TemplateParser.Fm_ConstantPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_StringLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_StringLiteralPlaceHolder(C11TemplateParser.Fm_StringLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_StringLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_StringLiteralPlaceHolder(C11TemplateParser.Fm_StringLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_ComplexDefinePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ComplexDefinePlaceHolder(C11TemplateParser.Fm_ComplexDefinePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_ComplexDefinePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ComplexDefinePlaceHolder(C11TemplateParser.Fm_ComplexDefinePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_AsmBlockPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AsmBlockPlaceHolder(C11TemplateParser.Fm_AsmBlockPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_AsmBlockPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AsmBlockPlaceHolder(C11TemplateParser.Fm_AsmBlockPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LineAfterPreprocessingPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LineAfterPreprocessingPlaceHolder(C11TemplateParser.Fm_LineAfterPreprocessingPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LineAfterPreprocessingPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LineAfterPreprocessingPlaceHolder(C11TemplateParser.Fm_LineAfterPreprocessingPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LineDirectivePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LineDirectivePlaceHolder(C11TemplateParser.Fm_LineDirectivePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LineDirectivePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LineDirectivePlaceHolder(C11TemplateParser.Fm_LineDirectivePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_PragmaDirectivePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PragmaDirectivePlaceHolder(C11TemplateParser.Fm_PragmaDirectivePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_PragmaDirectivePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PragmaDirectivePlaceHolder(C11TemplateParser.Fm_PragmaDirectivePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_WhitespacePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_WhitespacePlaceHolder(C11TemplateParser.Fm_WhitespacePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_WhitespacePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_WhitespacePlaceHolder(C11TemplateParser.Fm_WhitespacePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_NewlinePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NewlinePlaceHolder(C11TemplateParser.Fm_NewlinePlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_NewlinePlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NewlinePlaceHolder(C11TemplateParser.Fm_NewlinePlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_BlockCommentPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BlockCommentPlaceHolder(C11TemplateParser.Fm_BlockCommentPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_BlockCommentPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BlockCommentPlaceHolder(C11TemplateParser.Fm_BlockCommentPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LineCommentPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LineCommentPlaceHolder(C11TemplateParser.Fm_LineCommentPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LineCommentPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LineCommentPlaceHolder(C11TemplateParser.Fm_LineCommentPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifierRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclarationSpecifierRParenIfLoop(C11TemplateParser.Fm_LParendeclarationSpecifierRParenIfLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifierRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclarationSpecifierRParenIfLoop(C11TemplateParser.Fm_LParendeclarationSpecifierRParenIfLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop(C11TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoop(C11TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenIfLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar(C11TemplateParser.Fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStar(C11TemplateParser.Fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParenlogicalOrExpressionRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclarationSpecifierRParenStar(C11TemplateParser.Fm_LParendeclarationSpecifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclarationSpecifierRParenStar(C11TemplateParser.Fm_LParendeclarationSpecifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx4}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx4(C11TemplateParser.Fm_newRulexXXx4Context ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx4}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx4(C11TemplateParser.Fm_newRulexXXx4Context ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar(C11TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStar(C11TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar(C11TemplateParser.Fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStar(C11TemplateParser.Fm_LParenLParenfm_CommaPlaceHolderOrCommaRParenLParengccAttributeRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParengccDeclaratorExtensionRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengccDeclaratorExtensionRParenStar(C11TemplateParser.Fm_LParengccDeclaratorExtensionRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParengccDeclaratorExtensionRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengccDeclaratorExtensionRParenStar(C11TemplateParser.Fm_LParengccDeclaratorExtensionRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx6}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx6(C11TemplateParser.Fm_newRulexXXx6Context ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx6}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx6(C11TemplateParser.Fm_newRulexXXx6Context ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenexpressionRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionRParenQuestion(C11TemplateParser.Fm_LParenexpressionRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenexpressionRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionRParenQuestion(C11TemplateParser.Fm_LParenexpressionRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx3}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx3(C11TemplateParser.Fm_newRulexXXx3Context ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx3}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx3(C11TemplateParser.Fm_newRulexXXx3Context ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendesignationRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendesignationRParenQuestion(C11TemplateParser.Fm_LParendesignationRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendesignationRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendesignationRParenQuestion(C11TemplateParser.Fm_LParendesignationRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclarationListRParenQuestion(C11TemplateParser.Fm_LParendeclarationListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclarationListRParenQuestion(C11TemplateParser.Fm_LParendeclarationListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParentranslationUnitRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentranslationUnitRParenQuestion(C11TemplateParser.Fm_LParentranslationUnitRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParentranslationUnitRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentranslationUnitRParenQuestion(C11TemplateParser.Fm_LParentranslationUnitRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenblockItemListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockItemListRParenQuestion(C11TemplateParser.Fm_LParenblockItemListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenblockItemListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockItemListRParenQuestion(C11TemplateParser.Fm_LParenblockItemListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenabstractDeclaratorRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenabstractDeclaratorRParenQuestion(C11TemplateParser.Fm_LParenabstractDeclaratorRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenabstractDeclaratorRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenabstractDeclaratorRParenQuestion(C11TemplateParser.Fm_LParenabstractDeclaratorRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenassignmentExpressionRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenassignmentExpressionRParenQuestion(C11TemplateParser.Fm_LParenassignmentExpressionRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenassignmentExpressionRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenassignmentExpressionRParenQuestion(C11TemplateParser.Fm_LParenassignmentExpressionRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstructDeclaratorListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstructDeclaratorListRParenQuestion(C11TemplateParser.Fm_LParenstructDeclaratorListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstructDeclaratorListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstructDeclaratorListRParenQuestion(C11TemplateParser.Fm_LParenstructDeclaratorListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifiersRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclarationSpecifiersRParenQuestion(C11TemplateParser.Fm_LParendeclarationSpecifiersRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifiersRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclarationSpecifiersRParenQuestion(C11TemplateParser.Fm_LParendeclarationSpecifiersRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclaratorRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclaratorRParenQuestion(C11TemplateParser.Fm_LParendeclaratorRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclaratorRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclaratorRParenQuestion(C11TemplateParser.Fm_LParendeclaratorRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx0}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx0(C11TemplateParser.Fm_newRulexXXx0Context ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx0}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx0(C11TemplateParser.Fm_newRulexXXx0Context ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenargumentExpressionListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenargumentExpressionListRParenQuestion(C11TemplateParser.Fm_LParenargumentExpressionListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenargumentExpressionListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenargumentExpressionListRParenQuestion(C11TemplateParser.Fm_LParenargumentExpressionListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenpointerRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpointerRParenQuestion(C11TemplateParser.Fm_LParenpointerRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenpointerRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpointerRParenQuestion(C11TemplateParser.Fm_LParenpointerRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenidentifierListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenidentifierListRParenQuestion(C11TemplateParser.Fm_LParenidentifierListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenidentifierListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenidentifierListRParenQuestion(C11TemplateParser.Fm_LParenidentifierListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion(C11TemplateParser.Fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestion(C11TemplateParser.Fm_LParenLParenfm_ElsePlaceHolderOrElseRParenLParenstatementRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx5}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx5(C11TemplateParser.Fm_newRulexXXx5Context ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx5}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx5(C11TemplateParser.Fm_newRulexXXx5Context ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LPareninitDeclaratorListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninitDeclaratorListRParenQuestion(C11TemplateParser.Fm_LPareninitDeclaratorListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LPareninitDeclaratorListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninitDeclaratorListRParenQuestion(C11TemplateParser.Fm_LPareninitDeclaratorListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParentypeQualifierListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeQualifierListRParenQuestion(C11TemplateParser.Fm_LParentypeQualifierListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParentypeQualifierListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeQualifierListRParenQuestion(C11TemplateParser.Fm_LParentypeQualifierListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion(C11TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion(C11TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenparameterTypeListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenparameterTypeListRParenQuestion(C11TemplateParser.Fm_LParenparameterTypeListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenparameterTypeListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenparameterTypeListRParenQuestion(C11TemplateParser.Fm_LParenparameterTypeListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ElsePlaceHolderOrElseRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ElsePlaceHolderOrElseRParenOne(C11TemplateParser.Fm_LParenfm_ElsePlaceHolderOrElseRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ElsePlaceHolderOrElseRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ElsePlaceHolderOrElseRParenOne(C11TemplateParser.Fm_LParenfm_ElsePlaceHolderOrElseRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_GenericPlaceHolderOrGenericRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_GenericPlaceHolderOrGenericRParenOne(C11TemplateParser.Fm_LParenfm_GenericPlaceHolderOrGenericRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_GenericPlaceHolderOrGenericRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_GenericPlaceHolderOrGenericRParenOne(C11TemplateParser.Fm_LParenfm_GenericPlaceHolderOrGenericRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_FloatPlaceHolderOrFloatRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FloatPlaceHolderOrFloatRParenOne(C11TemplateParser.Fm_LParenfm_FloatPlaceHolderOrFloatRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_FloatPlaceHolderOrFloatRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FloatPlaceHolderOrFloatRParenOne(C11TemplateParser.Fm_LParenfm_FloatPlaceHolderOrFloatRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_TildePlaceHolderOrTildeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_TildePlaceHolderOrTildeRParenOne(C11TemplateParser.Fm_LParenfm_TildePlaceHolderOrTildeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_TildePlaceHolderOrTildeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_TildePlaceHolderOrTildeRParenOne(C11TemplateParser.Fm_LParenfm_TildePlaceHolderOrTildeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ColonPlaceHolderOrColonRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ColonPlaceHolderOrColonRParenOne(C11TemplateParser.Fm_LParenfm_ColonPlaceHolderOrColonRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ColonPlaceHolderOrColonRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ColonPlaceHolderOrColonRParenOne(C11TemplateParser.Fm_LParenfm_ColonPlaceHolderOrColonRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AutoPlaceHolderOrAutoRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AutoPlaceHolderOrAutoRParenOne(C11TemplateParser.Fm_LParenfm_AutoPlaceHolderOrAutoRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AutoPlaceHolderOrAutoRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AutoPlaceHolderOrAutoRParenOne(C11TemplateParser.Fm_LParenfm_AutoPlaceHolderOrAutoRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenlogicalOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlogicalOrExpressionRParenOne(C11TemplateParser.Fm_LParenlogicalOrExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenlogicalOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlogicalOrExpressionRParenOne(C11TemplateParser.Fm_LParenlogicalOrExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne(C11TemplateParser.Fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RightParenPlaceHolderOrRightParenRParenOne(C11TemplateParser.Fm_LParenfm_RightParenPlaceHolderOrRightParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne(C11TemplateParser.Fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOne(C11TemplateParser.Fm_LParenfm_EllipsisPlaceHolderOrEllipsisRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne(C11TemplateParser.Fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOne(C11TemplateParser.Fm_LParenfm_RightBracketPlaceHolderOrRightBracketRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DoPlaceHolderOrDoRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DoPlaceHolderOrDoRParenOne(C11TemplateParser.Fm_LParenfm_DoPlaceHolderOrDoRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DoPlaceHolderOrDoRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DoPlaceHolderOrDoRParenOne(C11TemplateParser.Fm_LParenfm_DoPlaceHolderOrDoRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_OrPlaceHolderOrOrRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_OrPlaceHolderOrOrRParenOne(C11TemplateParser.Fm_LParenfm_OrPlaceHolderOrOrRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_OrPlaceHolderOrOrRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_OrPlaceHolderOrOrRParenOne(C11TemplateParser.Fm_LParenfm_OrPlaceHolderOrOrRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne(C11TemplateParser.Fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOne(C11TemplateParser.Fm_LParenfm_PlusPlusPlaceHolderOrPlusPlusRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenexternalDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexternalDeclarationRParenOne(C11TemplateParser.Fm_LParenexternalDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenexternalDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexternalDeclarationRParenOne(C11TemplateParser.Fm_LParenexternalDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne(C11TemplateParser.Fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOne(C11TemplateParser.Fm_LParenfm_RightShiftAssignPlaceHolderOrRightShiftAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstructDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstructDeclarationRParenOne(C11TemplateParser.Fm_LParenstructDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstructDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstructDeclarationRParenOne(C11TemplateParser.Fm_LParenstructDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne(C11TemplateParser.Fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOne(C11TemplateParser.Fm_LParenfm_MinusAssignPlaceHolderOrMinusAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenlabeledStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlabeledStatementRParenOne(C11TemplateParser.Fm_LParenlabeledStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenlabeledStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlabeledStatementRParenOne(C11TemplateParser.Fm_LParenlabeledStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ShortPlaceHolderOrShortRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ShortPlaceHolderOrShortRParenOne(C11TemplateParser.Fm_LParenfm_ShortPlaceHolderOrShortRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ShortPlaceHolderOrShortRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ShortPlaceHolderOrShortRParenOne(C11TemplateParser.Fm_LParenfm_ShortPlaceHolderOrShortRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne(C11TemplateParser.Fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_TypedefPlaceHolderOrTypedefRParenOne(C11TemplateParser.Fm_LParenfm_TypedefPlaceHolderOrTypedefRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenparameterListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenparameterListRParenOne(C11TemplateParser.Fm_LParenparameterListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenparameterListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenparameterListRParenOne(C11TemplateParser.Fm_LParenparameterListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstorageClassSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstorageClassSpecifierRParenOne(C11TemplateParser.Fm_LParenstorageClassSpecifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstorageClassSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstorageClassSpecifierRParenOne(C11TemplateParser.Fm_LParenstorageClassSpecifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_CasePlaceHolderOrCaseRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CasePlaceHolderOrCaseRParenOne(C11TemplateParser.Fm_LParenfm_CasePlaceHolderOrCaseRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_CasePlaceHolderOrCaseRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CasePlaceHolderOrCaseRParenOne(C11TemplateParser.Fm_LParenfm_CasePlaceHolderOrCaseRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenenumerationConstantRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumerationConstantRParenOne(C11TemplateParser.Fm_LParenenumerationConstantRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenenumerationConstantRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumerationConstantRParenOne(C11TemplateParser.Fm_LParenenumerationConstantRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne(C11TemplateParser.Fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOne(C11TemplateParser.Fm_LParenfm_AndAssignPlaceHolderOrAndAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParengccAttributeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengccAttributeRParenOne(C11TemplateParser.Fm_LParengccAttributeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParengccAttributeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengccAttributeRParenOne(C11TemplateParser.Fm_LParengccAttributeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenconditionalExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconditionalExpressionRParenOne(C11TemplateParser.Fm_LParenconditionalExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenconditionalExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconditionalExpressionRParenOne(C11TemplateParser.Fm_LParenconditionalExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne(C11TemplateParser.Fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_OrOrPlaceHolderOrOrOrRParenOne(C11TemplateParser.Fm_LParenfm_OrOrPlaceHolderOrOrOrRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne(C11TemplateParser.Fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOne(C11TemplateParser.Fm_LParenfm_StaticAssertPlaceHolderOrStaticAssertRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendirectAbstractDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendirectAbstractDeclaratorRParenOne(C11TemplateParser.Fm_LParendirectAbstractDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendirectAbstractDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendirectAbstractDeclaratorRParenOne(C11TemplateParser.Fm_LParendirectAbstractDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne(C11TemplateParser.Fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOne(C11TemplateParser.Fm_LParenfm_NoreturnPlaceHolderOrNoreturnRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_GotoPlaceHolderOrGotoRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_GotoPlaceHolderOrGotoRParenOne(C11TemplateParser.Fm_LParenfm_GotoPlaceHolderOrGotoRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_GotoPlaceHolderOrGotoRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_GotoPlaceHolderOrGotoRParenOne(C11TemplateParser.Fm_LParenfm_GotoPlaceHolderOrGotoRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenabstractDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenabstractDeclaratorRParenOne(C11TemplateParser.Fm_LParenabstractDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenabstractDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenabstractDeclaratorRParenOne(C11TemplateParser.Fm_LParenabstractDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstructDeclarationListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstructDeclarationListRParenOne(C11TemplateParser.Fm_LParenstructDeclarationListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstructDeclarationListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstructDeclarationListRParenOne(C11TemplateParser.Fm_LParenstructDeclarationListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_InlinePlaceHolderOrInlineRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_InlinePlaceHolderOrInlineRParenOne(C11TemplateParser.Fm_LParenfm_InlinePlaceHolderOrInlineRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_InlinePlaceHolderOrInlineRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_InlinePlaceHolderOrInlineRParenOne(C11TemplateParser.Fm_LParenfm_InlinePlaceHolderOrInlineRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstructDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstructDeclaratorRParenOne(C11TemplateParser.Fm_LParenstructDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstructDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstructDeclaratorRParenOne(C11TemplateParser.Fm_LParenstructDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstatementRParenOne(C11TemplateParser.Fm_LParenstatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstatementRParenOne(C11TemplateParser.Fm_LParenstatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenparameterDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenparameterDeclarationRParenOne(C11TemplateParser.Fm_LParenparameterDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenparameterDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenparameterDeclarationRParenOne(C11TemplateParser.Fm_LParenparameterDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenprimaryExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryExpressionRParenOne(C11TemplateParser.Fm_LParenprimaryExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenprimaryExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryExpressionRParenOne(C11TemplateParser.Fm_LParenprimaryExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne(C11TemplateParser.Fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AlignofPlaceHolderOrAlignofRParenOne(C11TemplateParser.Fm_LParenfm_AlignofPlaceHolderOrAlignofRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_UnionPlaceHolderOrUnionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_UnionPlaceHolderOrUnionRParenOne(C11TemplateParser.Fm_LParenfm_UnionPlaceHolderOrUnionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_UnionPlaceHolderOrUnionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_UnionPlaceHolderOrUnionRParenOne(C11TemplateParser.Fm_LParenfm_UnionPlaceHolderOrUnionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne(C11TemplateParser.Fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOne(C11TemplateParser.Fm_LParenFM_ImplicitToken11OrFM_ImplicitToken12OrFM_ImplicitToken13RParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclaratorRParenOne(C11TemplateParser.Fm_LParendeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclaratorRParenOne(C11TemplateParser.Fm_LParendeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne(C11TemplateParser.Fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOne(C11TemplateParser.Fm_LParenfm_DivAssignPlaceHolderOrDivAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx1}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx1(C11TemplateParser.Fm_newRulexXXx1Context ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx1}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx1(C11TemplateParser.Fm_newRulexXXx1Context ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_CommaPlaceHolderOrCommaRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CommaPlaceHolderOrCommaRParenOne(C11TemplateParser.Fm_LParenfm_CommaPlaceHolderOrCommaRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_CommaPlaceHolderOrCommaRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CommaPlaceHolderOrCommaRParenOne(C11TemplateParser.Fm_LParenfm_CommaPlaceHolderOrCommaRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenexclusiveOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexclusiveOrExpressionRParenOne(C11TemplateParser.Fm_LParenexclusiveOrExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenexclusiveOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexclusiveOrExpressionRParenOne(C11TemplateParser.Fm_LParenexclusiveOrExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StructPlaceHolderOrStructRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StructPlaceHolderOrStructRParenOne(C11TemplateParser.Fm_LParenfm_StructPlaceHolderOrStructRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StructPlaceHolderOrStructRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StructPlaceHolderOrStructRParenOne(C11TemplateParser.Fm_LParenfm_StructPlaceHolderOrStructRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ModPlaceHolderOrModRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ModPlaceHolderOrModRParenOne(C11TemplateParser.Fm_LParenfm_ModPlaceHolderOrModRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ModPlaceHolderOrModRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ModPlaceHolderOrModRParenOne(C11TemplateParser.Fm_LParenfm_ModPlaceHolderOrModRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ComplexPlaceHolderOrComplexRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ComplexPlaceHolderOrComplexRParenOne(C11TemplateParser.Fm_LParenfm_ComplexPlaceHolderOrComplexRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ComplexPlaceHolderOrComplexRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ComplexPlaceHolderOrComplexRParenOne(C11TemplateParser.Fm_LParenfm_ComplexPlaceHolderOrComplexRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenatomicTypeSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenatomicTypeSpecifierRParenOne(C11TemplateParser.Fm_LParenatomicTypeSpecifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenatomicTypeSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenatomicTypeSpecifierRParenOne(C11TemplateParser.Fm_LParenatomicTypeSpecifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ArrowPlaceHolderOrArrowRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ArrowPlaceHolderOrArrowRParenOne(C11TemplateParser.Fm_LParenfm_ArrowPlaceHolderOrArrowRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ArrowPlaceHolderOrArrowRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ArrowPlaceHolderOrArrowRParenOne(C11TemplateParser.Fm_LParenfm_ArrowPlaceHolderOrArrowRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_IfPlaceHolderOrIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IfPlaceHolderOrIfRParenOne(C11TemplateParser.Fm_LParenfm_IfPlaceHolderOrIfRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_IfPlaceHolderOrIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IfPlaceHolderOrIfRParenOne(C11TemplateParser.Fm_LParenfm_IfPlaceHolderOrIfRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx2}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx2(C11TemplateParser.Fm_newRulexXXx2Context ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_newRulexXXx2}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx2(C11TemplateParser.Fm_newRulexXXx2Context ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ForPlaceHolderOrForRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ForPlaceHolderOrForRParenOne(C11TemplateParser.Fm_LParenfm_ForPlaceHolderOrForRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ForPlaceHolderOrForRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ForPlaceHolderOrForRParenOne(C11TemplateParser.Fm_LParenfm_ForPlaceHolderOrForRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus(C11TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlus(C11TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOnePlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstructOrUnionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstructOrUnionRParenOne(C11TemplateParser.Fm_LParenstructOrUnionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstructOrUnionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstructOrUnionRParenOne(C11TemplateParser.Fm_LParenstructOrUnionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne(C11TemplateParser.Fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AtomicPlaceHolderOrAtomicRParenOne(C11TemplateParser.Fm_LParenfm_AtomicPlaceHolderOrAtomicRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenadditiveExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenadditiveExpressionRParenOne(C11TemplateParser.Fm_LParenadditiveExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenadditiveExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenadditiveExpressionRParenOne(C11TemplateParser.Fm_LParenadditiveExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StaticPlaceHolderOrStaticRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StaticPlaceHolderOrStaticRParenOne(C11TemplateParser.Fm_LParenfm_StaticPlaceHolderOrStaticRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StaticPlaceHolderOrStaticRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StaticPlaceHolderOrStaticRParenOne(C11TemplateParser.Fm_LParenfm_StaticPlaceHolderOrStaticRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne(C11TemplateParser.Fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOne(C11TemplateParser.Fm_LParenFM_ImplicitToken20OrFM_ImplicitToken21RParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne(C11TemplateParser.Fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DefaultPlaceHolderOrDefaultRParenOne(C11TemplateParser.Fm_LParenfm_DefaultPlaceHolderOrDefaultRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenpostfixExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpostfixExpressionRParenOne(C11TemplateParser.Fm_LParenpostfixExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenpostfixExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpostfixExpressionRParenOne(C11TemplateParser.Fm_LParenpostfixExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne(C11TemplateParser.Fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOne(C11TemplateParser.Fm_LParenfm_StarAssignPlaceHolderOrStarAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParencompoundStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencompoundStatementRParenOne(C11TemplateParser.Fm_LParencompoundStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParencompoundStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencompoundStatementRParenOne(C11TemplateParser.Fm_LParencompoundStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ContinuePlaceHolderOrContinueRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ContinuePlaceHolderOrContinueRParenOne(C11TemplateParser.Fm_LParenfm_ContinuePlaceHolderOrContinueRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ContinuePlaceHolderOrContinueRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ContinuePlaceHolderOrContinueRParenOne(C11TemplateParser.Fm_LParenfm_ContinuePlaceHolderOrContinueRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LongPlaceHolderOrLongRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LongPlaceHolderOrLongRParenOne(C11TemplateParser.Fm_LParenfm_LongPlaceHolderOrLongRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LongPlaceHolderOrLongRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LongPlaceHolderOrLongRParenOne(C11TemplateParser.Fm_LParenfm_LongPlaceHolderOrLongRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne(C11TemplateParser.Fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOne(C11TemplateParser.Fm_LParenLParenfm_VolatilePlaceHolderOrVolatileRParenOrFM_ImplicitToken22RParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenmultiplicativeExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmultiplicativeExpressionRParenOne(C11TemplateParser.Fm_LParenmultiplicativeExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenmultiplicativeExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmultiplicativeExpressionRParenOne(C11TemplateParser.Fm_LParenmultiplicativeExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LessPlaceHolderOrLessRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LessPlaceHolderOrLessRParenOne(C11TemplateParser.Fm_LParenfm_LessPlaceHolderOrLessRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LessPlaceHolderOrLessRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LessPlaceHolderOrLessRParenOne(C11TemplateParser.Fm_LParenfm_LessPlaceHolderOrLessRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne(C11TemplateParser.Fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOne(C11TemplateParser.Fm_LParenfm_GreaterEqualPlaceHolderOrGreaterEqualRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenselectionStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenselectionStatementRParenOne(C11TemplateParser.Fm_LParenselectionStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenselectionStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenselectionStatementRParenOne(C11TemplateParser.Fm_LParenselectionStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne(C11TemplateParser.Fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOne(C11TemplateParser.Fm_LParenfm_ModAssignPlaceHolderOrModAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne(C11TemplateParser.Fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOne(C11TemplateParser.Fm_LParenfm_LeftBracePlaceHolderOrLeftBraceRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LPareniterationStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareniterationStatementRParenOne(C11TemplateParser.Fm_LPareniterationStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LPareniterationStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareniterationStatementRParenOne(C11TemplateParser.Fm_LPareniterationStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne(C11TemplateParser.Fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOne(C11TemplateParser.Fm_LParenfm_OrAssignPlaceHolderOrOrAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParengccAttributeSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengccAttributeSpecifierRParenOne(C11TemplateParser.Fm_LParengccAttributeSpecifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParengccAttributeSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengccAttributeSpecifierRParenOne(C11TemplateParser.Fm_LParengccAttributeSpecifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifierRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclarationSpecifierRParenOnePlus(C11TemplateParser.Fm_LParendeclarationSpecifierRParenOnePlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifierRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclarationSpecifierRParenOnePlus(C11TemplateParser.Fm_LParendeclarationSpecifierRParenOnePlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne(C11TemplateParser.Fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOne(C11TemplateParser.Fm_LParenfm_NotEqualPlaceHolderOrNotEqualRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifiersRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclarationSpecifiersRParenOne(C11TemplateParser.Fm_LParendeclarationSpecifiersRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifiersRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclarationSpecifiersRParenOne(C11TemplateParser.Fm_LParendeclarationSpecifiersRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfunctionSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfunctionSpecifierRParenOne(C11TemplateParser.Fm_LParenfunctionSpecifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfunctionSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfunctionSpecifierRParenOne(C11TemplateParser.Fm_LParenfunctionSpecifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LPareninclusiveOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninclusiveOrExpressionRParenOne(C11TemplateParser.Fm_LPareninclusiveOrExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LPareninclusiveOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninclusiveOrExpressionRParenOne(C11TemplateParser.Fm_LPareninclusiveOrExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_PlusPlaceHolderOrPlusRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PlusPlaceHolderOrPlusRParenOne(C11TemplateParser.Fm_LParenfm_PlusPlaceHolderOrPlusRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_PlusPlaceHolderOrPlusRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PlusPlaceHolderOrPlusRParenOne(C11TemplateParser.Fm_LParenfm_PlusPlaceHolderOrPlusRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne(C11TemplateParser.Fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SizeofPlaceHolderOrSizeofRParenOne(C11TemplateParser.Fm_LParenfm_SizeofPlaceHolderOrSizeofRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_SemiPlaceHolderOrSemiRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SemiPlaceHolderOrSemiRParenOne(C11TemplateParser.Fm_LParenfm_SemiPlaceHolderOrSemiRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_SemiPlaceHolderOrSemiRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SemiPlaceHolderOrSemiRParenOne(C11TemplateParser.Fm_LParenfm_SemiPlaceHolderOrSemiRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenblockItemRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockItemRParenOne(C11TemplateParser.Fm_LParenblockItemRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenblockItemRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockItemRParenOne(C11TemplateParser.Fm_LParenblockItemRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParentypeQualifierListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeQualifierListRParenOne(C11TemplateParser.Fm_LParentypeQualifierListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParentypeQualifierListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeQualifierListRParenOne(C11TemplateParser.Fm_LParentypeQualifierListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne(C11TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne(C11TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendesignatorListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendesignatorListRParenOne(C11TemplateParser.Fm_LParendesignatorListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendesignatorListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendesignatorListRParenOne(C11TemplateParser.Fm_LParendesignatorListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfunctionDefinitionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfunctionDefinitionRParenOne(C11TemplateParser.Fm_LParenfunctionDefinitionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfunctionDefinitionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfunctionDefinitionRParenOne(C11TemplateParser.Fm_LParenfunctionDefinitionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_BoolPlaceHolderOrBoolRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BoolPlaceHolderOrBoolRParenOne(C11TemplateParser.Fm_LParenfm_BoolPlaceHolderOrBoolRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_BoolPlaceHolderOrBoolRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BoolPlaceHolderOrBoolRParenOne(C11TemplateParser.Fm_LParenfm_BoolPlaceHolderOrBoolRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenenumeratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumeratorRParenOne(C11TemplateParser.Fm_LParenenumeratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenenumeratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumeratorRParenOne(C11TemplateParser.Fm_LParenenumeratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenexpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionRParenOne(C11TemplateParser.Fm_LParenexpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenexpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionRParenOne(C11TemplateParser.Fm_LParenexpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenconstantExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstantExpressionRParenOne(C11TemplateParser.Fm_LParenconstantExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenconstantExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstantExpressionRParenOne(C11TemplateParser.Fm_LParenconstantExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne(C11TemplateParser.Fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOne(C11TemplateParser.Fm_LParenfm_MinusMinusPlaceHolderOrMinusMinusRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_CaretPlaceHolderOrCaretRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CaretPlaceHolderOrCaretRParenOne(C11TemplateParser.Fm_LParenfm_CaretPlaceHolderOrCaretRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_CaretPlaceHolderOrCaretRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CaretPlaceHolderOrCaretRParenOne(C11TemplateParser.Fm_LParenfm_CaretPlaceHolderOrCaretRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StarPlaceHolderOrStarRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StarPlaceHolderOrStarRParenOne(C11TemplateParser.Fm_LParenfm_StarPlaceHolderOrStarRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_StarPlaceHolderOrStarRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StarPlaceHolderOrStarRParenOne(C11TemplateParser.Fm_LParenfm_StarPlaceHolderOrStarRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParentypeSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeSpecifierRParenOne(C11TemplateParser.Fm_LParentypeSpecifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParentypeSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeSpecifierRParenOne(C11TemplateParser.Fm_LParentypeSpecifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclarationRParenOne(C11TemplateParser.Fm_LParendeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclarationRParenOne(C11TemplateParser.Fm_LParendeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DotPlaceHolderOrDotRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DotPlaceHolderOrDotRParenOne(C11TemplateParser.Fm_LParenfm_DotPlaceHolderOrDotRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DotPlaceHolderOrDotRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DotPlaceHolderOrDotRParenOne(C11TemplateParser.Fm_LParenfm_DotPlaceHolderOrDotRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LPareninitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninitializerRParenOne(C11TemplateParser.Fm_LPareninitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LPareninitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninitializerRParenOne(C11TemplateParser.Fm_LPareninitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenenumSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumSpecifierRParenOne(C11TemplateParser.Fm_LParenenumSpecifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenenumSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumSpecifierRParenOne(C11TemplateParser.Fm_LParenenumSpecifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenjumpStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenjumpStatementRParenOne(C11TemplateParser.Fm_LParenjumpStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenjumpStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenjumpStatementRParenOne(C11TemplateParser.Fm_LParenjumpStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_IntPlaceHolderOrIntRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IntPlaceHolderOrIntRParenOne(C11TemplateParser.Fm_LParenfm_IntPlaceHolderOrIntRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_IntPlaceHolderOrIntRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IntPlaceHolderOrIntRParenOne(C11TemplateParser.Fm_LParenfm_IntPlaceHolderOrIntRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ConstantPlaceHolderOrConstantRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ConstantPlaceHolderOrConstantRParenOne(C11TemplateParser.Fm_LParenfm_ConstantPlaceHolderOrConstantRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ConstantPlaceHolderOrConstantRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ConstantPlaceHolderOrConstantRParenOne(C11TemplateParser.Fm_LParenfm_ConstantPlaceHolderOrConstantRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne(C11TemplateParser.Fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AlignasPlaceHolderOrAlignasRParenOne(C11TemplateParser.Fm_LParenfm_AlignasPlaceHolderOrAlignasRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_SignedPlaceHolderOrSignedRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SignedPlaceHolderOrSignedRParenOne(C11TemplateParser.Fm_LParenfm_SignedPlaceHolderOrSignedRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_SignedPlaceHolderOrSignedRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SignedPlaceHolderOrSignedRParenOne(C11TemplateParser.Fm_LParenfm_SignedPlaceHolderOrSignedRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenandExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenandExpressionRParenOne(C11TemplateParser.Fm_LParenandExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenandExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenandExpressionRParenOne(C11TemplateParser.Fm_LParenandExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendesignatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendesignatorRParenOne(C11TemplateParser.Fm_LParendesignatorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendesignatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendesignatorRParenOne(C11TemplateParser.Fm_LParendesignatorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstaticAssertDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstaticAssertDeclarationRParenOne(C11TemplateParser.Fm_LParenstaticAssertDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstaticAssertDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstaticAssertDeclarationRParenOne(C11TemplateParser.Fm_LParenstaticAssertDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_CharPlaceHolderOrCharRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CharPlaceHolderOrCharRParenOne(C11TemplateParser.Fm_LParenfm_CharPlaceHolderOrCharRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_CharPlaceHolderOrCharRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CharPlaceHolderOrCharRParenOne(C11TemplateParser.Fm_LParenfm_CharPlaceHolderOrCharRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne(C11TemplateParser.Fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOne(C11TemplateParser.Fm_LParenfm_PlusAssignPlaceHolderOrPlusAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_EqualPlaceHolderOrEqualRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_EqualPlaceHolderOrEqualRParenOne(C11TemplateParser.Fm_LParenfm_EqualPlaceHolderOrEqualRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_EqualPlaceHolderOrEqualRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_EqualPlaceHolderOrEqualRParenOne(C11TemplateParser.Fm_LParenfm_EqualPlaceHolderOrEqualRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne(C11TemplateParser.Fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_GreaterPlaceHolderOrGreaterRParenOne(C11TemplateParser.Fm_LParenfm_GreaterPlaceHolderOrGreaterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_WhilePlaceHolderOrWhileRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_WhilePlaceHolderOrWhileRParenOne(C11TemplateParser.Fm_LParenfm_WhilePlaceHolderOrWhileRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_WhilePlaceHolderOrWhileRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_WhilePlaceHolderOrWhileRParenOne(C11TemplateParser.Fm_LParenfm_WhilePlaceHolderOrWhileRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendirectDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendirectDeclaratorRParenOne(C11TemplateParser.Fm_LParendirectDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendirectDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendirectDeclaratorRParenOne(C11TemplateParser.Fm_LParendirectDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenassignmentExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenassignmentExpressionRParenOne(C11TemplateParser.Fm_LParenassignmentExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenassignmentExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenassignmentExpressionRParenOne(C11TemplateParser.Fm_LParenassignmentExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_EnumPlaceHolderOrEnumRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_EnumPlaceHolderOrEnumRParenOne(C11TemplateParser.Fm_LParenfm_EnumPlaceHolderOrEnumRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_EnumPlaceHolderOrEnumRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_EnumPlaceHolderOrEnumRParenOne(C11TemplateParser.Fm_LParenfm_EnumPlaceHolderOrEnumRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne(C11TemplateParser.Fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_QuestionPlaceHolderOrQuestionRParenOne(C11TemplateParser.Fm_LParenfm_QuestionPlaceHolderOrQuestionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ExternPlaceHolderOrExternRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ExternPlaceHolderOrExternRParenOne(C11TemplateParser.Fm_LParenfm_ExternPlaceHolderOrExternRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ExternPlaceHolderOrExternRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ExternPlaceHolderOrExternRParenOne(C11TemplateParser.Fm_LParenfm_ExternPlaceHolderOrExternRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ReturnPlaceHolderOrReturnRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ReturnPlaceHolderOrReturnRParenOne(C11TemplateParser.Fm_LParenfm_ReturnPlaceHolderOrReturnRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ReturnPlaceHolderOrReturnRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ReturnPlaceHolderOrReturnRParenOne(C11TemplateParser.Fm_LParenfm_ReturnPlaceHolderOrReturnRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne(C11TemplateParser.Fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOne(C11TemplateParser.Fm_LParenfm_LeftBracketPlaceHolderOrLeftBracketRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne(C11TemplateParser.Fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RestrictPlaceHolderOrRestrictRParenOne(C11TemplateParser.Fm_LParenfm_RestrictPlaceHolderOrRestrictRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParencastExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencastExpressionRParenOne(C11TemplateParser.Fm_LParencastExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParencastExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencastExpressionRParenOne(C11TemplateParser.Fm_LParencastExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_VoidPlaceHolderOrVoidRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_VoidPlaceHolderOrVoidRParenOne(C11TemplateParser.Fm_LParenfm_VoidPlaceHolderOrVoidRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_VoidPlaceHolderOrVoidRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_VoidPlaceHolderOrVoidRParenOne(C11TemplateParser.Fm_LParenfm_VoidPlaceHolderOrVoidRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenspecifierQualifierListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenspecifierQualifierListRParenOne(C11TemplateParser.Fm_LParenspecifierQualifierListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenspecifierQualifierListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenspecifierQualifierListRParenOne(C11TemplateParser.Fm_LParenspecifierQualifierListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_BreakPlaceHolderOrBreakRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BreakPlaceHolderOrBreakRParenOne(C11TemplateParser.Fm_LParenfm_BreakPlaceHolderOrBreakRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_BreakPlaceHolderOrBreakRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BreakPlaceHolderOrBreakRParenOne(C11TemplateParser.Fm_LParenfm_BreakPlaceHolderOrBreakRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_NotPlaceHolderOrNotRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NotPlaceHolderOrNotRParenOne(C11TemplateParser.Fm_LParenfm_NotPlaceHolderOrNotRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_NotPlaceHolderOrNotRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NotPlaceHolderOrNotRParenOne(C11TemplateParser.Fm_LParenfm_NotPlaceHolderOrNotRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_MinusPlaceHolderOrMinusRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MinusPlaceHolderOrMinusRParenOne(C11TemplateParser.Fm_LParenfm_MinusPlaceHolderOrMinusRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_MinusPlaceHolderOrMinusRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MinusPlaceHolderOrMinusRParenOne(C11TemplateParser.Fm_LParenfm_MinusPlaceHolderOrMinusRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne(C11TemplateParser.Fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOne(C11TemplateParser.Fm_LParenfm_XorAssignPlaceHolderOrXorAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne(C11TemplateParser.Fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RegisterPlaceHolderOrRegisterRParenOne(C11TemplateParser.Fm_LParenfm_RegisterPlaceHolderOrRegisterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne(C11TemplateParser.Fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOne(C11TemplateParser.Fm_LParenfm_LessEqualPlaceHolderOrLessEqualRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AndPlaceHolderOrAndRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AndPlaceHolderOrAndRParenOne(C11TemplateParser.Fm_LParenfm_AndPlaceHolderOrAndRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AndPlaceHolderOrAndRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AndPlaceHolderOrAndRParenOne(C11TemplateParser.Fm_LParenfm_AndPlaceHolderOrAndRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParentypeQualifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeQualifierRParenOne(C11TemplateParser.Fm_LParentypeQualifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParentypeQualifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeQualifierRParenOne(C11TemplateParser.Fm_LParentypeQualifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DoublePlaceHolderOrDoubleRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DoublePlaceHolderOrDoubleRParenOne(C11TemplateParser.Fm_LParenfm_DoublePlaceHolderOrDoubleRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DoublePlaceHolderOrDoubleRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DoublePlaceHolderOrDoubleRParenOne(C11TemplateParser.Fm_LParenfm_DoublePlaceHolderOrDoubleRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenunaryExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunaryExpressionRParenOne(C11TemplateParser.Fm_LParenunaryExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenunaryExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunaryExpressionRParenOne(C11TemplateParser.Fm_LParenunaryExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne(C11TemplateParser.Fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOne(C11TemplateParser.Fm_LParenfm_LeftShiftPlaceHolderOrLeftShiftRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne(C11TemplateParser.Fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_VolatilePlaceHolderOrVolatileRParenOne(C11TemplateParser.Fm_LParenfm_VolatilePlaceHolderOrVolatileRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenenumeratorListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumeratorListRParenOne(C11TemplateParser.Fm_LParenenumeratorListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenenumeratorListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumeratorListRParenOne(C11TemplateParser.Fm_LParenenumeratorListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParentypedefNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypedefNameRParenOne(C11TemplateParser.Fm_LParentypedefNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParentypedefNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypedefNameRParenOne(C11TemplateParser.Fm_LParentypedefNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenrelationalExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenrelationalExpressionRParenOne(C11TemplateParser.Fm_LParenrelationalExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenrelationalExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenrelationalExpressionRParenOne(C11TemplateParser.Fm_LParenrelationalExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LPareninitializerListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninitializerListRParenOne(C11TemplateParser.Fm_LPareninitializerListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LPareninitializerListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninitializerListRParenOne(C11TemplateParser.Fm_LPareninitializerListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenpointerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpointerRParenOne(C11TemplateParser.Fm_LParenpointerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenpointerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpointerRParenOne(C11TemplateParser.Fm_LParenpointerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DivPlaceHolderOrDivRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DivPlaceHolderOrDivRParenOne(C11TemplateParser.Fm_LParenfm_DivPlaceHolderOrDivRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_DivPlaceHolderOrDivRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DivPlaceHolderOrDivRParenOne(C11TemplateParser.Fm_LParenfm_DivPlaceHolderOrDivRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenequalityExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenequalityExpressionRParenOne(C11TemplateParser.Fm_LParenequalityExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenequalityExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenequalityExpressionRParenOne(C11TemplateParser.Fm_LParenequalityExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LPareninitDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninitDeclaratorRParenOne(C11TemplateParser.Fm_LPareninitDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LPareninitDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninitDeclaratorRParenOne(C11TemplateParser.Fm_LPareninitDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParengenericAssociationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengenericAssociationRParenOne(C11TemplateParser.Fm_LParengenericAssociationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParengenericAssociationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengenericAssociationRParenOne(C11TemplateParser.Fm_LParengenericAssociationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParengenericSelectionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengenericSelectionRParenOne(C11TemplateParser.Fm_LParengenericSelectionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParengenericSelectionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengenericSelectionRParenOne(C11TemplateParser.Fm_LParengenericSelectionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenunaryOperatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunaryOperatorRParenOne(C11TemplateParser.Fm_LParenunaryOperatorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenunaryOperatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunaryOperatorRParenOne(C11TemplateParser.Fm_LParenunaryOperatorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne(C11TemplateParser.Fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AndAndPlaceHolderOrAndAndRParenOne(C11TemplateParser.Fm_LParenfm_AndAndPlaceHolderOrAndAndRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne(C11TemplateParser.Fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SwitchPlaceHolderOrSwitchRParenOne(C11TemplateParser.Fm_LParenfm_SwitchPlaceHolderOrSwitchRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenalignmentSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenalignmentSpecifierRParenOne(C11TemplateParser.Fm_LParenalignmentSpecifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenalignmentSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenalignmentSpecifierRParenOne(C11TemplateParser.Fm_LParenalignmentSpecifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne(C11TemplateParser.Fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOne(C11TemplateParser.Fm_LParenfm_LeftParenPlaceHolderOrLeftParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParengenericAssocListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengenericAssocListRParenOne(C11TemplateParser.Fm_LParengenericAssocListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParengenericAssocListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengenericAssocListRParenOne(C11TemplateParser.Fm_LParengenericAssocListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParengccAttributeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengccAttributeListRParenOne(C11TemplateParser.Fm_LParengccAttributeListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParengccAttributeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengccAttributeListRParenOne(C11TemplateParser.Fm_LParengccAttributeListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne(C11TemplateParser.Fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOne(C11TemplateParser.Fm_LParenfm_UnsignedPlaceHolderOrUnsignedRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenshiftExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenshiftExpressionRParenOne(C11TemplateParser.Fm_LParenshiftExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenshiftExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenshiftExpressionRParenOne(C11TemplateParser.Fm_LParenshiftExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifiers2RParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendeclarationSpecifiers2RParenOne(C11TemplateParser.Fm_LParendeclarationSpecifiers2RParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParendeclarationSpecifiers2RParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendeclarationSpecifiers2RParenOne(C11TemplateParser.Fm_LParendeclarationSpecifiers2RParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne(C11TemplateParser.Fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOne(C11TemplateParser.Fm_LParenfm_RightShiftPlaceHolderOrRightShiftRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne(C11TemplateParser.Fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOne(C11TemplateParser.Fm_LParenfm_LeftShiftAssignPlaceHolderOrLeftShiftAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenassignmentOperatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenassignmentOperatorRParenOne(C11TemplateParser.Fm_LParenassignmentOperatorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenassignmentOperatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenassignmentOperatorRParenOne(C11TemplateParser.Fm_LParenassignmentOperatorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenexpressionStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionStatementRParenOne(C11TemplateParser.Fm_LParenexpressionStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenexpressionStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionStatementRParenOne(C11TemplateParser.Fm_LParenexpressionStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AssignPlaceHolderOrAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AssignPlaceHolderOrAssignRParenOne(C11TemplateParser.Fm_LParenfm_AssignPlaceHolderOrAssignRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_AssignPlaceHolderOrAssignRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AssignPlaceHolderOrAssignRParenOne(C11TemplateParser.Fm_LParenfm_AssignPlaceHolderOrAssignRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ConstPlaceHolderOrConstRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ConstPlaceHolderOrConstRParenOne(C11TemplateParser.Fm_LParenfm_ConstPlaceHolderOrConstRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ConstPlaceHolderOrConstRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ConstPlaceHolderOrConstRParenOne(C11TemplateParser.Fm_LParenfm_ConstPlaceHolderOrConstRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne(C11TemplateParser.Fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOne(C11TemplateParser.Fm_LParenfm_ThreadLocalPlaceHolderOrThreadLocalRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenstructOrUnionSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstructOrUnionSpecifierRParenOne(C11TemplateParser.Fm_LParenstructOrUnionSpecifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenstructOrUnionSpecifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstructOrUnionSpecifierRParenOne(C11TemplateParser.Fm_LParenstructOrUnionSpecifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne(C11TemplateParser.Fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOne(C11TemplateParser.Fm_LParenfm_RightBracePlaceHolderOrRightBraceRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenparameterTypeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenparameterTypeListRParenOne(C11TemplateParser.Fm_LParenparameterTypeListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenparameterTypeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenparameterTypeListRParenOne(C11TemplateParser.Fm_LParenparameterTypeListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParenlogicalAndExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlogicalAndExpressionRParenOne(C11TemplateParser.Fm_LParenlogicalAndExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParenlogicalAndExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlogicalAndExpressionRParenOne(C11TemplateParser.Fm_LParenlogicalAndExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link C11TemplateParser#fm_LParentypeNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeNameRParenOne(C11TemplateParser.Fm_LParentypeNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link C11TemplateParser#fm_LParentypeNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeNameRParenOne(C11TemplateParser.Fm_LParentypeNameRParenOneContext ctx);
}