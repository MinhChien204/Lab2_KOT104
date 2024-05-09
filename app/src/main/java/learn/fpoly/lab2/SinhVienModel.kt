package learn.fpoly.lab2

data class SinhVien(
    var tenSV: String,
    var mssv: String,
    var diemTB: Float,
    var daTotNghiep: Boolean?,
    var tuoi: Int?
)

class QuanLySinhVien {
    private val danhSachSinhVien = mutableListOf<SinhVien>()

    fun themSinhVien(sv: SinhVien) {
        danhSachSinhVien.add(sv)
    }

    fun xoaSinhVien(mssv: String) {
        val sv = danhSachSinhVien.find { it.mssv == mssv }
        if (sv != null) {
            danhSachSinhVien.remove(sv)
            println("Đã xóa sinh viên với MSSV: $mssv")
        } else {
            println("Không tìm thấy sinh viên với MSSV: $mssv")
        }
    }

    fun suaSinhVien(mssv: String, tenMoi: String, diemTBMoi: Float, daTotNghiepMoi: Boolean?, tuoiMoi: Int?) {
        val sv = danhSachSinhVien.find { it.mssv == mssv }
        if (sv != null) {
            sv.tenSV = tenMoi
            sv.diemTB = diemTBMoi
            sv.daTotNghiep = daTotNghiepMoi
            sv.tuoi = tuoiMoi
            println("Đã cập nhật thông tin của sinh viên với MSSV: $mssv")
        } else {
            println("Không tìm thấy sinh viên với MSSV: $mssv")
        }
    }

    fun xemDanhSachSinhVien() {
        if (danhSachSinhVien.isEmpty()) {
            println("Danh sách sinh viên hiện đang trống.")
            return
        }
        println("Danh sách sinh viên:")
        danhSachSinhVien.forEachIndexed { index, sv ->
            println("${index + 1}. Tên: ${sv.tenSV}, MSSV: ${sv.mssv}, Điểm TB: ${sv.diemTB}, Tốt nghiệp: ${sv.daTotNghiep ?: "Chưa có dữ liệu"}, Tuổi: ${sv.tuoi ?: "Chưa có dữ liệu"}")
        }
    }
}

fun main() {
    val quanLySV = QuanLySinhVien()
    var luaChon: Int
    do {
        println("==== Quản Lý Sinh Viên ====")
        println("1. Thêm sinh viên")
        println("2. Xóa sinh viên")
        println("3. Sửa thông tin sinh viên")
        println("4. Xem danh sách sinh viên")
        println("0. Thoát chương trình")
        print("Nhập lựa chọn của bạn: ")
        try {
            luaChon = readLine()?.toInt() ?: -1
        } catch (e: NumberFormatException) {
            luaChon = -1
        }

        when (luaChon) {
            1 -> {
                println("Nhập thông tin sinh viên mới:")
                print("Tên SV: ")
                val tenSV = readLine() ?: ""
                print("MSSV: ")
                val mssv = readLine() ?: ""
                print("Điểm TB: ")
                val diemTB = readLine()?.toFloatOrNull() ?: 0.0f
                print("Đã tốt nghiệp (true/false): ")
                val daTotNghiep = readLine()?.toSafeBoolean()
                print("Tuổi: ")
                val tuoi = readLine()?.toIntOrNull()
                quanLySV.themSinhVien(SinhVien(tenSV, mssv, diemTB, daTotNghiep, tuoi))
            }
            2 -> {
                print("Nhập MSSV của sinh viên cần xóa: ")
                val mssv = readLine() ?: ""
                quanLySV.xoaSinhVien(mssv)
            }
            3 -> {
                print("Nhập MSSV của sinh viên cần sửa: ")
                val mssv = readLine() ?: ""
                print("Tên mới: ")
                val tenMoi = readLine() ?: ""
                print("Điểm TB mới: ")
                val diemTBMoi = readLine()?.toFloatOrNull() ?: 0.0f
                print("Đã tốt nghiệp mới (true/false): ")
                val daTotNghiepMoi = readLine()?.toSafeBoolean()
                print("Tuổi mới: ")
                val tuoiMoi = readLine()?.toIntOrNull()
                quanLySV.suaSinhVien(mssv, tenMoi, diemTBMoi, daTotNghiepMoi, tuoiMoi)
            }
            4 -> {
                quanLySV.xemDanhSachSinhVien()
            }
            0 -> {
                println("Chương trình đã thoát.")
            }
            else -> {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            }
        }
    } while (luaChon != 0)
}
fun String?.toSafeBoolean(): Boolean? {
    return when (this?.toLowerCase()) {
        "true" -> true
        "false" -> false
        else -> null
    }
}
