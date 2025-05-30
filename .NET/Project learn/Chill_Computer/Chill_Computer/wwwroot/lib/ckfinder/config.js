/*
 Copyright (c) 2007-2019, CKSource - Frederico Knabben. All rights reserved.
 For licensing, see LICENSE.html or https://ckeditor.com/sales/license/ckfinder
 */

var config = {};

// Set your configuration options below.

// Examples:
// config.language = 'pl';
// config.skin = 'jquery-mobile';

CKFinder.define(config);

CKFinder.customConfig = function (config) {
    config.connectorPath = '/ckfinder/core/connector/aspx/connector.aspx'; // ASP.NET connector
    config.removePlugins = 'EasyImage';
};
