package com.example.duan1_truongndph07899.tudien;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.duan1_truongndph07899.R;
import com.example.duan1_truongndph07899.database.DataBaseHelper;

import java.util.ArrayList;
import java.util.List;

public class tudientt extends AppCompatActivity {
    private EditText edtText;
    private RecyclerView lvList;


    private DataBaseHelper dataBaseHelper;

    private WordAdapter wordAdapter;

    private LinearLayoutManager linearLayoutManager;


    private List<Word> wordList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tudientt);
        edtText = findViewById(R.id.edtText);
        lvList = findViewById(R.id.lvList);

        dataBaseHelper = new DataBaseHelper(this);
        dataBaseHelper.createDataBase();


        wordAdapter = new WordAdapter(wordList, this);
        linearLayoutManager = new LinearLayoutManager(this);

        lvList.setAdapter(wordAdapter);

        lvList.setLayoutManager(linearLayoutManager);


    }

    public void search(View view) {

        String word = edtText.getText().toString().trim();

        // kiểm tra nếu người dùng chưa nhập gì thì dừng lại và thông báo lỗi
        if (word.isEmpty()) {
            edtText.setError("Vui lòng nhập dữ liệu !!!");
            return;
            // nếu chữ ko empty thì tiếp tục tìm kiếm và hiển thị danh sách kết quả lên list nếu có
        } else {

            List<Word> wordList = dataBaseHelper.searchWord(word);
            this.wordList.addAll(wordList);
            wordAdapter.notifyDataSetChanged();
        }


    }

}