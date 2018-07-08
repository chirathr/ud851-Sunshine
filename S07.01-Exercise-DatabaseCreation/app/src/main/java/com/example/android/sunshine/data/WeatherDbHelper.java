/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.sunshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Manages a local database for weather data.
 */
// TODO (11) Extend SQLiteOpenHelper from WeatherDbHelper
public class WeatherDbHelper extends SQLiteOpenHelper {

    //  TODO (12) Create a public static final String called DATABASE_NAME with value "weather.db"
    public static final String DATABASE_NAME = "weather.db";

    //  TODO (13) Create a private static final int called DATABASE_VERSION and set it to 1
    private static final int DATABASE_VERSION = 1;

    public WeatherDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CREATE_STATEMENT = "CREATE TABLE " + WeatherContract.WeatherEntry.TABLE_NAME +
                "( " + WeatherContract.WeatherEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WeatherContract.WeatherEntry.COLUMN_WEATHER_ID + " INTEGER" +
                WeatherContract.WeatherEntry.COLUMN_DATE + "INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_MIN_TEMP + "INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_MAX_TEMP + "INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_HUMIDITY + "INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_PRESSURE + "INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_WIND_SPEED + "INTEGER NOT NULL, " +
                WeatherContract.WeatherEntry.COLUMN_DEGREES + "INTEGER NOT NULL );"  ;

        sqLiteDatabase.execSQL(TABLE_CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//  TODO (14) Create a constructor that accepts a context and call through to the superclass constructor

//  TODO (15) Override onCreate and create the weather table from within it

//  TODO (16) Override onUpgrade, but don't do anything within it yet
}