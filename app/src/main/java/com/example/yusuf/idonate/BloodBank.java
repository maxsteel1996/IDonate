package com.example.yusuf.idonate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BloodBank extends AppCompatActivity {

    ListView bloodBankList;

    String[] list= {"Sunil Blood Bank and Trsnsfusion Center, 806 Arjun Nagar, Kotla Mubrakpur, Opp. Defence Colony, New Delhi-03.",
            "Blood Bank, Bajaj Blood Bank, (Institute of Immunohaematology), I-C/3, Guru Govind Marg, New Delhi-5.",
            "Blood Bank, G.K. Medical Center, E-49, Greater Kailash-II, New Delhi-48.",
            "Blood Bank, G.K. Medical Center, E-49, Greater Kailash-II, New Delhi-48.",
            "Central Poly Clinic Blood Bank, J-36, Lajpat Nagar, New Delhi-24.",
            "White Cross Blood Bank, A-60, East of Kailash, New Delhi-65",
            "Central Poly Clinic Blood Bank, 3, Gangan Vihar, Shahdara Road, Delhi-51.",
            "Blood Bank, Indraprastha Medical Corporation (Apollo Hospital) Sarita Vihar, New Delhi-44",
            "Blood Bank, Sunder Lal Jain Charitable Hospital, Ashok Vihar, Phase-III, Delhi-52.",
            "Blood Bank of Sanjay Gandhi Memorial Hospital, Mangalpuri, Delhi.",
            "Blood Bank, Rotary Blood Bank, 56-57, Institutional Area, Tughlabad, New Delhi.",
            "Blood Bank, Dr. Baba Sahab Ambedkar Hospital, Rohani, Delhi.",
            "Blood Bank, Max Super Specialty Hospital, (A unit of Devki Devi Foundation), 2, Press Enclave Road, Saket, New Delhi.",
            "Blood Bank, Rockland Hospital, B-33-34, Qutab Institutional Area, New Delhi-16",
            "Blood Bank, Dr. BL Kapoor Memorial Hospital, 5 Pusa Road, New Delhi.",
            "Blood Bank, Kalra Hospital & Shri Ram Cardiothoracic & Neurosciences Center (SRCNC), A-4, Kirti nagar, New Delhi – 110015.",
            "Blood Bank, Institute of Liver and Biliary Sciences, D1, Vasant Kunj, New Delhi.",
            "Blood Bank, Park Hospital, 12-13, Meera Enclave (Chowkhandi), New Delhi.","Blood Bank, Max Super Specialty Hospital (a unit of Max Healthcare Institute Ltd.), FC-50, Block-C & D, Shalimar Bagh, Delhi-110088",
            "Bensups Hospital Blood bank, Bensups Avenue, Sector-12, Dwarka, New Delhi.","Bensups Hospital Blood bank, Bensups Avenue, Sector-12, Dwarka, New Delhi.",
            "Bensups Hospital Blood bank, Bensups Avenue, Sector-12, Dwarka, New Delhi.",
            "Blood bank, Mission Jan Jagriti Blood bank, C/o MGS Hospital, 35/37, Rohtak Road, West Punjabi Bagh, New Delhi-110026.",
            "Blood Bank, Indian Spinal Injuries Centre, C-8, Vasant Kunj, New Delhi.","Blood Bank, Mission Jan Jagriti Blood Bank, C/o Jeevan Anmol Hospital, Mayur Vihar, Phase-I, Delhi-91.",
    };
    ArrayAdapter<String> adapterList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_bank);


        bloodBankList = (ListView) findViewById(R.id.bloodBankList);

        adapterList = new ArrayAdapter<String>(this, R.layout.my_creation_filled, list);

        bloodBankList.setAdapter(adapterList);


    }
    }
