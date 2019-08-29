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

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.zawmoehtike.tododagger2.data.Todo;

import java.util.List;

/**
 * Data Access Object for the tasks table.
 */
@Dao
public interface TodoDao {

    /**
     * Select all tasks from the tasks table.
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM todos")
    List<Todo> getTodoList();

    /**
     * Select a task by id.
     *
     * @param todoId the task id.
     * @return the task with taskId.
     */
    @Query("SELECT * FROM todos WHERE id = :todoId")
    Todo getTodoById(String todoId);

    /**
     * Insert a task in the database. If the task already exists, replace it.
     *
     * @param todo the task to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTodo(Todo todo);

    @Query("DELETE FROM todos")
    void deleteAllTodo();
}
