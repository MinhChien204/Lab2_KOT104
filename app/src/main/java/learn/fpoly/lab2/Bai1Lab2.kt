package learn.fpoly.lab2

fun main() {
    do {
        println("Nhập mssv: ")
        val mssv: String? = readLine()

        val tenSV = getTenSV(mssv!!)

        println("Ten sv với mã $mssv là: $tenSV")
        print("Tiếp không?(c/k):")
        val s = readLine()
        if (s == "k")
            break;
    } while (true)
    println("Kết thúc chương trình!")
}

val danhsachSV: Map<String, String> =
    mutableMapOf("PH39754" to "Nguyễn Minh Chiến", "PH39753" to "Minh Chiến")

fun getTenSV(mssv: String): String? {
    val tenSV = danhsachSV.get(mssv)
    if (tenSV == null) {
        println("Không tìm thấy tên sinh viên")
    }
    return tenSV
}
