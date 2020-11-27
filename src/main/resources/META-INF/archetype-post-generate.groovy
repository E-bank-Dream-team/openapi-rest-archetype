import java.nio.file.Files
import java.nio.file.Paths

genProjProperties = request.properties
genProjBasedir = Paths.get(request.outputDirectory, request.artifactId)

void leaveCIScript() {
    ciType = genProjProperties.get('ci')
    ciDir = genProjBasedir.resolve('ci')
    ciDir.toFile().eachDir { f ->
        if (f.name != ciType) {
            dir = ciDir.resolve(f.name).toFile()
            println 'Deleting directory ' + genProjBasedir.toFile().relativePath(dir)
            dir.deleteDir()
        }
    }
}

leaveCIScript()
