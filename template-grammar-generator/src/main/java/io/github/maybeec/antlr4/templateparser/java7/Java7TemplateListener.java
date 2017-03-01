// Generated from C:\Projects\cobigen\workspaces\approach2\cobigen\MA_manual_merge\manual_merge\src\main\java\java7TemplateParser\Java7Template.g4 by ANTLR 4.5.1
package io.github.maybeec.antlr4.templateparser.java7;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Java7TemplateParser}.
 */
public interface Java7TemplateListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(Java7TemplateParser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(Java7TemplateParser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(Java7TemplateParser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(Java7TemplateParser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(Java7TemplateParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(Java7TemplateParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(Java7TemplateParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(Java7TemplateParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(Java7TemplateParser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(Java7TemplateParser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceModifier(Java7TemplateParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#classOrInterfaceModifier}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceModifier(Java7TemplateParser.ClassOrInterfaceModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void enterVariableModifier(Java7TemplateParser.VariableModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#variableModifier}.
	 * @param ctx the parse tree
	 */
	void exitVariableModifier(Java7TemplateParser.VariableModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(Java7TemplateParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(Java7TemplateParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(Java7TemplateParser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(Java7TemplateParser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(Java7TemplateParser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(Java7TemplateParser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterTypeBound(Java7TemplateParser.TypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitTypeBound(Java7TemplateParser.TypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(Java7TemplateParser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(Java7TemplateParser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstants(Java7TemplateParser.EnumConstantsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#enumConstants}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstants(Java7TemplateParser.EnumConstantsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(Java7TemplateParser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(Java7TemplateParser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(Java7TemplateParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(Java7TemplateParser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(Java7TemplateParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(Java7TemplateParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(Java7TemplateParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(Java7TemplateParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(Java7TemplateParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(Java7TemplateParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(Java7TemplateParser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(Java7TemplateParser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(Java7TemplateParser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(Java7TemplateParser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMemberDeclaration(Java7TemplateParser.MemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#memberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMemberDeclaration(Java7TemplateParser.MemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(Java7TemplateParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(Java7TemplateParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericMethodDeclaration(Java7TemplateParser.GenericMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#genericMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericMethodDeclaration(Java7TemplateParser.GenericMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(Java7TemplateParser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(Java7TemplateParser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericConstructorDeclaration(Java7TemplateParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#genericConstructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericConstructorDeclaration(Java7TemplateParser.GenericConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(Java7TemplateParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(Java7TemplateParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBodyDeclaration(Java7TemplateParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#interfaceBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBodyDeclaration(Java7TemplateParser.InterfaceBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(Java7TemplateParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(Java7TemplateParser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstDeclaration(Java7TemplateParser.ConstDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#constDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstDeclaration(Java7TemplateParser.ConstDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclarator(Java7TemplateParser.ConstantDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#constantDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclarator(Java7TemplateParser.ConstantDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(Java7TemplateParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(Java7TemplateParser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterGenericInterfaceMethodDeclaration(Java7TemplateParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#genericInterfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitGenericInterfaceMethodDeclaration(Java7TemplateParser.GenericInterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarators(Java7TemplateParser.VariableDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#variableDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarators(Java7TemplateParser.VariableDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(Java7TemplateParser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(Java7TemplateParser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(Java7TemplateParser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(Java7TemplateParser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(Java7TemplateParser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(Java7TemplateParser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(Java7TemplateParser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(Java7TemplateParser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantName(Java7TemplateParser.EnumConstantNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#enumConstantName}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantName(Java7TemplateParser.EnumConstantNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(Java7TemplateParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(Java7TemplateParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterClassOrInterfaceType(Java7TemplateParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#classOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitClassOrInterfaceType(Java7TemplateParser.ClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(Java7TemplateParser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(Java7TemplateParser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(Java7TemplateParser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(Java7TemplateParser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(Java7TemplateParser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(Java7TemplateParser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedNameList(Java7TemplateParser.QualifiedNameListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#qualifiedNameList}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedNameList(Java7TemplateParser.QualifiedNameListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(Java7TemplateParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(Java7TemplateParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(Java7TemplateParser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(Java7TemplateParser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(Java7TemplateParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(Java7TemplateParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(Java7TemplateParser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(Java7TemplateParser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(Java7TemplateParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(Java7TemplateParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(Java7TemplateParser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(Java7TemplateParser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(Java7TemplateParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(Java7TemplateParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Java7TemplateParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Java7TemplateParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(Java7TemplateParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(Java7TemplateParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationName(Java7TemplateParser.AnnotationNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotationName}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationName(Java7TemplateParser.AnnotationNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairs(Java7TemplateParser.ElementValuePairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#elementValuePairs}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairs(Java7TemplateParser.ElementValuePairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(Java7TemplateParser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(Java7TemplateParser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValue(Java7TemplateParser.ElementValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValue(Java7TemplateParser.ElementValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(Java7TemplateParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(Java7TemplateParser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(Java7TemplateParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(Java7TemplateParser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(Java7TemplateParser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(Java7TemplateParser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(Java7TemplateParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(Java7TemplateParser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementRest(Java7TemplateParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotationTypeElementRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementRest(Java7TemplateParser.AnnotationTypeElementRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodOrConstantRest(Java7TemplateParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotationMethodOrConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodOrConstantRest(Java7TemplateParser.AnnotationMethodOrConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationMethodRest(Java7TemplateParser.AnnotationMethodRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotationMethodRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationMethodRest(Java7TemplateParser.AnnotationMethodRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationConstantRest(Java7TemplateParser.AnnotationConstantRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#annotationConstantRest}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationConstantRest(Java7TemplateParser.AnnotationConstantRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(Java7TemplateParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(Java7TemplateParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Java7TemplateParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Java7TemplateParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(Java7TemplateParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(Java7TemplateParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(Java7TemplateParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(Java7TemplateParser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(Java7TemplateParser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(Java7TemplateParser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Java7TemplateParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Java7TemplateParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(Java7TemplateParser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(Java7TemplateParser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#catchType}.
	 * @param ctx the parse tree
	 */
	void enterCatchType(Java7TemplateParser.CatchTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#catchType}.
	 * @param ctx the parse tree
	 */
	void exitCatchType(Java7TemplateParser.CatchTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void enterFinallyBlock(Java7TemplateParser.FinallyBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#finallyBlock}.
	 * @param ctx the parse tree
	 */
	void exitFinallyBlock(Java7TemplateParser.FinallyBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(Java7TemplateParser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(Java7TemplateParser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#resources}.
	 * @param ctx the parse tree
	 */
	void enterResources(Java7TemplateParser.ResourcesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#resources}.
	 * @param ctx the parse tree
	 */
	void exitResources(Java7TemplateParser.ResourcesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(Java7TemplateParser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(Java7TemplateParser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlockStatementGroup(Java7TemplateParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#switchBlockStatementGroup}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlockStatementGroup(Java7TemplateParser.SwitchBlockStatementGroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void enterSwitchLabel(Java7TemplateParser.SwitchLabelContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#switchLabel}.
	 * @param ctx the parse tree
	 */
	void exitSwitchLabel(Java7TemplateParser.SwitchLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(Java7TemplateParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(Java7TemplateParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(Java7TemplateParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(Java7TemplateParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForControl(Java7TemplateParser.EnhancedForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#enhancedForControl}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForControl(Java7TemplateParser.EnhancedForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(Java7TemplateParser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(Java7TemplateParser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void enterParExpression(Java7TemplateParser.ParExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#parExpression}.
	 * @param ctx the parse tree
	 */
	void exitParExpression(Java7TemplateParser.ParExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(Java7TemplateParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(Java7TemplateParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(Java7TemplateParser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(Java7TemplateParser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void enterConstantExpression(Java7TemplateParser.ConstantExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#constantExpression}.
	 * @param ctx the parse tree
	 */
	void exitConstantExpression(Java7TemplateParser.ConstantExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Java7TemplateParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Java7TemplateParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(Java7TemplateParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(Java7TemplateParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterCreator(Java7TemplateParser.CreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitCreator(Java7TemplateParser.CreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#createdName}.
	 * @param ctx the parse tree
	 */
	void enterCreatedName(Java7TemplateParser.CreatedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#createdName}.
	 * @param ctx the parse tree
	 */
	void exitCreatedName(Java7TemplateParser.CreatedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void enterInnerCreator(Java7TemplateParser.InnerCreatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#innerCreator}.
	 * @param ctx the parse tree
	 */
	void exitInnerCreator(Java7TemplateParser.InnerCreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreatorRest(Java7TemplateParser.ArrayCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#arrayCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreatorRest(Java7TemplateParser.ArrayCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void enterClassCreatorRest(Java7TemplateParser.ClassCreatorRestContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#classCreatorRest}.
	 * @param ctx the parse tree
	 */
	void exitClassCreatorRest(Java7TemplateParser.ClassCreatorRestContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocation(Java7TemplateParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#explicitGenericInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocation(Java7TemplateParser.ExplicitGenericInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArguments(Java7TemplateParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#nonWildcardTypeArguments}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArguments(Java7TemplateParser.NonWildcardTypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentsOrDiamond(Java7TemplateParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentsOrDiamond(Java7TemplateParser.TypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterNonWildcardTypeArgumentsOrDiamond(Java7TemplateParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#nonWildcardTypeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitNonWildcardTypeArgumentsOrDiamond(Java7TemplateParser.NonWildcardTypeArgumentsOrDiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void enterSuperSuffix(Java7TemplateParser.SuperSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#superSuffix}.
	 * @param ctx the parse tree
	 */
	void exitSuperSuffix(Java7TemplateParser.SuperSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void enterExplicitGenericInvocationSuffix(Java7TemplateParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#explicitGenericInvocationSuffix}.
	 * @param ctx the parse tree
	 */
	void exitExplicitGenericInvocationSuffix(Java7TemplateParser.ExplicitGenericInvocationSuffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(Java7TemplateParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(Java7TemplateParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ABSTRACTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ABSTRACTPlaceHolder(Java7TemplateParser.Fm_ABSTRACTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ABSTRACTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ABSTRACTPlaceHolder(Java7TemplateParser.Fm_ABSTRACTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ASSERTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ASSERTPlaceHolder(Java7TemplateParser.Fm_ASSERTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ASSERTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ASSERTPlaceHolder(Java7TemplateParser.Fm_ASSERTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_BOOLEANPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BOOLEANPlaceHolder(Java7TemplateParser.Fm_BOOLEANPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_BOOLEANPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BOOLEANPlaceHolder(Java7TemplateParser.Fm_BOOLEANPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_BREAKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BREAKPlaceHolder(Java7TemplateParser.Fm_BREAKPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_BREAKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BREAKPlaceHolder(Java7TemplateParser.Fm_BREAKPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_BYTEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BYTEPlaceHolder(Java7TemplateParser.Fm_BYTEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_BYTEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BYTEPlaceHolder(Java7TemplateParser.Fm_BYTEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_CASEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CASEPlaceHolder(Java7TemplateParser.Fm_CASEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_CASEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CASEPlaceHolder(Java7TemplateParser.Fm_CASEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_CATCHPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CATCHPlaceHolder(Java7TemplateParser.Fm_CATCHPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_CATCHPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CATCHPlaceHolder(Java7TemplateParser.Fm_CATCHPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_CHARPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CHARPlaceHolder(Java7TemplateParser.Fm_CHARPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_CHARPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CHARPlaceHolder(Java7TemplateParser.Fm_CHARPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_CLASSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CLASSPlaceHolder(Java7TemplateParser.Fm_CLASSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_CLASSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CLASSPlaceHolder(Java7TemplateParser.Fm_CLASSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_CONSTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CONSTPlaceHolder(Java7TemplateParser.Fm_CONSTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_CONSTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CONSTPlaceHolder(Java7TemplateParser.Fm_CONSTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_CONTINUEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CONTINUEPlaceHolder(Java7TemplateParser.Fm_CONTINUEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_CONTINUEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CONTINUEPlaceHolder(Java7TemplateParser.Fm_CONTINUEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_DEFAULTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DEFAULTPlaceHolder(Java7TemplateParser.Fm_DEFAULTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_DEFAULTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DEFAULTPlaceHolder(Java7TemplateParser.Fm_DEFAULTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_DOPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DOPlaceHolder(Java7TemplateParser.Fm_DOPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_DOPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DOPlaceHolder(Java7TemplateParser.Fm_DOPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_DOUBLEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DOUBLEPlaceHolder(Java7TemplateParser.Fm_DOUBLEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_DOUBLEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DOUBLEPlaceHolder(Java7TemplateParser.Fm_DOUBLEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ELSEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ELSEPlaceHolder(Java7TemplateParser.Fm_ELSEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ELSEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ELSEPlaceHolder(Java7TemplateParser.Fm_ELSEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ENUMPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ENUMPlaceHolder(Java7TemplateParser.Fm_ENUMPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ENUMPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ENUMPlaceHolder(Java7TemplateParser.Fm_ENUMPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_EXTENDSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_EXTENDSPlaceHolder(Java7TemplateParser.Fm_EXTENDSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_EXTENDSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_EXTENDSPlaceHolder(Java7TemplateParser.Fm_EXTENDSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_FINALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FINALPlaceHolder(Java7TemplateParser.Fm_FINALPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_FINALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FINALPlaceHolder(Java7TemplateParser.Fm_FINALPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_FINALLYPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FINALLYPlaceHolder(Java7TemplateParser.Fm_FINALLYPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_FINALLYPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FINALLYPlaceHolder(Java7TemplateParser.Fm_FINALLYPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_FLOATPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FLOATPlaceHolder(Java7TemplateParser.Fm_FLOATPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_FLOATPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FLOATPlaceHolder(Java7TemplateParser.Fm_FLOATPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_FORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FORPlaceHolder(Java7TemplateParser.Fm_FORPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_FORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FORPlaceHolder(Java7TemplateParser.Fm_FORPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_IFPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IFPlaceHolder(Java7TemplateParser.Fm_IFPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_IFPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IFPlaceHolder(Java7TemplateParser.Fm_IFPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_GOTOPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GOTOPlaceHolder(Java7TemplateParser.Fm_GOTOPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_GOTOPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GOTOPlaceHolder(Java7TemplateParser.Fm_GOTOPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_IMPLEMENTSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IMPLEMENTSPlaceHolder(Java7TemplateParser.Fm_IMPLEMENTSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_IMPLEMENTSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IMPLEMENTSPlaceHolder(Java7TemplateParser.Fm_IMPLEMENTSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_IMPORTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IMPORTPlaceHolder(Java7TemplateParser.Fm_IMPORTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_IMPORTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IMPORTPlaceHolder(Java7TemplateParser.Fm_IMPORTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_INSTANCEOFPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_INSTANCEOFPlaceHolder(Java7TemplateParser.Fm_INSTANCEOFPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_INSTANCEOFPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_INSTANCEOFPlaceHolder(Java7TemplateParser.Fm_INSTANCEOFPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_INTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_INTPlaceHolder(Java7TemplateParser.Fm_INTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_INTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_INTPlaceHolder(Java7TemplateParser.Fm_INTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_INTERFACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_INTERFACEPlaceHolder(Java7TemplateParser.Fm_INTERFACEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_INTERFACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_INTERFACEPlaceHolder(Java7TemplateParser.Fm_INTERFACEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LONGPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LONGPlaceHolder(Java7TemplateParser.Fm_LONGPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LONGPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LONGPlaceHolder(Java7TemplateParser.Fm_LONGPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_NATIVEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NATIVEPlaceHolder(Java7TemplateParser.Fm_NATIVEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_NATIVEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NATIVEPlaceHolder(Java7TemplateParser.Fm_NATIVEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_NEWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NEWPlaceHolder(Java7TemplateParser.Fm_NEWPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_NEWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NEWPlaceHolder(Java7TemplateParser.Fm_NEWPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_PACKAGEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PACKAGEPlaceHolder(Java7TemplateParser.Fm_PACKAGEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_PACKAGEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PACKAGEPlaceHolder(Java7TemplateParser.Fm_PACKAGEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_PRIVATEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PRIVATEPlaceHolder(Java7TemplateParser.Fm_PRIVATEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_PRIVATEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PRIVATEPlaceHolder(Java7TemplateParser.Fm_PRIVATEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_PROTECTEDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PROTECTEDPlaceHolder(Java7TemplateParser.Fm_PROTECTEDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_PROTECTEDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PROTECTEDPlaceHolder(Java7TemplateParser.Fm_PROTECTEDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_PUBLICPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_PUBLICPlaceHolder(Java7TemplateParser.Fm_PUBLICPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_PUBLICPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_PUBLICPlaceHolder(Java7TemplateParser.Fm_PUBLICPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_RETURNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RETURNPlaceHolder(Java7TemplateParser.Fm_RETURNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_RETURNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RETURNPlaceHolder(Java7TemplateParser.Fm_RETURNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_SHORTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SHORTPlaceHolder(Java7TemplateParser.Fm_SHORTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_SHORTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SHORTPlaceHolder(Java7TemplateParser.Fm_SHORTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_STATICPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_STATICPlaceHolder(Java7TemplateParser.Fm_STATICPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_STATICPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_STATICPlaceHolder(Java7TemplateParser.Fm_STATICPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_STRICTFPPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_STRICTFPPlaceHolder(Java7TemplateParser.Fm_STRICTFPPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_STRICTFPPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_STRICTFPPlaceHolder(Java7TemplateParser.Fm_STRICTFPPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_SUPERPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SUPERPlaceHolder(Java7TemplateParser.Fm_SUPERPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_SUPERPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SUPERPlaceHolder(Java7TemplateParser.Fm_SUPERPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_SWITCHPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SWITCHPlaceHolder(Java7TemplateParser.Fm_SWITCHPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_SWITCHPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SWITCHPlaceHolder(Java7TemplateParser.Fm_SWITCHPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_SYNCHRONIZEDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SYNCHRONIZEDPlaceHolder(Java7TemplateParser.Fm_SYNCHRONIZEDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_SYNCHRONIZEDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SYNCHRONIZEDPlaceHolder(Java7TemplateParser.Fm_SYNCHRONIZEDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_THISPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_THISPlaceHolder(Java7TemplateParser.Fm_THISPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_THISPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_THISPlaceHolder(Java7TemplateParser.Fm_THISPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_THROWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_THROWPlaceHolder(Java7TemplateParser.Fm_THROWPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_THROWPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_THROWPlaceHolder(Java7TemplateParser.Fm_THROWPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_THROWSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_THROWSPlaceHolder(Java7TemplateParser.Fm_THROWSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_THROWSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_THROWSPlaceHolder(Java7TemplateParser.Fm_THROWSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_TRANSIENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_TRANSIENTPlaceHolder(Java7TemplateParser.Fm_TRANSIENTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_TRANSIENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_TRANSIENTPlaceHolder(Java7TemplateParser.Fm_TRANSIENTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_TRYPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_TRYPlaceHolder(Java7TemplateParser.Fm_TRYPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_TRYPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_TRYPlaceHolder(Java7TemplateParser.Fm_TRYPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_VOIDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_VOIDPlaceHolder(Java7TemplateParser.Fm_VOIDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_VOIDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_VOIDPlaceHolder(Java7TemplateParser.Fm_VOIDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_VOLATILEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_VOLATILEPlaceHolder(Java7TemplateParser.Fm_VOLATILEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_VOLATILEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_VOLATILEPlaceHolder(Java7TemplateParser.Fm_VOLATILEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_WHILEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_WHILEPlaceHolder(Java7TemplateParser.Fm_WHILEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_WHILEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_WHILEPlaceHolder(Java7TemplateParser.Fm_WHILEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_IntegerLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IntegerLiteralPlaceHolder(Java7TemplateParser.Fm_IntegerLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_IntegerLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IntegerLiteralPlaceHolder(Java7TemplateParser.Fm_IntegerLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_FloatingPointLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_FloatingPointLiteralPlaceHolder(Java7TemplateParser.Fm_FloatingPointLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_FloatingPointLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_FloatingPointLiteralPlaceHolder(Java7TemplateParser.Fm_FloatingPointLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_BooleanLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BooleanLiteralPlaceHolder(Java7TemplateParser.Fm_BooleanLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_BooleanLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BooleanLiteralPlaceHolder(Java7TemplateParser.Fm_BooleanLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_CharacterLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CharacterLiteralPlaceHolder(Java7TemplateParser.Fm_CharacterLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_CharacterLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CharacterLiteralPlaceHolder(Java7TemplateParser.Fm_CharacterLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_StringLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_StringLiteralPlaceHolder(Java7TemplateParser.Fm_StringLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_StringLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_StringLiteralPlaceHolder(Java7TemplateParser.Fm_StringLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_NullLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NullLiteralPlaceHolder(Java7TemplateParser.Fm_NullLiteralPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_NullLiteralPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NullLiteralPlaceHolder(Java7TemplateParser.Fm_NullLiteralPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LPARENPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPARENPlaceHolder(Java7TemplateParser.Fm_LPARENPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LPARENPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPARENPlaceHolder(Java7TemplateParser.Fm_LPARENPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_RPARENPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RPARENPlaceHolder(Java7TemplateParser.Fm_RPARENPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_RPARENPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RPARENPlaceHolder(Java7TemplateParser.Fm_RPARENPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LBRACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LBRACEPlaceHolder(Java7TemplateParser.Fm_LBRACEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LBRACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LBRACEPlaceHolder(Java7TemplateParser.Fm_LBRACEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_RBRACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RBRACEPlaceHolder(Java7TemplateParser.Fm_RBRACEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_RBRACEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RBRACEPlaceHolder(Java7TemplateParser.Fm_RBRACEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LBRACKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LBRACKPlaceHolder(Java7TemplateParser.Fm_LBRACKPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LBRACKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LBRACKPlaceHolder(Java7TemplateParser.Fm_LBRACKPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_RBRACKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RBRACKPlaceHolder(Java7TemplateParser.Fm_RBRACKPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_RBRACKPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RBRACKPlaceHolder(Java7TemplateParser.Fm_RBRACKPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_SEMIPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SEMIPlaceHolder(Java7TemplateParser.Fm_SEMIPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_SEMIPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SEMIPlaceHolder(Java7TemplateParser.Fm_SEMIPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_COMMAPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_COMMAPlaceHolder(Java7TemplateParser.Fm_COMMAPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_COMMAPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_COMMAPlaceHolder(Java7TemplateParser.Fm_COMMAPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_DOTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DOTPlaceHolder(Java7TemplateParser.Fm_DOTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_DOTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DOTPlaceHolder(Java7TemplateParser.Fm_DOTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ASSIGNPlaceHolder(Java7TemplateParser.Fm_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ASSIGNPlaceHolder(Java7TemplateParser.Fm_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_GTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GTPlaceHolder(Java7TemplateParser.Fm_GTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_GTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GTPlaceHolder(Java7TemplateParser.Fm_GTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LTPlaceHolder(Java7TemplateParser.Fm_LTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LTPlaceHolder(Java7TemplateParser.Fm_LTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_BANGPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BANGPlaceHolder(Java7TemplateParser.Fm_BANGPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_BANGPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BANGPlaceHolder(Java7TemplateParser.Fm_BANGPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_TILDEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_TILDEPlaceHolder(Java7TemplateParser.Fm_TILDEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_TILDEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_TILDEPlaceHolder(Java7TemplateParser.Fm_TILDEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_QUESTIONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_QUESTIONPlaceHolder(Java7TemplateParser.Fm_QUESTIONPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_QUESTIONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_QUESTIONPlaceHolder(Java7TemplateParser.Fm_QUESTIONPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_COLONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_COLONPlaceHolder(Java7TemplateParser.Fm_COLONPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_COLONPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_COLONPlaceHolder(Java7TemplateParser.Fm_COLONPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_EQUALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_EQUALPlaceHolder(Java7TemplateParser.Fm_EQUALPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_EQUALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_EQUALPlaceHolder(Java7TemplateParser.Fm_EQUALPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LEPlaceHolder(Java7TemplateParser.Fm_LEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LEPlaceHolder(Java7TemplateParser.Fm_LEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_GEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_GEPlaceHolder(Java7TemplateParser.Fm_GEPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_GEPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_GEPlaceHolder(Java7TemplateParser.Fm_GEPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_NOTEQUALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_NOTEQUALPlaceHolder(Java7TemplateParser.Fm_NOTEQUALPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_NOTEQUALPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_NOTEQUALPlaceHolder(Java7TemplateParser.Fm_NOTEQUALPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ANDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ANDPlaceHolder(Java7TemplateParser.Fm_ANDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ANDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ANDPlaceHolder(Java7TemplateParser.Fm_ANDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ORPlaceHolder(Java7TemplateParser.Fm_ORPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ORPlaceHolder(Java7TemplateParser.Fm_ORPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_INCPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_INCPlaceHolder(Java7TemplateParser.Fm_INCPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_INCPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_INCPlaceHolder(Java7TemplateParser.Fm_INCPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_DECPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DECPlaceHolder(Java7TemplateParser.Fm_DECPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_DECPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DECPlaceHolder(Java7TemplateParser.Fm_DECPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ADDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ADDPlaceHolder(Java7TemplateParser.Fm_ADDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ADDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ADDPlaceHolder(Java7TemplateParser.Fm_ADDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_SUBPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SUBPlaceHolder(Java7TemplateParser.Fm_SUBPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_SUBPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SUBPlaceHolder(Java7TemplateParser.Fm_SUBPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_MULPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MULPlaceHolder(Java7TemplateParser.Fm_MULPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_MULPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MULPlaceHolder(Java7TemplateParser.Fm_MULPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_DIVPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DIVPlaceHolder(Java7TemplateParser.Fm_DIVPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_DIVPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DIVPlaceHolder(Java7TemplateParser.Fm_DIVPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_BITANDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BITANDPlaceHolder(Java7TemplateParser.Fm_BITANDPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_BITANDPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BITANDPlaceHolder(Java7TemplateParser.Fm_BITANDPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_BITORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_BITORPlaceHolder(Java7TemplateParser.Fm_BITORPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_BITORPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_BITORPlaceHolder(Java7TemplateParser.Fm_BITORPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_CARETPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_CARETPlaceHolder(Java7TemplateParser.Fm_CARETPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_CARETPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_CARETPlaceHolder(Java7TemplateParser.Fm_CARETPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_MODPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MODPlaceHolder(Java7TemplateParser.Fm_MODPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_MODPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MODPlaceHolder(Java7TemplateParser.Fm_MODPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ADD_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ADD_ASSIGNPlaceHolder(Java7TemplateParser.Fm_ADD_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ADD_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ADD_ASSIGNPlaceHolder(Java7TemplateParser.Fm_ADD_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_SUB_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_SUB_ASSIGNPlaceHolder(Java7TemplateParser.Fm_SUB_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_SUB_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_SUB_ASSIGNPlaceHolder(Java7TemplateParser.Fm_SUB_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_MUL_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MUL_ASSIGNPlaceHolder(Java7TemplateParser.Fm_MUL_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_MUL_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MUL_ASSIGNPlaceHolder(Java7TemplateParser.Fm_MUL_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_DIV_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_DIV_ASSIGNPlaceHolder(Java7TemplateParser.Fm_DIV_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_DIV_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_DIV_ASSIGNPlaceHolder(Java7TemplateParser.Fm_DIV_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_AND_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_AND_ASSIGNPlaceHolder(Java7TemplateParser.Fm_AND_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_AND_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_AND_ASSIGNPlaceHolder(Java7TemplateParser.Fm_AND_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_OR_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_OR_ASSIGNPlaceHolder(Java7TemplateParser.Fm_OR_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_OR_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_OR_ASSIGNPlaceHolder(Java7TemplateParser.Fm_OR_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_XOR_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_XOR_ASSIGNPlaceHolder(Java7TemplateParser.Fm_XOR_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_XOR_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_XOR_ASSIGNPlaceHolder(Java7TemplateParser.Fm_XOR_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_MOD_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_MOD_ASSIGNPlaceHolder(Java7TemplateParser.Fm_MOD_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_MOD_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_MOD_ASSIGNPlaceHolder(Java7TemplateParser.Fm_MOD_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LSHIFT_ASSIGNPlaceHolder(Java7TemplateParser.Fm_LSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LSHIFT_ASSIGNPlaceHolder(Java7TemplateParser.Fm_LSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_RSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_RSHIFT_ASSIGNPlaceHolder(Java7TemplateParser.Fm_RSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_RSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_RSHIFT_ASSIGNPlaceHolder(Java7TemplateParser.Fm_RSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_URSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_URSHIFT_ASSIGNPlaceHolder(Java7TemplateParser.Fm_URSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_URSHIFT_ASSIGNPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_URSHIFT_ASSIGNPlaceHolder(Java7TemplateParser.Fm_URSHIFT_ASSIGNPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_IdentifierPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_IdentifierPlaceHolder(Java7TemplateParser.Fm_IdentifierPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_IdentifierPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_IdentifierPlaceHolder(Java7TemplateParser.Fm_IdentifierPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ATPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ATPlaceHolder(Java7TemplateParser.Fm_ATPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ATPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ATPlaceHolder(Java7TemplateParser.Fm_ATPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_ELLIPSISPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_ELLIPSISPlaceHolder(Java7TemplateParser.Fm_ELLIPSISPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_ELLIPSISPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_ELLIPSISPlaceHolder(Java7TemplateParser.Fm_ELLIPSISPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_WSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_WSPlaceHolder(Java7TemplateParser.Fm_WSPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_WSPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_WSPlaceHolder(Java7TemplateParser.Fm_WSPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_COMMENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_COMMENTPlaceHolder(Java7TemplateParser.Fm_COMMENTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_COMMENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_COMMENTPlaceHolder(Java7TemplateParser.Fm_COMMENTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LINE_COMMENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void enterFm_LINE_COMMENTPlaceHolder(Java7TemplateParser.Fm_LINE_COMMENTPlaceHolderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LINE_COMMENTPlaceHolder}.
	 * @param ctx the parse tree
	 */
	void exitFm_LINE_COMMENTPlaceHolder(Java7TemplateParser.Fm_LINE_COMMENTPlaceHolderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenblockStatementRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockStatementRParenIfLoop(Java7TemplateParser.Fm_LParenblockStatementRParenIfLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenblockStatementRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockStatementRParenIfLoop(Java7TemplateParser.Fm_LParenblockStatementRParenIfLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenswitchLabelRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchLabelRParenIfLoop(Java7TemplateParser.Fm_LParenswitchLabelRParenIfLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenswitchLabelRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchLabelRParenIfLoop(Java7TemplateParser.Fm_LParenswitchLabelRParenIfLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParencatchClauseRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchClauseRParenIfLoop(Java7TemplateParser.Fm_LParencatchClauseRParenIfLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParencatchClauseRParenIfLoop}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchClauseRParenIfLoop(Java7TemplateParser.Fm_LParencatchClauseRParenIfLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeParameterRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableInitializerRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenannotationTypeElementDeclarationRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenannotationTypeElementDeclarationRParenRParenStar(Java7TemplateParser.Fm_LParenLParenannotationTypeElementDeclarationRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenannotationTypeElementDeclarationRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenannotationTypeElementDeclarationRParenRParenStar(Java7TemplateParser.Fm_LParenLParenannotationTypeElementDeclarationRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_IdentifierPlaceHolderOrIdentifierRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableModifierRParenStar(Java7TemplateParser.Fm_LParenvariableModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableModifierRParenStar(Java7TemplateParser.Fm_LParenvariableModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenmodifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmodifierRParenStar(Java7TemplateParser.Fm_LParenmodifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenmodifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmodifierRParenStar(Java7TemplateParser.Fm_LParenmodifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_BITANDPlaceHolderOrBITANDRParenLParentypeRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeArgumentRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_SEMIPlaceHolderOrSEMIRParenLParenresourceRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenswitchBlockStatementGroupRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchBlockStatementGroupRParenStar(Java7TemplateParser.Fm_LParenswitchBlockStatementGroupRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenswitchBlockStatementGroupRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchBlockStatementGroupRParenStar(Java7TemplateParser.Fm_LParenswitchBlockStatementGroupRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenconstantDeclaratorRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParencatchClauseRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchClauseRParenStar(Java7TemplateParser.Fm_LParencatchClauseRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParencatchClauseRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchClauseRParenStar(Java7TemplateParser.Fm_LParencatchClauseRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenformalParameterRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx10}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx10(Java7TemplateParser.Fm_newRulexXXx10Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx10}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx10(Java7TemplateParser.Fm_newRulexXXx10Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenexpressionRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenimportDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenimportDeclarationRParenStar(Java7TemplateParser.Fm_LParenimportDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenimportDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenimportDeclarationRParenStar(Java7TemplateParser.Fm_LParenimportDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenexpressionRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenswitchLabelRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchLabelRParenStar(Java7TemplateParser.Fm_LParenswitchLabelRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenswitchLabelRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchLabelRParenStar(Java7TemplateParser.Fm_LParenswitchLabelRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_BITORPlaceHolderOrBITORRParenLParenqualifiedNameRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenclassOrInterfaceModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassOrInterfaceModifierRParenStar(Java7TemplateParser.Fm_LParenclassOrInterfaceModifierRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenclassOrInterfaceModifierRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassOrInterfaceModifierRParenStar(Java7TemplateParser.Fm_LParenclassOrInterfaceModifierRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeDeclarationRParenStar(Java7TemplateParser.Fm_LParentypeDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeDeclarationRParenStar(Java7TemplateParser.Fm_LParentypeDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx3}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx3(Java7TemplateParser.Fm_newRulexXXx3Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx3}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx3(Java7TemplateParser.Fm_newRulexXXx3Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenclassBodyDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassBodyDeclarationRParenStar(Java7TemplateParser.Fm_LParenclassBodyDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenclassBodyDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassBodyDeclarationRParenStar(Java7TemplateParser.Fm_LParenclassBodyDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenblockStatementRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockStatementRParenStar(Java7TemplateParser.Fm_LParenblockStatementRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenblockStatementRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockStatementRParenStar(Java7TemplateParser.Fm_LParenblockStatementRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParentypeRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationRParenStar(Java7TemplateParser.Fm_LParenannotationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationRParenStar(Java7TemplateParser.Fm_LParenannotationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceBodyDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceBodyDeclarationRParenStar(Java7TemplateParser.Fm_LPareninterfaceBodyDeclarationRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceBodyDeclarationRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceBodyDeclarationRParenStar(Java7TemplateParser.Fm_LPareninterfaceBodyDeclarationRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenenumConstantRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValuePairRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenvariableDeclaratorRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenqualifiedNameRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStarContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStar(Java7TemplateParser.Fm_LParenLParenfm_LBRACKPlaceHolderOrLBRACKRParenLParenfm_RBRACKPlaceHolderOrRBRACKRParenRParenStarContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion(Java7TemplateParser.Fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestion(Java7TemplateParser.Fm_LParennonWildcardTypeArgumentsOrDiamondRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenexpressionRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionRParenQuestion(Java7TemplateParser.Fm_LParenexpressionRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenexpressionRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionRParenQuestion(Java7TemplateParser.Fm_LParenexpressionRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_ELSEPlaceHolderOrELSERParenstatementRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_ASSIGNPlaceHolderOrASSIGNRParenLParenvariableInitializerRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenexpressionListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionListRParenQuestion(Java7TemplateParser.Fm_LParenexpressionListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenexpressionListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionListRParenQuestion(Java7TemplateParser.Fm_LParenexpressionListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeListRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenLParentypeBoundRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenforUpdateRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenforUpdateRParenQuestion(Java7TemplateParser.Fm_LParenforUpdateRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenforUpdateRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenforUpdateRParenQuestion(Java7TemplateParser.Fm_LParenforUpdateRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeArgumentsOrDiamondRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentsOrDiamondRParenQuestion(Java7TemplateParser.Fm_LParentypeArgumentsOrDiamondRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeArgumentsOrDiamondRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentsOrDiamondRParenQuestion(Java7TemplateParser.Fm_LParentypeArgumentsOrDiamondRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion(Java7TemplateParser.Fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestion(Java7TemplateParser.Fm_LParenfm_COMMAPlaceHolderOrCOMMARParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenpackageDeclarationRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenpackageDeclarationRParenQuestion(Java7TemplateParser.Fm_LParenpackageDeclarationRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenpackageDeclarationRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenpackageDeclarationRParenQuestion(Java7TemplateParser.Fm_LParenpackageDeclarationRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenenumConstantsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumConstantsRParenQuestion(Java7TemplateParser.Fm_LParenenumConstantsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenenumConstantsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumConstantsRParenQuestion(Java7TemplateParser.Fm_LParenenumConstantsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParennonWildcardTypeArgumentsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParennonWildcardTypeArgumentsRParenQuestion(Java7TemplateParser.Fm_LParennonWildcardTypeArgumentsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParennonWildcardTypeArgumentsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParennonWildcardTypeArgumentsRParenQuestion(Java7TemplateParser.Fm_LParennonWildcardTypeArgumentsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion(Java7TemplateParser.Fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestion(Java7TemplateParser.Fm_LParenfm_SEMIPlaceHolderOrSEMIRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion(Java7TemplateParser.Fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestion(Java7TemplateParser.Fm_LParenfm_STATICPlaceHolderOrSTATICRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenargumentsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenargumentsRParenQuestion(Java7TemplateParser.Fm_LParenargumentsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenargumentsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenargumentsRParenQuestion(Java7TemplateParser.Fm_LParenargumentsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_THROWSPlaceHolderOrTHROWSRParenLParenqualifiedNameListRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeParametersRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeParametersRParenQuestion(Java7TemplateParser.Fm_LParentypeParametersRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeParametersRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeParametersRParenQuestion(Java7TemplateParser.Fm_LParentypeParametersRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParendefaultValueRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParendefaultValueRParenQuestion(Java7TemplateParser.Fm_LParendefaultValueRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParendefaultValueRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParendefaultValueRParenQuestion(Java7TemplateParser.Fm_LParendefaultValueRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx4}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx4(Java7TemplateParser.Fm_newRulexXXx4Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx4}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx4(Java7TemplateParser.Fm_newRulexXXx4Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenenumBodyDeclarationsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumBodyDeclarationsRParenQuestion(Java7TemplateParser.Fm_LParenenumBodyDeclarationsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenenumBodyDeclarationsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumBodyDeclarationsRParenQuestion(Java7TemplateParser.Fm_LParenenumBodyDeclarationsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenlastFormalParameterRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenclassBodyRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassBodyRParenQuestion(Java7TemplateParser.Fm_LParenclassBodyRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenclassBodyRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassBodyRParenQuestion(Java7TemplateParser.Fm_LParenclassBodyRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenelementValuePairsRParenOrLParenelementValueRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_COLONPlaceHolderOrCOLONRParenLParenexpressionRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion(Java7TemplateParser.Fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestion(Java7TemplateParser.Fm_LParenLParenelementValueRParenLParenLParenfm_COMMAPlaceHolderOrCOMMARParenLParenelementValueRParenRParenStarRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx5}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx5(Java7TemplateParser.Fm_newRulexXXx5Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx5}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx5(Java7TemplateParser.Fm_newRulexXXx5Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeArgumentsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentsRParenQuestion(Java7TemplateParser.Fm_LParentypeArgumentsRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeArgumentsRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentsRParenQuestion(Java7TemplateParser.Fm_LParentypeArgumentsRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenLParentypeListRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenforInitRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenforInitRParenQuestion(Java7TemplateParser.Fm_LParenforInitRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenforInitRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenforInitRParenQuestion(Java7TemplateParser.Fm_LParenforInitRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion(Java7TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestion(Java7TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx2}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx2(Java7TemplateParser.Fm_newRulexXXx2Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx2}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx2(Java7TemplateParser.Fm_newRulexXXx2Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestion(Java7TemplateParser.Fm_LParenLParenfm_DOTPlaceHolderOrDOTRParenLParenfm_MULPlaceHolderOrMULRParenRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfinallyBlockRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfinallyBlockRParenQuestion(Java7TemplateParser.Fm_LParenfinallyBlockRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfinallyBlockRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfinallyBlockRParenQuestion(Java7TemplateParser.Fm_LParenfinallyBlockRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenformalParameterListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenformalParameterListRParenQuestion(Java7TemplateParser.Fm_LParenformalParameterListRParenQuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenformalParameterListRParenQuestion}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenformalParameterListRParenQuestion(Java7TemplateParser.Fm_LParenformalParameterListRParenQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LEPlaceHolderOrLERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LEPlaceHolderOrLERParenOne(Java7TemplateParser.Fm_LParenfm_LEPlaceHolderOrLERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LEPlaceHolderOrLERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LEPlaceHolderOrLERParenOne(Java7TemplateParser.Fm_LParenfm_LEPlaceHolderOrLERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenforControlRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenforControlRParenOne(Java7TemplateParser.Fm_LParenforControlRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenforControlRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenforControlRParenOne(Java7TemplateParser.Fm_LParenforControlRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_WHILEPlaceHolderOrWHILERParenOne(Java7TemplateParser.Fm_LParenfm_WHILEPlaceHolderOrWHILERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_WHILEPlaceHolderOrWHILERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_WHILEPlaceHolderOrWHILERParenOne(Java7TemplateParser.Fm_LParenfm_WHILEPlaceHolderOrWHILERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenarrayCreatorRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenarrayCreatorRestRParenOne(Java7TemplateParser.Fm_LParenarrayCreatorRestRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenarrayCreatorRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenarrayCreatorRestRParenOne(Java7TemplateParser.Fm_LParenarrayCreatorRestRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParencreatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencreatorRParenOne(Java7TemplateParser.Fm_LParencreatorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParencreatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencreatorRParenOne(Java7TemplateParser.Fm_LParencreatorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne(Java7TemplateParser.Fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_VOIDPlaceHolderOrVOIDRParenOne(Java7TemplateParser.Fm_LParenfm_VOIDPlaceHolderOrVOIDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CHARPlaceHolderOrCHARRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CHARPlaceHolderOrCHARRParenOne(Java7TemplateParser.Fm_LParenfm_CHARPlaceHolderOrCHARRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CHARPlaceHolderOrCHARRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CHARPlaceHolderOrCHARRParenOne(Java7TemplateParser.Fm_LParenfm_CHARPlaceHolderOrCHARRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationConstantRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationConstantRestRParenOne(Java7TemplateParser.Fm_LParenannotationConstantRestRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationConstantRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationConstantRestRParenOne(Java7TemplateParser.Fm_LParenannotationConstantRestRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IFPlaceHolderOrIFRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IFPlaceHolderOrIFRParenOne(Java7TemplateParser.Fm_LParenfm_IFPlaceHolderOrIFRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IFPlaceHolderOrIFRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IFPlaceHolderOrIFRParenOne(Java7TemplateParser.Fm_LParenfm_IFPlaceHolderOrIFRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx7}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx7(Java7TemplateParser.Fm_newRulexXXx7Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx7}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx7(Java7TemplateParser.Fm_newRulexXXx7Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParengenericMethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengenericMethodDeclarationRParenOne(Java7TemplateParser.Fm_LParengenericMethodDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParengenericMethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengenericMethodDeclarationRParenOne(Java7TemplateParser.Fm_LParengenericMethodDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParengenericInterfaceMethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengenericInterfaceMethodDeclarationRParenOne(Java7TemplateParser.Fm_LParengenericInterfaceMethodDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParengenericInterfaceMethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengenericInterfaceMethodDeclarationRParenOne(Java7TemplateParser.Fm_LParengenericInterfaceMethodDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationTypeBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeBodyRParenOne(Java7TemplateParser.Fm_LParenannotationTypeBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationTypeBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeBodyRParenOne(Java7TemplateParser.Fm_LParenannotationTypeBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne(Java7TemplateParser.Fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOne(Java7TemplateParser.Fm_LParenLParenarrayCreatorRestRParenOrLParenclassCreatorRestRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_TRYPlaceHolderOrTRYRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_TRYPlaceHolderOrTRYRParenOne(Java7TemplateParser.Fm_LParenfm_TRYPlaceHolderOrTRYRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_TRYPlaceHolderOrTRYRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_TRYPlaceHolderOrTRYRParenOne(Java7TemplateParser.Fm_LParenfm_TRYPlaceHolderOrTRYRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FINALPlaceHolderOrFINALRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FINALPlaceHolderOrFINALRParenOne(Java7TemplateParser.Fm_LParenfm_FINALPlaceHolderOrFINALRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FINALPlaceHolderOrFINALRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FINALPlaceHolderOrFINALRParenOne(Java7TemplateParser.Fm_LParenfm_FINALPlaceHolderOrFINALRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne(Java7TemplateParser.Fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOne(Java7TemplateParser.Fm_LParenfm_QUESTIONPlaceHolderOrQUESTIONRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SUBPlaceHolderOrSUBRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SUBPlaceHolderOrSUBRParenOne(Java7TemplateParser.Fm_LParenfm_SUBPlaceHolderOrSUBRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SUBPlaceHolderOrSUBRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SUBPlaceHolderOrSUBRParenOne(Java7TemplateParser.Fm_LParenfm_SUBPlaceHolderOrSUBRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenprimaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimaryRParenOne(Java7TemplateParser.Fm_LParenprimaryRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenprimaryRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimaryRParenOne(Java7TemplateParser.Fm_LParenprimaryRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenclassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassOrInterfaceTypeRParenOne(Java7TemplateParser.Fm_LParenclassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenclassOrInterfaceTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassOrInterfaceTypeRParenOne(Java7TemplateParser.Fm_LParenclassOrInterfaceTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne(Java7TemplateParser.Fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOne(Java7TemplateParser.Fm_LParenfm_TRANSIENTPlaceHolderOrTRANSIENTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenclassOrInterfaceModifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassOrInterfaceModifierRParenOne(Java7TemplateParser.Fm_LParenclassOrInterfaceModifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenclassOrInterfaceModifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassOrInterfaceModifierRParenOne(Java7TemplateParser.Fm_LParenclassOrInterfaceModifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenstatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstatementRParenOne(Java7TemplateParser.Fm_LParenstatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenstatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstatementRParenOne(Java7TemplateParser.Fm_LParenstatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_MOD_ASSIGNPlaceHolderOrMOD_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_SUB_ASSIGNPlaceHolderOrSUB_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne(Java7TemplateParser.Fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_EQUALPlaceHolderOrEQUALRParenOne(Java7TemplateParser.Fm_LParenfm_EQUALPlaceHolderOrEQUALRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenenumDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumDeclarationRParenOne(Java7TemplateParser.Fm_LParenenumDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenenumDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumDeclarationRParenOne(Java7TemplateParser.Fm_LParenenumDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenresourceSpecificationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenresourceSpecificationRParenOne(Java7TemplateParser.Fm_LParenresourceSpecificationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenresourceSpecificationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenresourceSpecificationRParenOne(Java7TemplateParser.Fm_LParenresourceSpecificationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeArgumentsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentsRParenOne(Java7TemplateParser.Fm_LParentypeArgumentsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeArgumentsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentsRParenOne(Java7TemplateParser.Fm_LParentypeArgumentsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenconstantDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstantDeclaratorRParenOne(Java7TemplateParser.Fm_LParenconstantDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenconstantDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstantDeclaratorRParenOne(Java7TemplateParser.Fm_LParenconstantDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne(Java7TemplateParser.Fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RPARENPlaceHolderOrRPARENRParenOne(Java7TemplateParser.Fm_LParenfm_RPARENPlaceHolderOrRPARENRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne(Java7TemplateParser.Fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOne(Java7TemplateParser.Fm_LParenfm_ABSTRACTPlaceHolderOrABSTRACTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_EQUALPlaceHolderOrEQUALRParenOrLParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeBoundRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeBoundRParenOne(Java7TemplateParser.Fm_LParentypeBoundRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeBoundRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeBoundRParenOne(Java7TemplateParser.Fm_LParentypeBoundRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_ASSIGNPlaceHolderOrASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne(Java7TemplateParser.Fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CLASSPlaceHolderOrCLASSRParenOne(Java7TemplateParser.Fm_LParenfm_CLASSPlaceHolderOrCLASSRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CASEPlaceHolderOrCASERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CASEPlaceHolderOrCASERParenOne(Java7TemplateParser.Fm_LParenfm_CASEPlaceHolderOrCASERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CASEPlaceHolderOrCASERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CASEPlaceHolderOrCASERParenOne(Java7TemplateParser.Fm_LParenfm_CASEPlaceHolderOrCASERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BITORPlaceHolderOrBITORRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BITORPlaceHolderOrBITORRParenOne(Java7TemplateParser.Fm_LParenfm_BITORPlaceHolderOrBITORRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BITORPlaceHolderOrBITORRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BITORPlaceHolderOrBITORRParenOne(Java7TemplateParser.Fm_LParenfm_BITORPlaceHolderOrBITORRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParencatchTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchTypeRParenOne(Java7TemplateParser.Fm_LParencatchTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParencatchTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchTypeRParenOne(Java7TemplateParser.Fm_LParencatchTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne(Java7TemplateParser.Fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CATCHPlaceHolderOrCATCHRParenOne(Java7TemplateParser.Fm_LParenfm_CATCHPlaceHolderOrCATCHRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne(Java7TemplateParser.Fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOne(Java7TemplateParser.Fm_LParenfm_PACKAGEPlaceHolderOrPACKAGERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LTPlaceHolderOrLTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LTPlaceHolderOrLTRParenOne(Java7TemplateParser.Fm_LParenfm_LTPlaceHolderOrLTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LTPlaceHolderOrLTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LTPlaceHolderOrLTRParenOne(Java7TemplateParser.Fm_LParenfm_LTPlaceHolderOrLTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne(Java7TemplateParser.Fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOne(Java7TemplateParser.Fm_LParenfm_DOUBLEPlaceHolderOrDOUBLERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenlocalVariableDeclarationStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlocalVariableDeclarationStatementRParenOne(Java7TemplateParser.Fm_LParenlocalVariableDeclarationStatementRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenlocalVariableDeclarationStatementRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlocalVariableDeclarationStatementRParenOne(Java7TemplateParser.Fm_LParenlocalVariableDeclarationStatementRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceBodyRParenOne(Java7TemplateParser.Fm_LPareninterfaceBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceBodyRParenOne(Java7TemplateParser.Fm_LPareninterfaceBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne(Java7TemplateParser.Fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOne(Java7TemplateParser.Fm_LParenfm_PRIVATEPlaceHolderOrPRIVATERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne(Java7TemplateParser.Fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOne(Java7TemplateParser.Fm_LParenfm_DEFAULTPlaceHolderOrDEFAULTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParennonWildcardTypeArgumentsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParennonWildcardTypeArgumentsRParenOne(Java7TemplateParser.Fm_LParennonWildcardTypeArgumentsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParennonWildcardTypeArgumentsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParennonWildcardTypeArgumentsRParenOne(Java7TemplateParser.Fm_LParennonWildcardTypeArgumentsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne(Java7TemplateParser.Fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SEMIPlaceHolderOrSEMIRParenOne(Java7TemplateParser.Fm_LParenfm_SEMIPlaceHolderOrSEMIRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenstatementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenstatementExpressionRParenOne(Java7TemplateParser.Fm_LParenstatementExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenstatementExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenstatementExpressionRParenOne(Java7TemplateParser.Fm_LParenstatementExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenformalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenformalParameterRParenOne(Java7TemplateParser.Fm_LParenformalParameterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenformalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenformalParameterRParenOne(Java7TemplateParser.Fm_LParenformalParameterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne(Java7TemplateParser.Fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LPARENPlaceHolderOrLPARENRParenOne(Java7TemplateParser.Fm_LParenfm_LPARENPlaceHolderOrLPARENRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_StringLiteralPlaceHolderOrStringLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenmethodBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodBodyRParenOne(Java7TemplateParser.Fm_LParenmethodBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenmethodBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodBodyRParenOne(Java7TemplateParser.Fm_LParenmethodBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_XOR_ASSIGNPlaceHolderOrXOR_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ANDPlaceHolderOrANDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ANDPlaceHolderOrANDRParenOne(Java7TemplateParser.Fm_LParenfm_ANDPlaceHolderOrANDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ANDPlaceHolderOrANDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ANDPlaceHolderOrANDRParenOne(Java7TemplateParser.Fm_LParenfm_ANDPlaceHolderOrANDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenconstructorDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstructorDeclarationRParenOne(Java7TemplateParser.Fm_LParenconstructorDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenconstructorDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstructorDeclarationRParenOne(Java7TemplateParser.Fm_LParenconstructorDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne(Java7TemplateParser.Fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOne(Java7TemplateParser.Fm_LParenfm_LBRACEPlaceHolderOrLBRACERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_GTPlaceHolderOrGTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_GTPlaceHolderOrGTRParenOne(Java7TemplateParser.Fm_LParenfm_GTPlaceHolderOrGTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_GTPlaceHolderOrGTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_GTPlaceHolderOrGTRParenOne(Java7TemplateParser.Fm_LParenfm_GTPlaceHolderOrGTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenqualifiedNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenqualifiedNameRParenOne(Java7TemplateParser.Fm_LParenqualifiedNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenqualifiedNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenqualifiedNameRParenOne(Java7TemplateParser.Fm_LParenqualifiedNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LONGPlaceHolderOrLONGRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LONGPlaceHolderOrLONGRParenOne(Java7TemplateParser.Fm_LParenfm_LONGPlaceHolderOrLONGRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LONGPlaceHolderOrLONGRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LONGPlaceHolderOrLONGRParenOne(Java7TemplateParser.Fm_LParenfm_LONGPlaceHolderOrLONGRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenexpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionRParenOne(Java7TemplateParser.Fm_LParenexpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenexpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionRParenOne(Java7TemplateParser.Fm_LParenexpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenconstantExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstantExpressionRParenOne(Java7TemplateParser.Fm_LParenconstantExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenconstantExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstantExpressionRParenOne(Java7TemplateParser.Fm_LParenconstantExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne(Java7TemplateParser.Fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOne(Java7TemplateParser.Fm_LParenfm_IMPORTPlaceHolderOrIMPORTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeArgumentRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeArgumentRParenOne(Java7TemplateParser.Fm_LParentypeArgumentRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeArgumentRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeArgumentRParenOne(Java7TemplateParser.Fm_LParentypeArgumentRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParencreatedNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencreatedNameRParenOne(Java7TemplateParser.Fm_LParencreatedNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParencreatedNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencreatedNameRParenOne(Java7TemplateParser.Fm_LParencreatedNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne(Java7TemplateParser.Fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOne(Java7TemplateParser.Fm_LParenfm_ELLIPSISPlaceHolderOrELLIPSISRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationMethodRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationMethodRestRParenOne(Java7TemplateParser.Fm_LParenannotationMethodRestRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationMethodRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationMethodRestRParenOne(Java7TemplateParser.Fm_LParenannotationMethodRestRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenarrayInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenarrayInitializerRParenOne(Java7TemplateParser.Fm_LParenarrayInitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenarrayInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenarrayInitializerRParenOne(Java7TemplateParser.Fm_LParenarrayInitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne(Java7TemplateParser.Fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOne(Java7TemplateParser.Fm_LParenfm_RBRACKPlaceHolderOrRBRACKRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne(Java7TemplateParser.Fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BITANDPlaceHolderOrBITANDRParenOne(Java7TemplateParser.Fm_LParenfm_BITANDPlaceHolderOrBITANDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_FloatingPointLiteralPlaceHolderOrFloatingPointLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeParameterRParenOne(Java7TemplateParser.Fm_LParentypeParameterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeParameterRParenOne(Java7TemplateParser.Fm_LParentypeParameterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenliteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenliteralRParenOne(Java7TemplateParser.Fm_LParenliteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenliteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenliteralRParenOne(Java7TemplateParser.Fm_LParenliteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_THISPlaceHolderOrTHISRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_THISPlaceHolderOrTHISRParenOne(Java7TemplateParser.Fm_LParenfm_THISPlaceHolderOrTHISRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_THISPlaceHolderOrTHISRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_THISPlaceHolderOrTHISRParenOne(Java7TemplateParser.Fm_LParenfm_THISPlaceHolderOrTHISRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_OR_ASSIGNPlaceHolderOrOR_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenclassBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassBodyRParenOne(Java7TemplateParser.Fm_LParenclassBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenclassBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassBodyRParenOne(Java7TemplateParser.Fm_LParenclassBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne(Java7TemplateParser.Fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOne(Java7TemplateParser.Fm_LParenLParenmethodBodyRParenOrLParenfm_SEMIPlaceHolderOrSEMIRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeRParenOne(Java7TemplateParser.Fm_LParentypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeRParenOne(Java7TemplateParser.Fm_LParentypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableDeclaratorIdRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableDeclaratorIdRParenOne(Java7TemplateParser.Fm_LParenvariableDeclaratorIdRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableDeclaratorIdRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableDeclaratorIdRParenOne(Java7TemplateParser.Fm_LParenvariableDeclaratorIdRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenenumConstantNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumConstantNameRParenOne(Java7TemplateParser.Fm_LParenenumConstantNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenenumConstantNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumConstantNameRParenOne(Java7TemplateParser.Fm_LParenenumConstantNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenswitchLabelRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenswitchLabelRParenOnePlus(Java7TemplateParser.Fm_LParenswitchLabelRParenOnePlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenswitchLabelRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenswitchLabelRParenOnePlus(Java7TemplateParser.Fm_LParenswitchLabelRParenOnePlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_MULPlaceHolderOrMULRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MULPlaceHolderOrMULRParenOne(Java7TemplateParser.Fm_LParenfm_MULPlaceHolderOrMULRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_MULPlaceHolderOrMULRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MULPlaceHolderOrMULRParenOne(Java7TemplateParser.Fm_LParenfm_MULPlaceHolderOrMULRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenenumConstantRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenumConstantRParenOne(Java7TemplateParser.Fm_LParenenumConstantRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenenumConstantRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenumConstantRParenOne(Java7TemplateParser.Fm_LParenenumConstantRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne(Java7TemplateParser.Fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOne(Java7TemplateParser.Fm_LParenfm_SYNCHRONIZEDPlaceHolderOrSYNCHRONIZEDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne(Java7TemplateParser.Fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOne(Java7TemplateParser.Fm_LParenfm_INSTANCEOFPlaceHolderOrINSTANCEOFRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne(Java7TemplateParser.Fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOne(Java7TemplateParser.Fm_LParenLParencatchClauseRParenPlusLParenfinallyBlockRParenQuestionOrLParenfinallyBlockRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ORPlaceHolderOrORRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ORPlaceHolderOrORRParenOne(Java7TemplateParser.Fm_LParenfm_ORPlaceHolderOrORRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ORPlaceHolderOrORRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ORPlaceHolderOrORRParenOne(Java7TemplateParser.Fm_LParenfm_ORPlaceHolderOrORRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx1}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx1(Java7TemplateParser.Fm_newRulexXXx1Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx1}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx1(Java7TemplateParser.Fm_newRulexXXx1Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationMethodOrConstantRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationMethodOrConstantRestRParenOne(Java7TemplateParser.Fm_LParenannotationMethodOrConstantRestRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationMethodOrConstantRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationMethodOrConstantRestRParenOne(Java7TemplateParser.Fm_LParenannotationMethodOrConstantRestRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ENUMPlaceHolderOrENUMRParenOne(Java7TemplateParser.Fm_LParenfm_ENUMPlaceHolderOrENUMRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ENUMPlaceHolderOrENUMRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ENUMPlaceHolderOrENUMRParenOne(Java7TemplateParser.Fm_LParenfm_ENUMPlaceHolderOrENUMRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenexpressionListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexpressionListRParenOne(Java7TemplateParser.Fm_LParenexpressionListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenexpressionListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexpressionListRParenOne(Java7TemplateParser.Fm_LParenexpressionListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DECPlaceHolderOrDECRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DECPlaceHolderOrDECRParenOne(Java7TemplateParser.Fm_LParenfm_DECPlaceHolderOrDECRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DECPlaceHolderOrDECRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DECPlaceHolderOrDECRParenOne(Java7TemplateParser.Fm_LParenfm_DECPlaceHolderOrDECRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenmethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmethodDeclarationRParenOne(Java7TemplateParser.Fm_LParenmethodDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenmethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmethodDeclarationRParenOne(Java7TemplateParser.Fm_LParenmethodDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne(Java7TemplateParser.Fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOne(Java7TemplateParser.Fm_LParenfm_VOLATILEPlaceHolderOrVOLATILERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne(Java7TemplateParser.Fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOne(Java7TemplateParser.Fm_LParenLParentypeRParenOrLParenfm_VOIDPlaceHolderOrVOIDRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_STATICPlaceHolderOrSTATICRParenOne(Java7TemplateParser.Fm_LParenfm_STATICPlaceHolderOrSTATICRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_STATICPlaceHolderOrSTATICRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_STATICPlaceHolderOrSTATICRParenOne(Java7TemplateParser.Fm_LParenfm_STATICPlaceHolderOrSTATICRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ELSEPlaceHolderOrELSERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ELSEPlaceHolderOrELSERParenOne(Java7TemplateParser.Fm_LParenfm_ELSEPlaceHolderOrELSERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ELSEPlaceHolderOrELSERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ELSEPlaceHolderOrELSERParenOne(Java7TemplateParser.Fm_LParenfm_ELSEPlaceHolderOrELSERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne(Java7TemplateParser.Fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOne(Java7TemplateParser.Fm_LParenfm_THROWSPlaceHolderOrTHROWSRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParengenericConstructorDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParengenericConstructorDeclarationRParenOne(Java7TemplateParser.Fm_LParengenericConstructorDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParengenericConstructorDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParengenericConstructorDeclarationRParenOne(Java7TemplateParser.Fm_LParengenericConstructorDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx6}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx6(Java7TemplateParser.Fm_newRulexXXx6Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx6}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx6(Java7TemplateParser.Fm_newRulexXXx6Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne(Java7TemplateParser.Fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SUPERPlaceHolderOrSUPERRParenOne(Java7TemplateParser.Fm_LParenfm_SUPERPlaceHolderOrSUPERRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FORPlaceHolderOrFORRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FORPlaceHolderOrFORRParenOne(Java7TemplateParser.Fm_LParenfm_FORPlaceHolderOrFORRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FORPlaceHolderOrFORRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FORPlaceHolderOrFORRParenOne(Java7TemplateParser.Fm_LParenfm_FORPlaceHolderOrFORRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne(Java7TemplateParser.Fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOne(Java7TemplateParser.Fm_LParenfm_PROTECTEDPlaceHolderOrPROTECTEDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_CharacterLiteralPlaceHolderOrCharacterLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne(Java7TemplateParser.Fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOne(Java7TemplateParser.Fm_LParenLParenexplicitGenericInvocationSuffixRParenOrLParenfm_THISPlaceHolderOrTHISRParenLParenargumentsRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne(Java7TemplateParser.Fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOne(Java7TemplateParser.Fm_LParenfm_ASSERTPlaceHolderOrASSERTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenenhancedForControlRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenenhancedForControlRParenOne(Java7TemplateParser.Fm_LParenenhancedForControlRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenenhancedForControlRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenenhancedForControlRParenOne(Java7TemplateParser.Fm_LParenenhancedForControlRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenformalParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenformalParametersRParenOne(Java7TemplateParser.Fm_LParenformalParametersRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenformalParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenformalParametersRParenOne(Java7TemplateParser.Fm_LParenformalParametersRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenelementValuePairRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValuePairRParenOne(Java7TemplateParser.Fm_LParenelementValuePairRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenelementValuePairRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValuePairRParenOne(Java7TemplateParser.Fm_LParenelementValuePairRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_LSHIFT_ASSIGNPlaceHolderOrLSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_INCPlaceHolderOrINCRParenOrLParenfm_DECPlaceHolderOrDECRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne(Java7TemplateParser.Fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BREAKPlaceHolderOrBREAKRParenOne(Java7TemplateParser.Fm_LParenfm_BREAKPlaceHolderOrBREAKRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx11}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx11(Java7TemplateParser.Fm_newRulexXXx11Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx11}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx11(Java7TemplateParser.Fm_newRulexXXx11Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_ADD_ASSIGNPlaceHolderOrADD_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenclassDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassDeclarationRParenOne(Java7TemplateParser.Fm_LParenclassDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenclassDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassDeclarationRParenOne(Java7TemplateParser.Fm_LParenclassDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParensuperSuffixRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParensuperSuffixRParenOne(Java7TemplateParser.Fm_LParensuperSuffixRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParensuperSuffixRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParensuperSuffixRParenOne(Java7TemplateParser.Fm_LParensuperSuffixRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationTypeElementRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeElementRestRParenOne(Java7TemplateParser.Fm_LParenannotationTypeElementRestRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationTypeElementRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeElementRestRParenOne(Java7TemplateParser.Fm_LParenannotationTypeElementRestRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenprimitiveTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenprimitiveTypeRParenOne(Java7TemplateParser.Fm_LParenprimitiveTypeRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenprimitiveTypeRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenprimitiveTypeRParenOne(Java7TemplateParser.Fm_LParenprimitiveTypeRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne(Java7TemplateParser.Fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOne(Java7TemplateParser.Fm_LParenfm_LBRACKPlaceHolderOrLBRACKRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_RSHIFT_ASSIGNPlaceHolderOrRSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeParametersRParenOne(Java7TemplateParser.Fm_LParentypeParametersRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeParametersRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeParametersRParenOne(Java7TemplateParser.Fm_LParentypeParametersRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenresourceRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenresourceRParenOne(Java7TemplateParser.Fm_LParenresourceRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenresourceRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenresourceRParenOne(Java7TemplateParser.Fm_LParenresourceRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfieldDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfieldDeclarationRParenOne(Java7TemplateParser.Fm_LParenfieldDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfieldDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfieldDeclarationRParenOne(Java7TemplateParser.Fm_LParenfieldDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_THROWPlaceHolderOrTHROWRParenOne(Java7TemplateParser.Fm_LParenfm_THROWPlaceHolderOrTHROWRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_THROWPlaceHolderOrTHROWRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_THROWPlaceHolderOrTHROWRParenOne(Java7TemplateParser.Fm_LParenfm_THROWPlaceHolderOrTHROWRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOrLParenfm_SUPERPlaceHolderOrSUPERRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenblockStatementRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockStatementRParenOnePlus(Java7TemplateParser.Fm_LParenblockStatementRParenOnePlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenblockStatementRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockStatementRParenOnePlus(Java7TemplateParser.Fm_LParenblockStatementRParenOnePlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx0}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx0(Java7TemplateParser.Fm_newRulexXXx0Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx0}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx0(Java7TemplateParser.Fm_newRulexXXx0Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DOTPlaceHolderOrDOTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DOTPlaceHolderOrDOTRParenOne(Java7TemplateParser.Fm_LParenfm_DOTPlaceHolderOrDOTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DOTPlaceHolderOrDOTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DOTPlaceHolderOrDOTRParenOne(Java7TemplateParser.Fm_LParenfm_DOTPlaceHolderOrDOTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceMethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceMethodDeclarationRParenOne(Java7TemplateParser.Fm_LPareninterfaceMethodDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceMethodDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceMethodDeclarationRParenOne(Java7TemplateParser.Fm_LPareninterfaceMethodDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_ADDPlaceHolderOrADDRParenOrLParenfm_SUBPlaceHolderOrSUBRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationNameRParenOne(Java7TemplateParser.Fm_LParenannotationNameRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationNameRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationNameRParenOne(Java7TemplateParser.Fm_LParenannotationNameRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LPareninnerCreatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninnerCreatorRParenOne(Java7TemplateParser.Fm_LPareninnerCreatorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LPareninnerCreatorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninnerCreatorRParenOne(Java7TemplateParser.Fm_LPareninnerCreatorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_INTPlaceHolderOrINTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_INTPlaceHolderOrINTRParenOne(Java7TemplateParser.Fm_LParenfm_INTPlaceHolderOrINTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_INTPlaceHolderOrINTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_INTPlaceHolderOrINTRParenOne(Java7TemplateParser.Fm_LParenfm_INTPlaceHolderOrINTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenelementValueArrayInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValueArrayInitializerRParenOne(Java7TemplateParser.Fm_LParenelementValueArrayInitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenelementValueArrayInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValueArrayInitializerRParenOne(Java7TemplateParser.Fm_LParenelementValueArrayInitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DOPlaceHolderOrDORParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DOPlaceHolderOrDORParenOne(Java7TemplateParser.Fm_LParenfm_DOPlaceHolderOrDORParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DOPlaceHolderOrDORParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DOPlaceHolderOrDORParenOne(Java7TemplateParser.Fm_LParenfm_DOPlaceHolderOrDORParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_MUL_ASSIGNPlaceHolderOrMUL_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne(Java7TemplateParser.Fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOne(Java7TemplateParser.Fm_LParenfm_SWITCHPlaceHolderOrSWITCHRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne(Java7TemplateParser.Fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOne(Java7TemplateParser.Fm_LParenfm_CONTINUEPlaceHolderOrCONTINUERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenparExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenparExpressionRParenOne(Java7TemplateParser.Fm_LParenparExpressionRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenparExpressionRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenparExpressionRParenOne(Java7TemplateParser.Fm_LParenparExpressionRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenmemberDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenmemberDeclarationRParenOne(Java7TemplateParser.Fm_LParenmemberDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenmemberDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenmemberDeclarationRParenOne(Java7TemplateParser.Fm_LParenmemberDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParencatchClauseRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParencatchClauseRParenOnePlus(Java7TemplateParser.Fm_LParencatchClauseRParenOnePlusContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParencatchClauseRParenOnePlus}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParencatchClauseRParenOnePlus(Java7TemplateParser.Fm_LParencatchClauseRParenOnePlusContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_TILDEPlaceHolderOrTILDERParenOrLParenfm_BANGPlaceHolderOrBANGRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne(Java7TemplateParser.Fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOne(Java7TemplateParser.Fm_LParenfm_BOOLEANPlaceHolderOrBOOLEANRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationTypeElementDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeElementDeclarationRParenOne(Java7TemplateParser.Fm_LParenannotationTypeElementDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationTypeElementDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeElementDeclarationRParenOne(Java7TemplateParser.Fm_LParenannotationTypeElementDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_BooleanLiteralPlaceHolderOrBooleanLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenelementValuePairsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValuePairsRParenOne(Java7TemplateParser.Fm_LParenelementValuePairsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenelementValuePairsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValuePairsRParenOne(Java7TemplateParser.Fm_LParenelementValuePairsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne(Java7TemplateParser.Fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOne(Java7TemplateParser.Fm_LParenfm_EXTENDSPlaceHolderOrEXTENDSRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceMemberDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceMemberDeclarationRParenOne(Java7TemplateParser.Fm_LPareninterfaceMemberDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceMemberDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceMemberDeclarationRParenOne(Java7TemplateParser.Fm_LPareninterfaceMemberDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationRParenOne(Java7TemplateParser.Fm_LParenannotationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationRParenOne(Java7TemplateParser.Fm_LParenannotationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_NullLiteralPlaceHolderOrNullLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableDeclaratorsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableDeclaratorsRParenOne(Java7TemplateParser.Fm_LParenvariableDeclaratorsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableDeclaratorsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableDeclaratorsRParenOne(Java7TemplateParser.Fm_LParenvariableDeclaratorsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DIVPlaceHolderOrDIVRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DIVPlaceHolderOrDIVRParenOne(Java7TemplateParser.Fm_LParenfm_DIVPlaceHolderOrDIVRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DIVPlaceHolderOrDIVRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DIVPlaceHolderOrDIVRParenOne(Java7TemplateParser.Fm_LParenfm_DIVPlaceHolderOrDIVRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne(Java7TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOne(Java7TemplateParser.Fm_LParenfm_IdentifierPlaceHolderOrIdentifierRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne(Java7TemplateParser.Fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOne(Java7TemplateParser.Fm_LParenfm_PUBLICPlaceHolderOrPUBLICRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_AND_ASSIGNPlaceHolderOrAND_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenlastFormalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlastFormalParameterRParenOne(Java7TemplateParser.Fm_LParenlastFormalParameterRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenlastFormalParameterRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlastFormalParameterRParenOne(Java7TemplateParser.Fm_LParenlastFormalParameterRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_URSHIFT_ASSIGNPlaceHolderOrURSHIFT_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BANGPlaceHolderOrBANGRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BANGPlaceHolderOrBANGRParenOne(Java7TemplateParser.Fm_LParenfm_BANGPlaceHolderOrBANGRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BANGPlaceHolderOrBANGRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BANGPlaceHolderOrBANGRParenOne(Java7TemplateParser.Fm_LParenfm_BANGPlaceHolderOrBANGRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne(Java7TemplateParser.Fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RETURNPlaceHolderOrRETURNRParenOne(Java7TemplateParser.Fm_LParenfm_RETURNPlaceHolderOrRETURNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOne(Java7TemplateParser.Fm_LParenfm_DIV_ASSIGNPlaceHolderOrDIV_ASSIGNRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne(Java7TemplateParser.Fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOne(Java7TemplateParser.Fm_LParenfm_IMPLEMENTSPlaceHolderOrIMPLEMENTSRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeListRParenOne(Java7TemplateParser.Fm_LParentypeListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeListRParenOne(Java7TemplateParser.Fm_LParentypeListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_GEPlaceHolderOrGERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_GEPlaceHolderOrGERParenOne(Java7TemplateParser.Fm_LParenfm_GEPlaceHolderOrGERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_GEPlaceHolderOrGERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_GEPlaceHolderOrGERParenOne(Java7TemplateParser.Fm_LParenfm_GEPlaceHolderOrGERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne(Java7TemplateParser.Fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_COMMAPlaceHolderOrCOMMARParenOne(Java7TemplateParser.Fm_LParenfm_COMMAPlaceHolderOrCOMMARParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx8}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx8(Java7TemplateParser.Fm_newRulexXXx8Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx8}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx8(Java7TemplateParser.Fm_newRulexXXx8Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_TILDEPlaceHolderOrTILDERParenOne(Java7TemplateParser.Fm_LParenfm_TILDEPlaceHolderOrTILDERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_TILDEPlaceHolderOrTILDERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_TILDEPlaceHolderOrTILDERParenOne(Java7TemplateParser.Fm_LParenfm_TILDEPlaceHolderOrTILDERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_COLONPlaceHolderOrCOLONRParenOne(Java7TemplateParser.Fm_LParenfm_COLONPlaceHolderOrCOLONRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_COLONPlaceHolderOrCOLONRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_COLONPlaceHolderOrCOLONRParenOne(Java7TemplateParser.Fm_LParenfm_COLONPlaceHolderOrCOLONRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne(Java7TemplateParser.Fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FLOATPlaceHolderOrFLOATRParenOne(Java7TemplateParser.Fm_LParenfm_FLOATPlaceHolderOrFLOATRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne(Java7TemplateParser.Fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOne(Java7TemplateParser.Fm_LParenfm_INTERFACEPlaceHolderOrINTERFACERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne(Java7TemplateParser.Fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOne(Java7TemplateParser.Fm_LParenfm_NATIVEPlaceHolderOrNATIVERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_INCPlaceHolderOrINCRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_INCPlaceHolderOrINCRParenOne(Java7TemplateParser.Fm_LParenfm_INCPlaceHolderOrINCRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_INCPlaceHolderOrINCRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_INCPlaceHolderOrINCRParenOne(Java7TemplateParser.Fm_LParenfm_INCPlaceHolderOrINCRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ADDPlaceHolderOrADDRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ADDPlaceHolderOrADDRParenOne(Java7TemplateParser.Fm_LParenfm_ADDPlaceHolderOrADDRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ADDPlaceHolderOrADDRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ADDPlaceHolderOrADDRParenOne(Java7TemplateParser.Fm_LParenfm_ADDPlaceHolderOrADDRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne(Java7TemplateParser.Fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOne(Java7TemplateParser.Fm_LParenfm_NOTEQUALPlaceHolderOrNOTEQUALRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParentypeDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParentypeDeclarationRParenOne(Java7TemplateParser.Fm_LParentypeDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParentypeDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParentypeDeclarationRParenOne(Java7TemplateParser.Fm_LParentypeDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_MODPlaceHolderOrMODRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_MODPlaceHolderOrMODRParenOne(Java7TemplateParser.Fm_LParenfm_MODPlaceHolderOrMODRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_MODPlaceHolderOrMODRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_MODPlaceHolderOrMODRParenOne(Java7TemplateParser.Fm_LParenfm_MODPlaceHolderOrMODRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOne(Java7TemplateParser.Fm_LParenfm_IntegerLiteralPlaceHolderOrIntegerLiteralRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne(Java7TemplateParser.Fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_SHORTPlaceHolderOrSHORTRParenOne(Java7TemplateParser.Fm_LParenfm_SHORTPlaceHolderOrSHORTRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ATPlaceHolderOrATRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_ATPlaceHolderOrATRParenOne(Java7TemplateParser.Fm_LParenfm_ATPlaceHolderOrATRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_ATPlaceHolderOrATRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_ATPlaceHolderOrATRParenOne(Java7TemplateParser.Fm_LParenfm_ATPlaceHolderOrATRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenclassCreatorRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenclassCreatorRestRParenOne(Java7TemplateParser.Fm_LParenclassCreatorRestRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenclassCreatorRestRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenclassCreatorRestRParenOne(Java7TemplateParser.Fm_LParenclassCreatorRestRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenelementValueRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenelementValueRParenOne(Java7TemplateParser.Fm_LParenelementValueRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenelementValueRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenelementValueRParenOne(Java7TemplateParser.Fm_LParenelementValueRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfinallyBlockRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfinallyBlockRParenOne(Java7TemplateParser.Fm_LParenfinallyBlockRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfinallyBlockRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfinallyBlockRParenOne(Java7TemplateParser.Fm_LParenfinallyBlockRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenexplicitGenericInvocationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexplicitGenericInvocationRParenOne(Java7TemplateParser.Fm_LParenexplicitGenericInvocationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenexplicitGenericInvocationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexplicitGenericInvocationRParenOne(Java7TemplateParser.Fm_LParenexplicitGenericInvocationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenconstDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstDeclarationRParenOne(Java7TemplateParser.Fm_LParenconstDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenconstDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstDeclarationRParenOne(Java7TemplateParser.Fm_LParenconstDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LPareninterfaceDeclarationRParenOne(Java7TemplateParser.Fm_LPareninterfaceDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LPareninterfaceDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LPareninterfaceDeclarationRParenOne(Java7TemplateParser.Fm_LPareninterfaceDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne(Java7TemplateParser.Fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOne(Java7TemplateParser.Fm_LParenfm_FINALLYPlaceHolderOrFINALLYRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne(Java7TemplateParser.Fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOne(Java7TemplateParser.Fm_LParenfm_RBRACEPlaceHolderOrRBRACERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx9}.
	 * @param ctx the parse tree
	 */
	void enterFm_newRulexXXx9(Java7TemplateParser.Fm_newRulexXXx9Context ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_newRulexXXx9}.
	 * @param ctx the parse tree
	 */
	void exitFm_newRulexXXx9(Java7TemplateParser.Fm_newRulexXXx9Context ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableInitializerRParenOne(Java7TemplateParser.Fm_LParenvariableInitializerRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableInitializerRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableInitializerRParenOne(Java7TemplateParser.Fm_LParenvariableInitializerRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_BYTEPlaceHolderOrBYTERParenOne(Java7TemplateParser.Fm_LParenfm_BYTEPlaceHolderOrBYTERParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_BYTEPlaceHolderOrBYTERParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_BYTEPlaceHolderOrBYTERParenOne(Java7TemplateParser.Fm_LParenfm_BYTEPlaceHolderOrBYTERParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne(Java7TemplateParser.Fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOne(Java7TemplateParser.Fm_LParenfm_STRICTFPPlaceHolderOrSTRICTFPRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenargumentsRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenargumentsRParenOne(Java7TemplateParser.Fm_LParenargumentsRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenargumentsRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenargumentsRParenOne(Java7TemplateParser.Fm_LParenargumentsRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenvariableDeclaratorRParenOne(Java7TemplateParser.Fm_LParenvariableDeclaratorRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenvariableDeclaratorRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenvariableDeclaratorRParenOne(Java7TemplateParser.Fm_LParenvariableDeclaratorRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CARETPlaceHolderOrCARETRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_CARETPlaceHolderOrCARETRParenOne(Java7TemplateParser.Fm_LParenfm_CARETPlaceHolderOrCARETRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_CARETPlaceHolderOrCARETRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_CARETPlaceHolderOrCARETRParenOne(Java7TemplateParser.Fm_LParenfm_CARETPlaceHolderOrCARETRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_NEWPlaceHolderOrNEWRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenfm_NEWPlaceHolderOrNEWRParenOne(Java7TemplateParser.Fm_LParenfm_NEWPlaceHolderOrNEWRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenfm_NEWPlaceHolderOrNEWRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenfm_NEWPlaceHolderOrNEWRParenOne(Java7TemplateParser.Fm_LParenfm_NEWPlaceHolderOrNEWRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOne(Java7TemplateParser.Fm_LParenLParenfm_MULPlaceHolderOrMULRParenOrLParenfm_DIVPlaceHolderOrDIVRParenOrLParenfm_MODPlaceHolderOrMODRParenRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenqualifiedNameListRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenqualifiedNameListRParenOne(Java7TemplateParser.Fm_LParenqualifiedNameListRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenqualifiedNameListRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenqualifiedNameListRParenOne(Java7TemplateParser.Fm_LParenqualifiedNameListRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenexplicitGenericInvocationSuffixRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenexplicitGenericInvocationSuffixRParenOne(Java7TemplateParser.Fm_LParenexplicitGenericInvocationSuffixRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenexplicitGenericInvocationSuffixRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenexplicitGenericInvocationSuffixRParenOne(Java7TemplateParser.Fm_LParenexplicitGenericInvocationSuffixRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenresourcesRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenresourcesRParenOne(Java7TemplateParser.Fm_LParenresourcesRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenresourcesRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenresourcesRParenOne(Java7TemplateParser.Fm_LParenresourcesRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenblockRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenblockRParenOne(Java7TemplateParser.Fm_LParenblockRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenblockRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenblockRParenOne(Java7TemplateParser.Fm_LParenblockRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenconstructorBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenconstructorBodyRParenOne(Java7TemplateParser.Fm_LParenconstructorBodyRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenconstructorBodyRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenconstructorBodyRParenOne(Java7TemplateParser.Fm_LParenconstructorBodyRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenlocalVariableDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenlocalVariableDeclarationRParenOne(Java7TemplateParser.Fm_LParenlocalVariableDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenlocalVariableDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenlocalVariableDeclarationRParenOne(Java7TemplateParser.Fm_LParenlocalVariableDeclarationRParenOneContext ctx);
	/**
	 * Enter a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationTypeDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void enterFm_LParenannotationTypeDeclarationRParenOne(Java7TemplateParser.Fm_LParenannotationTypeDeclarationRParenOneContext ctx);
	/**
	 * Exit a parse tree produced by {@link Java7TemplateParser#fm_LParenannotationTypeDeclarationRParenOne}.
	 * @param ctx the parse tree
	 */
	void exitFm_LParenannotationTypeDeclarationRParenOne(Java7TemplateParser.Fm_LParenannotationTypeDeclarationRParenOneContext ctx);
}