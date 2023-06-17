package org.d3if3086.tabunganku.network

import android.content.Context
import android.util.Log
import androidx.work.Configuration
import androidx.work.Worker
import androidx.work.WorkerParameters

class UpdateWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams){
    companion object {
        const val WORK_NAME = "updater"
    }
    override fun doWork(): Result {
        Log.d("Worker", "Menjalankan proses background..")
        return Result.success()
    }

}