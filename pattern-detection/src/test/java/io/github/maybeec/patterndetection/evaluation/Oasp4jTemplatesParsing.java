package io.github.maybeec.patterndetection.evaluation;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.assertj.core.util.Lists;
import org.junit.Ignore;
import org.junit.Test;

import io.github.maybeec.antlr4.parser.TemplateParser;
import io.github.maybeec.parsers.javatemplate.JavaTemplateLexer;
import io.github.maybeec.parsers.javatemplate.JavaTemplateParser;
import io.github.maybeec.patterndetection.utils.MetaLangCounter;

/**
 *
 */
@Ignore
public class Oasp4jTemplatesParsing {

    private final static Path testResourcesRootPath =
        new File("D:\\Diss\\IDE-Research\\workspaces\\cobigen-fork\\master\\cobigen-templates\\templates-oasp4j")
            .toPath();

    private List<String> paths = Lists.newArrayList("constants/named_queries/NamedQueries.java.ftl",
        "constants/security_permissions/PermissionConstants.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/common/api/${variables.entityName}.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/api/dao/${variables.entityName}Dao.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/api/repo/${variables.entityName}Repo.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/api/repo/${variables.entityName}RepoCustom.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/api/repo/${variables.entityName}RepoImpl.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/api/${variables.entityName}Entity.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/api/${variables.entityName}EntityRegistrationBean.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/impl/dao/${variables.entityName}DaoImpl.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/logic/api/to/${variables.entityName}Cto.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/logic/api/to/${variables.entityName}Eto.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/logic/api/to/${variables.entityName}SearchCriteriaTo.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/logic/api/${variables.component#cap_first}.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/logic/impl/${variables.component#cap_first}Impl.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/logic/impl/${variables.component#cap_first}RepoImpl.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/service/api/rest/${variables.component#cap_first}RestService.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/service/api/soap/${variables.component#cap_first}SoapService.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/service/impl/rest/${variables.component#cap_first}RestServiceImpl.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/service/impl/soap/${variables.component#cap_first}SoapServiceImpl.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/common/api/to/AbstractCto.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/common/api/to/AbstractEto.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/common/api/to/PaginatedListToWrapper.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/common/api/ApplicationEntity.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/common/base/AbstractBeanMapperSupport.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/dataaccess/api/dao/ApplicationDao.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/dataaccess/api/ApplicationPersistenceEntity.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/dataaccess/base/dao/ApplicationDaoImpl.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/logic/base/AbstractComponentFacade.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/service/impl/config/ServiceConfig.java.ftl",
        "crud_java_server_app/templates/java/${variables.rootPackage}/general/service/impl/config/WebApplicationContextLocator.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/${variables.component}/logic/api/usecase/UcFind${variables.entityName}.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/${variables.component}/logic/api/usecase/UcManage${variables.entityName}.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/${variables.component}/logic/api/${variables.component#cap_first}.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/${variables.component}/logic/base/usecase/Abstract${variables.entityName}Uc.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/${variables.component}/logic/impl/usecase/UcFind${variables.entityName}Impl.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/${variables.component}/logic/impl/usecase/UcManage${variables.entityName}Impl.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/${variables.component}/logic/impl/${variables.component#cap_first}Impl.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/general/common/base/AbstractBeanMapperSupport.java.ftl",
        "crud_java_server_app_complex/templates/java/${variables.rootPackage}/general/logic/base/AbstractUc.java.ftl",
        "embeddables/templates/java/${variables.rootPackage}/${variables.component}/common/api/${variables.entityName}.java.ftl",
        "embeddables/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/api/${variables.entityName}Embeddable.java.ftl",
        "embeddables/templates/java/${variables.rootPackage}/${variables.component}/logic/api/to/${variables.entityName}Eto.java.ftl",
        "embeddables/templates/java/${variables.rootPackage}/${variables.component}/logic/api/to/${variables.entityName}SearchCriteriaTo.java.ftl",
        "embeddables/templates/java/${variables.rootPackage}/general/common/api/to/AbstractEto.java.ftl",
        "testdata_builder/ObjectBuilder_customFunctions.java.ftl",
        "testdata_builder/ObjectBuilder_fillMandatoryFields.java.ftl",
        "testdata_builder/ObjectBuilder_persistable.java.ftl", "testdata_builder/ObjectBuilder.java.ftl",
        "testdata_builder/P.java.ftl");

