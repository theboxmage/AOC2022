import java.io.File

class FileUtils {
    companion object {
        fun readFileAsLines(fileName: String): List<String>
                = File(fileName).useLines { it.toList() }
    }

}