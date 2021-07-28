package com.etomun.mobile.pokeapp.data.local.base

import android.content.SharedPreferences

abstract class BasePreference protected constructor(private val pref: SharedPreferences) {
    private fun edit(): SharedPreferences.Editor {
        return pref.edit()
    }

    protected operator fun contains(key: String): Boolean {
        return pref.contains(key)
    }

    protected fun remove(key: String) {
        edit().remove(key).apply()
    }

    protected fun clear() {
        pref.edit().clear().apply()
    }

    /* GETTER */
    protected operator fun get(key: String, fallback: String): String {
        return pref.getString(key, fallback).toString()
    }

    protected operator fun get(key: String, fallback: Int): Int {
        return pref.getInt(key, fallback)
    }

    protected operator fun get(key: String, fallback: Long): Long {
        return pref.getLong(key, fallback)
    }

    protected operator fun get(key: String, fallback: Float): Float {
        return pref.getFloat(key, fallback)
    }

    protected operator fun get(key: String, fallback: Boolean): Boolean {
        return pref.getBoolean(key, fallback)
    }

    /* SETTER */
    protected operator fun set(key: String, value: String) {
        edit().putString(key, value).apply()
    }

    protected operator fun set(key: String, value: Int) {
        edit().putInt(key, value).apply()
    }

    protected operator fun set(key: String, value: Long) {
        edit().putLong(key, value).apply()
    }

    protected operator fun set(key: String, value: Float) {
        edit().putFloat(key, value).apply()
    }

    protected operator fun set(key: String, value: Boolean) {
        edit().putBoolean(key, value).apply()
    }

}