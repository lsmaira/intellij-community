package com.jetbrains.python.inspections;

import com.jetbrains.python.fixtures.PyTestCase;
import org.jetbrains.annotations.NotNull;

/**
 * @author yole
 */
public class PyUnusedImportTest extends PyTestCase {
  // PY-3626
  public void testModuleAndSubmodule() {
    doTest("py3626.py");
  }

  // PY-3201
  public void testSubpackageInInitPy() {
    doTest("package1/__init__.py");
  }

  // PY-5589
  public void testUnusedPackageAndSubmodule() {
    doTest("test1.py");
  }

  // PY-5621
  public void testUnusedSubmodule() {
    doTest("test1.py");
  }

  // PY-6380
  public void testUnusedAfterStarImport() {
    doTest("test1.py");
  }

  private void doTest(@NotNull String filename) {
    myFixture.copyDirectoryToProject("inspections/unusedImport/" + getTestName(true), "");
    myFixture.enableInspections(PyUnresolvedReferencesInspection.class);
    myFixture.testHighlighting(true, false, false, filename);
  }
}
