package com.ag.rules

import com.android.tools.lint.client.api.IssueRegistry

class CustomLintRegistry : IssueRegistry() {
    override val issues = listOf(
        MethodsIssue.ISSUE
    )
}