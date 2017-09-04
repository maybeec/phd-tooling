package io.github.maybeec.patterndetection.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import io.github.maybeec.patterndetection.Detector;

/**
 *
 */
public class DetectorTest {

    private final static String testResourcesRootPath = "src/test/resources/unittest/DetectorTest/";

    @Test
    public void testSimpleClassIdentifierDetection() throws Exception {

        Path template = new File(testResourcesRootPath + "SimpleClassTemplate.java").toPath();
        List<Path> pattern = new ArrayList<>();
        pattern.add(template);

        Path file = new File(testResourcesRootPath + "SimpleClass.java").toPath();
        Set<Path> applicationFiles = new HashSet<>();
        applicationFiles.add(file);

        List<Map<String, String>> variableStubsitutions = new Detector().detect(pattern, applicationFiles, ".ftl");

        assertThat(variableStubsitutions).hasSize(1);
        assertThat(variableStubsitutions.get(0)).hasSize(1).extracting("${clazz}").containsExactly("A");
    }

    @Test
    public void testSimplePackageDeclDetection() throws Exception {

        Path template = new File(testResourcesRootPath + "SimplePackageDeclTemplate.java").toPath();
        List<Path> pattern = new ArrayList<>();
        pattern.add(template);

        Path file = new File(testResourcesRootPath + "SimplePackageDecl.java").toPath();
        Set<Path> applicationFiles = new HashSet<>();
        applicationFiles.add(file);

        List<Map<String, String>> variableStubsitutions = new Detector().detect(pattern, applicationFiles, ".ftl");

        assertThat(variableStubsitutions).hasSize(1);
        assertThat(variableStubsitutions.get(0)).hasSize(2).extracting("${c}", "${e}").containsExactly("c", "e");
    }

    @Test
    public void testComplexPackageDeclDetection() throws Exception {

        Path template = new File(testResourcesRootPath + "ComplexPackageDeclTemplate.java").toPath();
        List<Path> pattern = new ArrayList<>();
        pattern.add(template);

        Path file = new File(testResourcesRootPath + "ComplexPackageDecl.java").toPath();
        Set<Path> applicationFiles = new HashSet<>();
        applicationFiles.add(file);

        List<Map<String, String>> variableStubsitutions = new Detector().detect(pattern, applicationFiles, ".ftl");

        assertThat(variableStubsitutions).hasSize(1);
        assertThat(variableStubsitutions.get(0)).hasSize(3).extracting("${a}", "${b}", "${e}").containsExactly("a",
            "b.c", "e.f.g.h");
    }

    @Test
    public void testImportOrderDetection() throws Exception {

        Path template = new File(testResourcesRootPath + "ImportOrderingTemplate.java").toPath();
        List<Path> pattern = new ArrayList<>();
        pattern.add(template);

        Path file = new File(testResourcesRootPath + "ImportOrdering.java").toPath();
        Set<Path> applicationFiles = new HashSet<>();
        applicationFiles.add(file);

        List<Map<String, String>> variableStubsitutions = new Detector().detect(pattern, applicationFiles, ".ftl");

        assertThat(variableStubsitutions).hasSize(1);
        assertThat(variableStubsitutions.get(0)).hasSize(1).extracting("${D}").containsExactly("D");
    }

    @Test
    public void complexTest() throws Exception {

        Path componentFacade = new File(testResourcesRootPath + "ComponentFacade.java.ftl").toPath();

        List<Path> pattern = new ArrayList<>();
        pattern.add(componentFacade);

        // Set<String> fileEndingsOfInterest = retrieveFileEndingsOfInterest(pattern, ".ftl");

        // Set<Path> applicationFiles =
        // Files.walk(new
        // File("").getAbsoluteFile().toPath().resolve("../oasp4j/samples/core/src/main/").normalize())
        // .filter(path -> !path.toString().matches(".*target.*")).filter(path -> //
        // Files.isRegularFile(path)//
        // ).filter(path -> //
        // fileEndingsOfInterest.contains(getFileExtension(path.getFileName().toString()))//
        // ).collect(Collectors.toSet());

        Set<Path> applicationFiles = new HashSet<>();
        applicationFiles.add(new File(testResourcesRootPath + "ComponentFacadeInstance.java").toPath());

        new Detector().detect(pattern, applicationFiles, ".ftl");

    }

    private Set<String> retrieveFileEndingsOfInterest(Iterable<Path> pattern, String templateFileEnding) {
        Set<String> fileEndingsOfInterest = new HashSet<>();
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**" + templateFileEnding);
        for (Path template : pattern) {
            String filename;
            if (matcher.matches(template)) {
                filename = template.getFileName().toString();
                filename = filename.substring(0, filename.length() - templateFileEnding.length());
            } else {
                filename = template.getFileName().toString();
            }

            String extension = getFileExtension(filename);
            if (extension != null) {
                fileEndingsOfInterest.add(extension);
            }
        }
        return fileEndingsOfInterest;
    }

    /**
     * @param filename
     * @return
     */
    private String getFileExtension(String filename) {
        String extension = null;
        int i = filename.lastIndexOf('.');
        if (i > 0) {
            extension = filename.substring(i + 1);
        }
        return extension;
    }
}
