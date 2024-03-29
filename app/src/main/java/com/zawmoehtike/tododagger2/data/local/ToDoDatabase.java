/*
 * Copyright 2017, The Android Open Source Project
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

package com.zawmoehtike.tododagger2.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.zawmoehtike.tododagger2.data.Todo;

/**
 * The Room Database that contains the Task table.
 */
@Database(entities = {Todo.class}, version = 1)
public abstract class ToDoDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();
}
