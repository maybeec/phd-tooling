// Generated from C:\Projects\cobigen\workspaces\approach2\cobigen\MA_manual_merge\manual_merge\src\main\java\java8TemplateParser\Java8Template.g4 by ANTLR 4.5.1
package java8TemplateParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Java8TemplateParser}.
 */
public interface Java8TemplateListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Java8TemplateParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Java8TemplateParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Java8TemplateParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Java8TemplateParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(Java8TemplateParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(Java8TemplateParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(Java8TemplateParser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(Java8TemplateParser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(Java8TemplateParser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(Java8TemplateParser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(Java8TemplateParser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(Java8TemplateParser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(Java8TemplateParser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(Java8TemplateParser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(Java8TemplateParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(Java8TemplateParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(Java8TemplateParser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(Java8TemplateParser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassType_lf_classOrInterfaceType(Java8TemplateParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassType_lf_classOrInterfaceType(Java8TemplateParser.ClassType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassType_lfno_classOrInterfaceType(Java8TemplateParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassType_lfno_classOrInterfaceType(Java8TemplateParser.ClassType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType(Java8TemplateParser.InterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType(Java8TemplateParser.InterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType_lf_classOrInterfaceType(Java8TemplateParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceType_lf_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType_lf_classOrInterfaceType(Java8TemplateParser.InterfaceType_lf_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceType_lfno_classOrInterfaceType(Java8TemplateParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceType_lfno_classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceType_lfno_classOrInterfaceType(Java8TemplateParser.InterfaceType_lfno_classOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(Java8TemplateParser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(Java8TemplateParser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(Java8TemplateParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(Java8TemplateParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(Java8TemplateParser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(Java8TemplateParser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(Java8TemplateParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(Java8TemplateParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterModifier(Java8TemplateParser.TypeParameterModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterModifier(Java8TemplateParser.TypeParameterModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(Java8TemplateParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(Java8TemplateParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(Java8TemplateParser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(Java8TemplateParser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(Java8TemplateParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(Java8TemplateParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(Java8TemplateParser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(Java8TemplateParser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(Java8TemplateParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(Java8TemplateParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(Java8TemplateParser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(Java8TemplateParser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(Java8TemplateParser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(Java8TemplateParser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(Java8TemplateParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(Java8TemplateParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(Java8TemplateParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(Java8TemplateParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void enterPackageOrTypeName(Java8TemplateParser.PackageOrTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#packageOrTypeName}.
	 * @param ctx the parse tree
	 */
	void exitPackageOrTypeName(Java8TemplateParser.PackageOrTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(Java8TemplateParser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(Java8TemplateParser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodName}.
	 * @param ctx the parse tree
	 */
	void enterMethodName(Java8TemplateParser.MethodNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodName}.
	 * @param ctx the parse tree
	 */
	void exitMethodName(Java8TemplateParser.MethodNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void enterAmbiguousName(Java8TemplateParser.AmbiguousNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#ambiguousName}.
	 * @param ctx the parse tree
	 */
	void exitAmbiguousName(Java8TemplateParser.AmbiguousNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(Java8TemplateParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(Java8TemplateParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(Java8TemplateParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(Java8TemplateParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void enterPackageModifier(Java8TemplateParser.PackageModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#packageModifier}.
	 * @param ctx the parse tree
	 */
	void exitPackageModifier(Java8TemplateParser.PackageModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(Java8TemplateParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(Java8TemplateParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleTypeImportDeclaration(Java8TemplateParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#singleTypeImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleTypeImportDeclaration(Java8TemplateParser.SingleTypeImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeImportOnDemandDeclaration(Java8TemplateParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeImportOnDemandDeclaration(Java8TemplateParser.TypeImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterSingleStaticImportDeclaration(Java8TemplateParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#singleStaticImportDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitSingleStaticImportDeclaration(Java8TemplateParser.SingleStaticImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterStaticImportOnDemandDeclaration(Java8TemplateParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#staticImportOnDemandDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitStaticImportOnDemandDeclaration(Java8TemplateParser.StaticImportOnDemandDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(Java8TemplateParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(Java8TemplateParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(Java8TemplateParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(Java8TemplateParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalClassDeclaration(Java8TemplateParser.NormalClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#normalClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalClassDeclaration(Java8TemplateParser.NormalClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassModifier(Java8TemplateParser.ClassModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassModifier(Java8TemplateParser.ClassModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(Java8TemplateParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(Java8TemplateParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(Java8TemplateParser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(Java8TemplateParser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#superclass}.
	 * @param ctx the parse tree
	 */
	void enterSuperclass(Java8TemplateParser.SuperclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#superclass}.
	 * @param ctx the parse tree
	 */
	void exitSuperclass(Java8TemplateParser.SuperclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void enterSuperinterfaces(Java8TemplateParser.SuperinterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void exitSuperinterfaces(Java8TemplateParser.SuperinterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(Java8TemplateParser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(Java8TemplateParser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(Java8TemplateParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(Java8TemplateParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(Java8TemplateParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(Java8TemplateParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassMemberDeclaration(Java8TemplateParser.ClassMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassMemberDeclaration(Java8TemplateParser.ClassMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(Java8TemplateParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(Java8TemplateParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void enterFieldModifier(Java8TemplateParser.FieldModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fieldModifier}.
	 * @param ctx the parse tree
	 */
	void exitFieldModifier(Java8TemplateParser.FieldModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(Java8TemplateParser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(Java8TemplateParser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(Java8TemplateParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(Java8TemplateParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(Java8TemplateParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(Java8TemplateParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(Java8TemplateParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(Java8TemplateParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(Java8TemplateParser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(Java8TemplateParser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(Java8TemplateParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(Java8TemplateParser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType(Java8TemplateParser.UnannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType(Java8TemplateParser.UnannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(Java8TemplateParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(Java8TemplateParser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(Java8TemplateParser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(Java8TemplateParser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lf_unannClassOrInterfaceType(Java8TemplateParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lf_unannClassOrInterfaceType(Java8TemplateParser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lfno_unannClassOrInterfaceType(Java8TemplateParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lfno_unannClassOrInterfaceType(Java8TemplateParser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType(Java8TemplateParser.UnannInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType(Java8TemplateParser.UnannInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lf_unannClassOrInterfaceType(Java8TemplateParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lf_unannClassOrInterfaceType(Java8TemplateParser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(Java8TemplateParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(Java8TemplateParser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(Java8TemplateParser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(Java8TemplateParser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(Java8TemplateParser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(Java8TemplateParser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(Java8TemplateParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(Java8TemplateParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void enterMethodModifier(Java8TemplateParser.MethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodModifier}.
	 * @param ctx the parse tree
	 */
	void exitMethodModifier(Java8TemplateParser.MethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(Java8TemplateParser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(Java8TemplateParser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(Java8TemplateParser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(Java8TemplateParser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(Java8TemplateParser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(Java8TemplateParser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(Java8TemplateParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(Java8TemplateParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(Java8TemplateParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(Java8TemplateParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(Java8TemplateParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(Java8TemplateParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(Java8TemplateParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(Java8TemplateParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(Java8TemplateParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(Java8TemplateParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(Java8TemplateParser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(Java8TemplateParser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#throws_}.
	 * @param ctx the parse tree
	 */
	void enterThrows_(Java8TemplateParser.Throws_Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#throws_}.
	 * @param ctx the parse tree
	 */
	void exitThrows_(Java8TemplateParser.Throws_Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(Java8TemplateParser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(Java8TemplateParser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(Java8TemplateParser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(Java8TemplateParser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(Java8TemplateParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(Java8TemplateParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(Java8TemplateParser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(Java8TemplateParser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(Java8TemplateParser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(Java8TemplateParser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(Java8TemplateParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(Java8TemplateParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstructorModifier(Java8TemplateParser.ConstructorModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#constructorModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstructorModifier(Java8TemplateParser.ConstructorModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(Java8TemplateParser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(Java8TemplateParser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(Java8TemplateParser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(Java8TemplateParser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(Java8TemplateParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(Java8TemplateParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(Java8TemplateParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(Java8TemplateParser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(Java8TemplateParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(Java8TemplateParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(Java8TemplateParser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(Java8TemplateParser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(Java8TemplateParser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(Java8TemplateParser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(Java8TemplateParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(Java8TemplateParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantModifier(Java8TemplateParser.EnumConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enumConstantModifier}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantModifier(Java8TemplateParser.EnumConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(Java8TemplateParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(Java8TemplateParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(Java8TemplateParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(Java8TemplateParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(Java8TemplateParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(Java8TemplateParser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceModifier(Java8TemplateParser.InterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceModifier(Java8TemplateParser.InterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void enterExtendsInterfaces(Java8TemplateParser.ExtendsInterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void exitExtendsInterfaces(Java8TemplateParser.ExtendsInterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(Java8TemplateParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(Java8TemplateParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(Java8TemplateParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(Java8TemplateParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(Java8TemplateParser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(Java8TemplateParser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void enterConstantModifier(Java8TemplateParser.ConstantModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#constantModifier}.
	 * @param ctx the parse tree
	 */
	void exitConstantModifier(Java8TemplateParser.ConstantModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(Java8TemplateParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(Java8TemplateParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodModifier(Java8TemplateParser.InterfaceMethodModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#interfaceMethodModifier}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodModifier(Java8TemplateParser.InterfaceMethodModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(Java8TemplateParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(Java8TemplateParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(Java8TemplateParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(Java8TemplateParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeMemberDeclaration(Java8TemplateParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeMemberDeclaration(Java8TemplateParser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(Java8TemplateParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(Java8TemplateParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementModifier(Java8TemplateParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#annotationTypeElementModifier}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementModifier(Java8TemplateParser.AnnotationTypeElementModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(Java8TemplateParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(Java8TemplateParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(Java8TemplateParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(Java8TemplateParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(Java8TemplateParser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(Java8TemplateParser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(Java8TemplateParser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(Java8TemplateParser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(Java8TemplateParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(Java8TemplateParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(Java8TemplateParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(Java8TemplateParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(Java8TemplateParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(Java8TemplateParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(Java8TemplateParser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(Java8TemplateParser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(Java8TemplateParser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(Java8TemplateParser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(Java8TemplateParser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(Java8TemplateParser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(Java8TemplateParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(Java8TemplateParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(Java8TemplateParser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(Java8TemplateParser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Java8TemplateParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Java8TemplateParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(Java8TemplateParser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(Java8TemplateParser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(Java8TemplateParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(Java8TemplateParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(Java8TemplateParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(Java8TemplateParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(Java8TemplateParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(Java8TemplateParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Java8TemplateParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Java8TemplateParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(Java8TemplateParser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(Java8TemplateParser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(Java8TemplateParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(Java8TemplateParser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(Java8TemplateParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(Java8TemplateParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(Java8TemplateParser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(Java8TemplateParser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(Java8TemplateParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(Java8TemplateParser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(Java8TemplateParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(Java8TemplateParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(Java8TemplateParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(Java8TemplateParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(Java8TemplateParser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(Java8TemplateParser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(Java8TemplateParser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(Java8TemplateParser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(Java8TemplateParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(Java8TemplateParser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(Java8TemplateParser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(Java8TemplateParser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(Java8TemplateParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(Java8TemplateParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(Java8TemplateParser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(Java8TemplateParser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(Java8TemplateParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(Java8TemplateParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#switchLabels}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabels(Java8TemplateParser.SwitchLabelsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#switchLabels}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabels(Java8TemplateParser.SwitchLabelsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(Java8TemplateParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(Java8TemplateParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(Java8TemplateParser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(Java8TemplateParser.EnumConstantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(Java8TemplateParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(Java8TemplateParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(Java8TemplateParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(Java8TemplateParser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(Java8TemplateParser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(Java8TemplateParser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(Java8TemplateParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(Java8TemplateParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(Java8TemplateParser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(Java8TemplateParser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(Java8TemplateParser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(Java8TemplateParser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(Java8TemplateParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(Java8TemplateParser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(Java8TemplateParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(Java8TemplateParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(Java8TemplateParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(Java8TemplateParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(Java8TemplateParser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(Java8TemplateParser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(Java8TemplateParser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(Java8TemplateParser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(Java8TemplateParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(Java8TemplateParser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(Java8TemplateParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(Java8TemplateParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(Java8TemplateParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(Java8TemplateParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(Java8TemplateParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(Java8TemplateParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(Java8TemplateParser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(Java8TemplateParser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(Java8TemplateParser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(Java8TemplateParser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(Java8TemplateParser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(Java8TemplateParser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(Java8TemplateParser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(Java8TemplateParser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(Java8TemplateParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(Java8TemplateParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterCatchFormalParameter(Java8TemplateParser.CatchFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#catchFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitCatchFormalParameter(Java8TemplateParser.CatchFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(Java8TemplateParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(Java8TemplateParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#finally_}.
	 * @param ctx the parse tree
	 */
	void enterFinally_(Java8TemplateParser.Finally_Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#finally_}.
	 * @param ctx the parse tree
	 */
	void exitFinally_(Java8TemplateParser.Finally_Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(Java8TemplateParser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(Java8TemplateParser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(Java8TemplateParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(Java8TemplateParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(Java8TemplateParser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(Java8TemplateParser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(Java8TemplateParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(Java8TemplateParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(Java8TemplateParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(Java8TemplateParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray(Java8TemplateParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray(Java8TemplateParser.PrimaryNoNewArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_arrayAccess(Java8TemplateParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_arrayAccess(Java8TemplateParser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess(Java8TemplateParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess(Java8TemplateParser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary(Java8TemplateParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary(Java8TemplateParser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(Java8TemplateParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(Java8TemplateParser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(Java8TemplateParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(Java8TemplateParser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary(Java8TemplateParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary(Java8TemplateParser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(Java8TemplateParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(Java8TemplateParser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(Java8TemplateParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(Java8TemplateParser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(Java8TemplateParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(Java8TemplateParser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lf_primary(Java8TemplateParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lf_primary(Java8TemplateParser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lfno_primary(Java8TemplateParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lfno_primary(Java8TemplateParser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(Java8TemplateParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(Java8TemplateParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(Java8TemplateParser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(Java8TemplateParser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lf_primary(Java8TemplateParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lf_primary(Java8TemplateParser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lfno_primary(Java8TemplateParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lfno_primary(Java8TemplateParser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(Java8TemplateParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(Java8TemplateParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lf_primary(Java8TemplateParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lf_primary(Java8TemplateParser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lfno_primary(Java8TemplateParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lfno_primary(Java8TemplateParser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(Java8TemplateParser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(Java8TemplateParser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lf_primary(Java8TemplateParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lf_primary(Java8TemplateParser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary(Java8TemplateParser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary(Java8TemplateParser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(Java8TemplateParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(Java8TemplateParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(Java8TemplateParser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(Java8TemplateParser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lf_primary(Java8TemplateParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lf_primary(Java8TemplateParser.MethodReference_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lfno_primary(Java8TemplateParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lfno_primary(Java8TemplateParser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(Java8TemplateParser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(Java8TemplateParser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(Java8TemplateParser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(Java8TemplateParser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(Java8TemplateParser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(Java8TemplateParser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(Java8TemplateParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(Java8TemplateParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Java8TemplateParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Java8TemplateParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(Java8TemplateParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(Java8TemplateParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(Java8TemplateParser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(Java8TemplateParser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterInferredFormalParameterList(Java8TemplateParser.InferredFormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitInferredFormalParameterList(Java8TemplateParser.InferredFormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(Java8TemplateParser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(Java8TemplateParser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(Java8TemplateParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(Java8TemplateParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Java8TemplateParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Java8TemplateParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(Java8TemplateParser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(Java8TemplateParser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(Java8TemplateParser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(Java8TemplateParser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(Java8TemplateParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(Java8TemplateParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalOrExpression(Java8TemplateParser.ConditionalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#conditionalOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalOrExpression(Java8TemplateParser.ConditionalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalAndExpression(Java8TemplateParser.ConditionalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#conditionalAndExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalAndExpression(Java8TemplateParser.ConditionalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveOrExpression(Java8TemplateParser.InclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#inclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveOrExpression(Java8TemplateParser.InclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveOrExpression(Java8TemplateParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#exclusiveOrExpression}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveOrExpression(Java8TemplateParser.ExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(Java8TemplateParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#andExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(Java8TemplateParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(Java8TemplateParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#equalityExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(Java8TemplateParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(Java8TemplateParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#relationalExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(Java8TemplateParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(Java8TemplateParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(Java8TemplateParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(Java8TemplateParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#additiveExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(Java8TemplateParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(Java8TemplateParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(Java8TemplateParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(Java8TemplateParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(Java8TemplateParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(Java8TemplateParser.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#preIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(Java8TemplateParser.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecrementExpression(Java8TemplateParser.PreDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#preDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecrementExpression(Java8TemplateParser.PreDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpressionNotPlusMinus(Java8TemplateParser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#unaryExpressionNotPlusMinus}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpressionNotPlusMinus(Java8TemplateParser.UnaryExpressionNotPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(Java8TemplateParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(Java8TemplateParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(Java8TemplateParser.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#postIncrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(Java8TemplateParser.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression_lf_postfixExpression(Java8TemplateParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#postIncrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression_lf_postfixExpression(Java8TemplateParser.PostIncrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression(Java8TemplateParser.PostDecrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#postDecrementExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression(Java8TemplateParser.PostDecrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecrementExpression_lf_postfixExpression(Java8TemplateParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#postDecrementExpression_lf_postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecrementExpression_lf_postfixExpression(Java8TemplateParser.PostDecrementExpression_lf_postfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(Java8TemplateParser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(Java8TemplateParser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ABSTRACTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ABSTRACTPlaceHolder(Java8TemplateParser.Fm_ABSTRACTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ABSTRACTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ABSTRACTPlaceHolder(Java8TemplateParser.Fm_ABSTRACTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ASSERTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ASSERTPlaceHolder(Java8TemplateParser.Fm_ASSERTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ASSERTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ASSERTPlaceHolder(Java8TemplateParser.Fm_ASSERTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_BOOLEANPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BOOLEANPlaceHolder(Java8TemplateParser.Fm_BOOLEANPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_BOOLEANPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BOOLEANPlaceHolder(Java8TemplateParser.Fm_BOOLEANPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_BREAKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BREAKPlaceHolder(Java8TemplateParser.Fm_BREAKPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_BREAKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BREAKPlaceHolder(Java8TemplateParser.Fm_BREAKPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_BYTEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BYTEPlaceHolder(Java8TemplateParser.Fm_BYTEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_BYTEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BYTEPlaceHolder(Java8TemplateParser.Fm_BYTEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_CASEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CASEPlaceHolder(Java8TemplateParser.Fm_CASEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_CASEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CASEPlaceHolder(Java8TemplateParser.Fm_CASEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_CATCHPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CATCHPlaceHolder(Java8TemplateParser.Fm_CATCHPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_CATCHPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CATCHPlaceHolder(Java8TemplateParser.Fm_CATCHPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_CHARPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CHARPlaceHolder(Java8TemplateParser.Fm_CHARPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_CHARPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CHARPlaceHolder(Java8TemplateParser.Fm_CHARPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_CLASSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CLASSPlaceHolder(Java8TemplateParser.Fm_CLASSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_CLASSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CLASSPlaceHolder(Java8TemplateParser.Fm_CLASSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_CONSTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CONSTPlaceHolder(Java8TemplateParser.Fm_CONSTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_CONSTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CONSTPlaceHolder(Java8TemplateParser.Fm_CONSTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_CONTINUEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CONTINUEPlaceHolder(Java8TemplateParser.Fm_CONTINUEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_CONTINUEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CONTINUEPlaceHolder(Java8TemplateParser.Fm_CONTINUEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_DEFAULTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DEFAULTPlaceHolder(Java8TemplateParser.Fm_DEFAULTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_DEFAULTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DEFAULTPlaceHolder(Java8TemplateParser.Fm_DEFAULTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_DOPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DOPlaceHolder(Java8TemplateParser.Fm_DOPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_DOPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DOPlaceHolder(Java8TemplateParser.Fm_DOPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_DOUBLEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DOUBLEPlaceHolder(Java8TemplateParser.Fm_DOUBLEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_DOUBLEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DOUBLEPlaceHolder(Java8TemplateParser.Fm_DOUBLEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ELSEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ELSEPlaceHolder(Java8TemplateParser.Fm_ELSEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ELSEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ELSEPlaceHolder(Java8TemplateParser.Fm_ELSEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ENUMPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ENUMPlaceHolder(Java8TemplateParser.Fm_ENUMPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ENUMPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ENUMPlaceHolder(Java8TemplateParser.Fm_ENUMPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_EXTENDSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_EXTENDSPlaceHolder(Java8TemplateParser.Fm_EXTENDSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_EXTENDSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_EXTENDSPlaceHolder(Java8TemplateParser.Fm_EXTENDSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_FINALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FINALPlaceHolder(Java8TemplateParser.Fm_FINALPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_FINALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FINALPlaceHolder(Java8TemplateParser.Fm_FINALPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_FINALLYPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FINALLYPlaceHolder(Java8TemplateParser.Fm_FINALLYPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_FINALLYPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FINALLYPlaceHolder(Java8TemplateParser.Fm_FINALLYPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_FLOATPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FLOATPlaceHolder(Java8TemplateParser.Fm_FLOATPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_FLOATPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FLOATPlaceHolder(Java8TemplateParser.Fm_FLOATPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_FORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FORPlaceHolder(Java8TemplateParser.Fm_FORPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_FORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FORPlaceHolder(Java8TemplateParser.Fm_FORPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_IFPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IFPlaceHolder(Java8TemplateParser.Fm_IFPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_IFPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IFPlaceHolder(Java8TemplateParser.Fm_IFPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_GOTOPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GOTOPlaceHolder(Java8TemplateParser.Fm_GOTOPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_GOTOPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GOTOPlaceHolder(Java8TemplateParser.Fm_GOTOPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_IMPLEMENTSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IMPLEMENTSPlaceHolder(Java8TemplateParser.Fm_IMPLEMENTSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_IMPLEMENTSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IMPLEMENTSPlaceHolder(Java8TemplateParser.Fm_IMPLEMENTSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_IMPORTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IMPORTPlaceHolder(Java8TemplateParser.Fm_IMPORTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_IMPORTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IMPORTPlaceHolder(Java8TemplateParser.Fm_IMPORTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_INSTANCEOFPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_INSTANCEOFPlaceHolder(Java8TemplateParser.Fm_INSTANCEOFPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_INSTANCEOFPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_INSTANCEOFPlaceHolder(Java8TemplateParser.Fm_INSTANCEOFPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_INTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_INTPlaceHolder(Java8TemplateParser.Fm_INTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_INTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_INTPlaceHolder(Java8TemplateParser.Fm_INTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_INTERFACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_INTERFACEPlaceHolder(Java8TemplateParser.Fm_INTERFACEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_INTERFACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_INTERFACEPlaceHolder(Java8TemplateParser.Fm_INTERFACEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LONGPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LONGPlaceHolder(Java8TemplateParser.Fm_LONGPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LONGPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LONGPlaceHolder(Java8TemplateParser.Fm_LONGPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_NATIVEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NATIVEPlaceHolder(Java8TemplateParser.Fm_NATIVEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_NATIVEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NATIVEPlaceHolder(Java8TemplateParser.Fm_NATIVEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_NEWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NEWPlaceHolder(Java8TemplateParser.Fm_NEWPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_NEWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NEWPlaceHolder(Java8TemplateParser.Fm_NEWPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_PACKAGEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PACKAGEPlaceHolder(Java8TemplateParser.Fm_PACKAGEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_PACKAGEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PACKAGEPlaceHolder(Java8TemplateParser.Fm_PACKAGEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_PRIVATEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PRIVATEPlaceHolder(Java8TemplateParser.Fm_PRIVATEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_PRIVATEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PRIVATEPlaceHolder(Java8TemplateParser.Fm_PRIVATEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_PROTECTEDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PROTECTEDPlaceHolder(Java8TemplateParser.Fm_PROTECTEDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_PROTECTEDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PROTECTEDPlaceHolder(Java8TemplateParser.Fm_PROTECTEDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_PUBLICPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PUBLICPlaceHolder(Java8TemplateParser.Fm_PUBLICPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_PUBLICPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PUBLICPlaceHolder(Java8TemplateParser.Fm_PUBLICPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_RETURNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RETURNPlaceHolder(Java8TemplateParser.Fm_RETURNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_RETURNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RETURNPlaceHolder(Java8TemplateParser.Fm_RETURNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_SHORTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SHORTPlaceHolder(Java8TemplateParser.Fm_SHORTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_SHORTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SHORTPlaceHolder(Java8TemplateParser.Fm_SHORTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_STATICPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_STATICPlaceHolder(Java8TemplateParser.Fm_STATICPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_STATICPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_STATICPlaceHolder(Java8TemplateParser.Fm_STATICPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_STRICTFPPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_STRICTFPPlaceHolder(Java8TemplateParser.Fm_STRICTFPPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_STRICTFPPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_STRICTFPPlaceHolder(Java8TemplateParser.Fm_STRICTFPPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_SUPERPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SUPERPlaceHolder(Java8TemplateParser.Fm_SUPERPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_SUPERPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SUPERPlaceHolder(Java8TemplateParser.Fm_SUPERPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_SWITCHPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SWITCHPlaceHolder(Java8TemplateParser.Fm_SWITCHPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_SWITCHPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SWITCHPlaceHolder(Java8TemplateParser.Fm_SWITCHPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_SYNCHRONIZEDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SYNCHRONIZEDPlaceHolder(Java8TemplateParser.Fm_SYNCHRONIZEDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_SYNCHRONIZEDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SYNCHRONIZEDPlaceHolder(Java8TemplateParser.Fm_SYNCHRONIZEDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_THISPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_THISPlaceHolder(Java8TemplateParser.Fm_THISPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_THISPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_THISPlaceHolder(Java8TemplateParser.Fm_THISPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_THROWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_THROWPlaceHolder(Java8TemplateParser.Fm_THROWPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_THROWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_THROWPlaceHolder(Java8TemplateParser.Fm_THROWPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_THROWSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_THROWSPlaceHolder(Java8TemplateParser.Fm_THROWSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_THROWSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_THROWSPlaceHolder(Java8TemplateParser.Fm_THROWSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_TRANSIENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_TRANSIENTPlaceHolder(Java8TemplateParser.Fm_TRANSIENTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_TRANSIENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_TRANSIENTPlaceHolder(Java8TemplateParser.Fm_TRANSIENTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_TRYPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_TRYPlaceHolder(Java8TemplateParser.Fm_TRYPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_TRYPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_TRYPlaceHolder(Java8TemplateParser.Fm_TRYPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_VOIDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_VOIDPlaceHolder(Java8TemplateParser.Fm_VOIDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_VOIDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_VOIDPlaceHolder(Java8TemplateParser.Fm_VOIDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_VOLATILEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_VOLATILEPlaceHolder(Java8TemplateParser.Fm_VOLATILEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_VOLATILEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_VOLATILEPlaceHolder(Java8TemplateParser.Fm_VOLATILEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_WHILEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_WHILEPlaceHolder(Java8TemplateParser.Fm_WHILEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_WHILEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_WHILEPlaceHolder(Java8TemplateParser.Fm_WHILEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_IntegerLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IntegerLiteralPlaceHolder(Java8TemplateParser.Fm_IntegerLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_IntegerLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IntegerLiteralPlaceHolder(Java8TemplateParser.Fm_IntegerLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_FloatingPointLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FloatingPointLiteralPlaceHolder(Java8TemplateParser.Fm_FloatingPointLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_FloatingPointLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FloatingPointLiteralPlaceHolder(Java8TemplateParser.Fm_FloatingPointLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_BooleanLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BooleanLiteralPlaceHolder(Java8TemplateParser.Fm_BooleanLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_BooleanLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BooleanLiteralPlaceHolder(Java8TemplateParser.Fm_BooleanLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_CharacterLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CharacterLiteralPlaceHolder(Java8TemplateParser.Fm_CharacterLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_CharacterLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CharacterLiteralPlaceHolder(Java8TemplateParser.Fm_CharacterLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_StringLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_StringLiteralPlaceHolder(Java8TemplateParser.Fm_StringLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_StringLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_StringLiteralPlaceHolder(Java8TemplateParser.Fm_StringLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_NullLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NullLiteralPlaceHolder(Java8TemplateParser.Fm_NullLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_NullLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NullLiteralPlaceHolder(Java8TemplateParser.Fm_NullLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPARENPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPARENPlaceHolder(Java8TemplateParser.Fm_LPARENPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPARENPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPARENPlaceHolder(Java8TemplateParser.Fm_LPARENPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_RPARENPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RPARENPlaceHolder(Java8TemplateParser.Fm_RPARENPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_RPARENPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RPARENPlaceHolder(Java8TemplateParser.Fm_RPARENPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LBRACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LBRACEPlaceHolder(Java8TemplateParser.Fm_LBRACEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LBRACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LBRACEPlaceHolder(Java8TemplateParser.Fm_LBRACEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_RBRACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RBRACEPlaceHolder(Java8TemplateParser.Fm_RBRACEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_RBRACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RBRACEPlaceHolder(Java8TemplateParser.Fm_RBRACEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LBRACKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LBRACKPlaceHolder(Java8TemplateParser.Fm_LBRACKPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LBRACKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LBRACKPlaceHolder(Java8TemplateParser.Fm_LBRACKPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_RBRACKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RBRACKPlaceHolder(Java8TemplateParser.Fm_RBRACKPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_RBRACKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RBRACKPlaceHolder(Java8TemplateParser.Fm_RBRACKPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_SEMIPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SEMIPlaceHolder(Java8TemplateParser.Fm_SEMIPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_SEMIPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SEMIPlaceHolder(Java8TemplateParser.Fm_SEMIPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_COMMAPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_COMMAPlaceHolder(Java8TemplateParser.Fm_COMMAPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_COMMAPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_COMMAPlaceHolder(Java8TemplateParser.Fm_COMMAPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_DOTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DOTPlaceHolder(Java8TemplateParser.Fm_DOTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_DOTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DOTPlaceHolder(Java8TemplateParser.Fm_DOTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ASSIGNPlaceHolder(Java8TemplateParser.Fm_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ASSIGNPlaceHolder(Java8TemplateParser.Fm_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_GTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GTPlaceHolder(Java8TemplateParser.Fm_GTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_GTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GTPlaceHolder(Java8TemplateParser.Fm_GTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LTPlaceHolder(Java8TemplateParser.Fm_LTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LTPlaceHolder(Java8TemplateParser.Fm_LTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_BANGPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BANGPlaceHolder(Java8TemplateParser.Fm_BANGPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_BANGPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BANGPlaceHolder(Java8TemplateParser.Fm_BANGPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_TILDEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_TILDEPlaceHolder(Java8TemplateParser.Fm_TILDEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_TILDEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_TILDEPlaceHolder(Java8TemplateParser.Fm_TILDEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_QUESTIONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_QUESTIONPlaceHolder(Java8TemplateParser.Fm_QUESTIONPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_QUESTIONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_QUESTIONPlaceHolder(Java8TemplateParser.Fm_QUESTIONPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_COLONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_COLONPlaceHolder(Java8TemplateParser.Fm_COLONPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_COLONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_COLONPlaceHolder(Java8TemplateParser.Fm_COLONPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_EQUALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_EQUALPlaceHolder(Java8TemplateParser.Fm_EQUALPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_EQUALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_EQUALPlaceHolder(Java8TemplateParser.Fm_EQUALPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LEPlaceHolder(Java8TemplateParser.Fm_LEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LEPlaceHolder(Java8TemplateParser.Fm_LEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_GEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GEPlaceHolder(Java8TemplateParser.Fm_GEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_GEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GEPlaceHolder(Java8TemplateParser.Fm_GEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_NOTEQUALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NOTEQUALPlaceHolder(Java8TemplateParser.Fm_NOTEQUALPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_NOTEQUALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NOTEQUALPlaceHolder(Java8TemplateParser.Fm_NOTEQUALPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ANDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ANDPlaceHolder(Java8TemplateParser.Fm_ANDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ANDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ANDPlaceHolder(Java8TemplateParser.Fm_ANDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ORPlaceHolder(Java8TemplateParser.Fm_ORPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ORPlaceHolder(Java8TemplateParser.Fm_ORPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_INCPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_INCPlaceHolder(Java8TemplateParser.Fm_INCPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_INCPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_INCPlaceHolder(Java8TemplateParser.Fm_INCPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_DECPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DECPlaceHolder(Java8TemplateParser.Fm_DECPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_DECPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DECPlaceHolder(Java8TemplateParser.Fm_DECPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ADDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ADDPlaceHolder(Java8TemplateParser.Fm_ADDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ADDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ADDPlaceHolder(Java8TemplateParser.Fm_ADDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_SUBPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SUBPlaceHolder(Java8TemplateParser.Fm_SUBPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_SUBPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SUBPlaceHolder(Java8TemplateParser.Fm_SUBPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_MULPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MULPlaceHolder(Java8TemplateParser.Fm_MULPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_MULPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MULPlaceHolder(Java8TemplateParser.Fm_MULPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_DIVPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DIVPlaceHolder(Java8TemplateParser.Fm_DIVPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_DIVPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DIVPlaceHolder(Java8TemplateParser.Fm_DIVPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_BITANDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BITANDPlaceHolder(Java8TemplateParser.Fm_BITANDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_BITANDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BITANDPlaceHolder(Java8TemplateParser.Fm_BITANDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_BITORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BITORPlaceHolder(Java8TemplateParser.Fm_BITORPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_BITORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BITORPlaceHolder(Java8TemplateParser.Fm_BITORPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_CARETPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CARETPlaceHolder(Java8TemplateParser.Fm_CARETPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_CARETPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CARETPlaceHolder(Java8TemplateParser.Fm_CARETPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_MODPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MODPlaceHolder(Java8TemplateParser.Fm_MODPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_MODPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MODPlaceHolder(Java8TemplateParser.Fm_MODPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ARROWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ARROWPlaceHolder(Java8TemplateParser.Fm_ARROWPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ARROWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ARROWPlaceHolder(Java8TemplateParser.Fm_ARROWPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_COLONCOLONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_COLONCOLONPlaceHolder(Java8TemplateParser.Fm_COLONCOLONPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_COLONCOLONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_COLONCOLONPlaceHolder(Java8TemplateParser.Fm_COLONCOLONPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ADD_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ADD_ASSIGNPlaceHolder(Java8TemplateParser.Fm_ADD_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ADD_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ADD_ASSIGNPlaceHolder(Java8TemplateParser.Fm_ADD_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_SUB_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SUB_ASSIGNPlaceHolder(Java8TemplateParser.Fm_SUB_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_SUB_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SUB_ASSIGNPlaceHolder(Java8TemplateParser.Fm_SUB_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_MUL_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MUL_ASSIGNPlaceHolder(Java8TemplateParser.Fm_MUL_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_MUL_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MUL_ASSIGNPlaceHolder(Java8TemplateParser.Fm_MUL_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_DIV_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DIV_ASSIGNPlaceHolder(Java8TemplateParser.Fm_DIV_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_DIV_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DIV_ASSIGNPlaceHolder(Java8TemplateParser.Fm_DIV_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_AND_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AND_ASSIGNPlaceHolder(Java8TemplateParser.Fm_AND_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_AND_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AND_ASSIGNPlaceHolder(Java8TemplateParser.Fm_AND_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_OR_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_OR_ASSIGNPlaceHolder(Java8TemplateParser.Fm_OR_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_OR_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_OR_ASSIGNPlaceHolder(Java8TemplateParser.Fm_OR_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_XOR_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_XOR_ASSIGNPlaceHolder(Java8TemplateParser.Fm_XOR_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_XOR_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_XOR_ASSIGNPlaceHolder(Java8TemplateParser.Fm_XOR_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_MOD_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MOD_ASSIGNPlaceHolder(Java8TemplateParser.Fm_MOD_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_MOD_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MOD_ASSIGNPlaceHolder(Java8TemplateParser.Fm_MOD_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LSHIFT_ASSIGNPlaceHolder(Java8TemplateParser.Fm_LSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LSHIFT_ASSIGNPlaceHolder(Java8TemplateParser.Fm_LSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_RSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RSHIFT_ASSIGNPlaceHolder(Java8TemplateParser.Fm_RSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_RSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RSHIFT_ASSIGNPlaceHolder(Java8TemplateParser.Fm_RSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_URSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_URSHIFT_ASSIGNPlaceHolder(Java8TemplateParser.Fm_URSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_URSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_URSHIFT_ASSIGNPlaceHolder(Java8TemplateParser.Fm_URSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_IdentifierPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IdentifierPlaceHolder(Java8TemplateParser.Fm_IdentifierPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_IdentifierPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IdentifierPlaceHolder(Java8TemplateParser.Fm_IdentifierPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ATPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ATPlaceHolder(Java8TemplateParser.Fm_ATPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ATPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ATPlaceHolder(Java8TemplateParser.Fm_ATPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_ELLIPSISPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ELLIPSISPlaceHolder(Java8TemplateParser.Fm_ELLIPSISPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_ELLIPSISPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ELLIPSISPlaceHolder(Java8TemplateParser.Fm_ELLIPSISPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_WSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_WSPlaceHolder(Java8TemplateParser.Fm_WSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_WSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_WSPlaceHolder(Java8TemplateParser.Fm_WSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_COMMENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_COMMENTPlaceHolder(Java8TemplateParser.Fm_COMMENTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_COMMENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_COMMENTPlaceHolder(Java8TemplateParser.Fm_COMMENTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LINE_COMMENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LINE_COMMENTPlaceHolder(Java8TemplateParser.Fm_LINE_COMMENTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LINE_COMMENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LINE_COMMENTPlaceHolder(Java8TemplateParser.Fm_LINE_COMMENTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParendimExprRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendimExprRParenStar(Java8TemplateParser.Fm_LParendimExprRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParendimExprRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendimExprRParenStar(Java8TemplateParser.Fm_LParendimExprRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeElementModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeElementModifierRParenStar(Java8TemplateParser.Fm_LParenannotationTypeElementModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeElementModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeElementModifierRParenStar(Java8TemplateParser.Fm_LParenannotationTypeElementModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenannotationRParenStarLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchBlockStatementGroupRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchBlockStatementGroupRParenStar(Java8TemplateParser.Fm_LParenswitchBlockStatementGroupRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchBlockStatementGroupRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchBlockStatementGroupRParenStar(Java8TemplateParser.Fm_LParenswitchBlockStatementGroupRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParameterModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeParameterModifierRParenStar(Java8TemplateParser.Fm_LParentypeParameterModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParameterModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeParameterModifierRParenStar(Java8TemplateParser.Fm_LParentypeParameterModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParencatchClauseRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchClauseRParenStar(Java8TemplateParser.Fm_LParencatchClauseRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParencatchClauseRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchClauseRParenStar(Java8TemplateParser.Fm_LParencatchClauseRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenumConstantModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumConstantModifierRParenStar(Java8TemplateParser.Fm_LParenenumConstantModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenumConstantModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumConstantModifierRParenStar(Java8TemplateParser.Fm_LParenenumConstantModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar(Java8TemplateParser.Fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar(Java8TemplateParser.Fm_LParenLParenannotationRParenStarLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenstatementExpressionRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenimportDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenimportDeclarationRParenStar(Java8TemplateParser.Fm_LParenimportDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenimportDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenimportDeclarationRParenStar(Java8TemplateParser.Fm_LParenimportDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeDeclarationRParenStar(Java8TemplateParser.Fm_LParentypeDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeDeclarationRParenStar(Java8TemplateParser.Fm_LParentypeDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassBodyDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassBodyDeclarationRParenStar(Java8TemplateParser.Fm_LParenclassBodyDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassBodyDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassBodyDeclarationRParenStar(Java8TemplateParser.Fm_LParenclassBodyDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodModifierRParenStar(Java8TemplateParser.Fm_LParenmethodModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodModifierRParenStar(Java8TemplateParser.Fm_LParenmethodModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenadditionalBoundRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenadditionalBoundRParenStar(Java8TemplateParser.Fm_LParenadditionalBoundRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenadditionalBoundRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenadditionalBoundRParenStar(Java8TemplateParser.Fm_LParenadditionalBoundRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar(Java8TemplateParser.Fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStar(Java8TemplateParser.Fm_LParenLParenclassType_lf_classOrInterfaceTypeRParenOrLPareninterfaceType_lf_classOrInterfaceTypeRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx9}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx9(Java8TemplateParser.Fm_newRulexXXx9Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx9}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx9(Java8TemplateParser.Fm_newRulexXXx9Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeMemberDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeMemberDeclarationRParenStar(Java8TemplateParser.Fm_LParenannotationTypeMemberDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeMemberDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeMemberDeclarationRParenStar(Java8TemplateParser.Fm_LParenannotationTypeMemberDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfieldModifierRParenStar(Java8TemplateParser.Fm_LParenfieldModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfieldModifierRParenStar(Java8TemplateParser.Fm_LParenfieldModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLPareninterfaceTypeRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar(Java8TemplateParser.Fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStar(Java8TemplateParser.Fm_LParenLParenprimaryNoNewArray_lf_primaryRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconstantModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstantModifierRParenStar(Java8TemplateParser.Fm_LParenconstantModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconstantModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstantModifierRParenStar(Java8TemplateParser.Fm_LParenconstantModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx1}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx1(Java8TemplateParser.Fm_newRulexXXx1Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx1}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx1(Java8TemplateParser.Fm_newRulexXXx1Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx8}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx8(Java8TemplateParser.Fm_newRulexXXx8Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx8}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx8(Java8TemplateParser.Fm_newRulexXXx8Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpackageModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpackageModifierRParenStar(Java8TemplateParser.Fm_LParenpackageModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpackageModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpackageModifierRParenStar(Java8TemplateParser.Fm_LParenpackageModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceMethodModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceMethodModifierRParenStar(Java8TemplateParser.Fm_LPareninterfaceMethodModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceMethodModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceMethodModifierRParenStar(Java8TemplateParser.Fm_LPareninterfaceMethodModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableModifierRParenStar(Java8TemplateParser.Fm_LParenvariableModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableModifierRParenStar(Java8TemplateParser.Fm_LParenvariableModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceModifierRParenStar(Java8TemplateParser.Fm_LPareninterfaceModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceModifierRParenStar(Java8TemplateParser.Fm_LPareninterfaceModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx4}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx4(Java8TemplateParser.Fm_newRulexXXx4Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx4}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx4(Java8TemplateParser.Fm_newRulexXXx4Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexceptionTypeRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx6}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx6(Java8TemplateParser.Fm_newRulexXXx6Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx6}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx6(Java8TemplateParser.Fm_newRulexXXx6Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassModifierRParenStar(Java8TemplateParser.Fm_LParenclassModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassModifierRParenStar(Java8TemplateParser.Fm_LParenclassModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconstructorModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstructorModifierRParenStar(Java8TemplateParser.Fm_LParenconstructorModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconstructorModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstructorModifierRParenStar(Java8TemplateParser.Fm_LParenconstructorModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchLabelRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchLabelRParenStar(Java8TemplateParser.Fm_LParenswitchLabelRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchLabelRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchLabelRParenStar(Java8TemplateParser.Fm_LParenswitchLabelRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceMemberDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceMemberDeclarationRParenStar(Java8TemplateParser.Fm_LPareninterfaceMemberDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceMemberDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceMemberDeclarationRParenStar(Java8TemplateParser.Fm_LPareninterfaceMemberDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenclassTypeRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenblockStatementRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockStatementRParenStar(Java8TemplateParser.Fm_LParenblockStatementRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenblockStatementRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockStatementRParenStar(Java8TemplateParser.Fm_LParenblockStatementRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationRParenStar(Java8TemplateParser.Fm_LParenannotationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationRParenStar(Java8TemplateParser.Fm_LParenannotationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar(Java8TemplateParser.Fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeBoundRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeBoundRParenQuestion(Java8TemplateParser.Fm_LParentypeBoundRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeBoundRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeBoundRParenQuestion(Java8TemplateParser.Fm_LParentypeBoundRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParencatchesRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchesRParenQuestion(Java8TemplateParser.Fm_LParencatchesRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParencatchesRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchesRParenQuestion(Java8TemplateParser.Fm_LParencatchesRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenexpressionRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionRParenQuestion(Java8TemplateParser.Fm_LParenexpressionRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenexpressionRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionRParenQuestion(Java8TemplateParser.Fm_LParenexpressionRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParensuperinterfacesRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParensuperinterfacesRParenQuestion(Java8TemplateParser.Fm_LParensuperinterfacesRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParensuperinterfacesRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParensuperinterfacesRParenQuestion(Java8TemplateParser.Fm_LParensuperinterfacesRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion(Java8TemplateParser.Fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion(Java8TemplateParser.Fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValuePairListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValuePairListRParenQuestion(Java8TemplateParser.Fm_LParenelementValuePairListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValuePairListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValuePairListRParenQuestion(Java8TemplateParser.Fm_LParenelementValuePairListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenexplicitConstructorInvocationRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexplicitConstructorInvocationRParenQuestion(Java8TemplateParser.Fm_LParenexplicitConstructorInvocationRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenexplicitConstructorInvocationRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexplicitConstructorInvocationRParenQuestion(Java8TemplateParser.Fm_LParenexplicitConstructorInvocationRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenforUpdateRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenforUpdateRParenQuestion(Java8TemplateParser.Fm_LParenforUpdateRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenforUpdateRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenforUpdateRParenQuestion(Java8TemplateParser.Fm_LParenforUpdateRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfinally_RParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfinally_RParenQuestion(Java8TemplateParser.Fm_LParenfinally_RParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfinally_RParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfinally_RParenQuestion(Java8TemplateParser.Fm_LParenfinally_RParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentsOrDiamondRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentsOrDiamondRParenQuestion(Java8TemplateParser.Fm_LParentypeArgumentsOrDiamondRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentsOrDiamondRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentsOrDiamondRParenQuestion(Java8TemplateParser.Fm_LParentypeArgumentsOrDiamondRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion(Java8TemplateParser.Fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion(Java8TemplateParser.Fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion(Java8TemplateParser.Fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestion(Java8TemplateParser.Fm_LParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenLParenfm_DOTPlaceHolderOrDOTRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParendimsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendimsRParenQuestion(Java8TemplateParser.Fm_LParendimsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParendimsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendimsRParenQuestion(Java8TemplateParser.Fm_LParendimsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParensuperclassRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParensuperclassRParenQuestion(Java8TemplateParser.Fm_LParensuperclassRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParensuperclassRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParensuperclassRParenQuestion(Java8TemplateParser.Fm_LParensuperclassRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableInitializerListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableInitializerListRParenQuestion(Java8TemplateParser.Fm_LParenvariableInitializerListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableInitializerListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableInitializerListRParenQuestion(Java8TemplateParser.Fm_LParenvariableInitializerListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpackageDeclarationRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpackageDeclarationRParenQuestion(Java8TemplateParser.Fm_LParenpackageDeclarationRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpackageDeclarationRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpackageDeclarationRParenQuestion(Java8TemplateParser.Fm_LParenpackageDeclarationRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenthrows_RParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenthrows_RParenQuestion(Java8TemplateParser.Fm_LParenthrows_RParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenthrows_RParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenthrows_RParenQuestion(Java8TemplateParser.Fm_LParenthrows_RParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenwildcardBoundsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenwildcardBoundsRParenQuestion(Java8TemplateParser.Fm_LParenwildcardBoundsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenwildcardBoundsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenwildcardBoundsRParenQuestion(Java8TemplateParser.Fm_LParenwildcardBoundsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion(Java8TemplateParser.Fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion(Java8TemplateParser.Fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx2}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx2(Java8TemplateParser.Fm_newRulexXXx2Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx2}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx2(Java8TemplateParser.Fm_newRulexXXx2Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenumConstantListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumConstantListRParenQuestion(Java8TemplateParser.Fm_LParenenumConstantListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenumConstantListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumConstantListRParenQuestion(Java8TemplateParser.Fm_LParenenumConstantListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParametersRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeParametersRParenQuestion(Java8TemplateParser.Fm_LParentypeParametersRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParametersRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeParametersRParenQuestion(Java8TemplateParser.Fm_LParentypeParametersRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParendefaultValueRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendefaultValueRParenQuestion(Java8TemplateParser.Fm_LParendefaultValueRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParendefaultValueRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendefaultValueRParenQuestion(Java8TemplateParser.Fm_LParendefaultValueRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenumBodyDeclarationsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumBodyDeclarationsRParenQuestion(Java8TemplateParser.Fm_LParenenumBodyDeclarationsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenumBodyDeclarationsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumBodyDeclarationsRParenQuestion(Java8TemplateParser.Fm_LParenenumBodyDeclarationsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassBodyRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassBodyRParenQuestion(Java8TemplateParser.Fm_LParenclassBodyRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassBodyRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassBodyRParenQuestion(Java8TemplateParser.Fm_LParenclassBodyRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenextendsInterfacesRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenextendsInterfacesRParenQuestion(Java8TemplateParser.Fm_LParenextendsInterfacesRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenextendsInterfacesRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenextendsInterfacesRParenQuestion(Java8TemplateParser.Fm_LParenextendsInterfacesRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenblockStatementsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockStatementsRParenQuestion(Java8TemplateParser.Fm_LParenblockStatementsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenblockStatementsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockStatementsRParenQuestion(Java8TemplateParser.Fm_LParenblockStatementsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValueListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValueListRParenQuestion(Java8TemplateParser.Fm_LParenelementValueListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValueListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValueListRParenQuestion(Java8TemplateParser.Fm_LParenelementValueListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenargumentListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenargumentListRParenQuestion(Java8TemplateParser.Fm_LParenargumentListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenargumentListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenargumentListRParenQuestion(Java8TemplateParser.Fm_LParenargumentListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentsRParenQuestion(Java8TemplateParser.Fm_LParentypeArgumentsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentsRParenQuestion(Java8TemplateParser.Fm_LParentypeArgumentsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenforInitRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenforInitRParenQuestion(Java8TemplateParser.Fm_LParenforInitRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenforInitRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenforInitRParenQuestion(Java8TemplateParser.Fm_LParenforInitRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion(Java8TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion(Java8TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenformalParameterListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenformalParameterListRParenQuestion(Java8TemplateParser.Fm_LParenformalParameterListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenformalParameterListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenformalParameterListRParenQuestion(Java8TemplateParser.Fm_LParenformalParameterListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LEPlaceHolderOrLERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LEPlaceHolderOrLERParenOne(Java8TemplateParser.Fm_LParenfm_LEPlaceHolderOrLERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LEPlaceHolderOrLERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LEPlaceHolderOrLERParenOne(Java8TemplateParser.Fm_LParenfm_LEPlaceHolderOrLERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenambiguousNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenambiguousNameRParenOne(Java8TemplateParser.Fm_LParenambiguousNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenambiguousNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenambiguousNameRParenOne(Java8TemplateParser.Fm_LParenambiguousNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_WHILEPlaceHolderOrWHILERParenOne(Java8TemplateParser.Fm_LParenfm_WHILEPlaceHolderOrWHILERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_WHILEPlaceHolderOrWHILERParenOne(Java8TemplateParser.Fm_LParenfm_WHILEPlaceHolderOrWHILERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne(Java8TemplateParser.Fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne(Java8TemplateParser.Fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CHARPlaceHolderOrCHARRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CHARPlaceHolderOrCHARRParenOne(Java8TemplateParser.Fm_LParenfm_CHARPlaceHolderOrCHARRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CHARPlaceHolderOrCHARRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CHARPlaceHolderOrCHARRParenOne(Java8TemplateParser.Fm_LParenfm_CHARPlaceHolderOrCHARRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IFPlaceHolderOrIFRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IFPlaceHolderOrIFRParenOne(Java8TemplateParser.Fm_LParenfm_IFPlaceHolderOrIFRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IFPlaceHolderOrIFRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IFPlaceHolderOrIFRParenOne(Java8TemplateParser.Fm_LParenfm_IFPlaceHolderOrIFRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconstructorDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstructorDeclaratorRParenOne(Java8TemplateParser.Fm_LParenconstructorDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconstructorDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstructorDeclaratorRParenOne(Java8TemplateParser.Fm_LParenconstructorDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenreferenceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenreferenceTypeRParenOne(Java8TemplateParser.Fm_LParenreferenceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenreferenceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenreferenceTypeRParenOne(Java8TemplateParser.Fm_LParenreferenceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx3}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx3(Java8TemplateParser.Fm_newRulexXXx3Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx3}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx3(Java8TemplateParser.Fm_newRulexXXx3Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeBodyRParenOne(Java8TemplateParser.Fm_LParenannotationTypeBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeBodyRParenOne(Java8TemplateParser.Fm_LParenannotationTypeBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenwhileStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenwhileStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenwhileStatementNoShortIfRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenwhileStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenwhileStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenwhileStatementNoShortIfRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_TRYPlaceHolderOrTRYRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_TRYPlaceHolderOrTRYRParenOne(Java8TemplateParser.Fm_LParenfm_TRYPlaceHolderOrTRYRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_TRYPlaceHolderOrTRYRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_TRYPlaceHolderOrTRYRParenOne(Java8TemplateParser.Fm_LParenfm_TRYPlaceHolderOrTRYRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannClassType_lfno_unannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenstatementNoShortIfRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenstatementNoShortIfRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FINALPlaceHolderOrFINALRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FINALPlaceHolderOrFINALRParenOne(Java8TemplateParser.Fm_LParenfm_FINALPlaceHolderOrFINALRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FINALPlaceHolderOrFINALRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FINALPlaceHolderOrFINALRParenOne(Java8TemplateParser.Fm_LParenfm_FINALPlaceHolderOrFINALRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayAccess_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenarrayAccess_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenarrayAccess_lfno_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayAccess_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenarrayAccess_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenarrayAccess_lfno_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne(Java8TemplateParser.Fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne(Java8TemplateParser.Fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SUBPlaceHolderOrSUBRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SUBPlaceHolderOrSUBRParenOne(Java8TemplateParser.Fm_LParenfm_SUBPlaceHolderOrSUBRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SUBPlaceHolderOrSUBRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SUBPlaceHolderOrSUBRParenOne(Java8TemplateParser.Fm_LParenfm_SUBPlaceHolderOrSUBRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryRParenOne(Java8TemplateParser.Fm_LParenprimaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryRParenOne(Java8TemplateParser.Fm_LParenprimaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenclassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenclassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldAccess_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfieldAccess_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenfieldAccess_lfno_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldAccess_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfieldAccess_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenfieldAccess_lfno_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParameterListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeParameterListRParenOne(Java8TemplateParser.Fm_LParentypeParameterListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParameterListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeParameterListRParenOne(Java8TemplateParser.Fm_LParentypeParameterListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeImportOnDemandDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeImportOnDemandDeclarationRParenOne(Java8TemplateParser.Fm_LParentypeImportOnDemandDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeImportOnDemandDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeImportOnDemandDeclarationRParenOne(Java8TemplateParser.Fm_LParentypeImportOnDemandDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne(Java8TemplateParser.Fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne(Java8TemplateParser.Fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstatementRParenOne(Java8TemplateParser.Fm_LParenstatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstatementRParenOne(Java8TemplateParser.Fm_LParenstatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx5}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx5(Java8TemplateParser.Fm_newRulexXXx5Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx5}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx5(Java8TemplateParser.Fm_newRulexXXx5Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne(Java8TemplateParser.Fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne(Java8TemplateParser.Fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenumDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumDeclarationRParenOne(Java8TemplateParser.Fm_LParenenumDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenumDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumDeclarationRParenOne(Java8TemplateParser.Fm_LParenenumDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenexclusiveOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexclusiveOrExpressionRParenOne(Java8TemplateParser.Fm_LParenexclusiveOrExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenexclusiveOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexclusiveOrExpressionRParenOne(Java8TemplateParser.Fm_LParenexclusiveOrExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenresourceSpecificationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenresourceSpecificationRParenOne(Java8TemplateParser.Fm_LParenresourceSpecificationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenresourceSpecificationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenresourceSpecificationRParenOne(Java8TemplateParser.Fm_LParenresourceSpecificationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentsRParenOne(Java8TemplateParser.Fm_LParentypeArgumentsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentsRParenOne(Java8TemplateParser.Fm_LParentypeArgumentsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne(Java8TemplateParser.Fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne(Java8TemplateParser.Fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne(Java8TemplateParser.Fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne(Java8TemplateParser.Fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryNoNewArray_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lfno_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryNoNewArray_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lfno_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne(Java8TemplateParser.Fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne(Java8TemplateParser.Fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne(Java8TemplateParser.Fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOne(Java8TemplateParser.Fm_LParenLParenprimaryRParenOrLParenexpressionNameRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CASEPlaceHolderOrCASERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CASEPlaceHolderOrCASERParenOne(Java8TemplateParser.Fm_LParenfm_CASEPlaceHolderOrCASERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CASEPlaceHolderOrCASERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CASEPlaceHolderOrCASERParenOne(Java8TemplateParser.Fm_LParenfm_CASEPlaceHolderOrCASERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParencontinueStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencontinueStatementRParenOne(Java8TemplateParser.Fm_LParencontinueStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParencontinueStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencontinueStatementRParenOne(Java8TemplateParser.Fm_LParencontinueStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfinally_RParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfinally_RParenOne(Java8TemplateParser.Fm_LParenfinally_RParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfinally_RParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfinally_RParenOne(Java8TemplateParser.Fm_LParenfinally_RParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpostfixExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpostfixExpressionRParenOne(Java8TemplateParser.Fm_LParenpostfixExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpostfixExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpostfixExpressionRParenOne(Java8TemplateParser.Fm_LParenpostfixExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassInstanceCreationExpression_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenclassInstanceCreationExpression_lfno_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannClassType_lf_unannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BITORPlaceHolderOrBITORRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BITORPlaceHolderOrBITORRParenOne(Java8TemplateParser.Fm_LParenfm_BITORPlaceHolderOrBITORRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BITORPlaceHolderOrBITORRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BITORPlaceHolderOrBITORRParenOne(Java8TemplateParser.Fm_LParenfm_BITORPlaceHolderOrBITORRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParencatchTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchTypeRParenOne(Java8TemplateParser.Fm_LParencatchTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParencatchTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchTypeRParenOne(Java8TemplateParser.Fm_LParencatchTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne(Java8TemplateParser.Fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne(Java8TemplateParser.Fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannPrimitiveTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannPrimitiveTypeRParenOne(Java8TemplateParser.Fm_LParenunannPrimitiveTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannPrimitiveTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannPrimitiveTypeRParenOne(Java8TemplateParser.Fm_LParenunannPrimitiveTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne(Java8TemplateParser.Fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne(Java8TemplateParser.Fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParensingleStaticImportDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParensingleStaticImportDeclarationRParenOne(Java8TemplateParser.Fm_LParensingleStaticImportDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParensingleStaticImportDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParensingleStaticImportDeclarationRParenOne(Java8TemplateParser.Fm_LParensingleStaticImportDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LTPlaceHolderOrLTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LTPlaceHolderOrLTRParenOne(Java8TemplateParser.Fm_LParenfm_LTPlaceHolderOrLTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LTPlaceHolderOrLTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LTPlaceHolderOrLTRParenOne(Java8TemplateParser.Fm_LParenfm_LTPlaceHolderOrLTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne(Java8TemplateParser.Fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne(Java8TemplateParser.Fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenlocalVariableDeclarationStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlocalVariableDeclarationStatementRParenOne(Java8TemplateParser.Fm_LParenlocalVariableDeclarationStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenlocalVariableDeclarationStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlocalVariableDeclarationStatementRParenOne(Java8TemplateParser.Fm_LParenlocalVariableDeclarationStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceBodyRParenOne(Java8TemplateParser.Fm_LPareninterfaceBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceBodyRParenOne(Java8TemplateParser.Fm_LPareninterfaceBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannInterfaceType_lf_unannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne(Java8TemplateParser.Fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne(Java8TemplateParser.Fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenifThenStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenifThenStatementRParenOne(Java8TemplateParser.Fm_LParenifThenStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenifThenStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenifThenStatementRParenOne(Java8TemplateParser.Fm_LParenifThenStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconditionalAndExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconditionalAndExpressionRParenOne(Java8TemplateParser.Fm_LParenconditionalAndExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconditionalAndExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconditionalAndExpressionRParenOne(Java8TemplateParser.Fm_LParenconditionalAndExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParensingleElementAnnotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParensingleElementAnnotationRParenOne(Java8TemplateParser.Fm_LParensingleElementAnnotationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParensingleElementAnnotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParensingleElementAnnotationRParenOne(Java8TemplateParser.Fm_LParensingleElementAnnotationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne(Java8TemplateParser.Fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne(Java8TemplateParser.Fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne(Java8TemplateParser.Fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne(Java8TemplateParser.Fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstatementExpressionRParenOne(Java8TemplateParser.Fm_LParenstatementExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstatementExpressionRParenOne(Java8TemplateParser.Fm_LParenstatementExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne(Java8TemplateParser.Fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpostIncrementExpression_lf_postfixExpressionRParenOne(Java8TemplateParser.Fm_LParenpostIncrementExpression_lf_postfixExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne(Java8TemplateParser.Fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOne(Java8TemplateParser.Fm_LParenLParenclassType_lfno_classOrInterfaceTypeRParenOrLPareninterfaceType_lfno_classOrInterfaceTypeRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenformalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenformalParameterRParenOne(Java8TemplateParser.Fm_LParenformalParameterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenformalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenformalParameterRParenOne(Java8TemplateParser.Fm_LParenformalParameterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne(Java8TemplateParser.Fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne(Java8TemplateParser.Fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodBodyRParenOne(Java8TemplateParser.Fm_LParenmethodBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodBodyRParenOne(Java8TemplateParser.Fm_LParenmethodBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenifThenElseStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenifThenElseStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenifThenElseStatementNoShortIfRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenifThenElseStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenifThenElseStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenifThenElseStatementNoShortIfRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmarkerAnnotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmarkerAnnotationRParenOne(Java8TemplateParser.Fm_LParenmarkerAnnotationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmarkerAnnotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmarkerAnnotationRParenOne(Java8TemplateParser.Fm_LParenmarkerAnnotationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ANDPlaceHolderOrANDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ANDPlaceHolderOrANDRParenOne(Java8TemplateParser.Fm_LParenfm_ANDPlaceHolderOrANDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ANDPlaceHolderOrANDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ANDPlaceHolderOrANDRParenOne(Java8TemplateParser.Fm_LParenfm_ANDPlaceHolderOrANDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninclusiveOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninclusiveOrExpressionRParenOne(Java8TemplateParser.Fm_LPareninclusiveOrExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninclusiveOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninclusiveOrExpressionRParenOne(Java8TemplateParser.Fm_LPareninclusiveOrExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconstructorDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstructorDeclarationRParenOne(Java8TemplateParser.Fm_LParenconstructorDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconstructorDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstructorDeclarationRParenOne(Java8TemplateParser.Fm_LParenconstructorDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne(Java8TemplateParser.Fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne(Java8TemplateParser.Fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenreturnStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenreturnStatementRParenOne(Java8TemplateParser.Fm_LParenreturnStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenreturnStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenreturnStatementRParenOne(Java8TemplateParser.Fm_LParenreturnStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_GTPlaceHolderOrGTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_GTPlaceHolderOrGTRParenOne(Java8TemplateParser.Fm_LParenfm_GTPlaceHolderOrGTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_GTPlaceHolderOrGTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_GTPlaceHolderOrGTRParenOne(Java8TemplateParser.Fm_LParenfm_GTPlaceHolderOrGTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayAccess_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenarrayAccess_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenarrayAccess_lf_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayAccess_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenarrayAccess_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenarrayAccess_lf_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LPareninterfaceType_lf_classOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LONGPlaceHolderOrLONGRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LONGPlaceHolderOrLONGRParenOne(Java8TemplateParser.Fm_LParenfm_LONGPlaceHolderOrLONGRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LONGPlaceHolderOrLONGRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LONGPlaceHolderOrLONGRParenOne(Java8TemplateParser.Fm_LParenfm_LONGPlaceHolderOrLONGRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenexpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionRParenOne(Java8TemplateParser.Fm_LParenexpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenexpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionRParenOne(Java8TemplateParser.Fm_LParenexpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconstantExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstantExpressionRParenOne(Java8TemplateParser.Fm_LParenconstantExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconstantExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstantExpressionRParenOne(Java8TemplateParser.Fm_LParenconstantExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne(Java8TemplateParser.Fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne(Java8TemplateParser.Fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayAccessRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenarrayAccessRParenOne(Java8TemplateParser.Fm_LParenarrayAccessRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayAccessRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenarrayAccessRParenOne(Java8TemplateParser.Fm_LParenarrayAccessRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentRParenOne(Java8TemplateParser.Fm_LParentypeArgumentRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentRParenOne(Java8TemplateParser.Fm_LParentypeArgumentRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ARROWPlaceHolderOrARROWRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ARROWPlaceHolderOrARROWRParenOne(Java8TemplateParser.Fm_LParenfm_ARROWPlaceHolderOrARROWRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ARROWPlaceHolderOrARROWRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ARROWPlaceHolderOrARROWRParenOne(Java8TemplateParser.Fm_LParenfm_ARROWPlaceHolderOrARROWRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpreDecrementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpreDecrementExpressionRParenOne(Java8TemplateParser.Fm_LParenpreDecrementExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpreDecrementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpreDecrementExpressionRParenOne(Java8TemplateParser.Fm_LParenpreDecrementExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne(Java8TemplateParser.Fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne(Java8TemplateParser.Fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchLabelsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchLabelsRParenOne(Java8TemplateParser.Fm_LParenswitchLabelsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchLabelsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchLabelsRParenOne(Java8TemplateParser.Fm_LParenswitchLabelsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenarrayInitializerRParenOne(Java8TemplateParser.Fm_LParenarrayInitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenarrayInitializerRParenOne(Java8TemplateParser.Fm_LParenarrayInitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne(Java8TemplateParser.Fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne(Java8TemplateParser.Fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne(Java8TemplateParser.Fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne(Java8TemplateParser.Fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParennormalInterfaceDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParennormalInterfaceDeclarationRParenOne(Java8TemplateParser.Fm_LParennormalInterfaceDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParennormalInterfaceDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParennormalInterfaceDeclarationRParenOne(Java8TemplateParser.Fm_LParennormalInterfaceDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodDeclaratorRParenOne(Java8TemplateParser.Fm_LParenmethodDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodDeclaratorRParenOne(Java8TemplateParser.Fm_LParenmethodDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeParameterRParenOne(Java8TemplateParser.Fm_LParentypeParameterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeParameterRParenOne(Java8TemplateParser.Fm_LParentypeParameterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParennormalAnnotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParennormalAnnotationRParenOne(Java8TemplateParser.Fm_LParennormalAnnotationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParennormalAnnotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParennormalAnnotationRParenOne(Java8TemplateParser.Fm_LParennormalAnnotationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeVariableRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeVariableRParenOne(Java8TemplateParser.Fm_LParentypeVariableRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeVariableRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeVariableRParenOne(Java8TemplateParser.Fm_LParentypeVariableRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodReferenceRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodReferenceRParenOne(Java8TemplateParser.Fm_LParenmethodReferenceRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodReferenceRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodReferenceRParenOne(Java8TemplateParser.Fm_LParenmethodReferenceRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodHeaderRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodHeaderRParenOne(Java8TemplateParser.Fm_LParenmethodHeaderRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodHeaderRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodHeaderRParenOne(Java8TemplateParser.Fm_LParenmethodHeaderRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenliteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenliteralRParenOne(Java8TemplateParser.Fm_LParenliteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenliteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenliteralRParenOne(Java8TemplateParser.Fm_LParenliteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParencatchClauseRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchClauseRParenOne(Java8TemplateParser.Fm_LParencatchClauseRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParencatchClauseRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchClauseRParenOne(Java8TemplateParser.Fm_LParencatchClauseRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenunannInterfaceType_lfno_unannClassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassTypeRParenOne(Java8TemplateParser.Fm_LParenclassTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassTypeRParenOne(Java8TemplateParser.Fm_LParenclassTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassInstanceCreationExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassInstanceCreationExpressionRParenOne(Java8TemplateParser.Fm_LParenclassInstanceCreationExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassInstanceCreationExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassInstanceCreationExpressionRParenOne(Java8TemplateParser.Fm_LParenclassInstanceCreationExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_THISPlaceHolderOrTHISRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_THISPlaceHolderOrTHISRParenOne(Java8TemplateParser.Fm_LParenfm_THISPlaceHolderOrTHISRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_THISPlaceHolderOrTHISRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_THISPlaceHolderOrTHISRParenOne(Java8TemplateParser.Fm_LParenfm_THISPlaceHolderOrTHISRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannTypeVariableRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannTypeVariableRParenOne(Java8TemplateParser.Fm_LParenunannTypeVariableRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannTypeVariableRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannTypeVariableRParenOne(Java8TemplateParser.Fm_LParenunannTypeVariableRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannArrayTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannArrayTypeRParenOne(Java8TemplateParser.Fm_LParenunannArrayTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannArrayTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannArrayTypeRParenOne(Java8TemplateParser.Fm_LParenunannArrayTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParendimExprsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendimExprsRParenOne(Java8TemplateParser.Fm_LParendimExprsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParendimExprsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendimExprsRParenOne(Java8TemplateParser.Fm_LParendimExprsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenintegralTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenintegralTypeRParenOne(Java8TemplateParser.Fm_LParenintegralTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenintegralTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenintegralTypeRParenOne(Java8TemplateParser.Fm_LParenintegralTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassBodyRParenOne(Java8TemplateParser.Fm_LParenclassBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassBodyRParenOne(Java8TemplateParser.Fm_LParenclassBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenassignmentExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenassignmentExpressionRParenOne(Java8TemplateParser.Fm_LParenassignmentExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenassignmentExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenassignmentExpressionRParenOne(Java8TemplateParser.Fm_LParenassignmentExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableDeclaratorIdRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableDeclaratorIdRParenOne(Java8TemplateParser.Fm_LParenvariableDeclaratorIdRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableDeclaratorIdRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableDeclaratorIdRParenOne(Java8TemplateParser.Fm_LParenvariableDeclaratorIdRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenblockStatementsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockStatementsRParenOne(Java8TemplateParser.Fm_LParenblockStatementsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenblockStatementsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockStatementsRParenOne(Java8TemplateParser.Fm_LParenblockStatementsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenumConstantNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumConstantNameRParenOne(Java8TemplateParser.Fm_LParenenumConstantNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenumConstantNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumConstantNameRParenOne(Java8TemplateParser.Fm_LParenenumConstantNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenifThenElseStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenifThenElseStatementRParenOne(Java8TemplateParser.Fm_LParenifThenElseStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenifThenElseStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenifThenElseStatementRParenOne(Java8TemplateParser.Fm_LParenifThenElseStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenstaticImportOnDemandDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstaticImportOnDemandDeclarationRParenOne(Java8TemplateParser.Fm_LParenstaticImportOnDemandDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenstaticImportOnDemandDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstaticImportOnDemandDeclarationRParenOne(Java8TemplateParser.Fm_LParenstaticImportOnDemandDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_MULPlaceHolderOrMULRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MULPlaceHolderOrMULRParenOne(Java8TemplateParser.Fm_LParenfm_MULPlaceHolderOrMULRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_MULPlaceHolderOrMULRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MULPlaceHolderOrMULRParenOne(Java8TemplateParser.Fm_LParenfm_MULPlaceHolderOrMULRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenlambdaParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlambdaParametersRParenOne(Java8TemplateParser.Fm_LParenlambdaParametersRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenlambdaParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlambdaParametersRParenOne(Java8TemplateParser.Fm_LParenlambdaParametersRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpostIncrementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpostIncrementExpressionRParenOne(Java8TemplateParser.Fm_LParenpostIncrementExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpostIncrementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpostIncrementExpressionRParenOne(Java8TemplateParser.Fm_LParenpostIncrementExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenumConstantRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumConstantRParenOne(Java8TemplateParser.Fm_LParenenumConstantRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenumConstantRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumConstantRParenOne(Java8TemplateParser.Fm_LParenenumConstantRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne(Java8TemplateParser.Fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne(Java8TemplateParser.Fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne(Java8TemplateParser.Fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne(Java8TemplateParser.Fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ORPlaceHolderOrORRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ORPlaceHolderOrORRParenOne(Java8TemplateParser.Fm_LParenfm_ORPlaceHolderOrORRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ORPlaceHolderOrORRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ORPlaceHolderOrORRParenOne(Java8TemplateParser.Fm_LParenfm_ORPlaceHolderOrORRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ENUMPlaceHolderOrENUMRParenOne(Java8TemplateParser.Fm_LParenfm_ENUMPlaceHolderOrENUMRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ENUMPlaceHolderOrENUMRParenOne(Java8TemplateParser.Fm_LParenfm_ENUMPlaceHolderOrENUMRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DECPlaceHolderOrDECRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DECPlaceHolderOrDECRParenOne(Java8TemplateParser.Fm_LParenfm_DECPlaceHolderOrDECRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DECPlaceHolderOrDECRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DECPlaceHolderOrDECRParenOne(Java8TemplateParser.Fm_LParenfm_DECPlaceHolderOrDECRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne(Java8TemplateParser.Fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOne(Java8TemplateParser.Fm_LParenfm_COLONCOLONPlaceHolderOrCOLONCOLONRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunaryExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunaryExpressionRParenOne(Java8TemplateParser.Fm_LParenunaryExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunaryExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunaryExpressionRParenOne(Java8TemplateParser.Fm_LParenunaryExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne(Java8TemplateParser.Fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne(Java8TemplateParser.Fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodDeclarationRParenOne(Java8TemplateParser.Fm_LParenmethodDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodDeclarationRParenOne(Java8TemplateParser.Fm_LParenmethodDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenrelationalExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenrelationalExpressionRParenOne(Java8TemplateParser.Fm_LParenrelationalExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenrelationalExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenrelationalExpressionRParenOne(Java8TemplateParser.Fm_LParenrelationalExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableDeclaratorListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableDeclaratorListRParenOne(Java8TemplateParser.Fm_LParenvariableDeclaratorListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableDeclaratorListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableDeclaratorListRParenOne(Java8TemplateParser.Fm_LParenvariableDeclaratorListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_STATICPlaceHolderOrSTATICRParenOne(Java8TemplateParser.Fm_LParenfm_STATICPlaceHolderOrSTATICRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_STATICPlaceHolderOrSTATICRParenOne(Java8TemplateParser.Fm_LParenfm_STATICPlaceHolderOrSTATICRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceTypeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceTypeListRParenOne(Java8TemplateParser.Fm_LPareninterfaceTypeListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceTypeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceTypeListRParenOne(Java8TemplateParser.Fm_LPareninterfaceTypeListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenemptyStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenemptyStatementRParenOne(Java8TemplateParser.Fm_LParenemptyStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenemptyStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenemptyStatementRParenOne(Java8TemplateParser.Fm_LParenemptyStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ELSEPlaceHolderOrELSERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ELSEPlaceHolderOrELSERParenOne(Java8TemplateParser.Fm_LParenfm_ELSEPlaceHolderOrELSERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ELSEPlaceHolderOrELSERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ELSEPlaceHolderOrELSERParenOne(Java8TemplateParser.Fm_LParenfm_ELSEPlaceHolderOrELSERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne(Java8TemplateParser.Fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne(Java8TemplateParser.Fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne(Java8TemplateParser.Fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne(Java8TemplateParser.Fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodReference_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodReference_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenmethodReference_lfno_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodReference_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodReference_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenmethodReference_lfno_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FORPlaceHolderOrFORRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FORPlaceHolderOrFORRParenOne(Java8TemplateParser.Fm_LParenfm_FORPlaceHolderOrFORRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FORPlaceHolderOrFORRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FORPlaceHolderOrFORRParenOne(Java8TemplateParser.Fm_LParenfm_FORPlaceHolderOrFORRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParensingleTypeImportDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParensingleTypeImportDeclarationRParenOne(Java8TemplateParser.Fm_LParensingleTypeImportDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParensingleTypeImportDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParensingleTypeImportDeclarationRParenOne(Java8TemplateParser.Fm_LParensingleTypeImportDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenassignmentOperatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenassignmentOperatorRParenOne(Java8TemplateParser.Fm_LParenassignmentOperatorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenassignmentOperatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenassignmentOperatorRParenOne(Java8TemplateParser.Fm_LParenassignmentOperatorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lfno_arrayAccessRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenumBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumBodyRParenOne(Java8TemplateParser.Fm_LParenenumBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenumBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumBodyRParenOne(Java8TemplateParser.Fm_LParenenumBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenexpressionStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionStatementRParenOne(Java8TemplateParser.Fm_LParenexpressionStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenexpressionStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionStatementRParenOne(Java8TemplateParser.Fm_LParenexpressionStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne(Java8TemplateParser.Fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpostDecrementExpression_lf_postfixExpressionRParenOne(Java8TemplateParser.Fm_LParenpostDecrementExpression_lf_postfixExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne(Java8TemplateParser.Fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne(Java8TemplateParser.Fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentryWithResourcesStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentryWithResourcesStatementRParenOne(Java8TemplateParser.Fm_LParentryWithResourcesStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentryWithResourcesStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentryWithResourcesStatementRParenOne(Java8TemplateParser.Fm_LParentryWithResourcesStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconstantDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstantDeclarationRParenOne(Java8TemplateParser.Fm_LParenconstantDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconstantDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstantDeclarationRParenOne(Java8TemplateParser.Fm_LParenconstantDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldAccessRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfieldAccessRParenOne(Java8TemplateParser.Fm_LParenfieldAccessRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldAccessRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfieldAccessRParenOne(Java8TemplateParser.Fm_LParenfieldAccessRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne(Java8TemplateParser.Fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne(Java8TemplateParser.Fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfloatingPointTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfloatingPointTypeRParenOne(Java8TemplateParser.Fm_LParenfloatingPointTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfloatingPointTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfloatingPointTypeRParenOne(Java8TemplateParser.Fm_LParenfloatingPointTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParendimExprRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendimExprRParenOne(Java8TemplateParser.Fm_LParendimExprRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParendimExprRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendimExprRParenOne(Java8TemplateParser.Fm_LParendimExprRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodInvocation_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodInvocation_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenmethodInvocation_lfno_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodInvocation_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodInvocation_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenmethodInvocation_lfno_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenformalParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenformalParametersRParenOne(Java8TemplateParser.Fm_LParenformalParametersRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenformalParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenformalParametersRParenOne(Java8TemplateParser.Fm_LParenformalParametersRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValuePairRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValuePairRParenOne(Java8TemplateParser.Fm_LParenelementValuePairRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValuePairRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValuePairRParenOne(Java8TemplateParser.Fm_LParenelementValuePairRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne(Java8TemplateParser.Fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne(Java8TemplateParser.Fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParensynchronizedStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParensynchronizedStatementRParenOne(Java8TemplateParser.Fm_LParensynchronizedStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParensynchronizedStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParensynchronizedStatementRParenOne(Java8TemplateParser.Fm_LParensynchronizedStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldAccess_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfieldAccess_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenfieldAccess_lf_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldAccess_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfieldAccess_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenfieldAccess_lf_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryNoNewArray_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lf_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryNoNewArray_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lf_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenlabeledStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlabeledStatementRParenOne(Java8TemplateParser.Fm_LParenlabeledStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenlabeledStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlabeledStatementRParenOne(Java8TemplateParser.Fm_LParenlabeledStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenarrayTypeRParenOne(Java8TemplateParser.Fm_LParenarrayTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenarrayTypeRParenOne(Java8TemplateParser.Fm_LParenarrayTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassDeclarationRParenOne(Java8TemplateParser.Fm_LParenclassDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassDeclarationRParenOne(Java8TemplateParser.Fm_LParenclassDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannClassTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannClassTypeRParenOne(Java8TemplateParser.Fm_LParenunannClassTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannClassTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannClassTypeRParenOne(Java8TemplateParser.Fm_LParenunannClassTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannTypeRParenOne(Java8TemplateParser.Fm_LParenunannTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannTypeRParenOne(Java8TemplateParser.Fm_LParenunannTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenresourceListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenresourceListRParenOne(Java8TemplateParser.Fm_LParenresourceListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenresourceListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenresourceListRParenOne(Java8TemplateParser.Fm_LParenresourceListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentListRParenOne(Java8TemplateParser.Fm_LParentypeArgumentListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeArgumentListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentListRParenOne(Java8TemplateParser.Fm_LParentypeArgumentListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne(Java8TemplateParser.Fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne(Java8TemplateParser.Fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimitiveTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimitiveTypeRParenOne(Java8TemplateParser.Fm_LParenprimitiveTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimitiveTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimitiveTypeRParenOne(Java8TemplateParser.Fm_LParenprimitiveTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenassignmentRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenassignmentRParenOne(Java8TemplateParser.Fm_LParenassignmentRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenassignmentRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenassignmentRParenOne(Java8TemplateParser.Fm_LParenassignmentRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeParametersRParenOne(Java8TemplateParser.Fm_LParentypeParametersRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeParametersRParenOne(Java8TemplateParser.Fm_LParentypeParametersRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenhancedForStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenhancedForStatementRParenOne(Java8TemplateParser.Fm_LParenenhancedForStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenhancedForStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenhancedForStatementRParenOne(Java8TemplateParser.Fm_LParenenhancedForStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenresourceRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenresourceRParenOne(Java8TemplateParser.Fm_LParenresourceRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenresourceRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenresourceRParenOne(Java8TemplateParser.Fm_LParenresourceRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfieldDeclarationRParenOne(Java8TemplateParser.Fm_LParenfieldDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfieldDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfieldDeclarationRParenOne(Java8TemplateParser.Fm_LParenfieldDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconditionalExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconditionalExpressionRParenOne(Java8TemplateParser.Fm_LParenconditionalExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconditionalExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconditionalExpressionRParenOne(Java8TemplateParser.Fm_LParenconditionalExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_THROWPlaceHolderOrTHROWRParenOne(Java8TemplateParser.Fm_LParenfm_THROWPlaceHolderOrTHROWRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_THROWPlaceHolderOrTHROWRParenOne(Java8TemplateParser.Fm_LParenfm_THROWPlaceHolderOrTHROWRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DOTPlaceHolderOrDOTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DOTPlaceHolderOrDOTRParenOne(Java8TemplateParser.Fm_LParenfm_DOTPlaceHolderOrDOTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DOTPlaceHolderOrDOTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DOTPlaceHolderOrDOTRParenOne(Java8TemplateParser.Fm_LParenfm_DOTPlaceHolderOrDOTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceMethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceMethodDeclarationRParenOne(Java8TemplateParser.Fm_LPareninterfaceMethodDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceMethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceMethodDeclarationRParenOne(Java8TemplateParser.Fm_LPareninterfaceMethodDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninstanceInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninstanceInitializerRParenOne(Java8TemplateParser.Fm_LPareninstanceInitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninstanceInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninstanceInitializerRParenOne(Java8TemplateParser.Fm_LPareninstanceInitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_INTPlaceHolderOrINTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_INTPlaceHolderOrINTRParenOne(Java8TemplateParser.Fm_LParenfm_INTPlaceHolderOrINTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_INTPlaceHolderOrINTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_INTPlaceHolderOrINTRParenOne(Java8TemplateParser.Fm_LParenfm_INTPlaceHolderOrINTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValueArrayInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValueArrayInitializerRParenOne(Java8TemplateParser.Fm_LParenelementValueArrayInitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValueArrayInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValueArrayInitializerRParenOne(Java8TemplateParser.Fm_LParenelementValueArrayInitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DOPlaceHolderOrDORParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DOPlaceHolderOrDORParenOne(Java8TemplateParser.Fm_LParenfm_DOPlaceHolderOrDORParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DOPlaceHolderOrDORParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DOPlaceHolderOrDORParenOne(Java8TemplateParser.Fm_LParenfm_DOPlaceHolderOrDORParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpostDecrementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpostDecrementExpressionRParenOne(Java8TemplateParser.Fm_LParenpostDecrementExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpostDecrementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpostDecrementExpressionRParenOne(Java8TemplateParser.Fm_LParenpostDecrementExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenadditiveExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenadditiveExpressionRParenOne(Java8TemplateParser.Fm_LParenadditiveExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenadditiveExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenadditiveExpressionRParenOne(Java8TemplateParser.Fm_LParenadditiveExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementWithoutTrailingSubstatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstatementWithoutTrailingSubstatementRParenOne(Java8TemplateParser.Fm_LParenstatementWithoutTrailingSubstatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementWithoutTrailingSubstatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstatementWithoutTrailingSubstatementRParenOne(Java8TemplateParser.Fm_LParenstatementWithoutTrailingSubstatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninferredFormalParameterListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninferredFormalParameterListRParenOne(Java8TemplateParser.Fm_LPareninferredFormalParameterListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninferredFormalParameterListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninferredFormalParameterListRParenOne(Java8TemplateParser.Fm_LPareninferredFormalParameterListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementExpressionListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstatementExpressionListRParenOne(Java8TemplateParser.Fm_LParenstatementExpressionListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenstatementExpressionListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstatementExpressionListRParenOne(Java8TemplateParser.Fm_LParenstatementExpressionListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmultiplicativeExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmultiplicativeExpressionRParenOne(Java8TemplateParser.Fm_LParenmultiplicativeExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmultiplicativeExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmultiplicativeExpressionRParenOne(Java8TemplateParser.Fm_LParenmultiplicativeExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne(Java8TemplateParser.Fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne(Java8TemplateParser.Fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne(Java8TemplateParser.Fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne(Java8TemplateParser.Fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchBlockRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchBlockRParenOne(Java8TemplateParser.Fm_LParenswitchBlockRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchBlockRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchBlockRParenOne(Java8TemplateParser.Fm_LParenswitchBlockRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodNameRParenOne(Java8TemplateParser.Fm_LParenmethodNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodNameRParenOne(Java8TemplateParser.Fm_LParenmethodNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenexceptionTypeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexceptionTypeListRParenOne(Java8TemplateParser.Fm_LParenexceptionTypeListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenexceptionTypeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexceptionTypeListRParenOne(Java8TemplateParser.Fm_LParenexceptionTypeListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpackageOrTypeNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpackageOrTypeNameRParenOne(Java8TemplateParser.Fm_LParenpackageOrTypeNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpackageOrTypeNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpackageOrTypeNameRParenOne(Java8TemplateParser.Fm_LParenpackageOrTypeNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunaryExpressionNotPlusMinusRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunaryExpressionNotPlusMinusRParenOne(Java8TemplateParser.Fm_LParenunaryExpressionNotPlusMinusRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunaryExpressionNotPlusMinusRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunaryExpressionNotPlusMinusRParenOne(Java8TemplateParser.Fm_LParenunaryExpressionNotPlusMinusRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne(Java8TemplateParser.Fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne(Java8TemplateParser.Fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeElementDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeElementDeclarationRParenOne(Java8TemplateParser.Fm_LParenannotationTypeElementDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeElementDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeElementDeclarationRParenOne(Java8TemplateParser.Fm_LParenannotationTypeElementDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx7}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx7(Java8TemplateParser.Fm_newRulexXXx7Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx7}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx7(Java8TemplateParser.Fm_newRulexXXx7Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenwhileStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenwhileStatementRParenOne(Java8TemplateParser.Fm_LParenwhileStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenwhileStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenwhileStatementRParenOne(Java8TemplateParser.Fm_LParenwhileStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodInvocationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodInvocationRParenOne(Java8TemplateParser.Fm_LParenmethodInvocationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodInvocationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodInvocationRParenOne(Java8TemplateParser.Fm_LParenmethodInvocationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryNoNewArray_lf_arrayAccessRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lf_arrayAccessRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenexceptionTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexceptionTypeRParenOne(Java8TemplateParser.Fm_LParenexceptionTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenexceptionTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexceptionTypeRParenOne(Java8TemplateParser.Fm_LParenexceptionTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne(Java8TemplateParser.Fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne(Java8TemplateParser.Fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconditionalOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconditionalOrExpressionRParenOne(Java8TemplateParser.Fm_LParenconditionalOrExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconditionalOrExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconditionalOrExpressionRParenOne(Java8TemplateParser.Fm_LParenconditionalOrExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationRParenOne(Java8TemplateParser.Fm_LParenannotationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationRParenOne(Java8TemplateParser.Fm_LParenannotationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceTypeRParenOne(Java8TemplateParser.Fm_LPareninterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceTypeRParenOne(Java8TemplateParser.Fm_LPareninterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenforStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenforStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenforStatementNoShortIfRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenforStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenforStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenforStatementNoShortIfRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenexpressionNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionNameRParenOne(Java8TemplateParser.Fm_LParenexpressionNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenexpressionNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionNameRParenOne(Java8TemplateParser.Fm_LParenexpressionNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DIVPlaceHolderOrDIVRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DIVPlaceHolderOrDIVRParenOne(Java8TemplateParser.Fm_LParenfm_DIVPlaceHolderOrDIVRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DIVPlaceHolderOrDIVRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DIVPlaceHolderOrDIVRParenOne(Java8TemplateParser.Fm_LParenfm_DIVPlaceHolderOrDIVRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenassertStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenassertStatementRParenOne(Java8TemplateParser.Fm_LParenassertStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenassertStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenassertStatementRParenOne(Java8TemplateParser.Fm_LParenassertStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne(Java8TemplateParser.Fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne(Java8TemplateParser.Fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne(Java8TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne(Java8TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOne(Java8TemplateParser.Fm_LParenprimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenbasicForStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenbasicForStatementRParenOne(Java8TemplateParser.Fm_LParenbasicForStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenbasicForStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenbasicForStatementRParenOne(Java8TemplateParser.Fm_LParenbasicForStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenlastFormalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlastFormalParameterRParenOne(Java8TemplateParser.Fm_LParenlastFormalParameterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenlastFormalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlastFormalParameterRParenOne(Java8TemplateParser.Fm_LParenlastFormalParameterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassInstanceCreationExpression_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassInstanceCreationExpression_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenclassInstanceCreationExpression_lf_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassInstanceCreationExpression_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassInstanceCreationExpression_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenclassInstanceCreationExpression_lf_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BANGPlaceHolderOrBANGRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BANGPlaceHolderOrBANGRParenOne(Java8TemplateParser.Fm_LParenfm_BANGPlaceHolderOrBANGRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BANGPlaceHolderOrBANGRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BANGPlaceHolderOrBANGRParenOne(Java8TemplateParser.Fm_LParenfm_BANGPlaceHolderOrBANGRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParencatchesRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchesRParenOne(Java8TemplateParser.Fm_LParencatchesRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParencatchesRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchesRParenOne(Java8TemplateParser.Fm_LParencatchesRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassType_lfno_classOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassType_lfno_classOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenclassType_lfno_classOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassType_lfno_classOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassType_lfno_classOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenclassType_lfno_classOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne(Java8TemplateParser.Fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne(Java8TemplateParser.Fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParendoStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendoStatementRParenOne(Java8TemplateParser.Fm_LParendoStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParendoStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendoStatementRParenOne(Java8TemplateParser.Fm_LParendoStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne(Java8TemplateParser.Fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne(Java8TemplateParser.Fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne(Java8TemplateParser.Fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentryStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentryStatementRParenOne(Java8TemplateParser.Fm_LParentryStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentryStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentryStatementRParenOne(Java8TemplateParser.Fm_LParentryStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodReference_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodReference_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenmethodReference_lf_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodReference_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodReference_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenmethodReference_lf_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenresultRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenresultRParenOne(Java8TemplateParser.Fm_LParenresultRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenresultRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenresultRParenOne(Java8TemplateParser.Fm_LParenresultRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassType_lf_classOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassType_lf_classOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenclassType_lf_classOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassType_lf_classOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassType_lf_classOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LParenclassType_lf_classOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_GEPlaceHolderOrGERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_GEPlaceHolderOrGERParenOne(Java8TemplateParser.Fm_LParenfm_GEPlaceHolderOrGERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_GEPlaceHolderOrGERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_GEPlaceHolderOrGERParenOne(Java8TemplateParser.Fm_LParenfm_GEPlaceHolderOrGERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne(Java8TemplateParser.Fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne(Java8TemplateParser.Fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParendimsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendimsRParenOne(Java8TemplateParser.Fm_LParendimsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParendimsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendimsRParenOne(Java8TemplateParser.Fm_LParendimsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx0}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx0(Java8TemplateParser.Fm_newRulexXXx0Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_newRulexXXx0}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx0(Java8TemplateParser.Fm_newRulexXXx0Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenpreIncrementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpreIncrementExpressionRParenOne(Java8TemplateParser.Fm_LParenpreIncrementExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenpreIncrementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpreIncrementExpressionRParenOne(Java8TemplateParser.Fm_LParenpreIncrementExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_TILDEPlaceHolderOrTILDERParenOne(Java8TemplateParser.Fm_LParenfm_TILDEPlaceHolderOrTILDERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_TILDEPlaceHolderOrTILDERParenOne(Java8TemplateParser.Fm_LParenfm_TILDEPlaceHolderOrTILDERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_COLONPlaceHolderOrCOLONRParenOne(Java8TemplateParser.Fm_LParenfm_COLONPlaceHolderOrCOLONRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_COLONPlaceHolderOrCOLONRParenOne(Java8TemplateParser.Fm_LParenfm_COLONPlaceHolderOrCOLONRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne(Java8TemplateParser.Fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne(Java8TemplateParser.Fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenandExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenandExpressionRParenOne(Java8TemplateParser.Fm_LParenandExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenandExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenandExpressionRParenOne(Java8TemplateParser.Fm_LParenandExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne(Java8TemplateParser.Fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne(Java8TemplateParser.Fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenwildcardRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenwildcardRParenOne(Java8TemplateParser.Fm_LParenwildcardRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenwildcardRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenwildcardRParenOne(Java8TemplateParser.Fm_LParenwildcardRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne(Java8TemplateParser.Fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne(Java8TemplateParser.Fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_INCPlaceHolderOrINCRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_INCPlaceHolderOrINCRParenOne(Java8TemplateParser.Fm_LParenfm_INCPlaceHolderOrINCRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_INCPlaceHolderOrINCRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_INCPlaceHolderOrINCRParenOne(Java8TemplateParser.Fm_LParenfm_INCPlaceHolderOrINCRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayCreationExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenarrayCreationExpressionRParenOne(Java8TemplateParser.Fm_LParenarrayCreationExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenarrayCreationExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenarrayCreationExpressionRParenOne(Java8TemplateParser.Fm_LParenarrayCreationExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenbreakStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenbreakStatementRParenOne(Java8TemplateParser.Fm_LParenbreakStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenbreakStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenbreakStatementRParenOne(Java8TemplateParser.Fm_LParenbreakStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ADDPlaceHolderOrADDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ADDPlaceHolderOrADDRParenOne(Java8TemplateParser.Fm_LParenfm_ADDPlaceHolderOrADDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ADDPlaceHolderOrADDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ADDPlaceHolderOrADDRParenOne(Java8TemplateParser.Fm_LParenfm_ADDPlaceHolderOrADDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne(Java8TemplateParser.Fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne(Java8TemplateParser.Fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_MODPlaceHolderOrMODRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MODPlaceHolderOrMODRParenOne(Java8TemplateParser.Fm_LParenfm_MODPlaceHolderOrMODRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_MODPlaceHolderOrMODRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MODPlaceHolderOrMODRParenOne(Java8TemplateParser.Fm_LParenfm_MODPlaceHolderOrMODRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne(Java8TemplateParser.Fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenclassMemberDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassMemberDeclarationRParenOne(Java8TemplateParser.Fm_LParenclassMemberDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenclassMemberDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassMemberDeclarationRParenOne(Java8TemplateParser.Fm_LParenclassMemberDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne(Java8TemplateParser.Fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne(Java8TemplateParser.Fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ATPlaceHolderOrATRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ATPlaceHolderOrATRParenOne(Java8TemplateParser.Fm_LParenfm_ATPlaceHolderOrATRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_ATPlaceHolderOrATRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ATPlaceHolderOrATRParenOne(Java8TemplateParser.Fm_LParenfm_ATPlaceHolderOrATRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParennormalClassDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParennormalClassDeclarationRParenOne(Java8TemplateParser.Fm_LParennormalClassDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParennormalClassDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParennormalClassDeclarationRParenOne(Java8TemplateParser.Fm_LParennormalClassDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValueRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValueRParenOne(Java8TemplateParser.Fm_LParenelementValueRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenelementValueRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValueRParenOne(Java8TemplateParser.Fm_LParenelementValueRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParencastExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencastExpressionRParenOne(Java8TemplateParser.Fm_LParencastExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParencastExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencastExpressionRParenOne(Java8TemplateParser.Fm_LParencastExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenreceiverParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenreceiverParameterRParenOne(Java8TemplateParser.Fm_LParenreceiverParameterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenreceiverParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenreceiverParameterRParenOne(Java8TemplateParser.Fm_LParenreceiverParameterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenstaticInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstaticInitializerRParenOne(Java8TemplateParser.Fm_LParenstaticInitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenstaticInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstaticInitializerRParenOne(Java8TemplateParser.Fm_LParenstaticInitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenunannReferenceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenunannReferenceTypeRParenOne(Java8TemplateParser.Fm_LParenunannReferenceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenunannReferenceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenunannReferenceTypeRParenOne(Java8TemplateParser.Fm_LParenunannReferenceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceDeclarationRParenOne(Java8TemplateParser.Fm_LPareninterfaceDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceDeclarationRParenOne(Java8TemplateParser.Fm_LPareninterfaceDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne(Java8TemplateParser.Fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne(Java8TemplateParser.Fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne(Java8TemplateParser.Fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne(Java8TemplateParser.Fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOne(Java8TemplateParser.Fm_LPareninterfaceType_lfno_classOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParensimpleTypeNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParensimpleTypeNameRParenOne(Java8TemplateParser.Fm_LParensimpleTypeNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParensimpleTypeNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParensimpleTypeNameRParenOne(Java8TemplateParser.Fm_LParensimpleTypeNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableInitializerRParenOne(Java8TemplateParser.Fm_LParenvariableInitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableInitializerRParenOne(Java8TemplateParser.Fm_LParenvariableInitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParencatchFormalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchFormalParameterRParenOne(Java8TemplateParser.Fm_LParencatchFormalParameterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParencatchFormalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchFormalParameterRParenOne(Java8TemplateParser.Fm_LParencatchFormalParameterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenleftHandSideRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenleftHandSideRParenOne(Java8TemplateParser.Fm_LParenleftHandSideRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenleftHandSideRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenleftHandSideRParenOne(Java8TemplateParser.Fm_LParenleftHandSideRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenequalityExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenequalityExpressionRParenOne(Java8TemplateParser.Fm_LParenequalityExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenequalityExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenequalityExpressionRParenOne(Java8TemplateParser.Fm_LParenequalityExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenforStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenforStatementRParenOne(Java8TemplateParser.Fm_LParenforStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenforStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenforStatementRParenOne(Java8TemplateParser.Fm_LParenforStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BYTEPlaceHolderOrBYTERParenOne(Java8TemplateParser.Fm_LParenfm_BYTEPlaceHolderOrBYTERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BYTEPlaceHolderOrBYTERParenOne(Java8TemplateParser.Fm_LParenfm_BYTEPlaceHolderOrBYTERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne(Java8TemplateParser.Fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne(Java8TemplateParser.Fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne(Java8TemplateParser.Fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOne(Java8TemplateParser.Fm_LParenLParenprimaryNoNewArray_lfno_primaryRParenOrLParenarrayCreationExpressionRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenlambdaBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlambdaBodyRParenOne(Java8TemplateParser.Fm_LParenlambdaBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenlambdaBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlambdaBodyRParenOne(Java8TemplateParser.Fm_LParenlambdaBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableDeclaratorRParenOne(Java8TemplateParser.Fm_LParenvariableDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenvariableDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableDeclaratorRParenOne(Java8TemplateParser.Fm_LParenvariableDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenlabeledStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlabeledStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenlabeledStatementNoShortIfRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenlabeledStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlabeledStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenlabeledStatementNoShortIfRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CARETPlaceHolderOrCARETRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CARETPlaceHolderOrCARETRParenOne(Java8TemplateParser.Fm_LParenfm_CARETPlaceHolderOrCARETRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_CARETPlaceHolderOrCARETRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CARETPlaceHolderOrCARETRParenOne(Java8TemplateParser.Fm_LParenfm_CARETPlaceHolderOrCARETRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_NEWPlaceHolderOrNEWRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NEWPlaceHolderOrNEWRParenOne(Java8TemplateParser.Fm_LParenfm_NEWPlaceHolderOrNEWRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenfm_NEWPlaceHolderOrNEWRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NEWPlaceHolderOrNEWRParenOne(Java8TemplateParser.Fm_LParenfm_NEWPlaceHolderOrNEWRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParennumericTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParennumericTypeRParenOne(Java8TemplateParser.Fm_LParennumericTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParennumericTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParennumericTypeRParenOne(Java8TemplateParser.Fm_LParennumericTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodInvocation_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodInvocation_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenmethodInvocation_lf_primaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenmethodInvocation_lf_primaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodInvocation_lf_primaryRParenOne(Java8TemplateParser.Fm_LParenmethodInvocation_lf_primaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchLabelRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchLabelRParenOne(Java8TemplateParser.Fm_LParenswitchLabelRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchLabelRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchLabelRParenOne(Java8TemplateParser.Fm_LParenswitchLabelRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenshiftExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenshiftExpressionRParenOne(Java8TemplateParser.Fm_LParenshiftExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenshiftExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenshiftExpressionRParenOne(Java8TemplateParser.Fm_LParenshiftExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenlambdaExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlambdaExpressionRParenOne(Java8TemplateParser.Fm_LParenlambdaExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenlambdaExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlambdaExpressionRParenOne(Java8TemplateParser.Fm_LParenlambdaExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenblockStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockStatementRParenOne(Java8TemplateParser.Fm_LParenblockStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenblockStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockStatementRParenOne(Java8TemplateParser.Fm_LParenblockStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenblockRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockRParenOne(Java8TemplateParser.Fm_LParenblockRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenblockRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockRParenOne(Java8TemplateParser.Fm_LParenblockRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchStatementRParenOne(Java8TemplateParser.Fm_LParenswitchStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenswitchStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchStatementRParenOne(Java8TemplateParser.Fm_LParenswitchStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenconstructorBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstructorBodyRParenOne(Java8TemplateParser.Fm_LParenconstructorBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenconstructorBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstructorBodyRParenOne(Java8TemplateParser.Fm_LParenconstructorBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenenhancedForStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenhancedForStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenenhancedForStatementNoShortIfRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenenhancedForStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenhancedForStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenenhancedForStatementNoShortIfRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenlocalVariableDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlocalVariableDeclarationRParenOne(Java8TemplateParser.Fm_LParenlocalVariableDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenlocalVariableDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlocalVariableDeclarationRParenOne(Java8TemplateParser.Fm_LParenlocalVariableDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeDeclarationRParenOne(Java8TemplateParser.Fm_LParenannotationTypeDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenannotationTypeDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeDeclarationRParenOne(Java8TemplateParser.Fm_LParenannotationTypeDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenbasicForStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenbasicForStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenbasicForStatementNoShortIfRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenbasicForStatementNoShortIfRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenbasicForStatementNoShortIfRParenOne(Java8TemplateParser.Fm_LParenbasicForStatementNoShortIfRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParentypeNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeNameRParenOne(Java8TemplateParser.Fm_LParentypeNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParentypeNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeNameRParenOne(Java8TemplateParser.Fm_LParentypeNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java8TemplateParser#fm_LParenthrowStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenthrowStatementRParenOne(Java8TemplateParser.Fm_LParenthrowStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java8TemplateParser#fm_LParenthrowStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenthrowStatementRParenOne(Java8TemplateParser.Fm_LParenthrowStatementRParenOneContext ctx);
}