    @Test
    public void testSimpleClassIdentifierDetection() throws Exception {

        Path template = testResourcesRootPath.resolve(
            "crud_java_server_app/templates/java/${variables.rootPackage}/${variables.component}/dataaccess/impl/dao/${variables.entityName}DaoImpl.java.ftl");

        TemplateParser<JavaTemplateParser> parserWrapper = createParser(template);
        List<ParserRuleContext> templateCSTs = parserWrapper.parseAmbiguities(PredictionMode.LL_EXACT_AMBIG_DETECTION);

    }

    @Test
    public void evaluateAverageParseTime() throws Exception {

        // preparation, dismiss initial loading phase
        TemplateParser<JavaTemplateParser> parserWrapper =
            createParser(testResourcesRootPath.resolve("constants/named_queries/NamedQueries.java.ftl"));
        parserWrapper.parseAmbiguities(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        // evaluation

        long start = System.currentTimeMillis();
        for (String path : paths) {
            parserWrapper = createParser(testResourcesRootPath.resolve(path));
            List<ParserRuleContext> templateCSTs =
                parserWrapper.parseAmbiguities(PredictionMode.LL_EXACT_AMBIG_DETECTION);
        }
        long stop = System.currentTimeMillis();
        System.out.println("Number of templates parsed: " + paths.size());
        System.out.println("Time spend for parsing all: " + (stop - start) + "ms");
        System.out.println("Time spend in average per template: " + (stop - start) / new Double(paths.size()) + "ms");

    }

    @Test
    public void evaluateNoMetaLang() throws Exception {

        // preparation, dismiss initial loading phase
        TemplateParser<JavaTemplateParser> parserWrapper =
            createParser(testResourcesRootPath.resolve("constants/named_queries/NamedQueries.java.ftl"));
        parserWrapper.parseAmbiguities(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        // evaluation
        MetaLangCounter counter = new MetaLangCounter(new JavaTemplateParser(null).getVocabulary());

        for (String path : paths) {
            parserWrapper = createParser(testResourcesRootPath.resolve(path));
            List<ParserRuleContext> templateCSTs =
                parserWrapper.parseAmbiguities(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            new ParseTreeWalker().walk(counter, templateCSTs.get(0));
        }
        System.out.println("Number of templates parsed: " + paths.size());
        System.out.println(
            "Average count of placeholders per template: " + counter.getPlaceholderCount() / new Double(paths.size()));
        System.out
            .println("Average count of conditionals per template: " + counter.getIfCount() / new Double(paths.size()));
        System.out.println("Average count of loops per template: " + counter.getLoopCount() / new Double(paths.size()));

    }

    @Test
    public void evaluateLongest() throws Exception {

        // preparation, dismiss initial loading phase
        TemplateParser<JavaTemplateParser> parserWrapper =
            createParser(testResourcesRootPath.resolve("constants/named_queries/NamedQueries.java.ftl"));
        parserWrapper.parseAmbiguities(PredictionMode.LL_EXACT_AMBIG_DETECTION);

        // evaluation
        double longestTime = 0;
        String longestParsingFile = null;
        int longestPHCount = 0;
        int longestIfCount = 0;
        int longestLoopCount = 0;
        for (String path : paths) {
            long start = System.currentTimeMillis();
            parserWrapper = createParser(testResourcesRootPath.resolve(path));
            List<ParserRuleContext> templateCSTs =
                parserWrapper.parseAmbiguities(PredictionMode.LL_EXACT_AMBIG_DETECTION);
            long stop = System.currentTimeMillis();

            if (stop - start > longestTime) {
                longestTime = stop - start;
                longestParsingFile = path;
                MetaLangCounter counter = new MetaLangCounter(new JavaTemplateParser(null).getVocabulary());
                new ParseTreeWalker().walk(counter, templateCSTs.get(0));
                longestPHCount = counter.getPlaceholderCount();
                longestIfCount = counter.getIfCount();
                longestLoopCount = counter.getLoopCount();
            }
        }
        System.out.println("Longest taking parsing with " + longestPHCount + " placeholders, " + longestIfCount
            + " if, and " + longestLoopCount + " loops in " + longestTime + "ms" + " for " + longestParsingFile);

    }

    private TemplateParser<JavaTemplateParser> createParser(Path file) throws Exception {
        try (Reader reader = new FileReader(file.toFile())) {
            Lexer lexer = new JavaTemplateLexer(new ANTLRInputStream(reader));
            JavaTemplateParser parser = new JavaTemplateParser(new CommonTokenStream(lexer));

            try (InputStream grammar = getClass().getResourceAsStream("/antlr/JavaTemplate.g4")) {
                TemplateParser<JavaTemplateParser> parserWrapper =
                    new TemplateParser<>(parser, JavaTemplateParser.class.getMethod("compilationUnit"), grammar);
                return parserWrapper;
            }
        }
    }
}
