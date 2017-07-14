package io.github.maybeec.patterndetection.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import io.github.maybeec.patterndetection.deprecated.FlattenedTreeMatcher;
import io.github.maybeec.patterndetection.deprecated.TreePath;

@Ignore("deprecated, might be deleted in future")
public class FlattenedTreeMatcherTest {

    private final static String testResourcesRootPath = "src/test/resources/unittest/DetectorTest/";

    @Test
    public void testSimpleClassIdentifierDetection() throws Exception {

        Path template = new File(testResourcesRootPath + "SimpleClassTemplate.java").toPath();
        List<Path> pattern = new ArrayList<>();
        pattern.add(template);

        Path file = new File(testResourcesRootPath + "SimpleClass.java").toPath();
        Set<Path> applicationFiles = new HashSet<>();
        applicationFiles.add(file);

        Map<String, Set<TreePath>> variableStubsitutions =
            new FlattenedTreeMatcher().matches(pattern, applicationFiles);

        assertThat(variableStubsitutions).containsOnlyKeys("${clazz}");
        assertThat(variableStubsitutions.get("${clazz}")).isNotNull().extracting("text").containsExactly("A");
    }

    @Test
    public void testSimplePackageDeclDetection() throws Exception {

        Path template = new File(testResourcesRootPath + "SimplePackageDeclTemplate.java").toPath();
        List<Path> pattern = new ArrayList<>();
        pattern.add(template);

        Path file = new File(testResourcesRootPath + "SimplePackageDecl.java").toPath();
        Set<Path> applicationFiles = new HashSet<>();
        applicationFiles.add(file);

        Map<String, Set<TreePath>> variableStubsitutions =
            new FlattenedTreeMatcher().matches(pattern, applicationFiles);

        assertThat(variableStubsitutions).containsOnlyKeys("${c}", "${e}");
        assertThat(variableStubsitutions.get("${c}")).extracting("text").containsExactly("c");
        assertThat(variableStubsitutions.get("${e}")).extracting("text").containsExactly("e");
    }

    @Test
    public void testComplexPackageDeclDetection() throws Exception {

        Path template = new File(testResourcesRootPath + "ComplexPackageDeclTemplate.java").toPath();
        List<Path> pattern = new ArrayList<>();
        pattern.add(template);

        Path file = new File(testResourcesRootPath + "ComplexPackageDecl.java").toPath();
        Set<Path> applicationFiles = new HashSet<>();
        applicationFiles.add(file);

        Map<String, Set<TreePath>> variableStubsitutions =
            new FlattenedTreeMatcher().matches(pattern, applicationFiles);

        assertThat(variableStubsitutions).containsOnlyKeys("${a}", "${b}", "${e}");
        assertThat(variableStubsitutions.get("${a}")).extracting("text").containsExactly("a");
        assertThat(variableStubsitutions.get("${b}")).extracting("text").containsExactly("b.c");
        assertThat(variableStubsitutions.get("${e}")).extracting("text").containsExactly("e.f.g.h");
    }
}
