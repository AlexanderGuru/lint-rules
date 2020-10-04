package com.ag.rules

import com.android.tools.lint.detector.api.*

class MethodsIssue {
    companion object {

        private const val ID = "Incorrect order"
        private const val DESCRIPTION = "The method is located in the wrong order."
        private const val EXPLANATION = "The method is located in the wrong order."

        private const val PRIORITY = 6
        private val CATEGORY = Category.TYPOGRAPHY
        private val SEVERITY = Severity.ERROR

        val ISSUE = Issue.create(
            ID,
            DESCRIPTION,
            EXPLANATION,
            CATEGORY,
            PRIORITY,
            SEVERITY,
            Implementation(MethodsDetector::class.java, Scope.JAVA_FILE_SCOPE)
        )
    }
}