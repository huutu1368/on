package com.example.on

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.on.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var tenkhoanchi_347 = ""
    private var sotien_347 = 0.0
    private var ghichu_347 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 1. Khởi tạo binding và gọi setContentView 1 lần duy nhất ở đây
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Phan Manh Tung_2347"

        // 2. Đóng ngoặc khối WindowInsetsListener ngay sau từ khóa "insets"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 3. Viết sự kiện click ở bên ngoài WindowInsetsListener
        binding.btnThemKhoanChi347.setOnClickListener {
            tenkhoanchi_347 = binding.edtTenKhoanChi347.text.toString().trim()
            sotien_347 = binding.edtSoTien347.text.toString().trim().toDoubleOrNull() ?: -1.0
            ghichu_347 = binding.edtGhiChu347.text.toString().trim()

            if (tenkhoanchi_347.isBlank()) {
                binding.edtTenKhoanChi347.error = "Ten khoan chi khong hop le"
            } else if (sotien_347 <= 0.0) { // Bỏ kiểm tra == null vì đã có ?: -1.0
                binding.edtSoTien347.error = "So tien khong hop le"
            } else {
                Toast.makeText(this, "Them khoan chi thanh cong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}