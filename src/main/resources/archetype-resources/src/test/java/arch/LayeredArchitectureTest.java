package ${package}.arch;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.library.freeze.FreezingArchRule.freeze;

import org.junit.jupiter.api.Tag;

@Tag("arch")
@AnalyzeClasses(packages = "${package}", importOptions = { ImportOption.DoNotIncludeTests.class, ImportOption.DoNotIncludeJars.class, ImportOption.DoNotIncludeArchives.class })
public class LayeredArchitectureTest {


    @ArchTest
    static final ArchRule layer_dependencies_are_respected = freeze(layeredArchitecture()
            .layer("Controllers")
            .definedBy("${package}.controllers..")
            .layer("Services")
            .definedBy("${package}.services..")
            .layer("Repositories")
            .definedBy("${package}.repositories..")
            .whereLayer("Controllers")
            .mayNotBeAccessedByAnyLayer()
            .whereLayer("Services")
            .mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Repositories")
            .mayOnlyBeAccessedByLayers("Services"));

}
