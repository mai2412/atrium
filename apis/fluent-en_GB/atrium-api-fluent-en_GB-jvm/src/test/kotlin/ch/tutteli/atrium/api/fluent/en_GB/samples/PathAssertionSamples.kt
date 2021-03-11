package ch.tutteli.atrium.api.fluent.en_GB.samples

import ch.tutteli.atrium.api.fluent.en_GB.isEmptyDirectory
import ch.tutteli.atrium.api.fluent.en_GB.toBeASymbolicLink
import ch.tutteli.atrium.api.verbs.internal.expect
import ch.tutteli.niok.newDirectory
import ch.tutteli.niok.newFile
import java.nio.file.Files
import kotlin.test.Test

class PathAssertionSamples {

    private val tempDir = Files.createTempDirectory("PathAssertionSamples")

    @Test
    fun isASymbolicLink() {
        val target = tempDir.newFile("target")
        val link = Files.createSymbolicLink(tempDir.resolve("link"), target)

        // Passes, as subject `link` is a symbolic link
        expect(link).toBeASymbolicLink()
    }

    @Test
    fun isNotASymbolicLink() {
        val path = tempDir.newFile("somePath")

        // Fails, as subject `path` is a not a symbolic link
        fails {
            expect(path).toBeASymbolicLink()
        }
    }

    @Test
    fun isEmptyDirectory() {
        val path = tempDir.newDirectory("dir")
        expect(path).isEmptyDirectory()
    }

    @Test
    fun isNotEmptyDirectory() {
        tempDir.newFile("a")

        fails {
            expect(tempDir).isEmptyDirectory()
        }
    }
}
